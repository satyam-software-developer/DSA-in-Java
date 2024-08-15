
/*Problem statement
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.

Return empty string for numbers 0 and 1.

Note :
1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
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

public class ReturnKeypadString {

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

    // This method returns all possible strings that can be made using the digits of
    // the input number
    public static String[] keypad(int n) {
        // Base case: if the input number is 0, return an array with an empty string
        if (n == 0) {
            String output[] = { "" };
            return output;
        }

        // Recursive case: get the combinations for the smaller number (n/10)
        String smallerNumberArray[] = keypad(n / 10);

        // Get the characters for the last digit of the input number
        String singleDigitOutput[] = singleDigit(n % 10);

        // Calculate the total number of combinations and create the output array
        String output[] = new String[singleDigitOutput.length * smallerNumberArray.length];

        int k = 0; // Index for the output array

        // Combine each character of the singleDigitOutput with each string in
        // smallerNumberArray
        for (int a = 0; a < singleDigitOutput.length; a++) {
            for (int i = 0; i < smallerNumberArray.length; i++) {
                output[k] = smallerNumberArray[i] + singleDigitOutput[a];
                k++;
            }
        }

        return output; // Return the final array of combinations
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to take input from the user
        int input = s.nextInt(); // Read an integer input from the user

        // Get all possible strings that can be made using the digits of the input
        // number
        String output[] = keypad(input);

        // Print each string in the output array
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }

        s.close(); // Close the scanner
    }
}
