/*
Problem statement
For a given two-dimensional square matrix of size (N x N). 
Find the total sum of elements on both the diagonals and at all the four boundaries.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains a single integer value, 'N' representing the 'rows' and 'columns' for the two-dimensional square matrix.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'N' column values separated by a single space.
Output format:
For each test case, print the single integer denoting the sum.

Output for every test case will be printed in a seperate line.
Constraints:
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1sec
Sample input 1:
1
3
1 2 3
4 5 6
7 8 9
Sample Output 1:
45
Explanation for Sample Output 1:
The boundary elements are 1, 2, 3, 6, 9, 8, 7 and 4. 

The first-diagonal elements are 1, 5 and 9. 

The second-diagonal elements are 3, 5 and 7.

We just need to add all these numbers making sure that no number is added twice. 
For example, '1' is both a boundary element and a first-diagonal element similarly, '5' contributes to both the diagonals but they won't be added twice.

Hence, we add up, [1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 + 5] to give 45 as the output.
Sample input 2:
2
5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
4
1 2 3 10
4 5 6 11
7 8 9 12
13 14 15 16
Sample Output 2:
273
136

*/


package arrays;

import java.util.Scanner;

public class TotalSumBondariesDiagonals {

    // Function to calculate the sum of elements in the first diagonal of a square matrix
    public static int getFirstDiagonalSum(int[][] mat, int dimension) {
        int currRow = 0;
        int currCol = 0;

        int diagonalSum = 0;
        while (currRow < dimension && currCol < dimension) {
            diagonalSum += mat[currRow][currCol];
            currRow += 1;
            currCol += 1;
        }

        return diagonalSum;
    }

    // Function to calculate the sum of elements in the second diagonal of a square matrix
    public static int getSecondDiagonalSum(int[][] mat, int dimension) {
        int currRow = 0;
        int currCol = dimension - 1;

        int diagonalSum = 0;
        while (currRow < dimension && currCol >= 0) {
            diagonalSum += mat[currRow][currCol];
            currRow += 1;
            currCol -= 1;
        }

        return diagonalSum;
    }

    // Function to calculate the sum of boundary elements of a square matrix
    public static int getBoundarySum(int[][] mat, int dimension) {
        int sum = 0;
        for (int i = 1; i < (dimension - 1); i++) {
            sum += mat[0][i];  // Top row
            sum += mat[dimension - 1][i];  // Bottom row
            sum += mat[i][0];  // Left column
            sum += mat[i][dimension - 1];  // Right column
        }
        return sum;
    }

    // Function to calculate the total sum of the matrix
    public static void totalSum(int[][] mat) {
        int n = mat.length;  // Get the dimension of the square matrix
        if (n == 0) {
            System.out.println(0);  // Matrix is empty, print 0 and return
            return;
        }
        // Calculate the total sum by adding diagonal sums and boundary sums
        int totalSum = getFirstDiagonalSum(mat, n) + getSecondDiagonalSum(mat, n) + getBoundarySum(mat, n);
        // Adjust the sum if the dimension is odd by subtracting the center element
        if (n % 2 != 0) {
            totalSum -= mat[n / 2][n / 2];
        }
        System.out.println(totalSum);  // Print the total sum
    }

    public static void main(String[] args) {
        int t, N, M;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();  // Input number of test cases
        for (int k = 0; k < t; ++k) {
            N = s.nextInt();  // Input size of the square matrix
            int ar[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ar[i][j] = s.nextInt();  // Input elements of the matrix
                }
            }
            totalSum(ar);  // Calculate and print the total sum
        }
    }
}
