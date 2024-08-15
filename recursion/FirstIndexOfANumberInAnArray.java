/*
Problem statement
Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. 
Return -1 if it is not present in the array.

First index means, the index of first occurrence of x in the input array.

Do this recursively. Indexing in the array starts from 0.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
first index or -1
Constraints :
1 <= N <= 10^3

Sample Input :
4
9 8 10 8
8
Sample Output :
1
*/

/*
  Time Complexity : O(n)
  Space Complexity : O(n)
  where n is size of input array

*/


package recursion;

import java.util.Scanner;

// Class FirstIndexOfANumberInAnArray
public class FirstIndexOfANumberInAnArray {

    // Recursive method to find the first index of number 'x' in the array starting from index 'startIndex'
    public static int firstIndex(int input[], int x, int startIndex) {
        // Base case: If 'startIndex' reaches the length of the array, return -1 (indicating not found)
        if (startIndex == input.length) {
            return -1;
        }
        // Check if the element at 'startIndex' is equal to 'x'
        if (input[startIndex] == x) {
            return startIndex; // Return the index where 'x' is found
        }
        // Recursive step: Call the method again with incremented 'startIndex'
        return firstIndex(input, x, startIndex + 1);
    }

    // Overloaded method to find the first index of number 'x' in the entire array
    public static int firstIndex(int input[], int x) {
        // Call the main firstIndex method starting from index 0
        return firstIndex(input, x, 0);
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object to read input from standard input (keyboard)
        Scanner s = new Scanner(System.in);
        // Read the number of elements in the array from the user
        int n = s.nextInt();
        // Create an array of integers to store the input
        int[] input = new int[n];
        // Read the elements into the array
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        // Read the number to search for in the array
        int x = s.nextInt();
        // Call the firstIndex method and print the result
        System.out.println(firstIndex(input, x));
    }
}
