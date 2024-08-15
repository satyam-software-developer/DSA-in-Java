
/*Problem statement
Print the following pattern for the given N number of rows.

Pattern for N = 4
A
BC
CDE
DEFG
Detailed explanation ( Input/output format, Notes, Images )
Constraints
0 <= N <= 13
Sample Input 1:
5
Sample Output 1:
A
BC
CDE
DEFG
EFGHI
Sample Input 2:
6
Sample Output 2:
A
BC
CDE
DEFG
EFGHI
FGHIJK
 */


package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class CharacterPattern { // Declaring the public class CharacterPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows in the pattern

        int currRow = 1; // Initializing the current row to 1

        while (currRow <= n) { // Looping through each row until the current row reaches n
            int currCol = 1; // Initializing the current column to 1

            char ch = (char) ('A' + currRow - 1); // Calculating the character for the current row based on its position

            while (currCol <= currRow) { // Looping through each column until the current column reaches the current row
                System.out.print((char) (ch + currCol - 1)); // Printing the character for the current row and column
                currCol += 1; // Incrementing the current column for the next iteration
            }
            System.out.println(); // Moving to the next line after printing each row
            currRow += 1; // Incrementing the current row for the next iteration
        }
    }
}

