
/*Problem statement
Given a decimal number (integer N), convert it into binary and print.

Note: The given input number could be large, so the corresponding binary number can exceed the integer range. So you may want to take the answer as long for CPP and Java.
Note for C++ coders: Do not use the inbuilt implementation of "pow" function. The implementation of that function is done for 'double's and it may fail when used for 'int's, 'long's, or 'long long's. Implement your own "pow" function to work for non-float data types.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^5
Sample Input 1 :
12
Sample Output 1 :
1100
Sample Input 2 :
7
Sample Output 2 :
111
 */
package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class DecimalToBinary { // Declaring the public class DecimalToBinary

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the decimal number to convert

        long binary = 0, pow = 1; // Initializing variables to store the binary representation and the current power of 10
        while (n > 0) { // Looping until the decimal number becomes 0

            int lastBit = n % 2; // Calculating the last bit of the binary representation by taking the remainder when divided by 2
            binary += lastBit * pow; // Adding the last bit to the binary representation
            pow *= 10; // Increasing the power of 10 for the next digit position
            n = n / 2; // Dividing the decimal number by 2 to move to the next bit
        }

        System.out.println(binary); // Printing the binary representation of the decimal number
    }

}

