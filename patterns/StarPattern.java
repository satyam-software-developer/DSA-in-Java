
/*Problem statement
Print the following pattern

Pattern for N = 4

Hint
As taught in the video, you just have to modify the code so that instead of printing numbers, it should output stars ('*').
The dots represent spaces.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
   *
  *** 
 *****
Sample Input 2 :
4
Sample Output 2 :
    *
   *** 
  *****
 ******* */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class StarPattern { // Declaring the public class StarPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows in the star pattern

        int i = 1; // Initializing the outer loop counter 'i' to 1

        // Looping through each row up to 'n'
        while (i <= n) {
            int spaces = 1; // Initializing the spaces counter for each row

            // Looping to print the leading spaces in each row
            while (spaces <= n - i) {
                System.out.print(" "); // Printing a space
                spaces += 1; // Incrementing the spaces counter
            }

            int star = 1; // Initializing the star counter for each row

            // Looping to print the stars in each row
            while (star <= 2 * i - 1) {
                System.out.print("*"); // Printing a star
                star += 1; // Incrementing the star counter
            }

            System.out.println(); // Moving to the next line after printing the stars of the current row
            i++; // Incrementing the outer loop counter 'i' for the next iteration
        }
    }
}
