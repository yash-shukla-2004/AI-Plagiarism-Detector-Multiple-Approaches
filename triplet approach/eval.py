import os
import torch
from torch_geometric.data import Data
import networkx as nx
import numpy as np
from torch_geometric.nn import global_mean_pool
from old_app2 import model
from old_app import load_data_from_folder

#def load_single_file(file_path):
    #"""
    #Function to load a single code file and convert it to graph data.
    #In a real scenario, replace this with logic to parse the code into graph data (e.g., AST or CFG).
    #"""
    # Dummy graph generation (replace with actual logic for converting code to graph)
    #G = nx.erdos_renyi_graph(n=100, p=0.1)  # Example: random graph (replace with actual logic)
    #node_features = np.random.rand(G.number_of_nodes(), 32)  # Example: 32 features per node
    #x = torch.tensor(node_features, dtype=torch.float)
    #edge_index = torch.tensor(np.array(list(G.edges)).T, dtype=torch.long)
    #batch = torch.zeros(x.size(0), dtype=torch.long)
    
    #data = Data(x=x, edge_index=edge_index, batch=batch)
    #return data



    

def get_plagiarism_percentage(model, data):
    """
    Function to determine the plagiarism percentage based on a single file and the trained model.
    
    Parameters:
    - model: The trained model (e.g., with triplet loss or any other architecture).
    - file_path: Path to the file whose plagiarism percentage is to be determined.
    
    Returns:
    - Plagiarism percentage based on the model's output.
    """
    # Load the file and convert it to a graph data object
    
    
    # Pass the data through the model to get the output
    model.eval()  # Set the model to evaluation mode
    with torch.no_grad():
        x, edge_index, batch = data.x, data.edge_index, data.batch
        output = model(x, edge_index, batch)  # Model output
        
        # If the output has multiple elements, reduce it to a scalar by averaging
        if output.dim() > 1:
            output = output.mean()  # Reduce to a scalar by averaging the elements
        
        # Use sigmoid to get the probability (plagiarism score) from the logits
        plagiarism_score = torch.sigmoid(output).item()  # Convert to a scalar value
    
    # Convert to percentage
    plagiarism_percentage = plagiarism_score * 100
    return plagiarism_percentage

# Example usage:
file_path = './testing/test'  # Path to your code file
data = load_data_from_folder(file_path)

plagiarism_percentage = get_plagiarism_percentage(model, data[0])
print(f"Plagiarism Percentage: {plagiarism_percentage:.2f}%")