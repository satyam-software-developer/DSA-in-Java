/*
Problem statement
Given a string, compute recursively a new string where all 'x' chars have been removed.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
String S
Output format :
Modified String
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string S. 
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3:
*/

package recursion;

import java.util.Scanner;

// This class removes all occurrences of the character 'x' from a given string recursively.
public class RemoveX {

    // Recursive method to remove all occurrences of 'x' from the input string.
    public static String removeX(String input) {
        // Base case: if the input string is empty, return an empty string.
        if (input.length() == 0) {
            return "";
        }
        // If the first character of the input string is 'x', recursively call removeX with the substring starting from the next character.
        if (input.charAt(0) == 'x') {
            return removeX(input.substring(1));
        }
        // If the first character is not 'x', concatenate it with the result of removeX applied to the rest of the string.
        return input.charAt(0) + removeX(input.substring(1));
    }

    // Main method to take input and call the removeX method.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Read a line of input from the user.
        String input = s.nextLine();
        // Call the removeX method and print the result.
        System.out.println(removeX(input));
    }
}
