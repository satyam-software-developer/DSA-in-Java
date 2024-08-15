/* Problem statement
Given a number N, find its square root. You need to find and print only the integral part of square root of N.

For eg. if number given is 18, answer is 4.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^8
Sample Input 1 :
10
Sample Output 1 :
3
Sample Input 2 :
4
Sample Output 2 :
2 */

package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class SquareRootIntegral { // Declaring the public class SquareRootIntegral

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number to find the square root of

        int output = 0; // Initializing the variable to store the square root of the input number

        // Looping to find the integral square root of the input number
        while (output * output <= n) { // Checking if the square of the current output is less than or equal to the input number
            output = output + 1; // Incrementing the output to move towards the square root
        }

        output = output - 1; // Decrementing the output by 1 to get the integral square root
        System.out.println(output); // Printing the integral square root of the input number
    }
}
