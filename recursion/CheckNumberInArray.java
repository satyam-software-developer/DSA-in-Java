/*
Problem statement
Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
'true' or 'false'
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 10
8
Sample Output 1 :
true
Sample Input 2 :
3
9 8 10
2
Sample Output 2 :
false
*/


package recursion;

import java.util.Scanner;

// Class CheckNumberInArray
public class CheckNumberInArray {

    // Method to check if a number 'x' exists in the array 'input' starting from index 'startIndex'
    public static boolean checkNumber(int input[], int x, int startIndex) {
        // Base case: If 'startIndex' reaches the length of the array, return false
        if (startIndex == input.length) {
            return false;
        }
        // Check if the element at 'startIndex' is equal to 'x'
        if (input[startIndex] == x) {
            return true;
        }
        // Recursive step: Call the method again with incremented 'startIndex'
        return checkNumber(input, x, startIndex + 1);
    }

    // Method overload to initiate the search from the beginning of the array
    public static boolean checkNumber(int input[], int x) {
        // Call the main checkNumber method starting from index 0
        return checkNumber(input, x, 0);
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object to read input from standard input (keyboard)
        Scanner s = new Scanner(System.in);
        // Read the number of elements in the array from the user
        int n = s.nextInt();
        // Create an array of integers to store the input
        int input[] = new int[n];
        // Read the elements into the array
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        // Read the number to search for in the array
        int x = s.nextInt();
        // Call the checkNumber method and print the result
        System.out.println(checkNumber(input, x));
    }
}
