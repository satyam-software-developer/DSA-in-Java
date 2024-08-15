
/*Problem statement
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.
Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true */

/*
 * Time complexity: O(N)
 * Space complexity: O(1)
 * 
 * where N is the size of the the input array
 */

import java.io.IOException; // For handling IO exceptions
import java.util.Scanner; // For using Scanner to read input

public class CheckMaxHeap {

    // Method to check if the given array represents a max heap
    public static boolean checkMaxHeap(int arr[]) {
        int n = arr.length; // Get the number of elements in the array

        // Iterate over each element to check heap property
        for (int i = 0; 2 * i + 1 < n; i++) {
            int leftChildIndex = 2 * i + 1; // Index of the left child
            int rightChildIndex = leftChildIndex + 1; // Index of the right child

            // Check if the left child exists and is greater than the parent
            if (arr[i] < arr[leftChildIndex]) {
                return false; // If left child is greater than parent, return false
            }

            // Check if the right child exists and is greater than the parent
            if (rightChildIndex < n && arr[i] < arr[rightChildIndex]) {
                return false; // If right child is greater than parent, return false
            }
        }

        return true; // Return true if all heap properties are satisfied
    }

    static Scanner s = new Scanner(System.in); // Create a Scanner instance for reading input

    public static void main(String[] args) throws NumberFormatException, IOException {

        int n = s.nextInt(); // Read the size of the array
        int input[] = new int[n]; // Initialize the input array with the size n

        // Read the elements of the array
        for (int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }

        // Check if the input array represents a max heap and print the result
        System.out.println(checkMaxHeap(input));
    }
}
