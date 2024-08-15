
/*
Problem statement
For a given a string(str), find and return the highest occurring character.

Example:
Input String: "abcdeapapqarr"
Expected Output: 'a'
Since 'a' has appeared four times in the string which happens to be the highest frequency character, the answer would be 'a'.
If there are two characters in the input string with the same frequency, return the character which comes first.

Consider:
Assume all the characters in the given string to be in lowercase always.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of input contains a string without any leading and trailing spaces.
Output Format:
The only line of output prints the updated string. 
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
abdefgbabfba
Sample Output 1:
b
Sample Input 2:
xy
Sample Output 2:
x
*/

/*
 *   Time complexity: O(N)
 *   Space complexity: O(1)
 * 
 *   where N is the length of the input string
 */

package strings;

import java.util.Scanner;

public class HighestOccuringCharacter {

    // Method to find the highest occurring character in the string
    public static char highestOccuringChar(String str) {
        int n = str.length(); // Get the length of the input string
        int frequency[] = new int[256]; // Create an array to store the frequency of characters
        int maxFrequency = 0; // Variable to store the maximum frequency of any character

        // Loop through the input string to calculate the frequency of each character
        for (int i = 0; i < n; i++) {
            frequency[str.charAt(i)]++; // Increment the frequency count of the character
            maxFrequency = Math.max(maxFrequency, frequency[str.charAt(i)]); // Update the maximum frequency
        }
        char answer = '\0'; // Initialize the answer variable with null character

        // Loop through the input string to find the character with the maximum
        // frequency
        for (int i = 0; i < n; i++) {
            if (frequency[str.charAt(i)] == maxFrequency) { // If the current character has the maximum frequency
                answer = str.charAt(i); // Update the answer with the current character
                break; // Break the loop after finding the highest occurring character
            }
        }
        return answer; // Return the highest occurring character
    }

    // Main method where the program execution starts
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input from the user

        // Prompt the user to enter the input string
        String str = s.nextLine();

        // Call the method to find the highest occurring character and store the result
        char ans = highestOccuringChar(str);

        // Print the highest occurring character
        System.out.println(ans);
    }

}
