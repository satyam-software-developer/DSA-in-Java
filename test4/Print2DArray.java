/* 
Problem statement
Given a 2D integer array with n rows and m columns. 
Print the 0th row from input n times, 1st row n-1 times…..(n-1)th row will be printed 1 time.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : No of rows (n) and no of columns (m) (separated by single space)
Line 2 : Row 1 elements (separated by space)
Line 3 : Row 2 elements (separated by space)
Line 4 : and so on
Sample Input 1:
3 3
1 2 3
4 5 6
7 8 9
Sample Output 1 :
1 2 3
1 2 3
1 2 3
4 5 6
4 5 6
7 8 9
*/


package test4;

import java.util.Scanner;

// Defining a public class named Print2DArray
public class Print2DArray {

    // Method to print a 2D array in a specific pattern
    public static void print2DArray(int input[][]) {
        // Initialize a variable k to store the number of rows
        int k = input.length;
        // Loop through each row of the input array
        for (int i = 0; i < input.length; i++) {
            // Loop through each column in reverse order
            for (int l = k - 1; l >= 0; l--) {
                // Loop through each element of the row
                for (int j = 0; j < input[i].length; j++) {
                    // Print the element followed by a space
                    System.out.print(input[i][j] + " ");
                }
                // Move to the next line after printing each row
                System.out.println();
            }
            // Decrement the value of k to consider fewer rows in each iteration
            k--;
        }
    }

    // Method to take input for a 2D array from the user
    public static int[][] takeInput() {
        // Create a Scanner object to read input from the user
        Scanner s = new Scanner(System.in);
        // Read the number of rows and columns from the user
        int numRows = s.nextInt();
        int numCols = s.nextInt();
        // Create a 2D array with the specified number of rows and columns
        int[][] input = new int[numRows][numCols];
        // Loop through each row and column to read input values from the user
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                input[i][j] = s.nextInt();
            }
        }
        // Return the input 2D array
        return input;
    }

    // Main method
    public static void main(String[] args) {
        // Call the takeInput method to get the input 2D array from the user
        int[][] input = takeInput();
        // Call the print2DArray method to print the input 2D array
        print2DArray(input);
    }
}
