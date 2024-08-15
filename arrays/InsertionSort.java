/*
Problem statement
You are given an integer array 'arr' of size 'N'.

You must sort this array using 'Insertion Sort' recursively.

 Note:
Change in the input array itself. You don't need to return or print the elements.
Example:
Input: ‘N’ = 7
'arr' = [2, 13, 4, 1, 3, 6, 28]

Output: [1 2 3 4 6 13 28]

Explanation: After applying insertion sort on the input array, the output is [1 2 3 4 6 13 28].
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an integer 'N' representing the size of the array.

The second line contains 'N' single space-separated integers representing the elements of the array.
Output Format :
Print the array elements in sorted order, separated by a single space.
Sample Input 1:
5
9 3 6 2 0
Sample Output 1:
0 2 3 6 9
Sample Input 2:
4
4 3 2 1
Sample Output 2:
1 2 3 4 
Constraints :
0 <= N <= 10^3
0 <= arr[i] <= 10^5
Time Limit: 1 sec

*/

/*
  Time Complexity: O(N^2)
  Space Complexity: O(N)

*/


package arrays;

import java.util.Scanner; // Import the Scanner class from the java.util package for user input.

public class InsertionSort {

    // Method to perform insertion sort on an array.
    public static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) { // Iterate over the array starting from the second element.
            int key = arr[i]; // Store the current element in the key variable.
            int j = i - 1; // Initialize j to the index of the previous element.

            // Move elements of arr[0..i-1], that are greater than key, to one position
            // ahead of their current position.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift elements to the right.
                j--; // Move to the previous element.
            }
            arr[j + 1] = key; // Place the key at its correct position.
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input.
        int n = s.nextInt(); // Read the size of the array from the user.
        int[] arr = new int[n]; // Declare an array to store user input.

        // Read elements of the array from the user.
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt(); // Read an element from the user and store it in the array.
        }

        insertionSort(arr, n); // Call the insertionSort method to sort the array.

        // Print the sorted array.
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // Output each element of the array followed by a space.
        }
    }
}
