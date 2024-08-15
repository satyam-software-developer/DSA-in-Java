/*
Problem statement
Given an array of length N, you need to find and return the sum of all elements of the array.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Output Format :
Sum
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 9
Sample Output 1 :
26
Sample Input 2 :
3
4 2 1
Sample Output 2 :
7    
*/


package recursion;

import java.util.Scanner;

// Class SumOfArray
public class SumOfArray {

    // Recursive method to calculate sum of elements in an array starting from a specific index
    public static int sum(int input[], int startIndex) {
        // Base case: if startIndex reaches the length of the array, return 0
        if (startIndex == input.length) {
            return 0;
        }
        // Recursive step: return the sum of the current element and the sum of remaining elements
        return input[startIndex] + sum(input, startIndex + 1);
    }

    // Overloaded method to calculate sum of elements in an entire array
    public static int sum(int input[]) {
        // Call the sum method starting from index 0
        return sum(input, 0);
    }

    // Main method
    public static void main(String[] args) {
        // Creating Scanner object to read input from standard input (keyboard)
        Scanner s = new Scanner(System.in);
        // Reading the number of elements in the array
        int n = s.nextInt();
        // Creating an array of size n to store input elements
        int input[] = new int[n];
        // Reading elements into the array
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        // Printing the sum of elements in the array by calling the sum method
        System.out.println(sum(input));

    }

}

