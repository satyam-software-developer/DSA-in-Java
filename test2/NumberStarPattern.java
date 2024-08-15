/*Problem statement
Print the following pattern for given number of rows.

Input format :

Line 1 : N (Total number of rows)

Sample Input :
   5
Sample Output :
1234554321
1234**4321
123****321
12******21
1********1 */

package test2;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class NumberStarPattern { // Declaring the public class NumberStarPattern

    public static void main(String[] args) { // Declaring the main method
        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer input from the standard input stream
        int numStars = 0; // Initializing the number of stars

        int row = 1; // Initializing the row counter

        // Loop for each row of the pattern
        while (row <= n) {
            int value = 1; // Initializing the value for the first half of the pattern

            // Loop to print the numbers in the first half of the row
            while (value <= n - row + 1) {
                System.out.print(value);
                value = value + 1;
            }

            int stars = 1; // Initializing the star counter

            // Loop to print the stars
            while (stars <= numStars) {
                System.out.print("*");
                stars = stars + 1;
            }

            value = n - row + 1; // Resetting the value for the second half of the pattern

            // Loop to print the numbers in the second half of the row
            while (value >= 1) {
                System.out.print(value);
                value = value - 1;
            }

            System.out.println(); // Moving to the next line after printing each row
            row = row + 1; // Incrementing the row counter
            numStars = numStars + 2; // Updating the number of stars for the next row
        }
    }
}
