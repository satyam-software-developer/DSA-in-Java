package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {
    // Inner class representing an edge in the graph
    static class Edge {
        int src; // Source vertex of the edge
        int dest; // Destination vertex of the edge
        int wt; // Weight of the edge

        // Constructor to initialize an edge
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Method to create the graph using adjacency list representation
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>(); // Initialize each vertex with an empty list of edges
        }

        // Define the edges of the graph
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Inner class representing a pair of node and its distance
    public static class Pair implements Comparable<Pair> {
        int node; // Node or vertex
        int dist; // Distance

        // Constructor to initialize a pair
        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        // Compare pairs based on distance (needed for PriorityQueue)
        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // Ascending order based on distance
        }
    }

    // Dijkstra's algorithm to find the shortest paths from source to all other vertices
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Priority queue to store vertices based on their distance
        int dist[] = new int[V]; // Array to store the shortest distances from source to all vertices
        boolean vis[] = new boolean[V]; // Array to track visited vertices

        // Initialize distances to all vertices as infinity except for the source vertex
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0)); // Add the source vertex to the priority queue with distance 0

        // Dijkstra's algorithm loop
        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); // Extract the vertex with the minimum distance from the priority queue
            if (!vis[curr.node]) { // Process the vertex only if it hasn't been visited yet
                vis[curr.node] = true; // Mark the vertex as visited

                // Explore all adjacent vertices of the current vertex
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;

                    // Relaxation: Update the distance if a shorter path is found
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt; // Update the distance
                        pq.add(new Pair(v, dist[v])); // Add the updated vertex to the priority queue
                    }
                }
            }
        }

        // Print the shortest distances from the source vertex to all other vertices
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println(); // Move to the next line after printing all distances
    }

    // Main method
    public static void main(String[] args) {
        int V = 6; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Apply Dijkstra's algorithm to find the shortest paths from the source vertex (0) to all other vertices
        dijkstra(graph, 0, V);
    }
}
