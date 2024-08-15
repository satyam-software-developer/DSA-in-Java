
/* Problem statement
Given an undirected graph G(V,E), check if the graph G is connected graph or not.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
Output Format :
The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
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
true
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
false 
Sample Output 2 Explanation
The graph is not connected, even though vertices 0,1 and 3 are connected to each other but there isn’t any path from vertices 0,1,3 to vertex 2.  */

/*
 * Time complexity: O(V + E)
 * Space complexity: (V^2)
 * 
 * where V is the number of vertices in the input graph and 
 * E is the number of edges in the input graph
 */

import java.util.Scanner;
import java.io.IOException;

public class IsConnected {
    static Scanner s = new Scanner(System.in);

    public static void DFS(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                DFS(edges, i, visited);
                visited[i] = true;
            }
        }
    }

    public static boolean isConnected(int[][] edges) {
        boolean[] visited = new boolean[edges.length];

        DFS(edges, 0, visited);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the number of vertices and edges
        String[] strNums;
        strNums = s.nextLine().split("\\s"); // Split the input by whitespace
        int n = Integer.parseInt(strNums[0]); // Number of vertices in the graph
        int e = Integer.parseInt(strNums[1]); // Number of edges in the graph

        if (n == 0) {
            System.out.println("true");
            return;
        }

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
        System.out.println(isConnected(edges));

    }
}
