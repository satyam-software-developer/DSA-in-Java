/*Problem statement
Print the following pattern for the given number of rows.

Pattern for N = 5
E
DE
CDE
BCDE
ABCDE
Detailed explanation ( Input/output format, Notes, Images )
Constraints
0 <= N <= 26
Sample Input 1:
8
Sample Output 1:
H
GH
FGH
EFGH
DEFGH
CDEFGH
BCDEFGH
ABCDEFGH
Sample Input 2:
7
Sample Output 2:
G
FG
EFG
DEFG
CDEFG
BCDEFG
ABCDEFG
 */

package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class InterestingAlphabets { // Declaring the public class InterestingAlphabets

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows

        int currRow = 1; // Initializing the current row to 1

        // Looping through each row up to 'n'
        while (currRow <= n) {
            int currCol = 1; // Initializing the current column to 1

            char ch = (char) ('A' + n - currRow); // Calculating the starting character for the current row

            // Looping through each column up to the current row number
            while (currCol <= currRow) {
                System.out.print((char) (ch + currCol - 1)); // Printing characters in increasing order based on the current row and column
                currCol += 1; // Incrementing the current column for the next iteration
            }

            System.out.println(); // Moving to the next line after printing characters for the current row
            currRow += 1; // Incrementing the current row for the next iteration
        }
    }
}
