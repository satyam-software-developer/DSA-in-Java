
/* Problem statement
Given a string, find and print all the possible permutations of the input string.

Note :
The order of permutations are not important. Just print them in different lines.
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

public class PrintPermutationsOfAString {

    // Helper method to generate and print all permutations of the input string
    public static void permutationsHelper(String input, String output) {
        // Base case: if the input string is empty, print the output string
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        // Loop through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            // Recursively call the helper method with the remaining characters in the input
            // string
            // and the current character added to the output string
            permutationsHelper((input.substring(0, i) + input.substring(i + 1)), output + input.charAt(i));
        }
    }

    // Method to initiate the permutation process
    public static void permutations(String input) {
        // Call the helper method with the input string and an empty output string
        permutationsHelper(input, "");
    }

    // Main method to take input from the user and print all permutations
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to take input from the user
        String input = s.nextLine(); // Read a string input from the user
        permutations(input); // Call the permutations method to print all permutations of the input string
    }
}
