/*Problem statement
Given an array A of size n and an integer K, return all subsets of A which sum to K.

Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.


Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20

Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1 */

import java.util.Scanner;

public class ReturnSubsetsSumToK {

    // Helper method to find subsets that sum to k starting from a given index
    public static int[][] subsetsSumKHelper(int[] input, int beginIndex, int k) {
        // Base case: if beginIndex is equal to the length of the array
        if (beginIndex == input.length) {
            // If k is 0, return an array with one empty subset
            if (k == 0) {
                return new int[1][0];
            } else {
                // Otherwise, return an empty array (no subset found)
                return new int[0][0];
            }
        }

        // Recursively get subsets without including the current element
        int[][] smallOutput1 = subsetsSumKHelper(input, beginIndex + 1, k);
        // Recursively get subsets including the current element
        int[][] smallOutput2 = subsetsSumKHelper(input, beginIndex + 1, k - input[beginIndex]);

        // Create a new array to hold the combined results
        int[][] output = new int[smallOutput1.length + smallOutput2.length][];

        int index = 0;

        // Copy subsets from smallOutput1 to output
        for (int i = 0; i < smallOutput1.length; i++) {
            output[index++] = smallOutput1[i];
        }

        // Copy subsets from smallOutput2 to output, including the current element
        for (int i = 0; i < smallOutput2.length; i++) {
            output[index] = new int[smallOutput2[i].length + 1];
            output[index][0] = input[beginIndex]; // Add the current element
            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[index][j + 1] = smallOutput2[i][j];
            }
            index++;
        }

        return output;
    }

    // Public method to find all subsets of input array that sum to k
    public static int[][] subsetsSumK(int input[], int k) {
        return subsetsSumKHelper(input, 0, k);
    }

    static Scanner s = new Scanner(System.in);

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
        int output[][] = subsetsSumK(input, k); // Get all subsets that sum to k

        // Print all subsets
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
