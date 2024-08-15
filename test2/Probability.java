/*Problem statement
An urn contains 8 balls : 4 red , 2 blue and 2 green. Now n balls are drawn out of the urn. Calculate the probability that out of n drawn balls exactly x balls are red.

Find your answer multiplied by 100 and return the integer part.

All required values for computation will be in integer range.

x is always less than equal to 4 and x is always less than equal to n.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 1
Sample Output 1:
42 */

package test2;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class Probability { // Declaring the public class Probability

    // Method to calculate factorial of a number
    public static int fact(int number) {
        int ans = 1;
        for (int i = 1; i <= number; i++) {
            ans *= i;
        }
        return ans;
    }

    // Method to calculate combination (n choose r)
    public static int ncr(int num, int r) {
        int ans = fact(num) / (fact(num - r) * fact(r));
        return ans;
    }

    // Method to calculate probability of choosing x items out of n
    public static int probability(int n, int x) {
        // Calculate the combinations for choosing x items out of 4 and (n-x) items out
        // of 4
        int ans = ncr(4, x) * ncr(4, n - x);
        // Calculate the probability using the combination and total possible
        // combinations
        double probab = (double) ans / ncr(8, n);
        // Convert the probability to a percentage and return as an integer
        return (int) (probab * 100);
    }

    public static void main(String[] args) { // Main method
        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading the value of n from the user
        int x = s.nextInt(); // Reading the value of x from the user
        System.out.println(probability(n, x)); // Printing the probability
        s.close(); // Close the scanner after use to avoid resource leaks
    }
}
