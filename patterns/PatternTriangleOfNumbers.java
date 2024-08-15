/*Problem statement
Print the following pattern for the given number of rows.

Pattern for N = 4


The dots represent spaces.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1:
5
Sample Output 1:
           1
          232
         34543
        4567654
       567898765
Sample Input 2:
4
Sample Output 2:
           1
          232
         34543
        4567654 */


package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class PatternTriangleOfNumbers { // Declaring the public class PatternTriangleOfNumbers

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the height of the triangle

        int currRow = 1; // Initializing the current row to 1

        // Looping through each row up to 'n'
        while (currRow <= n) {
            int spaces = 1; // Initializing the variable to count leading spaces

            // Printing leading spaces for the current row
            while (spaces <= (n - currRow)) {
                System.out.print(" "); // Printing a space
                spaces += 1; // Incrementing the space counter
            }

            int currCol = 1; // Initializing the current column to 1
            int valToPrint = currRow; // Initializing the value to be printed in the triangle

            // Printing increasing numbers for the left side of the triangle
            while (currCol <= currRow) {
                System.out.print(valToPrint); // Printing the current value
                valToPrint += 1; // Incrementing the value to be printed
                currCol += 1; // Incrementing the column counter
            }

            currCol = 1; // Resetting the current column to 1
            valToPrint = 2 * currRow - 2; // Calculating the initial value to be printed for the right side of the triangle

            // Printing decreasing numbers for the right side of the triangle
            while (currCol <= currRow - 1) {
                System.out.print(valToPrint); // Printing the current value
                valToPrint -= 1; // Decrementing the value to be printed
                currCol += 1; // Incrementing the column counter
            }

            System.out.println(); // Moving to the next line after printing the current row
            currRow += 1; // Incrementing the current row for the next iteration
        }
    }
}
