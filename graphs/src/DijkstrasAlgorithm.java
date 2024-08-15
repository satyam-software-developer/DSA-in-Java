
/* Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.

Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
For each vertex, print its vertex number and its distance from source, in a separate line. The vertex number and its distance needs to be separated by a single space.
Note : Order of vertices in output doesn't matter.
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph

Sample Output 1 :
0 0
1 3
2 4
3 5 */

/*
 * Time complexity: O(E * log(V))
 * Space complexity: O(V^2)
 * 
 * where E is the number of edges in the graph and
 * V is the number of vertices in the graph
 */

import java.util.Scanner;

public class DijkstrasAlgorithm {

    // Method to implement Dijkstra's algorithm for finding the shortest path from
    // the source vertex (vertex 0) to all other vertices
    private static void dijkstra(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length; // Number of vertices in the graph
        boolean visited[] = new boolean[v]; // Array to track which vertices have been visited
        int distance[] = new int[v]; // Array to store the minimum distance from the source vertex to each vertex

        // Initialize the distance array; distance to the source vertex (vertex 0) is 0,
        // and all other distances are set to infinity (or a large value)
        distance[0] = 0;
        for (int i = 1; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Loop to find the shortest path for all vertices
        for (int i = 0; i < v - 1; i++) {
            // Find the vertex with the minimum distance that hasn't been visited yet
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true; // Mark this vertex as visited

            // Explore all the neighbors of the current vertex
            for (int j = 0; j < v; j++) {
                // If there is an edge from minVertex to j, and j has not been visited, and the
                // total distance to j through minVertex is shorter than the current known
                // distance to j, update the distance to j
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist; // Update the distance to vertex j
                    }
                }
            }
        }

        // Print the shortest distances from the source vertex to all other vertices
        for (int i = 0; i < v; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    // Helper method to find the vertex with the minimum distance that has not been
    // visited
    private static int findMinVertex(int[] distance, boolean visited[]) {
        int minVertex = -1; // Initialize the minimum vertex as -1
        for (int i = 0; i < distance.length; i++) {
            // If the vertex i has not been visited and either minVertex is -1 or the
            // distance to i is less than the distance to the current minVertex, update
            // minVertex to i
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex; // Return the vertex with the minimum distance
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner object to read input
        int v = s.nextInt(); // Read the number of vertices
        int e = s.nextInt(); // Read the number of edges
        int adjacencyMatrix[][] = new int[v][v]; // Create an adjacency matrix to represent the graph

        // Read the edges and populate the adjacency matrix
        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt(); // Read the first vertex of the edge
            int v2 = s.nextInt(); // Read the second vertex of the edge
            int weight = s.nextInt(); // Read the weight of the edge
            adjacencyMatrix[v1][v2] = weight; // Set the weight in the adjacency matrix
            adjacencyMatrix[v2][v1] = weight; // Since the graph is undirected, set the symmetric value
        }

        // Call Dijkstra's algorithm to find the shortest paths from the source vertex
        // (vertex 0)
        dijkstra(adjacencyMatrix);
    }
}
