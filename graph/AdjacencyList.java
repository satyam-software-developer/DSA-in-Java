package graph;

import java.util.ArrayList;

public class AdjacencyList {
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
        // Initialize each list in the array with an ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Define the edges of the graph
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int V = 4; // Number of vertices in the graph

        // Create an array of ArrayLists to represent the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph); // Create the graph

        // Print the neighbors of vertex 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i); // Get the i-th edge connected to vertex 2
            System.out.println(e.dest + " ," + e.wt); // Print the destination vertex and weight of the edge
        }
    }
}
