/*Problem statement
Check whether a given number ’n’ is a palindrome number.

Note :
Palindrome numbers are the numbers that don't change when reversed.
You don’t need to print anything. Just implement the given function.
Example:
Input: 'n' = 51415
Output: true
Explanation: On reversing, 51415 gives 51415.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1032
Sample Output 1 :
false
Explanation Of Sample Input 1:
1032, on being reversed, gives 2301, which is a totally different number.
Sample Input 2 :
121
Sample Output 2 :
true
Explanation Of Sample Input 2:
121, on being reversed, gives 121, which is the same.
Expected time complexity:
The expected time complexity is O(log(n)).
Constraints :
1 <= n <= 10^9
Time Limit: 1 sec */

package test1;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class PalindromeNumber { // Declaring the public class PalindromeNumber

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream

        int temp = n, revNum = 0; // Initializing variables to store the original and reversed numbers

        // Loop to reverse the number and store it in 'revNum'
        while (temp > 0) {
            int lastDigit = temp % 10; // Extracting the last digit of 'temp'
            temp = temp / 10; // Removing the last digit from 'temp'
            revNum = revNum * 10 + lastDigit; // Appending the last digit to the reversed number 'revNum'
        }

        // Checking if the original number 'n' is equal to its reversed version 'revNum'
        if (n == revNum) {
            System.out.println("true"); // Printing "true" if 'n' is a palindrome
        } else {
            System.out.println("false"); // Printing "false" if 'n' is not a palindrome
        }
    }
}
