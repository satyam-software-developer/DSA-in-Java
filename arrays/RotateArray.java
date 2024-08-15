/*
Problem statement
You have been given a random integer array/list(ARR) of size N. 
Write a function that rotates the given array/list by D elements(towards the left).

 Note:
Change in the input array/list itself.You don't need to return or print the elements.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains the value of 'D' by which the array/list needs to be rotated.
Output Format :
For each test case, print the rotated array/list in a row separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^4
0 <= N <= 10^6
0 <= D <= N
Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7
2
Sample Output 1:
3 4 5 6 7 1 2
Sample Input 2:
2
7
1 2 3 4 5 6 7
0
4
1 2 3 4
2
Sample Output 2:
1 2 3 4 5 6 7
3 4 1 2

*/

package arrays; // Declare the package name

import java.util.Scanner; // Import the Scanner class for user input

public class RotateArray { // Declare a class named RotateArray

    // Function to swap elements at indices start and end in the array
    public static void swapElements(int[] arr, int start, int end) {
        int temp = arr[start]; // Store the value of arr[start] in a temporary variable
        arr[start] = arr[end]; // Assign the value of arr[end] to arr[start]
        arr[end] = temp; // Assign the value of the temporary variable to arr[end]
    }

    // Function to reverse elements in the array between indices start and end
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) { // Loop until start is less than end
            swapElements(arr, start, end); // Swap elements at indices start and end
            start += 1; // Increment start
            end -= 1; // Decrement end
        }
    }

    // Function to rotate the array to the left by d positions
    public static void rotate(int[] arr, int d) {
        if (arr.length == 0) { // If the array is empty, return without rotation
            return;
        }

        if (d >= arr.length && arr.length != 0) { // If d is greater than or equal to the array length
            d %= arr.length; // Set d to the remainder when divided by the array length
        }

        // Perform array rotation in three steps: reverse the entire array, then reverse
        // the first part, then reverse the second part
        reverse(arr, 0, arr.length - 1); // Reverse the entire array
        reverse(arr, 0, arr.length - d - 1); // Reverse the first part of the array
        reverse(arr, arr.length - d, arr.length - 1); // Reverse the second part of the array
    }

    public static void main(String[] args) { // Main method
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input
        int t = s.nextInt(); // Read the number of test cases from the user

        while (t > 0) { // Loop through each test case
            int n = s.nextInt(); // Read the size of the array from the user
            int arr[] = new int[n]; // Declare an array to store the elements

            // Read elements of the array from the user
            for (int i = 0; i < n; i++) { // Iterate over each element of the array
                arr[i] = s.nextInt(); // Read an element from the user and store it in the array
            }

            int d = s.nextInt(); // Read the number of rotations from the user
            rotate(arr, d); // Call the rotate function to rotate the array by d positions to the left

            // Print the rotated array
            for (int i = 0; i < n; i++) { // Iterate over each element of the array
                System.out.print(arr[i] + " "); // Output each element of the array followed by a space
            }
            System.out.println(); // Output an end-of-line character after printing the array
            t = t - 1; // Decrement the number of test cases
        }
    }
}
