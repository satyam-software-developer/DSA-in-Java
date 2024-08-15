/*Problem statement
Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to print the answer.

Note : For this question, you can assume that 0 raised to the power of 0 is 1

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Two integers x and n (separated by space)
Output Format :
x^n (i.e. x raise to the power n)
Constraints:
0 <= x <= 8 
0 <= n <= 9
Sample Input 1 :
 3 4
Sample Output 1 :
81
Sample Input 2 :
 2 5
Sample Output 2 :
32 */

package conditionals_and_loops;

import java.util.Scanner;

public class PowerOfANumber {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner s = new Scanner(System.in);

        // Read the base number from the user
        int x = s.nextInt();

        // Initialize a variable to store the result
        int temp = 1;

        // Read the exponent from the user
        int n = s.nextInt();

        // Calculate the power of the number using a loop
        while (n != 0) {
            temp = temp * x; // Multiply the base number by itself for each iteration
            n--; // Decrement the exponent
        }

        // Print the result, which is the base number raised to the power of the
        // exponent
        System.out.println(temp);
    }
}
