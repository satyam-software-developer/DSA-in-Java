
/*Problem statement
Create a function that determines whether a given number N belongs to the Fibonacci sequence. If N is found in the Fibonacci sequence, the function should return true; otherwise, it should return false.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Integer N
Output Format :
true or false
Constraints :
0 <= n <= 10^4
Sample Input 1 :
5
Sample Output 1 :
true
Explanation :
Fibonacci sequence begins 0, 1, 1, 2, 3, 5, ... and so on. Since 5 appears in the sequence.
Sample Input 2 :
14
Sample Output 2 :
false     */

package functions_and_scope;

import java.util.Scanner;

public class FibonacciMember {
    // Method to check if a given number is a Fibonacci member
    public static boolean checkMember(int n) {
        int a = 0; // Initialize the first Fibonacci number
        int b = 1; // Initialize the second Fibonacci number
        int c; // Variable to store the next Fibonacci number

        // Loop to generate Fibonacci numbers until reaching or exceeding n
        while (a < n) {
            c = a + b; // Calculate the next Fibonacci number
            a = b; // Update the first Fibonacci number
            b = c; // Update the second Fibonacci number
        }

        // Check if n matches any Fibonacci number generated
        if (a == n) {
            return true; // Return true if n is a Fibonacci number
        } else {
            return false; // Return false if n is not a Fibonacci number
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read user input

        int n = s.nextInt(); // Read the integer input from the user

        // Call the method to check if the input number is a Fibonacci member and print
        // the result
        System.out.println(checkMember(n));
    }
}
