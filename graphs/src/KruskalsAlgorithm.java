
/* Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.

Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.

For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
Print the MST, as described in the task.
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph

Sample Output 1 :
1 2 1
0 1 3
0 3 5
Input Graph */

/*
 * Time complexity: O(E * log(E))
 * Space complexity: O(V + E)
 * 
 * where E is the number of edges in the graph and
 * V is the number of vertices in the graph
 */

import java.util.Arrays;
import java.util.Scanner;

// Define a class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int source; // The source vertex of the edge
    int dest; // The destination vertex of the edge
    int weight; // The weight of the edge

    // Method to print the edge in the required format
    void printEdge() {
        System.out.println(Math.min(source, dest) + " " + Math.max(source, dest) + " " + weight);
    }

    // Override the compareTo method to compare edges based on their weight
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class KruskalsAlgorithm {

    // Method to find the parent of a vertex in the disjoint set
    static int findParent(int v, int[] parent) {
        if (parent[v] == v) {
            return v;
        }
        // Recursively find the top-most parent (root) of the vertex
        return findParent(parent[v], parent);
    }

    // Method to implement Kruskal's algorithm
    private static void kruskal(Edge[] input, int v, int e) {
        // Sort all the edges in ascending order of their weight
        Arrays.sort(input);

        // Array to store the edges of the Minimum Spanning Tree (MST)
        Edge[] output = new Edge[v - 1];

        // Array to keep track of the parent of each vertex (for the disjoint set)
        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i; // Initially, each vertex is its own parent
        }

        int count = 0; // Number of edges included in the MST
        int i = 0; // Index to iterate through sorted edges

        // Keep adding edges to the MST until we have v-1 edges
        while (count != v - 1) {
            Edge currentEdge = input[i];

            // Find the parent of the source and destination vertices
            int sourceParent = findParent(currentEdge.source, parent);
            int destParent = findParent(currentEdge.dest, parent);

            // If they have different parents, adding this edge won't form a cycle
            if (sourceParent != destParent) {
                output[count] = currentEdge; // Add the edge to the MST
                count++;
                parent[sourceParent] = destParent; // Union the sets
            }
            i++;
        }

        // Print all the edges in the MST
        for (int j = 0; j < v - 1; j++) {
            output[j].printEdge();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Read the number of vertices and edges from the user
        int v = s.nextInt();
        int e = s.nextInt();

        // Array to store all edges
        Edge[] input = new Edge[e];

        // Read all edges from the user
        for (int i = 0; i < e; i++) {
            input[i] = new Edge();
            input[i].source = s.nextInt();
            input[i].dest = s.nextInt();
            input[i].weight = s.nextInt();
        }
        s.close();

        // Call the Kruskal's algorithm function
        kruskal(input, v, e);
    }
}
