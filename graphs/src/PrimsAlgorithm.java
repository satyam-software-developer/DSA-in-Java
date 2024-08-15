
/* Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.

Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.

For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note: Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
Line 1: Two Integers V and E (separated by space)
Next E lines: Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format:
Print the MST, as described in the task.
Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph



Sample Output 1 :
0 1 3
1 2 1
0 3 5
Input Graph */

/*
 * Time complexity: O(E * log(V))
 * Space complexity: O(V^2)
 * 
 * where E is the number of edges in the graph and 
 * V is the number of vertices in the graph
 */

import java.util.Scanner;
import java.util.PriorityQueue;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int vertex; // The vertex connected by this edge
    int weight; // The weight of the edge

    // Constructor to initialize the vertex and weight of the edge
    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    // Override the compareTo method to compare edges based on their weight
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class PrimsAlgorithm {

    // Method to implement Prim's algorithm for finding the Minimum Spanning Tree
    // (MST)
    private static void prims(int[][] adjacencyMatrix, int V) {
        boolean[] visited = new boolean[V]; // Array to keep track of visited vertices
        int[] parent = new int[V]; // Array to store the parent of each vertex in the MST
        int[] weight = new int[V]; // Array to store the minimum weight to reach each vertex

        // Initialize all weights to infinity and parents to -1 (no parent)
        for (int i = 0; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        // Start from vertex 0, setting its weight to 0
        weight[0] = 0;

        // Use a priority queue to always pick the vertex with the smallest edge weight
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0)); // Start with vertex 0 with weight 0

        // Continue until the priority queue is empty
        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll(); // Get the edge with the minimum weight
            int currentVertex = currentEdge.vertex; // Get the vertex associated with this edge

            // If the vertex is already visited, skip it
            if (visited[currentVertex])
                continue;

            // Mark the current vertex as visited
            visited[currentVertex] = true;

            // Explore all neighbors of the current vertex
            for (int i = 0; i < V; i++) {
                // Check if there is an edge and the neighbor is not visited
                if (adjacencyMatrix[currentVertex][i] != 0 && !visited[i]) {
                    // If the edge weight is less than the current weight of the neighbor
                    if (adjacencyMatrix[currentVertex][i] < weight[i]) {
                        weight[i] = adjacencyMatrix[currentVertex][i]; // Update the weight
                        parent[i] = currentVertex; // Update the parent
                        pq.add(new Edge(i, weight[i])); // Add the neighbor to the priority queue
                    }
                }
            }
        }

        // Print the edges of the MST
        for (int i = 1; i < V; i++) {
            if (parent[i] < i) {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            } else {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt(); // Read the number of vertices
        int E = s.nextInt(); // Read the number of edges
        int[][] adjacencyMatrix = new int[V][V]; // Create an adjacency matrix to represent the graph

        // Read the edges and populate the adjacency matrix
        for (int i = 0; i < E; i++) {
            int v1 = s.nextInt(); // Read the first vertex of the edge
            int v2 = s.nextInt(); // Read the second vertex of the edge
            int w = s.nextInt(); // Read the weight of the edge
            adjacencyMatrix[v1][v2] = w; // Set the weight in the adjacency matrix
            adjacencyMatrix[v2][v1] = w; // Since the graph is undirected, set the symmetric value
        }

        s.close(); // Close the scanner

        // Call Prim's algorithm to find and print the MST
        prims(adjacencyMatrix, V);
    }
}
