package graph;

import java.util.ArrayList;

public class Bridge {

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

    // Method to perform depth-first search (DFS) on the graph to find bridges
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[], int dt[], int low[], int time, int par) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            } else if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println("bridge is :" + curr + "---" + e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    // Method to find bridges in the graph
    public static void getBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V]; // Discovery time array for vertices
        int low[] = new int[V]; // Low time array for vertices
        int time = 0;

        boolean vis[] = new boolean[V]; // Array to track visited vertices
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, dt, low, time, -1); // Perform DFS starting from vertex i
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        // Find and print bridges in the graph
        getBridge(graph, V);
    }
}
