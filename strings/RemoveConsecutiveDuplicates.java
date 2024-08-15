/* 
Problem statement
For a given string(str), remove all the consecutive duplicate characters.

Example:
Input String: "aaaa"
Expected Output: "a"

Input String: "aabbbcc"
Expected Output: "abc"
 Input Format:
The first and only line of input contains a string without any leading and trailing spaces. 
All the characters in the string would be in lower case.
Output Format:
The only line of output prints the updated string.
Note:
You are not required to print anything. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
aabccbaa
Sample Output 1:
abcba
Sample Input 2:
xxyyzxx
Sample Output 2:
xyzx
*/

/*
 *   Time complexity: O(N)
 *   Space complexity: O(1)
 *   
 *   where N is the lenght of the input string
 *   
 */

package strings;

import java.util.Scanner;

public class RemoveConsecutiveDuplicates {

    // Function to remove consecutive duplicates from a string
    public static String removeConsecutiveDuplicates(String str) {
        int n = str.length(); // Get the length of the input string

        // If the string is empty, return the string as it is
        if (n == 0) {
            return str;
        }

        String answer = ""; // Initialize an empty string to store the result
        int startIndex = 0; // Initialize the start index for traversing the string

        // Loop until the start index is less than the length of the string
        while (startIndex < n) {
            char uniqueChar = str.charAt(startIndex); // Get the character at the current start index
            int nextUniqueCharIndex = startIndex + 1; // Initialize the index for the next unique character

            // Find the index of the next unique character
            while (nextUniqueCharIndex < n && str.charAt(nextUniqueCharIndex) == uniqueChar) {
                nextUniqueCharIndex += 1;
            }

            answer += uniqueChar; // Append the unique character to the answer string

            startIndex = nextUniqueCharIndex; // Update the start index to the index of the next unique character
        }
        return answer; // Return the resulting string with consecutive duplicates removed
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input from the console
        String str = s.nextLine(); // Read the input string from the console
        String ans = removeConsecutiveDuplicates(str); // Call the removeConsecutiveDuplicates function

        // Print the resulting string with consecutive duplicates removed
        System.out.println(ans);

        s.close(); // Close the Scanner object to prevent resource leak
    }
}
