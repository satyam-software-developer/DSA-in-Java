package graph;

import java.util.ArrayList;

public class PrintAllPath {

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

    // Depth-first search (DFS) traversal method
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " "); // Print the current vertex
        vis[curr] = true; // Mark the current vertex as visited

        // Explore all adjacent vertices
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // If the adjacent vertex is not visited
                dfs(graph, e.dest, vis); // Recursively visit the adjacent vertex
            }
        }
    }

    // Method to print all paths from a source to a target vertex in the graph
    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar) {
        // If the current vertex is the target vertex, print the current path
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        // Explore all adjacent vertices
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // If the adjacent vertex is not visited
                vis[curr] = true; // Mark the current vertex as visited
                // Recursively call the method to explore the adjacent vertex
                printAllPath(graph, vis, e.dest, path + e.dest, tar);
                vis[curr] = false; // Mark the current vertex as unvisited (backtrack)
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 7; // Number of vertices in the graph

        /*
        Graph:
           1 ----  3
        /          |  \
        0          |   5 -- 6
         \         | /
          2 -----  4
        */

        ArrayList<Edge> graph[] = new ArrayList[V]; // Create an array to represent the graph
        createGraph(graph); // Initialize the graph with edges

        int src = 0, tar = 5; // Source and target vertices for finding paths
        printAllPath(graph, new boolean[V], src, "0", tar); // Find and print all paths from source to target
    }
}
