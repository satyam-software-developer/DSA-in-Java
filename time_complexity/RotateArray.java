/* Problem statement
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

package time_complexity;

import java.util.Scanner; // Import the Scanner class for user input

public class RotateArray {
    // Function to swap elements at indices start and end in the array
    public static void swapElements(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // Function to reverse elements in the array from index start to end
    public static void reverse(int[] arr, int start, int end) {
        // Swap elements until the start index is less than the end index
        while (start < end) {
            swapElements(arr, start, end);
            start += 1;
            end -= 1;
        }
    }

    // Function to rotate the array by d positions to the left
    public static void rotate(int[] arr, int d) {
        // If the array is empty, return without performing any rotation
        if (arr.length == 0) {
            return;
        }

        // If d is greater than or equal to the array length, reduce d to its modulo
        // array length
        if (d >= arr.length && arr.length != 0) {
            d %= arr.length;
        }

        // Reverse the entire array
        reverse(arr, 0, arr.length - 1);
        // Reverse the first (array.length - d) elements
        reverse(arr, 0, arr.length - d - 1);
        // Reverse the remaining d elements
        reverse(arr, arr.length - d, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input
        int t = s.nextInt(); // Input the number of test cases

        // Iterate over each test case
        while (t > 0) {
            int n = s.nextInt(); // Input the size of the array
            int arr[] = new int[n]; // Create an array of size 'n'

            // Input the elements of the array
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }

            int d = s.nextInt(); // Input the number of rotations to the left

            // Perform rotation of the array by d positions to the left
            rotate(arr, d);

            // Output the rotated array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Move to the next line for the next test case
            t = t - 1; // Decrement the number of test cases
        }
        s.close(); // Close the scanner object
    }
}
