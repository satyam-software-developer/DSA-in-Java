/*Problem statement
Print the following pattern for the given N number of rows.

Pattern for N = 4
1
21
321
4321
Detailed explanation ( Input/output format, Notes, Images )
Constraints
0 <= N <= 50
Sample Input 1:
5
Sample Output 1:
1
21
321
4321
54321
Sample Input 2:
6
Sample Output 2:
1
21
321
4321
54321
654321 */


package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class ReverseNumberPattern { // Declaring the public class ReverseNumberPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the height of the pattern

        int i = 1; // Initializing the outer loop counter 'i'

        // Looping through each row up to 'n'
        while (i <= n) {
            int j = 1; // Initializing the inner loop counter 'j'

            // Looping to print numbers in reverse order for the current row
            while (j <= i) {
                System.out.print((i + 1) - j); // Printing the reverse order of numbers
                j++; // Incrementing the inner loop counter 'j'
            }

            System.out.println(); // Moving to the next line after printing the numbers for the current row
            i++; // Incrementing the outer loop counter 'i' for the next iteration
        }
    }
}
