/*Problem statement
Print the following pattern for the given N number of rows.

Pattern for N = 4

The dots represent spaces.

Detailed explanation ( Input/output format, Notes, Images )
Constraints
0 <= N <= 50
Sample Input 1:
3
Sample Output 1:
      1 
    12
  123
Sample Input 2:
4
Sample Output 2:
      1 
    12
  123
1234 */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class MirrorNumberPattern { // Declaring the public class MirrorNumberPattern

    public static void main(String[] args) { // Declaring the main method

        // Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        // int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows

        // int currRow = 1; // Initializing the current row to 1

        // // Looping through each row up to 'n'
        // while (currRow <= n) {
        //     int spaces = 1; // Initializing the spaces counter to 1

        //     // Looping through each space for the current row
        //     while (spaces <= n - currRow) {
        //         System.out.print(" "); // Printing a space
        //         spaces += 1; // Incrementing the spaces counter
        //     }

        //     int currCol = 1; // Initializing the current column to 1

        //     // Looping through each column for the current row
        //     while (currCol <= currRow) {
        //         System.out.print(currCol); // Printing the current column value
        //         currCol += 1; // Incrementing the current column
        //     }

        //     System.out.println(); // Moving to the next line after printing numbers for the current row
        //     currRow += 1; // Incrementing the current row for the next iteration
        // }

        Scanner sc = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int N = sc.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows
        
        // Looping through each row up to 'N'
        for (int i = 1; i <= N; i++) {
            int space = 1; // Initializing the space counter to 1
            
            // Looping through each space for the current row
            while (space <= N - i) {
                System.out.print(" "); // Printing a space
                space = space + 1; // Incrementing the space counter
            }
            
            // Looping through each column for the current row
            for (int j = 1; j <= i; j++) {
                System.out.print(j); // Printing the current column value
            }
            
            System.out.println(); // Moving to the next line after printing numbers for the current row
        }
    }
}
