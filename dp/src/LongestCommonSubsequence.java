
/* Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line of input contains the string 'S' of length 'M'.

The second line of the input contains the string 'T' of length 'N'.
Output format :
Return the length of the Longest Common Subsequence.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0. */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

    // Method to calculate the length of the Longest Common Subsequence (LCS)
    public static int lcs(String s, String t) {
        // Create a 2D array for memoization, initialized with -1
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // Initialize the memoization array with -1
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        // Call the helper method with the initial indices and the memoization array
        return lcsdp(s, t, 0, 0, dp);
    }

    // Helper method to calculate LCS using dynamic programming with memoization
    private static int lcsdp(String s, String t, int i, int j, int[][] dp) {
        // Base case: if either string is fully traversed, return 0
        if (s.length() == i || t.length() == j) {
            return 0;
        }

        // If characters match, add 1 to the result of the subproblem
        if (s.charAt(i) == t.charAt(j)) {
            int subProblem;
            // Check if the subproblem has already been solved
            if (dp[i + 1][j + 1] == -1) {
                // Solve the subproblem and store the result in the memoization array
                subProblem = lcsdp(s, t, i + 1, j + 1, dp);
                dp[i + 1][j + 1] = subProblem;
            } else {
                // Retrieve the result from the memoization array
                subProblem = dp[i + 1][j + 1];
            }
            // Return the result adding 1 for the current matching characters
            return 1 + subProblem;
        } else {
            // If characters do not match, solve two subproblems and take the maximum result
            int m;
            // Check if the subproblem (i+1, j) has already been solved
            if (dp[i + 1][j] == -1) {
                // Solve the subproblem and store the result in the memoization array
                m = lcsdp(s, t, i + 1, j, dp);
                dp[i + 1][j] = m;
            } else {
                // Retrieve the result from the memoization array
                m = dp[i + 1][j];
            }
            int n;
            // Check if the subproblem (i, j+1) has already been solved
            if (dp[i][j + 1] == -1) {
                // Solve the subproblem and store the result in the memoization array
                n = lcsdp(s, t, i, j + 1, dp);
                dp[i][j + 1] = n;
            } else {
                // Retrieve the result from the memoization array
                n = dp[i][j + 1];
            }
            // Return the maximum result of the two subproblems
            return Math.max(m, n);
        }
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Main method to read input and call the lcs method
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the first string
        String s = br.readLine().trim();
        // Read the second string
        String t = br.readLine().trim();

        // Print the length of the Longest Common Subsequence
        System.out.println(lcs(s, t));
    }
}
