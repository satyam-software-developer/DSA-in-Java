/*Problem statement
Write a program that asks the user for a number N and a choice C. And then give them the possibility to choose between computing the sum and computing the product of all integers in the range 1 to N (both inclusive).



If C is equal to -
 1, then print the sum
 2, then print the product
 Any other number, then print '-1' (without the quotes)
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 12
Sample Input 1 :
10
1
Sample Output 1 :
55
Sample Input 2 :
10
2
Sample Output 2 :
3628800
Sample Input 3 :
10
4
Sample Output 3 :
-1 */

package operators_and_for_loop;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class SumOrProduct { // Declaring the public class SumOrProduct

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream

        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the number
        int choice = s.nextInt(); // Reading an integer value from the standard input stream, which represents the user's choice (sum or product)

        if (choice == 1) { // Checking if the choice is 1 (for sum)
            int sum = 0; // Initializing the variable to store the sum
            for (int num = 1; num <= n; num++) { // Looping from 1 to n to calculate the sum
                sum += num; // Adding the current number to the sum
            }
            System.out.println(sum); // Printing the sum
        } else if (choice == 2) { // Checking if the choice is 2 (for product)
            int product = 1; // Initializing the variable to store the product
            for (int num = 1; num <= n; num++) { // Looping from 1 to n to calculate the product
                product *= num; // Multiplying the current number to the product
            }
            System.out.println(product); // Printing the product
        } else { // Handling the case if the choice is neither 1 nor 2
            System.out.println("-1"); // Printing -1 to indicate an invalid choice
        }

    }
}
