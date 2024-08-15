package graph;

import java.util.ArrayList;

public class TarjansAlgo {

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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // Depth-first search (DFS) method to find articulation points
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time, boolean ap[]) {

        vis[curr] = true; // Mark the current vertex as visited
        dt[curr] = low[curr] = ++time; // Initialize discovery time and low value for the current vertex
        int children = 0; // Count children of the current vertex

        // Traverse through all adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest; // Neighbor vertex

            if (par == neigh) {
                continue; // Skip if the neighbor is the parent
            } else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]); // Update low value of the current vertex
            } else {
                // Recursively call DFS for the neighbor vertex
                dfs(graph, neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]); // Update low value of the current vertex

                // Check if the current vertex is an articulation point
                if (dt[curr] <= low[neigh] && par != -1) {
                    ap[curr] = true; // Mark the current vertex as an articulation point
                }
                children++; // Increment children count
            }
        }

        // Check if the current vertex is the root and has more than one child
        if (par == -1 && children > 1) {
            ap[curr] = true; // Mark the current vertex as an articulation point
        }
    }

    // Method to get articulation points in the graph
    public static void getAP(ArrayList<Edge> graph[], int V, int time) {
        int dt[] = new int[V]; // Array to store discovery time of vertices
        int low[] = new int[V]; // Array to store low values of vertices
        boolean vis[] = new boolean[V]; // Array to track visited vertices
        boolean ap[] = new boolean[V]; // Array to store articulation points

        // Traverse through all vertices and call DFS for each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }

        // Print articulation points
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP: " + i);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph

        ArrayList<Edge> graph[] = new ArrayList[V]; // Create an array to represent the graph
        createGraph(graph); // Initialize the graph with edges
        getAP(graph, V, V); // Get and print articulation points in the graph
    }
}

