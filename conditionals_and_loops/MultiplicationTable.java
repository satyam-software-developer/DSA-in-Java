
/*Problem statement
Write a program that generates a multiplication table for a given integer.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
A single integer, n, where 0 <= n <= 10,000.
Output Format :
The first 10 multiples of n, each printed on a new line.
Constraints :
The input integer n is non-negative and less than or equal to 10,000.


Note:
The program should take an integer as input and print the first 10 multiples of the input integer. Each multiple should be printed on a new line. The program should not print anything else. The program should handle the case where the input integer is 0. In this case, the program should print ten lines of 0. The program does not need to handle invalid input. It can assume that the input will always be a valid integer within the specified constraints.
Sample Input 1 :
2
Sample Output 1 :
2
4
6
8
10
12
14
16
18
20
Sample Input 2 :
5
Sample Output 2 :
5
10
15
20
25
30
35
40
45
50 */

package conditionals_and_loops;

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read user input
        int n = s.nextInt(); // Read an integer input from the user

        int i = 1; // Initialize a counter variable for the multiplication table

        // Loop to print the multiplication table of the input number
        while (i <= 10) { // Iterate until 10 to print the table up to 10
            System.out.println(i * n); // Print the result of the current multiplication
            i++; // Increment the counter variable for the next multiplication
        }

    }

}
