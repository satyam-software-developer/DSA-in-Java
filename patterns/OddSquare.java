/*Problem statement
Write a program to print the pattern for the given N number of rows.

For N = 4

1357
3571
5713
7135
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
135
351
513
Sample Input 2 :
 5
Sample Output 2 :
13579
35791
57913
79135
91357
 */


package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class OddSquare { // Declaring the public class OddSquare

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the size of the square

        int currRow = 1; // Initializing the current row to 1

        // Looping through each row up to 'n'
        while (currRow <= n) {
            int currColVal = (2 * currRow) - 1; // Calculating the value to be printed in the current column
            int currCol = 1; // Initializing the current column to 1

            // Looping through each column up to 'n'
            while (currCol <= n) {
                System.out.print(currColVal); // Printing the value of the current column
                currColVal = currColVal + 2; // Incrementing the current column value by 2 to get the next odd number

                // Checking if the current column value exceeds the maximum odd value (2 * n - 1)
                if (currColVal > (2 * n) - 1) {
                    currColVal = 1; // Resetting the current column value to 1 if it exceeds the maximum
                }

                currCol = currCol + 1; // Incrementing the current column for the next iteration
            }

            System.out.println(); // Moving to the next line after printing all columns for the current row
            currRow = currRow + 1; // Incrementing the current row for the next iteration
        }
    }
}
