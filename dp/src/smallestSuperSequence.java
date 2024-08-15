
/*Problem statement
 Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.

 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.

Note :
If the two strings do not have any common characters, then return the sum of the lengths of the two strings. 
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first only line of input contains a string, that denotes the value of string S. The following line contains a string, that denotes the value of string T.
Output Format:
Length of the smallest super-sequence of given two strings. 
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9
		int min_len = Solution.smallestSuperSequence(str1, str2);
		System.out.print(min_len);
	}
}
 */
/*
 * Time Complexity: O(n*m)
 * Space Complexity: O(n*m)
 * 
 * where n and m are lengths of input strings
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smallestSuperSequence {

    // Method to find the length of the smallest super-sequence that contains both
    // input strings
    public static int smallestSuperSequence(String str1, String str2) {
        int len1 = str1.length(); // Length of the first string
        int len2 = str2.length(); // Length of the second string
        int superseq[][] = new int[len1 + 1][len2 + 1]; // DP table to store lengths of super-sequences

        // Fill the DP table
        for (int p = 0; p <= len1; p++) {
            for (int q = 0; q <= len2; q++) {
                if (p == 0) { // If the first string is empty
                    superseq[p][q] = q; // Length of super-sequence is the length of the second string
                } else if (q == 0) { // If the second string is empty
                    superseq[p][q] = p; // Length of super-sequence is the length of the first string
                } else if (str1.charAt(p - 1) == str2.charAt(q - 1)) { // If characters match
                    superseq[p][q] = 1 + superseq[p - 1][q - 1]; // Include this character in the super-sequence
                } else { // If characters do not match
                    superseq[p][q] = 1 + Math.min(superseq[p - 1][q], superseq[p][q - 1]); // Include either character
                                                                                           // and take the minimum
                }
            }
        }
        return superseq[len1][len2]; // Return the length of the smallest super-sequence
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for fast input

    public static void main(String[] args) throws IOException {
        // Read the two input strings
        String str1 = br.readLine();
        String str2 = br.readLine();

        // Find the length of the smallest super-sequence
        int min_len = smallestSuperSequence(str1, str2);

        // Print the length of the smallest super-sequence
        System.out.print(min_len);
    }
}
