/*Problem statement
Print the following pattern for the given N number of rows.

Pattern for N = 4
*
**
***
****
Note : There are no spaces between the stars (*).
Detailed explanation ( Input/output format, Notes, Images )
Constraints
0 <= N <= 50
Sample Input 1:
5
Sample Output 1:
*
**
***
****
*****
Sample Input 2:
6
Sample Output 2:
*
**
***
****
*****
****** */


package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class TriangleStarPattern { // Declaring the public class TriangleStarPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows in the pattern
        int i = 1; // Initializing the variable i to 1, which represents the current row number

        // Looping through each row up to 'n'
        while (i <= n) {
            int j = 1; // Initializing the variable j to 1, which represents the current column number

            // Looping to print the '*' character 'i' times in the current row
            while (j <= i) {
                System.out.print('*'); // Printing the '*' character
                j++; // Incrementing the column counter 'j'
            }

            System.out.println(); // Moving to the next line after printing the current row
            i++; // Incrementing the row counter 'i' for the next iteration
        }
    }
}

