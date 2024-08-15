/*
Problem statement
You are given an integer array 'arr' of size 'N'.



You must sort this array using 'Bubble Sort'.



Note:
Change in the input array itself. You don't need to return or print the elements.
Example:
Input: ‘N’ = 7
'arr' = [2, 13, 4, 1, 3, 6, 28]

Output: [1 2 3 4 6 13 28]

Explanation: After applying bubble sort on the input array, the output is [1 2 3 4 6 13 28].
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an integer 'N' representing the size of the array.

The second line contains 'N' single space-separated integers representing the elements of the array.
Output format :
The output contains the array elements after the sorting.
Sample Input 1:
7
2 13 4 1 3 6 28
Sample Output 1:
1 2 3 4 6 13 28
Explanation of Sample Output 1:
After applying bubble sort on the input array, the output is [1 2 3 4 6 13 28].
Sample Input 2:
5
9 3 6 2 0
Sample Output 2:
0 2 3 6 9
Explanation of Sample Output 2:
After applying bubble sort on the input array, the output is [0 2 3 6 9].
Constraints :
1 <= N <= 10^3
0 <= arr[i] <= 10^9
Time Limit: 1 sec

*/

package arrays;

import java.util.Scanner; // Import the Scanner class from the java.util package for user input.

public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        // Method to perform bubble sort on an array.
        for (int i = 0; i < n - 1; i++) { // Outer loop to traverse the array.
            for (int j = 0; j < n - 1 - i; j++) { // Inner loop to compare adjacent elements.
                if (arr[j] > arr[j + 1]) { // Compare adjacent elements.
                    int temp = arr[j]; // Swap if the current element is greater than the next element.
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Main method, entry point of the program.

        Scanner s = new Scanner(System.in); // Create a Scanner object for user input.
        int n = s.nextInt(); // Read the size of the array from the user.
        int[] arr = new int[n]; // Declare an array to store user input.

        // Read elements of the array from the user.
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt(); // Read an element from the user and store it in the array.
        }

        bubbleSort(arr, n); // Call the bubbleSort method to sort the array.

        // Print the sorted array.
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // Output each element of the array followed by a space.
        }
    }
}
