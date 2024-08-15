
/* Problem statement
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.

Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:

1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line of input contains the string S of length M.

The second line of the input contains the String T of length N.
Output format :
Print the minimum 'Edit Distance' between the strings.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9 */
/*
 * Time Complexity : O(M * N)
 * Space complexity : O(M * N)
 * 
 * Where M and N are the lengths of string 's' and 't' respectively
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

    // Helper method to calculate the edit distance using recursion and memoization
    private static int editDistanceHelper(String s, String t, int[][] subProblems) {
        // Base case: if the source string is empty, return the length of the target
        // string
        if (s.length() == 0) {
            return t.length();
        }
        // Base case: if the target string is empty, return the length of the source
        // string
        if (t.length() == 0) {
            return s.length();
        }

        int m = s.length();
        int n = t.length();

        // Check if the subproblem has already been solved
        if (subProblems[m][n] != -1) {
            return subProblems[m][n];
        }
        // If the first characters of both strings match, move to the next characters
        if (s.charAt(0) == t.charAt(0)) {
            int smallAns = editDistanceHelper(s.substring(1), t.substring(1), subProblems);
            subProblems[m - 1][n - 1] = smallAns;
            subProblems[m][n] = 0 + smallAns;
        } else {
            // Calculate the cost of removing a character from the source string
            int remove = editDistanceHelper(s.substring(1), t, subProblems);
            subProblems[m - 1][n] = remove;

            // Calculate the cost of inserting a character into the source string
            int insert = editDistanceHelper(s, t.substring(1), subProblems);
            subProblems[m][n - 1] = insert;

            // Calculate the cost of substituting a character in the source string
            int substitute = editDistanceHelper(s.substring(1), t.substring(1), subProblems);
            subProblems[m - 1][n - 1] = substitute;

            // Take the minimum of the three operations and add 1 (for the current
            // operation)
            subProblems[m][n] = 1 + Math.min(remove, Math.min(insert, substitute));
        }
        return subProblems[m][n];
    }

    // Method to initialize the memoization array and call the helper method
    public static int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Create a 2D array for memoization, initialized with -1
        int[][] subProblems = new int[(m + 1)][(n + 1)];

        // Initialize the memoization array with -1
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                subProblems[i][j] = -1;
            }
        }
        // Call the helper method with initial indices and the memoization array
        return editDistanceHelper(s, t, subProblems);
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Main method to read input and call the editDistance method
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the first string
        String s = br.readLine().trim();
        // Read the second string
        String t = br.readLine().trim();

        // Print the edit distance between the two strings
        System.out.println(editDistance(s, t));
    }
}
