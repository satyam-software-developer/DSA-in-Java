
/* Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using DFS and print the first path that you encountered.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
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
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1:
3 0 1
Sample Input 2:
6 3
5 3
0 1
3 4
0 3
Sample Output 2: */

/*
 * Time complexity: O(V + E)
 * Space complexity: O(V^2)
 * 
 * where V is the number of vertices in the input graph and
 * E is the number of edges in the input graph
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class GetPathDFS {

    // Scanner object for reading input
    static Scanner s = new Scanner(System.in);

    // Helper method to perform DFS and find a path from 'sv' (start vertex) to 'ev'
    // (end vertex)
    public static ArrayList<Integer> getPathDFSHelper(int[][] edges, int sv, int ev, boolean[] visited) {
        // Base case: if start vertex is the same as end vertex
        if (sv == ev) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sv); // Add the vertex to the path
            return ans; // Return the path
        }

        visited[sv] = true; // Mark the current vertex as visited
        int n = edges.length; // Get the number of vertices in the graph

        // Explore all adjacent vertices
        for (int i = 0; i < n; i++) {
            // Check if there is an edge and the adjacent vertex is not visited
            if (edges[sv][i] == 1 && !visited[i]) {
                // Recursively call DFS on the adjacent vertex
                ArrayList<Integer> smallAns = getPathDFSHelper(edges, i, ev, visited);

                // If a path is found, add the current vertex to the path and return
                if (smallAns != null) {
                    smallAns.add(sv);
                    return smallAns;
                }
            }
        }
        // Return null if no path is found from the current vertex
        return null;
    }

    // Method to initiate DFS and find a path from 'sv' (start vertex) to 'ev' (end
    // vertex)
    public static ArrayList<Integer> getPathDFS(int[][] edges, int sv, int ev) {
        boolean visited[] = new boolean[edges.length]; // Array to keep track of visited vertices
        return getPathDFSHelper(edges, sv, ev, visited); // Call the helper method to find the path
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
            String[] strNums1;
            strNums1 = s.nextLine().split("\\s");
            int fv = Integer.parseInt(strNums1[0]); // First vertex of the edge
            int sv = Integer.parseInt(strNums1[1]); // Second vertex of the edge
            edges[fv][sv] = 1; // Mark the edge as present in the adjacency matrix
            edges[sv][fv] = 1; // Since the graph is undirected, mark the reverse edge as well
        }

        // Read the source and end vertices to find the path
        String[] strNums1;
        strNums1 = s.nextLine().split("\\s");
        int sv = Integer.parseInt(strNums1[0]); // Source vertex
        int ev = Integer.parseInt(strNums1[1]); // End vertex

        // Get the path from sv to ev using DFS
        ArrayList<Integer> ans = getPathDFS(edges, sv, ev);
        if (ans != null) { // If a path exists
            for (int elem : ans) { // Print all elements in the path
                System.out.print(elem + " ");
            }
        }
    }
}
