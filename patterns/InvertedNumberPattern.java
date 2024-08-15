/*Problem statement
Print the following pattern for the given N number of rows.

Pattern for N = 4
4444
333
22
1
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1:
5
Sample Output 1:
55555 
4444
333
22
1
Sample Input 2:
6
Sample Output 2:
666666
55555 
4444
333
22
1 */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class InvertedNumberPattern { // Declaring the public class InvertedNumberPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows

        int currRow = 1; // Initializing the current row to 1

        // Looping through each row up to 'n'
        while (currRow <= n) {
            int currCol = n - currRow + 1; // Initializing the current column to 'n - currRow + 1'

            // Looping through each column while 'currCol' is greater than or equal to 1
            while (currCol >= 1) {
                System.out.print(n - currRow + 1); // Printing the value of 'n - currRow + 1' for the current row
                currCol--; // Decrementing the current column for the next iteration
            }
            System.out.println(); // Moving to the next line after printing numbers for the current row
            currRow++; // Incrementing the current row for the next iteration
        }
    }
}

