/*
Problem statement
Reverse the given string word wise. That is, the last word in given string should come at 1st place, 
last second word at 2nd place and so on. 
Individual words should remain as it is.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
String in a single line
Output format :
Word wise reversed string in a single line
Constraints :
0 <= |S| <= 10^7
where |S| represents the length of string, S.
Sample Input 1:
Welcome to Coding Ninjas
Sample Output 1:
Ninjas Coding to Welcome
Sample Input 2:
Always indent your code
Sample Output 2:
code your indent Always
 */

package strings;

import java.util.Scanner; // Import the Scanner class to read input from the console.

public class ReverseStringWordwise {

    // Method to reverse the words in a given string while maintaining the word
    // order.
    public static String reverseWordWise(String input) {
        int end = input.length(); // Initialize the end index to the length of the input string.
        int i = input.length() - 1; // Initialize the loop variable 'i' to the last index of the input string.
        String output = ""; // Initialize an empty string to store the reversed string.

        // Iterate through the characters of the input string from the end to the
        // beginning.
        while (i >= 0) {
            // Check if the current character is a space character.
            if (input.charAt(i) == ' ') {
                // Append the substring from (i + 1) to 'end' to the output string followed by a
                // space.
                output = output + input.substring(i + 1, end) + " ";
                end = i; // Update the 'end' index to the current index 'i'.
            }
            i--; // Decrement the loop variable 'i'.
        }
        // Append the substring from index 0 to 'end' (inclusive) to the output string.
        output += input.substring(i + 1, end);
        return output; // Return the reversed string with words in the reversed order.
    }

    // Main method where the program execution begins.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input.
        String input = s.nextLine(); // Read a line of input from the user.

        // Call the method to reverse the words in the input string and print the
        // result.
        System.out.println(reverseWordWise(input));
    }
}
