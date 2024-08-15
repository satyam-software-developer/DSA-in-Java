
/*Problem statement
Given a string consisting of lower case characters and hashes(#) where each hash represents a back space .

Find the resultant string after removing the backspaces from the given input string.

(Note : there will be no condition where we use backspace on empty string )

Example :

Input: xy#z
Output: xz */

import java.util.*;

public class Backspace {

    // Method to find the index of the next valid character after applying
    // backspaces
    public static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0; // Counter to track the number of backspaces
        while (index >= 0) {
            if (str.charAt(index) == '#') // Found a backspace character
                backspaceCount++; // Increment the backspace count
            else if (backspaceCount > 0) // Found a non-backspace character
                backspaceCount--; // Decrement the backspace count (as one backspace cancels out this character)
            else
                break; // If no backspaces to apply, break out of the loop
            index--; // Move to the previous character in the string
        }
        return index; // Return the index of the next valid character
    }

    // Method to process the string with backspaces and return the resulting string
    public static String backspace(String s) {
        String ns = ""; // Initialize an empty string to build the result
        int index = s.length() - 1; // Start from the last character of the string
        while (index >= 0) {
            int i = getNextValidCharIndex(s, index); // Get the next valid character index
            ns = s.charAt(i) + ns; // Append the valid character to the result string
            index = i - 1; // Move to the next character to process
        }
        return ns; // Return the final string after processing all backspaces
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner for user input
        String n = s.next(); // Read the input string
        String x = backspace(n); // Process the string with backspaces
        System.out.print(x); // Print the resulting string
        s.close(); // Close the scanner
    }

}
