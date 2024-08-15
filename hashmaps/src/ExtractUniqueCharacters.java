
/*Problem statement
Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first and only line of input contains a string, that denotes the value of S.
Output format :
The first and only line of output contains the updated string, as described in the task.
Constraints :
0 <= Length of S <= 10^8
Time Limit: 1 sec
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde */

import java.util.HashMap; // Import the HashMap class
import java.io.BufferedReader; // Import the BufferedReader class for reading input
import java.io.IOException; // Import the IOException class for handling IO exceptions
import java.io.InputStreamReader; // Import the InputStreamReader class for reading input stream

public class ExtractUniqueCharacters {
    // Create a BufferedReader object to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input from the user
    public static String takeInput() throws IOException {
        String str = br.readLine(); // Read a line of text from the console
        return str; // Return the input string
    }

    // Method to extract unique characters from the input string
    public static String uniqueChar(String str) {
        // If the input string is empty, return an empty string
        if (str.length() == 0) {
            return "";
        }

        String ans = ""; // Initialize an empty string to store the result
        HashMap<Character, Boolean> hm = new HashMap<Character, Boolean>(); // Create a HashMap to track characters

        // Iterate over each character in the input string
        for (int currIndex = 0; currIndex < str.length(); currIndex++) {
            char currChar = str.charAt(currIndex); // Get the current character
            // If the current character is not already in the HashMap
            if (!hm.containsKey(currChar)) {
                hm.put(currChar, true); // Add the character to the HashMap
                ans += currChar; // Append the character to the result string
            }
        }
        return ans; // Return the result string containing unique characters
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        String str = takeInput(); // Take input from the user
        System.out.print(uniqueChar(str)); // Print the unique characters in the input string
    }
}
