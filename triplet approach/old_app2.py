import torch
import torch.nn as nn
import torch.optim as optim
from torch_geometric.nn import GATConv,GINConv,global_mean_pool
from torch_geometric.data import DataLoader
import torch.nn.functional as F
from old_app import train_loader

class GNNModel(nn.Module):
    def __init__(self, in_channels=32, out_channels=128):
        super(GNNModel, self).__init__()
        self.conv1 = GATConv(in_channels, out_channels, heads=4, dropout=0.6)
        self.conv2 = GINConv(nn.Sequential(
            nn.Linear(out_channels * 4, 128),
            nn.ReLU(),
            nn.Linear(128, 64)
        ))
        self.fc = nn.Linear(64, 64)  # Outputting 64-dimensional embedding

    def forward(self, x, edge_index, batch):
        x = self.conv1(x, edge_index)
        x = F.relu(x)
        x = self.conv2(x, edge_index)
        x = global_mean_pool(x, batch)
        x = self.fc(x)  # Final embedding for the code snippet
        return x

# Triplet Margin Loss function
triplet_loss = nn.TripletMarginLoss(margin=1.5, p=2)

import torch.optim as optim

# Initialize model and optimizer
model = GNNModel()
optimizer = optim.Adam(model.parameters(), lr=0.001)

# Training Loop with Triplet Loss
def train_triplet_loss(model, data_loader, optimizer):
    model.train()
    total_loss = 0

    for anchor, positive, negative in data_loader:
        optimizer.zero_grad()

        # Get embeddings for anchor, positive, and negative samples
        anchor_embed = model(anchor.x, anchor.edge_index, anchor.batch)
        positive_embed = model(positive.x, positive.edge_index, positive.batch)
        negative_embed = model(negative.x, negative.edge_index, negative.batch)
        
        # Calculate triplet loss
        loss = triplet_loss(anchor_embed, positive_embed, negative_embed)
        total_loss += loss.item()
        
        # Backpropagation and optimization
        loss.backward()
        optimizer.step()

    return total_loss / len(data_loader)

# Run the training loop
num_epochs = 50
for epoch in range(num_epochs):
    loss = train_triplet_loss(model, train_loader, optimizer)
    print(f"Epoch {epoch+1}/{num_epochs}, Loss: {loss:.4f}")

