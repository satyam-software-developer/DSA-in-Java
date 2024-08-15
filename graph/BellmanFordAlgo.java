package graph;
import java.util.*;
import java.util.ArrayList;

public class BellmanFordAlgo {
    // Inner class representing an edge in the graph
    static class Edge {
        int src; // Source vertex
        int dest; // Destination vertex
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
            graph[i] = new ArrayList<Edge>(); // Initialize each list in the array with an ArrayList
        }

        // Define the edges of the graph
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));
        
        graph[3].add(new Edge(3, 4, 4));
        
        graph[4].add(new Edge(4, 1, -1));
    }

    // Method to perform Bellman-Ford algorithm to find shortest paths from source vertex
    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V]; // Array to store distances from source vertex to other vertices

        // Initialize distances: set all distances to infinity except the source vertex
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Relax edges |V| - 1 times
        for (int k = 0; k < V - 1; k++) {
            // Traverse all edges and relax them
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    // Relax the edge if a shorter path is found
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        // Print the distances from the source vertex to all other vertices
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph); // Create the graph

        // Perform Bellman-Ford algorithm from source vertex 0
        bellmanFord(graph, 0, V);
    }
}
