/*
Problem statement
Given the number 'n', write a code to print numbers from 1 to n in increasing order recursively.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Integer n
Output Format :
Numbers from 1 to n (separated by space)
Constraints :
1 <= n <= 10000
Sample Input 1 :
 6
Sample Output 1 :
1 2 3 4 5 6
Sample Input 2 :
 4
Sample Output 2 :
1 2 3 4
*/


package recursion;

import java.util.Scanner; // Importing Scanner class to read input from the user

public class PrintFirstNNaturalNumbers {
    // Recursive method to print the first 'n' natural numbers
    public static void print(int n) {
        // Base case: if n is 1, print 1 and return
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        // Recursive case: print the first 'n-1' natural numbers recursively
        print(n - 1);
        // Print the current number 'n'
        System.out.print(n + " ");
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Creating a Scanner object to read input from the user
        int n = s.nextInt(); // Reading an integer input from the user
        print(n); // Calling the print method to print the first 'n' natural numbers
    }
}


