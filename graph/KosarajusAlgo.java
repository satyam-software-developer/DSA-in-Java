package graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {

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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    // Method to perform topological sorting of the graph
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        // Traverse all adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr); // Push the current vertex to the stack after visiting all its adjacent vertices
    }

    // Depth First Search (DFS) traversal of the graph
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " "); // Print the current vertex

        // Traverse all adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    // Implementation of Kosaraju's Algorithm for finding strongly connected components
    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V) {
        // Step 1: Perform topological sorting using DFS
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // Reverse the direction of edges
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3: Perform DFS on the transpose graph and print strongly connected components
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                dfs(transpose, curr, vis); // Perform DFS on the transpose graph
                System.out.println(); // Move to the next line after printing each strongly connected component
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Apply Kosaraju's Algorithm to find strongly connected components
        kosarajuAlgo(graph, V);
    }

}
