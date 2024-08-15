/*Problem statement
Write a program that takes a number as input and prints all its factors except 1 and the number itself.. If the number has only two factors (1 and the number itself), then the program should print -1.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
A single integer, n
Output Format :
All the factors of n excluding 1 and the number itself
Constraints :
0 <= n <= 10,000
Sample Input 1 :
8
Sample Output 1 :
2 4
Explanation of Sample Output 1 :
The factors for the number excluding 1 and itself are 2 and 4, so the output is 2 4.
Sample Input 2 :
11
Sample Output 2 :
-1
Explanation of Sample Output 2 :
11 is a prime number having factors 1 and 11 so that output will be -1.
 */
package conditionals_and_loops;

import java.util.Scanner;

public class Factors {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Read the input integer from the user
        int i = 2; // Start checking for factors from 2, as 1 is a factor for all numbers
        boolean a = false; // Initialize a boolean variable to track if any factors are found

        // Loop to find factors of the input number
        while (i <= n / 2) { // Factors will not exceed n/2 for any number greater than 1
            if (n % i == 0) { // If i divides n without remainder, it is a factor
                System.out.print(i); // Print the factor
                System.out.print(" "); // Print a space for formatting
                a = true; // Update the boolean variable to indicate a factor is found
            }
            i++; // Move to the next number to check
        }

        // If no factors are found, print -1
        if (a == false) {
            System.out.print("-1");
        }

    }

}
