package graph;
import java.util.*;
import java.util.ArrayList;

public class CycleDetectionUG {

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
        graph[0].add(new Edge(0, 4));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
    }

    // Method to detect cycles in an undirected graph using DFS
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        // Iterate through the adjacent vertices of the current vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // If the destination vertex is visited and not the parent, a cycle is found
            if (vis[e.dest] && e.dest != par) {
                return true;
            } else if (!vis[e.dest]) {
                // If the destination vertex is not visited yet, recursively check for a cycle
                if (isCycleUndirected(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        int V = 6; // Number of vertices in the graph

        // Create the adjacency list representation of the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Check for cycles in the graph starting from vertex 0
        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));
    }
}
