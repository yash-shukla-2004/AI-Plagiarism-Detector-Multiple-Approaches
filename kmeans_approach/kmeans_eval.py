import torch
import torch.nn.functional as F
from sklearn.metrics import accuracy_score
import torch_geometric
from torch_geometric.data import Data
from kmeans import model
from kmeans import kmeans
import os
import torch
from torch_geometric.data import Data
import networkx as nx
import numpy as np
from torch_geometric.nn import global_mean_pool
from old_app import load_data_from_folder



# Assume that you have the following functions defined somewhere:
# load_single_file(file_path) to load a single file's graph data.
# The model is already trained.

# New evaluation function to evaluate the plagiarism percentage of a single file
import numpy as np
import torch
from sklearn.cluster import KMeans
from sklearn.metrics.pairwise import cosine_similarity

def evaluate_file_with_kmeans(model,file_data, kmeans):
    """
    Evaluate the general plagiarism percentage of a single file using K-means clustering.
    The plagiarism percentage is calculated based on how many samples in the same cluster 
    as the file are considered plagiarized.
    """
    model.eval()

    # Load the file data (this file's graph)
    
    file_embed = model(file_data.x, file_data.edge_index, file_data.batch)

    # Collect embeddings of known samples (train set or database)
    # Instead of collecting known samples explicitly, we'll assume they are already in the kmeans
    # model's data during training.
    
    # Get the embeddings from the K-means clusters (already trained during the model training phase)
    embeddings = kmeans.cluster_centers_  # Cluster centers represent the 'centroids' of the clusters.

    # Add the file's embedding to the embeddings list
    embeddings = np.append(embeddings, file_embed.detach().cpu().numpy().reshape(1, -1), axis=0)

    # Apply K-means clustering to the file embedding and other cluster centers
    kmeans_labels = kmeans.predict(embeddings)  # Predict cluster labels
    print(kmeans_labels)

    # Find which cluster the file belongs to
    file_cluster = kmeans_labels[-1]  # The file's cluster assignment is the last one

    # Calculate plagiarism percentage based on how many known samples in the same cluster
    # as the file are considered plagiarized (i.e., belonging to the same cluster)
    plagiarized = sum(1 for i in range(len(kmeans_labels) - 1)  # Exclude the file itself
                      if kmeans_labels[i] == file_cluster)  # Same cluster as the file

    # Calculate plagiarism percentage in the cluster (excluding the file itself)
    plagiarism_percentage = plagiarized / (len(kmeans_labels) - 1) * 100 if len(kmeans_labels) > 1 else 0

    return plagiarism_percentage


# Example usage:

# Assume that you have already trained the K-means model using the embeddings during the training phase
# and loaded the model as well.
# kmeans = KMeans(n_clusters=2, random_state=42)  # Trained K-means model
# model = ...  # Your trained GNN model

# Evaluate a file for plagiarism using the trained model and K-means
file_path = "./testing/test"  # Replace with the actual test file
data = load_data_from_folder(file_path)
plagiarism_percentage = evaluate_file_with_kmeans(model, data[0], kmeans)
print(f"Plagiarism Percentage: {plagiarism_percentage:.2f}%")
