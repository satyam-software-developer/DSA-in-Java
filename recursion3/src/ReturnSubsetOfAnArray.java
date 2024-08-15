
/*Problem statement
Given an integer array (of length n), find and return all the subsets of input array.

NOTE- Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

Expected Time Complexity: O(2^N), where N is the size of given array
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12  */
import java.util.Scanner;

public class ReturnSubsetOfAnArray {

    // Helper method to find all subsets of the array starting from a given index
    public static int[][] subsetsHelper(int[] input, int startIndex) {
        // Base case: if startIndex is equal to the length of the array
        if (startIndex == input.length) {
            // Return a 2D array with one empty subset
            int[][] output = new int[1][0];
            return output;
        }

        // Recursively find subsets for the rest of the array
        int[][] smallerOutput = subsetsHelper(input, startIndex + 1);

        // Create a new array to hold the combined results
        int[][] output = new int[2 * smallerOutput.length][];

        int k = 0;

        // Copy subsets from smallerOutput to output
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j];
            }
            k++;
        }

        // Copy subsets from smallerOutput to output, including the current element
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length + 1];
            output[k][0] = input[startIndex]; // Add the current element
            for (int j = 1; j <= smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j - 1];
            }
            k++;
        }

        return output;
    }

    // Public method to find all subsets of input array
    public static int[][] subsets(int input[]) {
        return subsetsHelper(input, 0);
    }

    // Method to take array input from the user
    public static int[] takeInput() {
        Scanner s = new Scanner(System.in); // Create a Scanner object to take input from the user
        int size = s.nextInt(); // Read the size of the array
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt(); // Read each element of the array
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput(); // Take array input from the user
        int output[][] = subsets(input); // Get all subsets of the input array

        // Print all subsets
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}

