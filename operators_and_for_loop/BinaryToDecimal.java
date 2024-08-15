/* Problem statement
Given a binary number as an integer N, convert it into decimal and print.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^9
Sample Input 1 :
1100
Sample Output 1 :
12
Sample Input 2 :
111
Sample Output 2 :
7
 */

package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class BinaryToDecimal { // Declaring the public class BinaryToDecimal

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int num = s.nextInt(); // Reading an integer value from the standard input stream and storing it in the variable 'num'

        int decimal = 0, pow = 1; // Initializing variables to store the decimal equivalent and the power of 2
        for (; num > 0;) { // Looping until the binary number becomes 0

            int last = num % 10; // Extracting the last digit of the binary number
            decimal += last * pow; // Adding the contribution of the last digit to the decimal equivalent
            pow *= 2; // Updating the power of 2 for the next digit
            num = num / 10; // Removing the last digit from the binary number

        }
        System.out.println(decimal); // Printing the decimal equivalent of the binary number to the standard output stream
    }

}
