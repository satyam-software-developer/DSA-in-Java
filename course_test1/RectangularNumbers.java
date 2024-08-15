/* Problem statement
Print the following pattern for the given number of rows.

Pattern for N = 4
4444444
4333334
4322234
4321234
4322234
4333334  
4444444
Input format : N (Total no. of rows)

Output format : Pattern in N lines

Sample Input :
3
Sample Output :
33333
32223
32123
32223
33333
*/


package course_test1;

import java.util.Scanner;

// Class definition for the RectangularNumbers class
public class RectangularNumbers {

    // Method to print rectangular numbers based on input
    public static void print(int n) {
        // Declare variables i, j, and a
        int i, j, a;
        
        // Loop through rows
        for (i = -(n - 1); i < n; i++) {
            a = n; // Set 'a' to the value of 'n'
            // Loop through columns
            for (j = -(n - 1); j < n; j++) {
                // If absolute value of 'i' is less than absolute value of 'j'
                if (Math.abs(i) < Math.abs(j)) {
                    // If 'j' is negative, print 'a' and decrement 'a'
                    if (j < 0) {
                        System.out.print(a);
                        a--;
                    } else {
                        // If 'j' is positive, increment 'a' and print 'a'
                        a++;
                        System.out.print(a);
                    }
                } else {
                    // If absolute value of 'i' is not less than absolute value of 'j', print 'a'
                    System.out.print(a);
                }
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner s = new Scanner(System.in);
        // Read an integer input from the user
        int n = s.nextInt();
        // Call the 'print' method with the input integer
        print(n);
        // Close the Scanner object
        s.close();
    }

}

