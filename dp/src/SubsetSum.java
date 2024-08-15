/* Problem statement
You are given a set of N integers. You have to return true if there exists a subset that sum up to K, otherwise return false.

Detailed explanation ( Input/output format, Notes, Images )
Input Format
The first line of the test case contains an integer 'N' representing the total elements in the set.

The second line of the input contains N integers separated by a single space.    

The third line of the input contains a single integer, denoting the value of K.
Output Format
Output Yes if there exists a subset whose sum is k, else output No.
Constraints :
1 <= N <= 10^3
1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
1 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1 :
4
4 3 5 2
13
Sample Output 1 :
No
Sample Input 2 :
5
4 2 5 6 7
14
Sample Output 2 :
Yes */

/*
 * Time Complexity: O(n*sum)
 * Space Complexity: O(n*sum)
 * 
 * where 'n' is the size of input array and 'sum' is the subset sum
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {

    // Method to determine if there is a subset of the array with a sum equal to the
    // given sum
    static boolean isSubsetPresent(int[] arr, int n, int sum) {
        // dp[i][j] is true if we can create a subset with sum j from the first i
        // elements
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, then the answer is true (empty subset always sums to 0)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If sum is not 0 and set is empty, then the answer is false
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        // Fill the table in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is greater than the sum, we can't include it
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, check if the sum can be obtained by including or excluding the
                    // current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        boolean result = dp[n][sum]; // Final result indicating if subset with given sum exists

        return result;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for fast input

    public static void main(String[] args) throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim()); // Read the number of elements in the array
        int[] input = new int[size]; // Initialize the array

        if (size == 0) { // If there are no elements, print "No" and return
            System.out.print("No");
            return;
        }

        // Read the elements of the array
        String[] strNums = br.readLine().split("\\s");
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        int sum = Integer.parseInt(br.readLine().trim()); // Read the target sum
        if (isSubsetPresent(input, size, sum)) { // Check if subset with given sum exists
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
