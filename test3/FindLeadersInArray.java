/* Problem statement
Given an integer array A of size n. Find and print all the leaders present in the input array. 
An array element A[i] is called Leader, if all the elements following it (i.e. present at its right) are less than or equal to A[i].

Print all the leader elements separated by space and in the reverse order. 
That means whichever leader comes at last should be printed first.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : Integer n, size of array
Line 2 : Array A elements (separated by space)
Output Format :
 leaders of array (separated by space)
Constraints :
1 <= n <= 10^6

Sample Input 1 :
6
3 12 34 2 0 -1
Sample Output 1 :
-1 0 2 34
Sample Input 2 :
5
13 17 5 4 6
Sample Output 2 :
6 17
*/


package test3;

import java.util.Scanner; // Import the Scanner class from java.util package

public class FindLeadersInArray { // Define a public class named FindLeadersInArray

    // Define a method named leaders that takes an array of integers as input
    public static void leaders(int[] input) {

        int max = Integer.MIN_VALUE; // Initialize a variable 'max' to the smallest possible integer value
        // Iterate through the array from the end to the beginning
        for (int i = input.length - 1; i >= 0; i--) {
            // Check if the current element is greater than or equal to 'max'
            if (input[i] >= max) {
                System.out.print(input[i] + " "); // Print the current element as it's a leader
                max = input[i]; // Update 'max' to the current element
            }
        }
    }

    // Define the main method, the entry point of the program
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in); // Create a Scanner object to read input from the console
        int n = s.nextInt(); // Read the size of the array from the user
        int input[] = new int[n]; // Create an array 'input' of size 'n' to store the elements
        // Input loop: Read 'n' integers from the user and store them in the 'input' array
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt(); // Read the next integer from the console
        }
        leaders(input); // Call the 'leaders' method passing the 'input' array as argument
    }
}
