package graph;

import java.util.*;

public class BFS {
    // Inner class representing an edge in the graph
    static class Edge {
        int src; // Source vertex
        int dest; // Destination vertex

        // Constructor to initialize an edge
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Method to create the graph using adjacency list representation
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize the adjacency lists
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
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

    // Method to perform breadth-first search (BFS) on the graph
    public static void bfs(ArrayList<Edge> graph[], int V) {
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS traversal
        boolean vis[] = new boolean[V]; // Array to track visited vertices
        q.add(0); // Start BFS from vertex 0

        while (!q.isEmpty()) {
            int curr = q.remove(); // Dequeue the current vertex
            if (!vis[curr]) { // Process only if the current vertex is not visited
                System.out.print(curr + " "); // Print the current vertex
                vis[curr] = true; // Mark the current vertex as visited

                // Enqueue all adjacent vertices of the current vertex
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); // Enqueue the destination vertex of the edge
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 7; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Perform BFS traversal starting from vertex 0
        bfs(graph, V);
        System.out.println(); // Move to the next line after printing the BFS traversal
    }
}
