/*
Problem statement
For a given a string(str) and a character X, write a function to remove all the occurrences of X from the given string.

The input string will remain unchanged if the given character(X) doesn't exist in the input string.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains a string without any leading and trailing spaces.

The second line of input contains a character(X) without any leading and trailing spaces.
Output Format:
The only line of output prints the updated string. 
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
aabccbaa
a
Sample Output 1:
bccb
Sample Input 2:
xxyyzxx
y
Sample Output 2:
xxzxx
*/

/*
 *   Time complexity: O(N)
 *   Space complexity: O(N)
 * 
 *   where N is the length of the input string
 * 
 */

package strings;

import java.util.Scanner;

public class RemoveCharacter {

    // Method to remove all occurrences of a character 'ch' from the string 'str'
    public static String removeAllOccurrencesOfChar(String str, char ch) {
        int n = str.length(); // Get the length of the input string
        String ans = ""; // Initialize an empty string to store the result

        // Iterate through each character of the input string
        for (int i = 0; i < n; i++) {
            // Check if the current character is not equal to 'ch'
            if (str.charAt(i) != ch) {
                // If the current character is not equal to 'ch', add it to the result string
                ans += str.charAt(i);
            }
        }
        // Return the string after removing all occurrences of 'ch'
        return ans;
    }

    // Main method where the program execution starts
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input from the user

        // Prompt the user to enter the input string
        String str = s.nextLine();

        // Prompt the user to enter the character to be removed
        char x = s.next().charAt(0);

        // Call the method to remove all occurrences of 'x' from the input string 'str'
        String ans = removeAllOccurrencesOfChar(str, x);

        // Print the modified string after removing all occurrences of 'x'
        System.out.println(ans);
    }
}
