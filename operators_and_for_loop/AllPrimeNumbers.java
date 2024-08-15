/*Problem statement
Given an integer N, print all the prime numbers that lie in the range 2 to N (both inclusive).

Print the prime numbers in different lines.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 100
Sample Input 1:
9
Sample Output 1:
2
3
5
7
Sample Input 2:
20
Sample Output 2:
2
3
5
7
11
13
17
19
 */

package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class AllPrimeNumbers { // Declaring the public class AllPrimeNumbers

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream and storing it in the variable 'n'

        // Looping through integers from 2 to n to find prime numbers
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true; // Initializing a boolean variable to track if the current number is prime

            // Looping through integers from 2 to i-1 to check for factors of i
            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // If i is divisible by j, it is not prime
                    isPrime = false;
                    break; // Exiting the loop as soon as a factor is found
                }
            }

            // If isPrime is still true after the inner loop, i is a prime number
            if (isPrime) {
                System.out.println(i); // Printing the prime number to the standard output stream
            }
        }
    }
}
