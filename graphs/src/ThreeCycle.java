
/*Problem statement
Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two space separated integers, that denotes the value of N and M.
Each of the following M lines contain two integers, that denote the vertices which have an undirected edge between them. Let us denote the two vertices with the symbol u and v. 
Output Format :
Print the count the number of 3-cycles in the given graph
Constraints :
0 <= N <= 100
0 <= M <= (N*(N-1))/2
0 <= u <= N - 1
0 <= v <= N - 1
Time Limit: 1 sec
Sample Input 1:
3 3
0 1
1 2
2 0
Sample Output 1:
1 */
/*
 * Time complexity: O(n^3)
 * Space complexity: O(N^2)
 * 
 * where N is the number of vertices in the input graph and 
 * E is the number of edges in the input graph
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeCycle {
    // BufferedReader to take input from the user
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to count the number of 3-cycles (triangles) in the graph
    public static int solve(boolean[][] graph, int n) {
        int cycleCount = 0; // Initialize a counter for the number of cycles

        // Loop through all possible triplets of vertices (i, j, k)
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    // Check if the triplet forms a cycle (i.e., i -> j, j -> k, k -> i)
                    if (graph[i][j] && graph[j][k] && graph[k][i]) {
                        ++cycleCount; // Increment the cycle count if a cycle is found
                    }
                }
            }
        }
        return cycleCount; // Return the total number of 3-cycles found
    }

    // Function to take input for the graph
    public static boolean[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s"); // Read the first line containing n and m
        int n = Integer.parseInt(strNums[0]); // Number of vertices
        int m = Integer.parseInt(strNums[1]); // Number of edges

        boolean[][] graphs = new boolean[n][n]; // Initialize the adjacency matrix
        int firstvertex, secondvertex;

        // Loop through all the edges to fill the adjacency matrix
        for (int i = 0; i < m; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s"); // Read the vertices connected by an edge
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            graphs[firstvertex][secondvertex] = true; // Mark the edge in the adjacency matrix
            graphs[secondvertex][firstvertex] = true; // Since the graph is undirected, mark the reverse edge as well
        }
        return graphs; // Return the adjacency matrix
    }

    // Main method
    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean[][] graphs = takeInput(); // Take input for the graph

        int ans = solve(graphs, graphs.length); // Solve the problem to find the number of 3-cycles
        System.out.println(ans); // Print the result
    }
}
