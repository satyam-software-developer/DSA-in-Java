/* 
Problem statement
Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.

Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.

You should start traversing your array from 0, not from (N - 1).

Do this recursively. Indexing in the array starts from 0.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
last index or -1
Constraints :
1 <= N <= 10^3

Sample Input :
4
9 8 10 8
8
Sample Output :
3
*/

package recursion;

import java.util.Scanner;

// This class finds the last index of a given number in an array recursively.
public class LastIndexOfANumberInAnArray {

    // This method finds the last index of the number 'x' in the array 'input'.
    // It starts searching from the 'startIndex'.
    public static int lastIndex(int input[], int x, int startIndex) {
        // Base case: if startIndex reaches the end of the array, return -1 (indicating not found).
        if (startIndex == input.length) {
            return -1;
        }
        // Recursive call: move to the next index and continue searching.
        int smallAns = lastIndex(input, x, startIndex + 1);
        // If the number is found in the later indices, return the index.
        if (smallAns != -1) {
            return smallAns;
        }
        // If the number is found at the current index, return the current index.
        if (input[startIndex] == x) {
            return startIndex;
        } else {
            // If the number is not found, return -1.
            return -1;
        }
    }

    // Overloaded method to start the search from the beginning of the array.
    public static int lastIndex(int input[], int x) {
        return lastIndex(input, x, 0);
    }

    // Main method to take input and call the lastIndex method.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Read the size of the array.
        int n = s.nextInt();
        // Create an array of size 'n'.
        int[] input = new int[n];
        // Read 'n' integers into the array.
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        // Read the number to find its last index.
        int x = s.nextInt();
        // Call the lastIndex method and print the result.
        System.out.println(lastIndex(input, x));
    }
}
