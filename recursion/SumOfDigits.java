/* 
Problem statement
Write a recursive function that returns the sum of the digits of a given integer.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Integer N
Output format :
Sum of digits of N
Constraints :
0 <= N <= 10^9
Sample Input 1 :
12345
Sample Output 1 :
15
Sample Input 2 :
9
Sample Output 2 :
9
*/

package recursion;

import java.util.Scanner;

public class SumOfDigits {

    // Function to calculate the sum of digits of a number recursively
    public static int sumOfDigits(int input) {
        int sum;
        // Base case: If the input is less than 10, it's a single-digit number, return the input itself
        if (input < 10) {
            return input;
        }
        // Recursive case: Calculate the sum of the last digit (input % 10) and the sum of digits of the remaining number (input / 10)
        sum = (input % 10) + sumOfDigits(input / 10);
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Input a number from the user
        int n = s.nextInt();
        // Calculate and print the sum of digits of the input number
        System.out.println(sumOfDigits(n));
    }
}
