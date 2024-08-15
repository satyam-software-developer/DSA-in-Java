
/* Problem statement
An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 0 to V-1) and E connections or edges between islands. Can you count the number of connected groups of islands.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b. 
Output Format :
Print the count the number of connected groups of islands
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V-1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1  */

/*
 * Time complexity: O(N^2)
 * Space complexity: O(N^2)
 * where N is the number of vertex in the graph
 */

import java.util.Scanner;
import java.io.IOException;

public class Islands {

    // Function to calculate the number of connected components (islands) in the
    // graph
    public static int numConnected(int[][] edges, int n) {
        boolean[] visited = new boolean[n]; // Array to keep track of visited vertices
        int count = 0; // Variable to store the number of connected components (islands)

        // Loop through all vertices
        for (int i = 0; i < n; i++) {
            // If the current vertex has not been visited, start a DFS from that vertex
            if (visited[i] == false) {
                dfs(edges, i, visited, n); // Perform DFS to visit all vertices in this component
                count++; // Increment the count of connected components (islands)
            }
        }
        return count; // Return the total number of connected components (islands)
    }

    // Helper function to perform DFS and visit all connected vertices
    private static void dfs(int[][] edges, int v1, boolean[] visited, int n) {
        visited[v1] = true; // Mark the current vertex as visited

        // Loop through all vertices to find adjacent vertices
        for (int i = 0; i < n; i++) {
            // If the vertex is not visited and there is an edge between the current vertex
            // and i
            if (visited[i] == false && edges[v1][i] == 1) {
                dfs(edges, i, visited, n); // Recursively visit the adjacent vertex
            }
        }
    }

    static Scanner sc = new Scanner(System.in); // Scanner object for reading input

    // Function to take input and build the adjacency matrix representation of the
    // graph
    public static int[][] takeInput() throws IOException {
        String[] strNums;
        strNums = sc.nextLine().split("\\s"); // Split the input by whitespace to get the number of vertices and edges
        int n = Integer.parseInt(strNums[0]); // Number of vertices in the graph
        int e = Integer.parseInt(strNums[1]); // Number of edges in the graph

        int[][] edges = new int[n][n]; // Adjacency matrix to represent the graph
        int firstvertex, secondvertex;

        // Loop to take all edges as input
        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = sc.nextLine().split("\\s"); // Split the input by whitespace to get the two vertices of an edge
            firstvertex = Integer.parseInt(strNums1[0]); // First vertex of the edge
            secondvertex = Integer.parseInt(strNums1[1]); // Second vertex of the edge
            edges[firstvertex][secondvertex] = 1; // Mark the edge as present in the adjacency matrix
            edges[secondvertex][firstvertex] = 1; // Since the graph is undirected, mark the reverse edge as well
        }
        return edges; // Return the constructed adjacency matrix
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] edges = takeInput(); // Read input and create the adjacency matrix

        int ans = numConnected(edges, edges.length); // Calculate the number of connected components (islands)
        System.out.println(ans); // Print the result
    }
}
