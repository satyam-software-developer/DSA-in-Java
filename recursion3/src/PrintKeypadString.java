
/* Problem statement
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.

Note :
The order of strings are not important. Just print different strings in new lines.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6

Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf */

import java.util.Scanner;

public class PrintKeypadString {

    // This method returns an array of strings corresponding to the characters on
    // the given single-digit key on a keypad
    public static String[] singleDigit(int n) {
        // Exit the program if the input is less than or equal to 1 or greater than 10
        if (n <= 1 || n > 10) {
            System.exit(0);
        }

        // Return the corresponding characters for each digit from 2 to 9
        if (n == 2) {
            String output[] = { "a", "b", "c" };
            return output;
        } else if (n == 3) {
            String output[] = { "d", "e", "f" };
            return output;
        } else if (n == 4) {
            String output[] = { "g", "h", "i" };
            return output;
        } else if (n == 5) {
            String output[] = { "j", "k", "l" };
            return output;
        } else if (n == 6) {
            String output[] = { "m", "n", "o" };
            return output;
        } else if (n == 7) {
            String output[] = { "p", "q", "r", "s" };
            return output;
        } else if (n == 8) {
            String output[] = { "t", "u", "v" };
            return output;
        } else {
            String output[] = { "w", "x", "y", "z" };
            return output;
        }
    }

    // This method prints all possible strings that can be made using the digits of
    // the input number
    public static void printKeypad(int input, String output) {
        // Base case: if the input number is 0, print the accumulated output string
        if (input == 0) {
            System.out.println(output);
            return;
        }

        // Get the characters for the last digit of the input number
        String singleDigitOutput[] = singleDigit(input % 10);

        // Recursively call the function for the remaining digits and accumulate the
        // results
        for (int i = 0; i < singleDigitOutput.length; i++) {
            printKeypad(input / 10, singleDigitOutput[i] + output);
        }
    }

    // Overloaded method to start the recursion with an empty output string
    public static void printKeypad(int input) {
        printKeypad(input, "");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to take input from the user
        int input = s.nextInt(); // Read an integer input from the user

        // Print all possible strings that can be made using the digits of the input
        // number
        printKeypad(input);

        s.close(); // Close the scanner
    }
}
