/*
Problem statement
For a given two-dimensional integer array/list of size (N x M), you need to find out which row or column has the largest sum(sum of all the elements in a row or column) amongst all the rows/columns.

Note :
If there are more than one rows/columns with maximum sum, consider the row/column that comes first. 
And if ith row and jth column has the same largest sum, consider the ith row as answer.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. 
They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'M' column values separated by a single space.
Output Format :
For each test case, If row sum is maximum, then print: "row" <row_index> <row_sum>
OR
If column sum is maximum, then print: "column" <col_index> <col_sum>
It will be printed in a single line separated by a single space between each piece of information.

Output for every test case will be printed in a seperate line.
 Consider :
If there doesn't exist a sum at all then print "row 0 -2147483648", where -2147483648 or -2^31 is the smallest value for the range of Integer.
Constraints:
1 <= t <= 10^2
1 <= N <= 10^3
1 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
3 2
6 9 
8 5 
9 2 
Sample Output 1:
column 0 23
Sample Input 2:
1
4 4
6 9 8 5 
9 2 4 1 
8 3 9 3 
8 7 8 6 
Sample Output 2:
column 0 31

*/

package arrays;

import java.util.Scanner;

public class LargestRowOrColumn {

    // Method to find the row or column with the largest sum in the given matrix
    public static void findLargest(int mat[][]) {
        // Initialize variables to store the state of whether the largest sum is in a
        // row, the largest sum, and the index of the row or column
        boolean isRow = true;
        int largestSum = Integer.MIN_VALUE;
        int num = 0;

        // Get the number of rows in the matrix
        int nRows = mat.length;

        // Handle the case when the matrix has no rows (empty matrix)
        if (nRows == 0) {
            System.out.println("row" + num + " " + largestSum);
            return;
        }

        // Get the number of columns in the matrix
        int mCols = mat[0].length;

        // Iterate through each row to calculate the sum of elements in that row and
        // find the row with the largest sum
        for (int i = 0; i < nRows; i++) {
            int rowSum = 0;
            // Calculate the sum of elements in the current row
            for (int j = 0; j < mCols; j++) {
                rowSum += mat[i][j];
            }
            // Update the largest sum and the index if the current row's sum is greater than
            // the current largest sum
            if (rowSum > largestSum) {
                largestSum = rowSum;
                num = i; // Store the index of the row
            }
        }

        // Iterate through each column to calculate the sum of elements in that column
        // and find the column with the largest sum
        for (int j = 0; j < mCols; j++) {
            int colSum = 0;
            // Calculate the sum of elements in the current column
            for (int i = 0; i < nRows; i++) {
                colSum += mat[i][j];
            }
            // Update the largest sum, the index, and the flag indicating whether it's a row
            // or column if the current column's sum is greater than the current largest sum
            if (colSum > largestSum) {
                largestSum = colSum;
                num = j; // Store the index of the column
                isRow = false; // Update the flag to indicate it's not a row
            }
        }

        // Print whether the maximum sum belongs to a row or column, along with the
        // index and the sum
        if (isRow) {
            System.out.println("row " + num + " " + largestSum);
        } else {
            System.out.println("column " + num + " " + largestSum);
        }
    }

    // Main method
    public static void main(String[] args) {
        // Declare variables for the number of test cases (t), number of rows (n), and
        // number of columns (m)
        int t, m, n;

        // Create a new Scanner object to read input from the standard input stream
        Scanner s = new Scanner(System.in);

        // Input the number of test cases
        t = s.nextInt();

        // Iterate through each test case
        for (int k = 0; k < t; ++k) {
            // Input the number of rows and columns for the current test case
            n = s.nextInt(); // Number of rows
            m = s.nextInt(); // Number of columns

            // Declare and initialize a 2D array with dimensions n x m to store the elements
            // of the matrix
            int mat[][] = new int[n][m]; // Swap n and m in array dimensions

            // Input the elements of the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = s.nextInt(); // Input each element of the matrix
                }
            }

            // Call the findLargest() method to find the row or column with the largest sum
            // for the current test case
            findLargest(mat);
        }
    }
}
