/*Problem statement
Given input consists of n numbers. 
Check whether those n numbers form an arithmetic progression or not. 
Print true or false.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
2 6 10 14 18 22
Sample Output 1 :
true
Sample Input 2 :
6
2 6 10 15 19 23
Sample Output 2 :
false */

package test1;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class CheckAP { // Declaring the public class CheckAP

    public static void main(String[] args) { // Declaring the main method

        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the standard input stream
        int n = s.nextInt(); // Reading an integer value from the standard input stream, which represents the total number of elements in the sequence
        int prev = s.nextInt(); // Reading the first integer value from the standard input stream, which represents the first element of the sequence
        int current = s.nextInt(); // Reading the second integer value from the standard input stream, which represents the second element of the sequence
        int count = 3; // Initializing the variable 'count' to 3, as we have already read the first two elements

        int d = current - prev; // Calculating the common difference 'd' of the arithmetic progression (AP)
        prev = current; // Updating the value of 'prev' to the current element

        // Loop to check the remaining elements of the sequence
        while (count <= n) {
            current = s.nextInt(); // Reading the next integer value from the standard input stream
            int tempD = current - prev; // Calculating the difference between the current element and the previous element

            // Checking if the difference 'tempD' is equal to the common difference 'd'
            if (tempD != d) {
                System.out.println("false"); // Printing 'false' and exiting the program if the difference is not equal to 'd'
                return;
            }
            count++; // Incrementing the counter 'count'
            prev = current; // Updating the value of 'prev' to the current element for the next iteration
        }
        System.out.println("true"); // Printing 'true' if the sequence satisfies the arithmetic progression (AP) property
    }
}

