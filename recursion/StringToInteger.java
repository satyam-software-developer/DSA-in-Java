/* 
Problem statement
Write a recursive function to convert a given string into the number it represents. 
That is input will be a numeric string that contains only numbers, 
you need to convert the string into corresponding integer and return the answer.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Numeric string S (string, Eg. "1234")
Output format :
Corresponding integer N (int, Eg. 1234)
Constraints :
0 < |S| <= 9
where |S| represents length of string S.
Sample Input 1 :
00001231
Sample Output 1 :
1231
Sample Input 2 :
12567
Sample Output 2 :
12567
*/

package recursion;

import java.util.Scanner;

// Defining a public class named StringToInteger
public class StringToInteger {
    
    // Method to convert a string to an integer recursively
    public static int convertStringToInt(String input) {
        // Base case: if the input string has only one character
        if (input.length() == 1) {
            // Return the integer equivalent of the single character
            return input.charAt(0) - '0'; // Subtracting '0' to convert character to integer
        }
        
        // Recursive case: if the input string has more than one character
        // Convert the substring from the first character to the second last character to integer recursively
        int smallOutput = convertStringToInt(input.substring(0, input.length() - 1));
        // Extract the last character of the input string and convert it to integer
        int lastDigit = input.charAt(input.length() - 1) - '0'; // Subtracting '0' to convert character to integer
        // Combine the result of the recursive call with the last digit to get the final integer value
        return smallOutput * 10 + lastDigit;
    }

    // Main method
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner s = new Scanner(System.in);
        // Prompting the user to enter a string
        String input = s.nextLine();
        // Calling the convertStringToInt method with the input string and printing the result
        System.out.println(convertStringToInt(input));
    }
}
