/*Problem statement
Write a program to input an integer 'n' and print the sum of all its even digits and the sum of all its odd digits separately.



Digits mean numbers, not places! That is, if the given integer is "132456", even digits are 2, 4, and 6, and odd digits are 1, 3, and 5.

Constraints
0<= 'n' <=10000


Example :
Input: 'n' = 132456

Output: 12 9

Explanation:
The sum of even digits = 2 + 4 + 6 = 12
The sum of odd digits = 1 + 3 + 5 = 9
Constraints
0<= 'n' <=10000


Example :
Input: 'n' = 132456

Output: 12 9

Explanation:
The sum of even digits = 2 + 4 + 6 = 12
The sum of odd digits = 1 + 3 + 5 = 9
Input format :
 The first line contains an integer 'n'.
Output format :
In a single line, print two space-separated integers, first the sum of even digits and then the sum of odd digits.
Sample Input 1:
132456


Sample Output 1:
12 9


Explanation of sample input 1 :
The sum of even digits = 2 + 4 + 6 = 12
The sum of odd digits = 1 + 3 + 5 = 9


Sample Input 2:
552245


Sample Output 2:
8 15
 */

package conditionals_and_loops;

import java.util.Scanner;

public class SumOfEvenOdd {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner s = new Scanner(System.in);

        // Read the integer input from the user
        int n = s.nextInt();

        // Initialize variables to store the sum of even and odd digits
        int evenSum = 0, oddSum = 0;

        // Loop to extract digits from the number and compute the sum of even and odd
        // digits
        while (n > 0) {
            int last = n % 10; // Extract the last digit of the number

            // Check if the last digit is even
            if (last % 2 == 0) {
                evenSum += last; // Add the even digit to the even sum
            }

            // Check if the last digit is odd
            if (last % 2 != 0) {
                oddSum += last; // Add the odd digit to the odd sum
            }

            // Remove the last digit from the number
            n = n / 10;
        }

        // Print the sum of even and odd digits
        System.out.println(evenSum + " " + oddSum);
    }
}
