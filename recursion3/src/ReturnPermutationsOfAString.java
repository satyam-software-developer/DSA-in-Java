
/* Problem statement
Given a string, find and return all the possible permutations of the input string.

Note :
The order of permutations are not important.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba */

import java.util.Scanner;

public class ReturnPermutationsOfAString {

    // This method returns all permutations of the given input string
    public static String[] permutationOfString(String input) {
        // Base case: if the input string is empty, return an array with an empty string
        if (input.length() == 0) {
            String output[] = { "" };
            return output;
        }

        // Recursive call to get permutations of the substring starting from the second
        // character
        String[] smallerOutput = permutationOfString(input.substring(1));

        // Create an output array to hold the final permutations
        String output[] = new String[input.length() * smallerOutput.length];

        int k = 0; // Index for the output array

        // Generate permutations by inserting the first character of the input string
        // into every possible position of each string in smallerOutput
        for (int i = 0; i < smallerOutput.length; i++) {
            String currentString = smallerOutput[i];
            for (int j = 0; j <= currentString.length(); j++) {
                output[k] = currentString.substring(0, j) + input.charAt(0) + currentString.substring(j);
                k++;
            }
        }

        return output; // Return the final array of permutations
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to take input from the user
        String input = s.nextLine(); // Read a string input from the user
        String output[] = permutationOfString(input); // Get all permutations of the input string

        // Print each permutation in the output array
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
