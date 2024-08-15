/*Problem statement
Write a program to print triangle of user defined integers sum.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
1=1
1+2=3
1+2+3=6
Sample Input 2 :
 5
Sample Output 2 :
1=1
1+2=3
1+2+3=6
1+2+3+4=10
1+2+3+4+5=15 */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class SumPattern { // Declaring the public class SumPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows in the sum pattern
        int currRow = 1; // Initializing the current row counter to 1
        int sum = 0; // Initializing the sum variable to 0

        // Looping through each row up to 'n'
        while (currRow <= n) {
            sum += currRow; // Adding the current row number to the sum
            int currCol = 1; // Initializing the current column counter to 1

            // Looping to print the numbers in each row along with '+' and '=' signs
            while (currCol <= currRow) {
                System.out.print(currCol); // Printing the current column number

                // Checking if the current column is the last column in the row
                if (currCol == currRow) {
                    System.out.print('='); // Printing '=' if it's the last column
                } else {
                    System.out.print('+'); // Printing '+' if it's not the last column
                }

                currCol = currCol + 1; // Incrementing the current column counter
            }

            System.out.println(sum); // Printing the accumulated sum for the current row
            currRow = currRow + 1; // Incrementing the current row counter for the next iteration
        }
    }
}
