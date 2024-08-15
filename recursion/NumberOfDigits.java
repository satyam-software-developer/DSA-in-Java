/*
Problem statement
You are given a number 'n'.

Return number of digits in ‘n’.

Example:
Input: 'n' = 123

Output: 3

Explanation:
The 3 digits in ‘123’ are 1, 2 and 3. 

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of input contains an integer ‘n’.

Output Format:
Return an integer as described in the problem statement. 

Note
You don’t need to print anything, it has already been taken care of, just complete the given function.
Sample Input 1:
121

Sample Output 1:
3

Explanation of sample output 1:
There are 3 digits in 121 are 1,2 and 1.

Sample Input 2:
38

Sample Output 2:
2

Expected time complexity :
The expected time complexity is O(log n).

Constraints:
1 <= ‘n’ <= 10^9
*/

/*
 *  Time Complexity: O(1)
 *  Space Complexity: O(1)
 * 
 *  Where 'n' is the given number.
 * 
 */

package recursion;

import java.util.Scanner;  // Importing Scanner class to read input from the user

public class NumberOfDigits {
    // Method to count the number of digits in an integer 'n'
    public static int countDigits(int n) {
        // Using Math.log10() to calculate the number of digits
        // Adding 1 to account for the position of the most significant digit
        return (int) (Math.log10(n) + 1);
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  // Creating a Scanner object to read input from the user
        int n = s.nextInt();  // Reading an integer input from the user
        System.out.println(countDigits(n));  // Calling the countDigits method and printing the result
    }
}
