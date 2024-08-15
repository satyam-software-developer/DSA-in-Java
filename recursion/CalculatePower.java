/* 
Problem statement
Write a program to find x to the power n (i.e. x^n). 
Take x and n from the user. You need to return the answer.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Two integers x and n (separated by space)
Output Format :
x^n (i.e. x raise to the power n)
Constraints :
0 <= x <= 30
0 <= n <= 30
Sample Input 1 :
 3 4
Sample Output 1 :
81
Sample Input 2 :
 2 5
Sample Output 2 :
32
*/


package recursion; // Package declaration

import java.util.Scanner; // Importing Scanner class for user input

public class CalculatePower { // Class declaration

    // Recursive function to compute the power of a number
    public static int power(int x, int n) {
        // Base cases
        if (x == 0 && n == 0) { // If both x and n are zero, return 1
            return 1;
        }
        if (x == 0) { // If x is zero, return 0
            return 0;
        }
        if (n == 0) { // If n is zero, return 1 (any number raised to the power of 0 is 1)
            return 1;
        }
        // Recursive case: compute x^n by multiplying x with x^(n-1)
        return x * power(x, n - 1);
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Creating a Scanner object for user input

        // Read the base (x) and the exponent (n) from the user
        int x = s.nextInt();
        int n = s.nextInt();

        // Compute x^n using the power function and print the result
        System.out.println(power(x, n));

        s.close(); // Close the Scanner object to prevent resource leak
    }
}
