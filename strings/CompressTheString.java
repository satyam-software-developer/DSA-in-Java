/*
Problem statement
Write a program to do basic string compression. For a character which is consecutively repeated more than once, replace consecutive duplicate occurrences with the count of repetitions.

Example:
If a string has 'x' repeated 5 times, replace this "xxxxx" with "x5".

The string is compressed only when the repeated character count is more than 1.
Note:
Consecutive count of every character in the input string is less than or equal to 9. You are not required to print anything. It has already been taken care of. Just implement the given function and return the compressed string.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of input contains a string without any leading and trailing spaces.
Output Format:
The output contains the string after compression printed in single line
Constraints:
0 <= N <= 10^6

Where 'N' is the length of the input string.

Time Limit: 1 sec
Sample Input 1:
aaabbccdsa
Sample Output 1:
a3b2c2dsa
Explanation for Sample Output 1:
In the given string 'a' is repeated 3 times, 'b' is repeated 2 times, 'c' is repeated 2 times and 'd', 's' and 'a' and occuring 1 time hence no compression for last 3 characters.
Sample Input 2:
aaabbcddeeeee
Sample Output 2:
a3b2cd2e5
Explanation for Sample Output 2:
In the given string 'a' is repeated 3 times, 'b' is repeated 2 times, 'c' is occuring single time, 'd' is repeating 2 times and 'e' is repeating 5times.
*/


/*
 *   Time complexity : O(N)
 *   Space complexity : O(1)
 * 
 *   Where 'N' is the size of the input string.
 * 
 */

package strings;

import java.util.Scanner;

public class CompressTheString {

    // This method takes a string input and compresses it based on the number of consecutive characters.
    public static String getCompressedString(String input) {
        // If the input string is null, return null.
        if (input == null) {
            return null;
        }

        // If the input string is empty, return an empty string.
        if (input.length() == 0) {
            return "";
        }

        // Variables to iterate the string and keep the count of the current character.
        int startIndex = 0; // Starting index of the current character.
        int endIndex = 0;   // Ending index of the current character.

        // Resulting string.
        String compressedString = "";

        // Iterate all the characters of the string.
        while (startIndex < input.length()) {
            // Move the endIndex as long as the current character is the same as the character at startIndex.
            while ((endIndex < input.length()) && (input.charAt(endIndex) == input.charAt(startIndex))) {
                endIndex += 1;
            }
            // Calculate the total count of consecutive characters.
            int totalCharCount = endIndex - startIndex;

            // If count is greater than 1, then append count to the string, else only character.
            if (totalCharCount != 1) {
                compressedString += (input.charAt(startIndex) + "" + totalCharCount);
            } else {
                compressedString += input.charAt(startIndex);
            }
            // Move the startIndex to the endIndex for the next iteration.
            startIndex = endIndex;
        }
        // Return the compressed string.
        return compressedString;
    }

    // Main method to test the getCompressedString method.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner object to read input from the user.
        String str = s.nextLine(); // Read the input string from the user.
        String ans = getCompressedString(str); // Call the getCompressedString method to compress the string.
        System.out.println(ans); // Print the compressed string.
    }
}
