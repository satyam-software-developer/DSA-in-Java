/*Problem statement
Write a program to print parallelogram pattern for the given N number of rows.

For N = 4

The dots represent spaces.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
***
 ***
  ***
Sample Input 2 :
5
Sample Output 2 :
*****
 *****
  *****
   *****
    *****
 */
package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class ParallelogramPattern { // Declaring the public class ParallelogramPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the size of the parallelogram

        int currRow = 1; // Initializing the current row to 1

        // Looping through each row up to 'n'
        while (currRow <= n) {
            int spaces = 1; // Initializing the variable to count leading spaces

            // Printing leading spaces for the current row
            while (spaces <= currRow - 1) {
                System.out.print(" "); // Printing a space
                spaces += 1; // Incrementing the space counter
            }

            int currCol = 1; // Initializing the current column to 1

            // Printing '*' for the entire width of the parallelogram
            while (currCol <= n) {
                System.out.print("*"); // Printing a '*'
                currCol += 1; // Incrementing the column counter
            }

            System.out.println(); // Moving to the next line after printing the current row
            currRow += 1; // Incrementing the current row for the next iteration
        }
    }
}
