
/* Problem statement
You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.

You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line contains the number of test cases T. T cases follow. Each test case consists of R C in the first line followed by the description of the grid in R lines, each containing C integers. Rows are numbered 1 to R from top to bottom and columns are numbered 1 to C from left to right. Cells with A[i][j] < 0 contain poison, others contain magic juice.
Output format:
Output T lines, one for each case containing the minimum strength you should start with from the cell (1,1) to have a positive strength through out his journey to the cell (R,C).
Constraints:
1 ≤ T ≤ 5
2 ≤ R, C ≤ 500
-10^3 ≤ A[i][j] ≤ 10^3
A[1][1] = A[R][C] = 0
Time Limit: 1 second
Sample Input 1:
3
2 3
0 1 -3
1 -2 0
2 2
0 1
2 0
3 4
0 -2 -3 1
-1 4 0 -2
1 -2 -3 0
Sample Output 1:
2
1
2 */

/*
    * Time complexity: O(N * M)
    * Space complexity: O(N * M)
    * 
    * where N and M are the rows and columns respectively of the given grid
    */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicGrid {

    // Method to find the minimum strength required to navigate from top-left to
    // bottom-right of the grid
    public static int getMinimumStrength(int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        int[][] dp = new int[n + 1][m + 1]; // DP table to store minimum strength required at each cell

        // Initialize dp array with a large value (effectively infinity)
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: minimum strength needed to move out of the grid from the
        // destination
        dp[n][m - 1] = 1; // Just outside the last cell in the last row
        dp[n - 1][m] = 1; // Just outside the last cell in the last column

        // Fill the dp array from bottom-right to top-left
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                // Calculate the minimum strength needed to survive
                int neededStrength = Math.min(dp[i + 1][j], dp[i][j + 1]) - grid[i][j];
                dp[i][j] = (neededStrength <= 0) ? 1 : neededStrength; // Ensure at least 1 strength is needed
            }
        }

        // The minimum strength required to start from the top-left corner
        return dp[0][0];
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for fast input

    // Method to take input for the grid
    public static int[][] takeInput() throws IOException {
        String[] nm = br.readLine().split("\\s"); // Read the dimensions of the grid
        int n = Integer.parseInt(nm[0]); // Number of rows
        int m = Integer.parseInt(nm[1]); // Number of columns
        int[][] arr = new int[n][m]; // Initialize the grid

        // Read the grid values
        for (int i = 0; i < n; ++i) {
            String[] strNums = br.readLine().split("\\s");
            for (int j = 0; j < m; ++j) {
                arr[i][j] = Integer.parseInt(strNums[j]);
            }
        }

        return arr; // Return the grid
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases
        while (t != 0) { // Process each test case
            int[][] grid = takeInput(); // Take input for the current grid
            System.out.println(getMinimumStrength(grid)); // Print the minimum strength required for the current grid
            t--; // Decrement the test case count
        }
    }
}
