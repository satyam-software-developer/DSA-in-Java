/*
Problem statement
For a given two-dimensional integer array/list of size (N x M), 
print it in a spiral form. That is, you need to print in the order followed for every iteration:

a. First row(left to right)
b. Last column(top to bottom)
c. Last row(right to left)
d. First column(bottom to top)
 Mind that every element will be printed only once.

Refer to the Image:
Spiral path of a matrix

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. 
They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'M' column values separated by a single space.
Output format :
For each test case, print the elements of the two-dimensional array/list in the spiral form in a single line, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
4 4 
1 2 3 4 
5 6 7 8 
9 10 11 12 
13 14 15 16
Sample Output 1:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Sample Input 2:
2
3 3 
1 2 3 
4 5 6 
7 8 9
3 1
10
20
30
Sample Output 2:
1 2 3 6 9 8 7 4 5 
10 20 30 

*/

package arrays;

import java.util.Scanner; // Importing the Scanner class from java.util package for user input

public class PrintSpiral {
    // Function to print the elements of a 2D array in a spiral order
    public static void spiralPrint(int mat[][]) {
        int nRows = mat.length; // Getting the number of rows in the matrix
        if (nRows == 0) { // Checking if the number of rows is 0, if so, there's nothing to print, so
                          // return from the function
            return;
        }

        int mCols = mat[0].length; // Getting the number of columns in the matrix

        int i, rowStart = 0, colStart = 0; // Declaring variables for iteration and tracking the start indices
        int numElements = nRows * mCols, count = 0; // Calculating the total number of elements in the matrix and
                                                    // initializing a count variable

        while (count < numElements) { // Continue iterating until all elements are printed
            // Print the elements of the first row from the remaining rows
            for (i = colStart; count < numElements && i < mCols; ++i) {
                System.out.print(mat[rowStart][i] + " "); // Print the element at the current row and column index
                count++; // Increment the count of printed elements
            }
            rowStart++; // Move to the next row

            // Print the elements of the last column from the remaining columns
            for (i = rowStart; count < numElements && i < nRows; ++i) {
                System.out.print(mat[i][mCols - 1] + " "); // Print the element at the current row and last column
                count++; // Increment the count of printed elements
            }
            mCols--; // Decrement the number of columns

            // Print the elements of the last row from the remaining rows
            for (i = mCols - 1; count < numElements && i >= colStart; --i) {
                System.out.print(mat[nRows - 1][i] + " "); // Print the element at the last row and current column
                count++; // Increment the count of printed elements
            }
            nRows--; // Decrement the number of rows

            // Print the elements of the first column from the remaining columns
            for (i = nRows - 1; count < numElements && i >= rowStart; --i) {
                System.out.print(mat[i][colStart] + " "); // Print the element at the current row and first column
                count++; // Increment the count of printed elements
            }
            colStart++; // Move to the next column
        }
    }

    public static void main(String[] args) {
        int t, N, M; // Variables to store the number of test cases, number of rows, and number of
                     // columns respectively
        Scanner s = new Scanner(System.in); // Creating a Scanner object for user input
        t = s.nextInt(); // Reading the number of test cases

        // Looping through each test case
        for (int k = 0; k < t; ++k) {
            N = s.nextInt(); // Reading the number of rows for the current test case
            M = s.nextInt(); // Reading the number of columns for the current test case
            int ar[][] = new int[N][M]; // Creating a 2D array to store the elements of the matrix
            // Reading the elements of the matrix from user input
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    ar[i][j] = s.nextInt();
                }
            }
            spiralPrint(ar); // Calling the spiralPrint method to print the matrix elements in a spiral order
            System.out.println(); // Printing a newline after printing the elements of each test case
        }
    }
}
