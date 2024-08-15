package graph;

import java.util.*;

public class CycleDetectionDG {

    // Inner class representing an edge in the graph
    static class Edge {
        int src; // Source vertex of the edge
        int dest; // Destination vertex of the edge

        // Constructor to initialize an edge
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Method to create the graph using adjacency list representation
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Define the edges of the graph
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    // Method to perform cycle detection in a directed graph using DFS
    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {
        // Mark the current vertex as visited and in the recursion stack
        vis[curr] = true;
        rec[curr] = true;

        // Iterate through the adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // If the destination vertex is already in the recursion stack, a cycle is found
            if (rec[e.dest]) {
                return true;
            } else if (!vis[e.dest]) {
                // If the destination vertex is not visited yet, recursively check for a cycle
                if (isCycleDirected(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }

        // Mark the current vertex as not in the recursion stack
        rec[curr] = false;
        return false;
    }

    // Main method
    public static void main(String[] args) {
        int V = 4; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Array to track visited vertices
        boolean vis[] = new boolean[V];
        // Array to track vertices in the recursion stack
        boolean rec[] = new boolean[V];

        // Iterate through the vertices and check for cycles
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                // Check for cycles starting from vertex i
                boolean isCycle = isCycleDirected(graph, vis, 0, rec);
                if (isCycle) {
                    System.out.println(isCycle); // Print if a cycle is found
                    break;
                }
            }
        }
    }
}
