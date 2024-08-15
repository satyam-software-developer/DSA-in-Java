package graph;
import java.util.*;

public class TopologicalSort {

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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Utility function for topological sort
    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true; // Mark the current vertex as visited

        // Traverse through all adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Recursively call topological sort for unvisited adjacent vertices
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr); // Push the current vertex to the stack after processing its adjacent vertices
    }

    // Method to perform topological sort on the graph
    public static void topSort(ArrayList<Edge> graph[], int V) {
        boolean vis[] = new boolean[V]; // Array to track visited vertices
        Stack<Integer> stack = new Stack<>(); // Stack to store the topological ordering

        // Traverse through all vertices and call topological sort utility for each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }

        // Print the elements of the stack to get the topological ordering
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 6; // Number of vertices in the graph

        ArrayList<Edge> graph[] = new ArrayList[V]; // Create an array to represent the graph
        createGraph(graph); // Initialize the graph with edges
        topSort(graph, V); // Perform topological sort on the graph
    }
}
