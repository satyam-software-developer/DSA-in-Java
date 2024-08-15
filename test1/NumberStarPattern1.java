/*Problem statement
Print the following pattern for given number of rows.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
   5
Sample Output :
 5432*
 543*1
 54*21
 5*321
 *4321 */

package test1;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class NumberStarPattern1 { // Declaring the public class NumberStarPattern1

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows/columns in the pattern

        // Loop for iterating through each row of the pattern
        for (int i = 1; i <= n; i++) {
            // Loop for printing each element in the current row of the pattern
            for (int j = n; j >= 1; j--) {
                // Checking if the column number 'j' is equal to the row number 'i'
                if (i == j) {
                    System.out.print('*'); // Printing '*' if the condition is true
                } else {
                    System.out.print(j); // Printing the column number 'j' if the condition is false
                }
            }
            System.out.println(); // Moving to the next line after printing each row of the pattern
        }
    }
}
