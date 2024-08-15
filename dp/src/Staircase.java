
/* Problem statement
A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first and the only line of input contains an integer value, 'n', denoting the total number of steps.
Output format :
Print the total possible number of ways.
 Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274 */
/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * where 'n' is the total number of steps in a staircase
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Staircase {

    // Method to calculate the number of ways to reach the nth stair
    public static long staircase(int n) {
        long[] ways = new long[n + 1]; // this is our DP array/list of size (n+1)

        // Base Case
        if (n == 0) {
            return 1; // There's only one way to stay at the ground (doing nothing)
        }
        if (n == 1 || n == 2) {
            return n; // If there's 1 stair, there's 1 way; if there are 2 stairs, there are 2 ways
        }

        // Initialize the base cases for dynamic programming
        ways[0] = 1; // 1 way to stay at the ground
        ways[1] = 1; // 1 way to reach the first stair
        ways[2] = 2; // 2 ways to reach the second stair (1+1 or 2)

        // Fill the DP array
        for (int i = 3; i <= n; i++) {
            // Number of ways to reach the ith stair is the sum of ways to reach (i-1)th,
            // (i-2)th, and (i-3)th stairs
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        return ways[n]; // Return the number of ways to reach the nth stair
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Main method to read input and call the staircase method
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Read the input (number of stairs)
        System.out.println(staircase(n)); // Print the result of the staircase method
    }
}
