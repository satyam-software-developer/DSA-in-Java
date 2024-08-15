/*Problem statement
Write a program to print N number of rows for Half Diamond pattern using stars and numbers

Note : There are no spaces between the characters in a single line.


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
*
*1*
*121*
*12321*
*121*
*1*
*
Sample Input 2 :
 5
Sample Output 2 :
*
*1*
*121*
*12321*
*1234321*
*123454321*
*1234321*
*12321*
*121*
*1*
* */


package patterns;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class HalfDiamondPattern { // Declaring the public class HalfDiamondPattern

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of rows

        System.out.println("*"); // Printing a single asterisk at the beginning of the pattern

        // First Half
        int currRow = 1; // Initializing the current row to 1
        while (currRow <= n) { // Looping through each row in the first half
            System.out.print("*"); // Printing an asterisk at the beginning of each row
            int currCol = 1; // Initializing the current column to 1

            // Printing numbers in increasing order up to the current row number
            while (currCol <= currRow) {
                System.out.print(currCol); // Printing the current column number
                currCol += 1; // Incrementing the current column for the next iteration
            }

            // Printing numbers in decreasing order from current row number - 1 down to 1
            currCol = currCol - 2; // Adjusting the current column to the second-to-last number
            while (currCol >= 1) {
                System.out.print(currCol); // Printing the current column number
                currCol -= 1; // Decrementing the current column for the next iteration
            }

            System.out.println("*"); // Printing an asterisk at the end of each row
            currRow += 1; // Incrementing the current row for the next iteration
        }

        // Second Half
        currRow = 1; // Re-initializing the current row to 1 for the second half
        while (currRow <= n - 1) { // Looping through each row in the second half
            System.out.print("*"); // Printing an asterisk at the beginning of each row

            int currCol = 1; // Initializing the current column to 1
            // Printing numbers in increasing order up to n - current row
            while (currCol <= n - currRow) {
                System.out.print(currCol); // Printing the current column number
                currCol += 1; // Incrementing the current column for the next iteration
            }

            // Printing numbers in decreasing order from n - current row - 1 down to 1
            currCol = currCol - 2; // Adjusting the current column to the second-to-last number
            while (currCol >= 1) {
                System.out.print(currCol); // Printing the current column number
                currCol -= 1; // Decrementing the current column for the next iteration
            }

            System.out.println("*"); // Printing an asterisk at the end of each row
            currRow += 1; // Incrementing the current row for the next iteration
        }
        System.out.print("*"); // Printing a single asterisk at the end of the pattern
    }
}

