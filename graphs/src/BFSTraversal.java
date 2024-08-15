
/*Problem statement
Given an undirected and disconnected graph G(V, E), print its BFS traversal.

Note:

1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print the BFS Traversal, as described in the task.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2 */
/*
 * Time complexity: O(V + E)
 * Space complexity: O(V^2)
 * 
 * where V is the number of vertices in the input graph and 
 * E is the number of edges in input graph
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.IOException;

public class BFSTraversal {

    static Scanner s = new Scanner(System.in); // Scanner object for reading input

    // Helper method to perform BFS traversal starting from a given vertex 'sv'
    public static void printBFSHelper(int edges[][], int sv, boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>(); // Queue to manage the BFS traversal
        visited[sv] = true; // Mark the starting vertex as visited
        queue.add(sv); // Enqueue the starting vertex

        while (!queue.isEmpty()) { // Loop until there are no more vertices to visit
            int front = queue.remove(); // Dequeue a vertex from the front of the queue
            System.out.print(front + " "); // Print the vertex

            // Explore all adjacent vertices of the current vertex
            for (int i = 0; i < edges.length; i++) {
                // Check if there is an edge between the current vertex and vertex 'i'
                // Also check if vertex 'i' has not been visited yet
                if (edges[front][i] == 1 && !visited[i]) {
                    visited[i] = true; // Mark vertex 'i' as visited
                    queue.add(i); // Enqueue vertex 'i' for further exploration
                }
            }
        }
    }

    // Method to initiate BFS traversal for all components of the graph
    public static void printBFS(int edges[][]) {
        boolean visited[] = new boolean[edges.length]; // Array to keep track of visited vertices

        // Traverse all vertices to handle disconnected components
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) { // If the vertex has not been visited yet
                // This check is performed to ensure BFS covers all disconnected components
                printBFSHelper(edges, i, visited); // Start BFS from this vertex
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] strNums;
        strNums = s.nextLine().split("\\s"); // Read the number of vertices and edges
        int n = Integer.parseInt(strNums[0]); // Number of vertices in the graph
        int e = Integer.parseInt(strNums[1]); // Number of edges in the graph

        if (n == 0) { // If there are no vertices, exit the program
            return;
        }

        int edges[][] = new int[n][n]; // Adjacency matrix to represent the graph, Space complexity O(V^2)

        // Loop to take all edges as input
        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = s.nextLine().split("\\s"); // Read the endpoints of an edge
            int fv = Integer.parseInt(strNums1[0]); // First vertex of the edge
            int sv = Integer.parseInt(strNums1[1]); // Second vertex of the edge
            edges[fv][sv] = 1; // Mark the edge as present in the adjacency matrix
            edges[sv][fv] = 1; // Since the graph is undirected, mark the reverse edge as well
        }

        // Call the method to perform BFS traversal
        printBFS(edges);
    }
}
