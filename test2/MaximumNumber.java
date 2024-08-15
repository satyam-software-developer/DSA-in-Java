/*Problem statement
We are given a 4 digit number using digits 1 to 9. What is the maximum 3 digit number that 
we can make by removing one digit from the given integer.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
5438
Sample Output :
548
Explanation :
1. If we remove 5, the new number is 438.
2. If we remove 4, the new number is 538.
3. If we remove 3, the new number is 548.
4. If we remove 8, the new number is 543.
Out of the 4 cases removing 3 gives us the maximum 3 digit number i.e 548
 */
package test2;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class MaximumNumber { // Declaring the public class MaximumNumber

    // Method to find the maximum number by rearranging digits of the given number
    public static int max_number(int n) {
        int maxNum = 0; // Initializing the maximum number
        int i = 1; // Initializing the divisor

        // Loop to iterate through each digit of the number
        while (n / i > 0) {
            // Rearranging the digits of the number by shifting the current digit to the leftmost position
            int newNum = (n / (i * 10)) * i + n % i;
            i = i * 10; // Updating the divisor for the next iteration

            // Updating the maximum number if the new rearranged number is greater
            if (maxNum < newNum) {
                maxNum = newNum;
            }
        }
        return maxNum; // Returning the maximum number
    }

    public static void main(String[] args) { // Declaring the main method
        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer input from the standard input stream

        System.out.println(max_number(n)); // Calling the max_number method and printing the maximum number
    }
}
