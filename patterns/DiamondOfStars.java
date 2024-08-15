/*Problem statement
Print the following pattern for the given number of rows.

Note: N is always odd.

Pattern for N = 5

The dots represent spaces.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 49
Sample Input 1:
5
Sample Output 1:
  *
 ***
*****
 ***
  *
Sample Input 2:
3
Sample Output 2:
  *
 ***
  * */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class DiamondOfStars { // Declaring the public class DiamondOfStars

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows in the diamond

        int firstHalf = (n / 2) + 1; // Calculating the number of rows in the first half of the diamond
        int secondHalf = n / 2; // Calculating the number of rows in the second half of the diamond

        // Printing the first half of the diamond
        int currRow = 1; // Initializing the current row to 1
        while (currRow <= firstHalf) { // Looping through each row in the first half
            int spaces = 1; // Initializing the number of spaces to 1
            while (spaces <= (firstHalf - currRow)) { // Looping to print spaces before the stars
                System.out.print(" "); // Printing a space
                spaces += 1; // Incrementing the spaces count
            }
            int currCol = 1; // Initializing the current column to 1
            while (currCol <= (2 * currRow) - 1) { // Looping to print stars
                System.out.print("*"); // Printing a star
                currCol += 1; // Incrementing the column count
            }
            System.out.println(); // Moving to the next line after printing each row
            currRow += 1; // Incrementing the current row for the next iteration
        }

        // Printing the second half of the diamond
        currRow = 1; // Re-initializing the current row to 1 for the second half
        while (currRow <= secondHalf) { // Looping through each row in the second half
            int spaces = 1; // Initializing the number of spaces to 1
            while (spaces <= currRow) { // Looping to print spaces before the stars
                System.out.print(" "); // Printing a space
                spaces += 1; // Incrementing the spaces count
            }
            int currCol = 2 * (secondHalf - currRow + 1) - 1; // Calculating the number of stars in the current row
            while (currCol >= 1) { // Looping to print stars
                System.out.print("*"); // Printing a star
                currCol -= 1; // Decrementing the column count
            }
            System.out.println(); // Moving to the next line after printing each row
            currRow += 1; // Incrementing the current row for the next iteration
        }
    }
}
