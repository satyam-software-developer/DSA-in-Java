/*
Problem statement
For a given two-dimensional integer array/list of size (N x M), 
find and print the sum of each of the row elements in a single line, separated by a single space.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. 
They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'M' column values separated by a single space.
Output Format :
For each test case, print the sum of every ith row elements in a single line separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
4 2 
1 2 
3 4 
5 6 
7 8
Sample Output 1:
3 7 11 15 
Sample Input 2:
2
2 5 
4 5 3 2 6 
7 5 3 8 9
4 4
1 2 3 4
9 8 7 6
3 4 5 6
-1 1 -10 5
Sample Output 2:
20 32 
10 30 18 -5 

*/

package arrays;

import java.util.Scanner; // Import the Scanner class for user input

public class RowWiseSum {
    // Method to compute the row-wise sum of a 2D array and print the sums
    public static void rowWiseSum(int[][] mat) {
        int nRows = mat.length; // Get the number of rows in the 2D array

        if (nRows == 0) { // Check if the 2D array is empty
            return; // If so, return without performing any operation
        }

        int mCols = mat[0].length; // Get the number of columns in the 2D array

        // Iterate over each row of the 2D array
        for (int i = 0; i < nRows; i++) {
            int rowSum = 0; // Initialize the sum for the current row

            // Iterate over each column of the current row
            for (int j = 0; j < mCols; j++) {
                rowSum += mat[i][j]; // Add the current element to the row sum
            }
            System.out.print(rowSum + " "); // Print the row sum
        }
        System.out.println(); // Print a newline after printing all row sums
    }

    // Main method
    public static void main(String[] args) {
        int t, m, n; // Variables to store the number of test cases and array dimensions
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input
        t = s.nextInt(); // Read the number of test cases from the user

        // Process each test case
        for (int k = 0; k < t; ++k) {
            n = s.nextInt(); // Read the number of rows in the 2D array
            m = s.nextInt(); // Read the number of columns in the 2D array
            int arr[][] = new int[n][m]; // Create a 2D array to store input elements

            // Input elements for each row of the 2D array
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = s.nextInt(); // Read each element of the 2D array
                }
            }
            rowWiseSum(arr); // Compute and print the row-wise sum of the 2D array
        }
    }
}
