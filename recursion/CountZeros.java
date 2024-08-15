/* 
Problem statement
Given an integer N, count and return the number of zeros that are present in the given integer using recursion.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Integer N
Output Format :
Number of zeros in N
Constraints :
0 <= N <= 10^9
Sample Input 1 :
0
Sample Output 1 :
1
Sample Input 2 :
00010204
Sample Output 2 :
2
Explanation for Sample Output 2 :
Even though "00010204" has 5 zeros, the output would still be 2 because when you convert it to an integer, it becomes 10204.
Sample Input 3 :
708000
Sample Output 3 :
4
*/

package recursion;

// Importing Scanner class for user input
import java.util.Scanner;

// Defining a public class named CountZeros
public class CountZeros {

    // Method to count zeros recursively
    public static int countZerosRec(int input) {
        // Base case: if input is a single digit number
        if (input < 10) {
            // If the input is zero, return 1, indicating one zero found
            if (input == 0) {
                return 1;
            }
            // If the input is not zero, return 0, indicating no zeros found
            else {
                return 0;
            }
        }
        // If input has more than one digit
        // Checking if the last digit is zero
        if(input % 10 == 0){
            // If last digit is zero, recursively call the function with input/10
            // and add 1 to the count of zeros
            return countZerosRec(input/10) + 1;
        } else {
            // If last digit is not zero, recursively call the function with input/10
            // and keep the count of zeros unchanged
            return countZerosRec(input/10) + 0;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner s = new Scanner(System.in);
        // Prompting the user to enter an integer
        int n = s.nextInt();
        // Calling the countZerosRec method with the input integer and printing the result
        System.out.println(countZerosRec(n));
    }
}
