/*Problem statement
Print the following pattern for the given N number of rows.

Pattern for N = 4
4444
4444
4444
4444
Detailed explanation ( Input/output format, Notes, Images )
Constraints
0 <= N <= 50
Sample Input 1:
7
Sample Output 1:
7777777
7777777
7777777
7777777
7777777
7777777
7777777
Sample Input 1:
6
Sample Output 1:
666666
666666
666666
666666
666666
666666
 */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class SquarePattern { // Declaring the public class SquarePattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the size of the square pattern

        int i = 1; // Initializing the outer loop counter 'i'

        // Looping through each row up to 'n'
        while (i <= n) {
            int j = 1; // Initializing the inner loop counter 'j'

            // Looping to print the value 'n' for each column in the current row
            while (j <= n) {
                System.out.print(n); // Printing the value 'n'
                j++; // Incrementing the inner loop counter 'j'
            }

            System.out.println(); // Moving to the next line after printing the current row
            i++; // Incrementing the outer loop counter 'i' for the next iteration
        }
    }
}
