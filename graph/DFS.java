package graph;

import java.util.*;

public class DFS {

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
            graph[i] = new ArrayList<Edge>(); // Initialize each vertex with an empty list of edges
        }

        // Define the edges of the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // Method to perform depth-first search (DFS) traversal of the graph
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " "); // Print the current vertex
        vis[curr] = true; // Mark the current vertex as visited

        // Traverse all the adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // If the destination vertex of the edge is not visited, recursively perform DFS
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 7; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V]; // Array to track visited vertices

        // Perform DFS traversal starting from each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis);
            }
        }

        System.out.println(); // Print a new line after DFS traversal
    }
}
