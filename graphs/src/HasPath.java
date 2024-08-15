/* Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false */

/*
 * In a typical BFS search, the time complexity is O(V+E)
 * where V is the number of vertices and 
 * E is the number of edges.
 * 
 * There are n nodes and m edges in this problem.
 * we build adjacent list of all m edges in graph which takes O(m)
 * Each node is added to the queue and popped from queue once, it takes O(n) to handle all nodes.
 * The time complexity is O(n+m).
 */

import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.util.Scanner;

public class HasPath {

    // Scanner object for reading input
    static Scanner s = new Scanner(System.in);

    // Method to perform BFS to check if there's a path between 'sv' and 'ev'
    public static boolean BFS(int edges[][], int sv, int ev, boolean visited[]) {

        // Check for invalid input of sv or ev
        if (sv > (edges.length - 1) || ev > (edges.length - 1)) {
            return false; // Return false if either source or end vertex is out of bounds
        }

        // If there's a direct edge between sv and ev, return true
        if (edges[sv][ev] == 1) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>(); // Queue to manage the BFS traversal
        visited[sv] = true; // Mark the starting vertex as visited
        queue.add(sv); // Enqueue the starting vertex

        // Loop until there are no more vertices to visit
        while (!queue.isEmpty()) { // Time complexity: O(V) in the worst case since we are adding only vertices.
            int front = queue.remove(); // Dequeue a vertex from the front of the queue

            // Explore all adjacent vertices of the current vertex
            for (int i = 0; i < edges.length; i++) { // Time complexity: O(E) for checking all edges
                if (edges[front][i] == 1 && !visited[i]) { // Check for an unvisited adjacent vertex
                    if (i == ev) { // If the adjacent vertex is the end vertex, return true
                        return true;
                    } else {
                        visited[i] = true; // Mark the vertex as visited
                        queue.add(i); // Enqueue the vertex for further exploration
                    }
                }
            }
        }
        return false; // If the loop ends, there is no path between sv and ev
    }

    // Wrapper method to initiate BFS and check for a path
    private static boolean hasPath(int[][] edges, int sv, int ev) {
        boolean visited[] = new boolean[edges.length]; // Array to keep track of visited vertices
        return BFS(edges, sv, ev, visited); // Call BFS to check if a path exists
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        // Read the number of vertices and edges
        String[] strNums;
        strNums = s.nextLine().split("\\s");
        int n = Integer.parseInt(strNums[0]); // Number of vertices
        int e = Integer.parseInt(strNums[1]); // Number of edges

        int edges[][] = new int[n][n]; // Initialize adjacency matrix for the graph

        // Loop to read all edges and build the adjacency matrix
        for (int i = 0; i < e; i++) {
            // Creating Adjacency Matrix
            String[] strNums1;
            strNums1 = s.nextLine().split("\\s");
            int fv = Integer.parseInt(strNums1[0]); // First vertex of the edge
            int sv = Integer.parseInt(strNums1[1]); // Second vertex of the edge

            edges[fv][sv] = 1; // Mark the edge as present in the adjacency matrix
            edges[sv][fv] = 1; // Since the graph is undirected, mark the reverse edge as well
        }

        // Read the source and end vertices to check for a path
        String[] strNums1;
        strNums1 = s.nextLine().split("\\s");
        int sv = Integer.parseInt(strNums1[0]); // Source vertex
        int ev = Integer.parseInt(strNums1[1]); // End vertex

        // Check and print whether there is a path between sv and ev
        System.out.println(hasPath(edges, sv, ev));

    }
}
