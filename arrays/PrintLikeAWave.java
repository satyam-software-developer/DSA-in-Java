/*
Problem statement
For a given two-dimensional integer array/list of size (N x M), print the array/list in a sine wave order, i.e, 
print the first column top to bottom, next column bottom to top and so on.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. 
They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'M' column values separated by a single space.
Output format :
For each test case, print the elements of the two-dimensional array/list in the sine wave order in a single line, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec
Sample Input 1:
1
3 4 
1  2  3  4 
5  6  7  8 
9 10 11 12
Sample Output 1:
1 5 9 10 6 2 3 7 11 12 8 4
Sample Input 2:
2
5 3 
1 2 3 
4 5 6 
7 8 9 
10 11 12 
13 14 15
3 3
10 20 30 
40 50 60
70 80 90
Sample Output 2:
1 4 7 10 13 14 11 8 5 2 3 6 9 12 15 
10 40 70 80 50 20 30 60 90 

*/

package arrays;

import java.util.Scanner; // Importing the Scanner class from java.util package for user input

public class PrintLikeAWave { // Defining a class named PrintLikeAWave

    // Method to print elements of a 2D array in a wave pattern
    public static void wavePrint(int mat[][]) {
        int nRows = mat.length; // Getting the number of rows in the matrix
        if (nRows == 0) { // Checking if the number of rows is 0, if so, there's nothing to print, so
                          // return from the function
            return;
        }

        int mCols = mat[0].length; // Getting the number of columns in the matrix

        // Iterating through each column of the matrix
        for (int j = 0; j < mCols; j++) {
            if (j % 2 == 0) { // If the column index is even
                // Printing elements of the column from top to bottom
                for (int i = 0; i < nRows; i++) {
                    System.out.print(mat[i][j] + " ");
                }
            } else { // If the column index is odd
                // Printing elements of the column from bottom to top
                for (int i = nRows - 1; i >= 0; i--) {
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
    }

    public static void main(String[] args) { // Main method, entry point of the program
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
            wavePrint(ar); // Calling the wavePrint method to print the matrix elements in a wave pattern
            System.out.println(); // Printing a newline after printing the elements of each test case
        }
    }
}
