
/*Problem statement
Write a program to generate the reverse of a given number N. Print the corresponding reverse number.

Note : If a number has trailing zeros, then its reverse will not include them. For e.g., reverse of 10400 will be 401 instead of 00401.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N < 10^8
Sample Input 1 :
1234
Sample Output 1 :
4321
Sample Input 2 :
1980
Sample Output 2 :
891
 */
package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class ReverseOfANumber { // Declaring the public class ReverseOfANumber

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number to be reversed

        int revNum = 0; // Initializing the variable to store the reverse of the number

        for (int temp = n; temp > 0;) { // Looping to reverse the number
            int lastDigit = temp % 10; // Extracting the last digit of the number
            revNum = revNum * 10 + lastDigit; // Building the reversed number by adding the last digit
            temp = temp / 10; // Removing the last digit from the number
        }

        System.out.println(revNum); // Printing the reverse of the given number
    }
}
