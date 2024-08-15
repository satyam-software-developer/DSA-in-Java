
/* Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using BFS and print the shortest path available.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
Print the path from v1 to v2 in reverse order.
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
 */

/*
 * In a typical BFS search, the time complexity is O(V+E)
 * where V is the number of vertices and 
 * E is the number of edges.
 * 
 * There are n nodes and m edges in this problem.
 * We build adjacent list of all m edges in  graph which takes O(m)
 * Each node is added to the queue and popped from queue once, it takes O(n) to handle all nodes.
 * The time complexity is O(n+m).
 * 
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class GetPathBFS {
    // Scanner object for reading input
    static Scanner s = new Scanner(System.in);

    // Helper method to perform BFS and find a path from 'sv' (start vertex) to 'ev'
    // (end vertex)
    public static ArrayList<Integer> getPathBFSHelper(int[][] edges, int sv, int ev, boolean[] visited) {
        int n = edges.length; // Get the number of vertices in the graph

        Map<Integer, Integer> map = new HashMap<>(); // Map to store the parent of each vertex
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        // Check for invalid input of sv or ev
        if (sv > (edges.length - 1) || ev > (edges.length - 1)) {
            return null; // Return null if either source or end vertex is out of bounds
        }

        // If there's a direct edge and sv is the same as ev
        if (edges[sv][ev] == 1 && sv == ev) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sv); // Add the vertex to the path
            return ans; // Return the path
        }

        queue.add(sv); // Enqueue the starting vertex
        visited[sv] = true; // Mark the starting vertex as visited

        // Loop until there are no more vertices to visit
        while (!queue.isEmpty()) {
            int front = queue.remove(); // Dequeue a vertex from the front of the queue

            // Explore all adjacent vertices of the current vertex
            for (int i = 0; i < n; i++) {
                if (edges[front][i] == 1 && !visited[i]) { // Check for an unvisited adjacent vertex
                    map.put(i, front); // Store the parent of the adjacent vertex
                    queue.add(i); // Enqueue the adjacent vertex

                    visited[i] = true; // Mark the vertex as visited

                    // If the adjacent vertex is the end vertex, construct the path
                    if (i == ev) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(ev); // Add the end vertex to the path
                        int value = map.get(ev); // Get the parent of the end vertex

                        // Backtrack through the parent map to construct the path
                        while (value != sv) {
                            ans.add(value); // Add each vertex in the path
                            value = map.get(value); // Move to the parent of the current vertex
                        }
                        ans.add(value); // Add the start vertex to the path

                        return ans; // Return the constructed path
                    }
                }
            }
        }
        return null; // If the loop ends, there is no path between sv and ev
    }

    // Method to initiate BFS and find a path from 'sv' (start vertex) to 'ev' (end
    // vertex)
    public static ArrayList<Integer> getPathBFS(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length]; // Array to keep track of visited vertices
        return getPathBFSHelper(edges, sv, ev, visited); // Call the helper method to find the path
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the number of vertices and edges
        String[] strNums;
        strNums = s.nextLine().split("\\s"); // Split the input by whitespace
        int n = Integer.parseInt(strNums[0]); // Number of vertices in the graph
        int e = Integer.parseInt(strNums[1]); // Number of edges in the graph

        int edges[][] = new int[n][n]; // Adjacency matrix to represent the graph, Space complexity O(V^2)

        // Loop to take all edges as input
        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = s.nextLine().split("\\s"); // Split the input by whitespace to get the edge vertices
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

        // Get the path from sv to ev using BFS
        ArrayList<Integer> ans = getPathBFS(edges, sv, ev);
        if (ans != null) { // If a path exists
            for (int elem : ans) { // Print all elements in the path
                System.out.print(elem + " ");
            }
        }
    }
}
