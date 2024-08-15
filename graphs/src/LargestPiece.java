
/*Problem statement
It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains an integer, that denotes the value of N. 
Each of the following N lines contain N space separated integers.
Output Format :
Print the count of '1's in the biggest piece of '1's, according to the description in the task.
Constraints :
1 <= N <= 1000
Time Limit: 1 sec
Sample Input 1:
2
1 1
0 1
Sample Output 1:
3 */
/*
 * Time complexity: O(N*N)
 * Space complexity: O(N*N)
 * 
 * where N is the size of cake 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {

    // Direction vectors for moving up, down, right, and left in the grid
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    // Main DFS function to find the largest connected piece of '1's in the grid
    public static int dfs(String[] edge, int n) {
        boolean[][] visited = new boolean[n][n]; // Array to keep track of visited cells

        int ans = 0; // Variable to store the size of the largest piece
        for (int i = 0; i < n; i++) { // Loop through all cells in the grid
            for (int j = 0; j < n; j++) {
                // If the cell is unvisited and contains '1', initiate DFS
                if (visited[i][j] == false && edge[i].charAt(j) == '1') {
                    // Update the answer with the maximum size found so far
                    ans = Math.max(ans, dfs(edge, visited, i, j, n));
                }
            }
        }
        return ans; // Return the size of the largest piece found
    }

    // Helper DFS function to explore the grid recursively
    private static int dfs(String[] edge, boolean[][] visited, int x, int y, int n) {
        visited[x][y] = true; // Mark the current cell as visited
        int count = 1; // Initialize the count for the current piece

        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int nex = x + dir[i][0]; // Calculate the next cell's row index
            int ney = y + dir[i][1]; // Calculate the next cell's column index

            // Check if the next cell is valid, contains '1', and is unvisited
            if (valid(nex, ney, n) && edge[nex].charAt(ney) == '1' && visited[nex][ney] == false) {
                // Recursively explore the next cell and accumulate the count
                count += dfs(edge, visited, nex, ney, n);
            }
        }
        return count; // Return the total count for the current piece
    }

    // Function to check if a cell is within the bounds of the grid
    private static boolean valid(int x, int y, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to take input from the user
    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Read the size of the grid

        String[] edge = new String[n]; // Create an array to store the grid
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", ""); // Read each row of the grid
        }
        return edge; // Return the grid
    }

    // Main method
    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput(); // Take input for the grid
        int ans = dfs(edge, edge.length); // Find the largest piece of '1's in the grid
        System.out.println(ans); // Output the size of the largest piece
    }
}
