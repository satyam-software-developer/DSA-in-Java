package graph;
import java.util.*;
import java.util.ArrayList;

public class PrimsAlgo {

    // Inner class representing an edge in the graph
    static class Edge {
        int src; // Source vertex of the edge
        int dest; // Destination vertex of the edge
        int wt; // Weight/cost of the edge

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

        // Define the edges of the graph along with their weights
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    // Inner class representing a pair of values (node, cost)
    public static class Pair implements Comparable<Pair> {
        int node; // Node/vertex
        int cost; // Cost associated with reaching this node

        // Constructor to initialize a pair
        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        // CompareTo method to compare pairs based on their costs
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // Ascending order based on cost
        }
    }

    // Method implementing Prim's algorithm to find the minimum spanning tree (MST)
    public static void primsAlgo(ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Priority queue to store non-MST edges
        boolean vis[] = new boolean[V]; // Array to mark visited nodes
        pq.add(new Pair(0, 0)); // Add the starting node (0) with cost 0 to the priority queue

        int mstCost = 0; // Variable to store the total cost of the MST

        // Main loop of Prim's algorithm
        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); // Remove the node with the minimum cost
            if (!vis[curr.node]) { // If the current node is not visited
                vis[curr.node] = true; // Mark it as visited
                mstCost += curr.cost; // Add its cost to the total cost of the MST

                // Explore the adjacent edges of the current node
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) { // If the adjacent node is not visited
                        pq.add(new Pair(e.dest, e.wt)); // Add it to the priority queue
                    }
                }
            }
        }

        // Print the minimum cost of the MST
        System.out.println("Minimum cost of Minimum Spanning Tree (MST) = " + mstCost);
    }

    // Main method
    public static void main(String[] args) {
        int V = 4; // Number of vertices in the graph

        ArrayList<Edge> graph[] = new ArrayList[V]; // Create an array to represent the graph
        createGraph(graph); // Initialize the graph with edges and weights
        primsAlgo(graph, V); // Apply Prim's algorithm to find the MST
    }
}
