/*
Problem statement
For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.

Permutations of each other
Two strings are said to be a permutation of each other when either of the string's characters can be rearranged so that it becomes identical to the other one.

Example: 
str1= "sinrtg" 
str2 = "string"

The character of the first string(str1) can be rearranged to form str2 and hence we can say that the given strings are a permutation of each other.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains a string without any leading and trailing spaces, representing the first string 'str1'.

The second line of input contains a string without any leading and trailing spaces, representing the second string 'str2'.
Note:
All the characters in the input strings would be in lower case.
Output Format:
The only line of output prints either 'true' or 'false', denoting whether the two strings are a permutation of each other or not.

You are not required to print anything. It has already been taken care of. Just implement the function. 
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
abcde
baedc
Sample Output 1:
true
Sample Input 2:
abc
cbd
Sample Output 2:
false 
*/

/*
 *   Time complexity: O(N + M)
 *   Space complexity: O(1)
 * 
 *   where N and M are the lengths of the two input strings
 * 
 * 
 */

package strings;

import java.util.Scanner;

public class CheckPermutation {

    // Function to check if two strings are permutations of each other
    public static boolean isPermutation(String str1, String str2) {
        // Check if the lengths of the strings are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Initialize an array to store the frequency of characters
        int frequency[] = new int[256];

        // Initialize the frequency array with 0
        for (int i = 0; i < 256; ++i) {
            frequency[i] = 0;
        }

        // Calculate the frequency of characters in the first string
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            ++frequency[ch];
        }

        // Decrease the frequency of characters in the second string
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            --frequency[ch];
        }

        // Check if the frequencies are equal for both strings
        for (int i = 0; i < 256; ++i) {
            if (frequency[i] != 0) {
                return false; // If frequencies are not equal, return false
            }
        }

        return true; // If all frequencies are equal, return true (permutation)
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner s = new Scanner(System.in);

        // Read two strings from the console
        String str1 = s.nextLine();
        String str2 = s.nextLine();

        // Check if str1 and str2 are permutations of each other and print the result
        boolean ans = isPermutation(str1, str2);
        System.out.println(ans);

        // Close the Scanner object to prevent resource leak
        s.close();
    }
}
