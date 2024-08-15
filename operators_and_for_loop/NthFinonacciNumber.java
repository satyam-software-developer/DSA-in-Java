/*Problem statement
The n-th term of Fibonacci series F(n), where F(n) is a function, is calculated using the following formula -

    F(n) = F(n - 1) + F(n - 2), 
    Where, F(1) = 1, F(2) = 1


Provided 'n' you have to find out the n-th Fibonacci Number. 
Handle edges cases like when 'n' = 1 or 'n' = 2 by using conditionals like if else and return what's expected.

"Indexing is start from 1"


Example :
Input: 6

Output: 8

Explanation: The number is ‘6’ so we have to find the “6th” Fibonacci number.
So by using the given formula of the Fibonacci series, we get the series:    
[ 1, 1, 2, 3, 5, 8, 13, 21]
So the “6th” element is “8” hence we get the output.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6

Sample Output 1:
8

Explanation of sample input 1 :
The number is ‘6’ so we have to find the “6th” Fibonacci number.
So by using the given formula of the Fibonacci series, we get the series:    
[ 1, 1, 2, 3, 5, 8, 13, 21]
So the “6th” element is “8” hence we get the output.


Expected time complexity :
The expected time complexity is O(n).


Constraints:
1 <= 'n' <= 10000     
Where ‘n’ represents the number for which we have to find its equivalent Fibonacci number.

Time Limit: 1 second
 */

/*
 Time complexity: O(N)
 Space complexity: O(1)
 where 1 represent the constant and 'N' represents the "Nth" number .
*/

package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class NthFinonacciNumber { // Declaring the public class NthFinonacciNumber

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input
                                            // stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the
                             // position of the Fibonacci number to find

        int a = 0; // Initializing the first Fibonacci number
        int b = 1; // Initializing the second Fibonacci number
        int c; // Declaring a variable to store the next Fibonacci number

        for (int i = 0; i < n; i++) { // Looping to calculate the nth Fibonacci number
            c = a + b; // Calculating the next Fibonacci number by adding the previous two numbers
            a = b; // Updating the value of the first Fibonacci number to the second Fibonacci
                   // number
            b = c; // Updating the value of the second Fibonacci number to the next Fibonacci
                   // number
        }

        System.out.println(a); // Printing the nth Fibonacci number
    }

}
