/*Problem statement
Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= x <= 1,000
Sample Input 1 :
10
Sample Output 1 :
5 11 14 17 23 26 29 35 38 41
Sample Input 2 :
4
Sample Output 2 :
5 11 14 17
 */
package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class TermsOfAP { // Declaring the public class TermsOfAP

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream

        int x = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number of terms to print

        int current = 1; // Initializing the current term to 1
        for (int count = 0; count < x; count++) { // Looping to print x terms
            int num = 3 * current + 2; // Calculating the next term of the arithmetic progression (AP)
            if (num % 4 != 0) { // Checking if the term is not divisible by 4
                System.out.print(num + " "); // Printing the term followed by a space
            } else {
                count--; // Decrementing the count if the term is divisible by 4 to maintain the desired number of terms
            }
            current++; // Incrementing the current term for the next iteration
        }
    }

}
