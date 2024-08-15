
/* Problem statement
Given an array A and an integer K, print all subsets of A which sum to K.

Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note :
The order of subsets are not important. Just print them in different lines.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Sample Input:
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output:
3 3
5 1
*/

import java.util.Scanner;

public class PrintSubsetSumToK {

    // Helper method to find subsets that sum to k starting from a given index
    public static void printSubsetsSumTokHelper(int[] input, int beginIndex, int[] output, int k) {
        // Base case: if beginIndex is equal to the length of the array
        if (beginIndex == input.length) {
            // If k is 0, print the current subset
            if (k == 0) {
                for (int i : output) {
                    System.out.print(i + " ");
                }
                System.out.println();
                return;
            } else {
                // If k is not 0, return without printing
                return;
            }
        }

        // Create a new array to hold the current subset including the current element
        int[] newOutput = new int[output.length + 1];
        int i = 0;
        for (; i < output.length; i++) {
            newOutput[i] = output[i];
        }
        newOutput[i] = input[beginIndex];

        // Recursively call the helper method excluding the current element
        printSubsetsSumTokHelper(input, beginIndex + 1, output, k);
        // Recursively call the helper method including the current element
        printSubsetsSumTokHelper(input, beginIndex + 1, newOutput, k - input[beginIndex]);
    }

    // Method to find and print all subsets of input array that sum to k
    public static void printSubsetsSumTok(int input[], int k) {
        int output[] = new int[0]; // Initialize an empty output array
        printSubsetsSumTokHelper(input, 0, output, k); // Call the helper method
    }

    static Scanner s = new Scanner(System.in); // Create a Scanner object for input

    // Method to take array input from the user
    public static int[] takeInput() {
        int size = s.nextInt(); // Read the size of the array
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt(); // Read each element of the array
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput(); // Take array input from the user
        int k = s.nextInt(); // Read the target sum k
        printSubsetsSumTok(input, k); // Print all subsets that sum to k
    }
}
