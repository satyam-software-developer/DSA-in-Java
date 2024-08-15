
/*Problem statement
For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.

Return 0 if the change isn't possible.

Detailed explanation ( Input/output format, Notes, Images )
Input Format
The first line of the input contains an integer value N, which denotes the total number of denominations.

The second line of input contains N values, separated by a single space. These values denote the value of denomination.

The third line of the input contains an integer value, that denotes the value of V.
Output Format
Print the total total number of ways i.e. W.
Constraints :

1 <= n <= 10
1 <= V <= 1000

Time Limit: 1sec
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903 */
/*
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 * 
 * where n is number of demoninationsa and m is the value inputted 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysToMakeCoinChange {

    // Method to count the number of ways to make change for a given value
    public static int countWaysToMakeChange(int denominations[], int value) {
        int n = denominations.length; // Number of different denominations

        // 2D array to store the number of ways to make change for each value using
        // subsets of denominations
        int ways[][] = new int[n][value + 1];

        // Initialize the ways array. There is one way to make change for the value 0:
        // using no coins.
        for (int i = 0; i < n; i++) {
            ways[i][0] = 1;
        }

        // Fill the ways array in a bottom-up manner
        for (int i = n - 1; i >= 0; i--) { // Loop through each denomination starting from the last one
            for (int j = 1; j <= value; j++) { // Loop through each value from 1 to the given value
                int count1 = 0;
                if (i + 1 <= n - 1) {
                    // Count of ways to make change without using the current denomination
                    count1 = ways[i + 1][j];
                }
                int count2 = 0;
                if (j - denominations[i] >= 0) {
                    // Count of ways to make change including the current denomination
                    count2 = ways[i][j - denominations[i]];
                }
                // Total ways to make change for the current value
                ways[i][j] = count1 + count2;
            }
        }

        // Return the number of ways to make change for the given value using all
        // denominations
        return ways[0][value];
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        // Read the number of different denominations
        int numDenominations = Integer.parseInt(br.readLine().trim());

        // Array to store the denominations
        int denominations[] = new int[numDenominations];
        String[] strNums;

        // Read the denominations
        strNums = br.readLine().split("\\s");
        for (int i = 0; i < numDenominations; ++i) {
            denominations[i] = Integer.parseInt(strNums[i]);
        }

        // Read the value for which we need to make change
        int value = Integer.parseInt(br.readLine().trim());

        // Print the number of ways to make change for the given value
        System.out.println(countWaysToMakeChange(denominations, value));
    }
}
