/*
Problem statement
Given a string, determine if it is a palindrome, considering only alphanumeric characters.

Palindrome
A palindrome is a word, number, phrase, or other sequences of characters which read the same backwards and forwards.
Example:
If the input string happens to be, "malayalam" then as we see that this word can be read the same as forward and backwards, it is said to be a valid palindrome.

The expected output for this example will print, 'true'.
From that being said, you are required to return a boolean value from the function that has been asked to implement.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of input contains a string without any leading and trailing spaces. 
All the characters in the string would be in lower case.
Output Format:
The only line of output prints either 'true' or 'false'.
Note:
You are not required to print anything. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1 :
abcdcba
Sample Output 1 :
true 
Sample Input 2:
coding
Sample Output 2:
false
*/

/* 
 *   Time complexity: O(N)
 *   Space complexity: O(1)
 * 
 */

package strings;

import java.util.Scanner;

public class StringPalindrome {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0; // Pointer for the start of the string
        int right = str.length() - 1; // Pointer for the end of the string

        // Iterate until the pointers meet or cross each other
        while (left < right) {
            // Compare characters at the left and right pointers
            if (str.charAt(left) != str.charAt(right)) {
                return false; // If characters don't match, the string is not a palindrome
            }
            ++left; // Move the left pointer towards the right
            --right; // Move the right pointer towards the left
        }
        return true; // If all characters match, the string is a palindrome
    }

    // Main method where the program starts execution
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input
        String str = s.nextLine(); // Read a string from the user

        // Check if the input string is a palindrome and store the result
        boolean ans = isPalindrome(str);

        // Print the result indicating whether the string is a palindrome or not
        System.out.println(ans);
    }

}
