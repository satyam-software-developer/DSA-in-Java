
/* Problem statement
Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line of the test case contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively.

Second-line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith rows constitutes column values separated by a single space (Either 0 or 1).
Output Format:
Print the size of maximum square sub-matrix.
 Constraints :
0 <= N <= 10^4
0 <= M <= 10^4

Time Limit: 1 sec
Sample Input 1:
3 3
1 1 0
1 1 1
1 1 1
Sample Output 1:
1
Sample Input 2:
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
Sample Output 2:
4 */

/*
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * 
 * where m is number of rows and n is number of columns
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSquareMatrixWithAllZeros {

    // Method to find the size of the largest square sub-matrix with all zeros
    public static int findMaxSquareWithAllZeros(int[][] input) {
        int max = 0;
        if (input.length == 0) {
            return 0;
        }
        int[][] array = new int[input.length][input[0].length];

        // Initialize the first row and column of the array
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == 0) {
                array[i][0] = 1;
                max = 1;
            } else {
                array[i][0] = 0;
            }
        }

        for (int j = 0; j < input[0].length; j++) {
            if (input[0][j] == 0) {
                array[0][j] = 1;
                max = 1;
            } else {
                array[0][j] = 0;
            }
        }

        // Fill the rest of the array
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[i][j] == 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1 + Math.min(array[i - 1][j - 1], Math.min(array[i][j - 1], array[i - 1][j]));
                    if (array[i][j] > max) {
                        max = array[i][j];
                    }
                }
            }
        }

        return max;
    }

    // Method to take input from the user
    public static int[][] takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] arr = new int[n][m];

        if (n == 0) {
            return arr;
        }

        for (int i = 0; i < n; ++i) {
            String[] strNums = br.readLine().split("\\s");
            for (int j = 0; j < m; ++j) {
                arr[i][j] = Integer.parseInt(strNums[j]);
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        int[][] arr = takeInput();
        System.out.println(findMaxSquareWithAllZeros(arr));
    }
}
