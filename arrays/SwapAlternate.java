/*
Problem statement
You have been given an array/list(ARR) of size N. 
You need to swap every pair of alternate elements in the array/list.

You don't need to print or return anything, just change in the input array itself.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.
Output Format :
For each test case, print the elements of the resulting array in a single row separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
Time Limit: 1sec
Sample Input 1:
1
6
9 3 6 12 4 32
Sample Output 1 :
3 9 12 6 32 4
Sample Input 2:
2
9
9 3 6 12 4 32 5 11 19
4
1 2 3 4
Sample Output 2 :
3 9 12 6 32 4 11 5 19 
2 1 4 3 

*/

package arrays;

import java.util.Scanner;

public class SwapAlternate {

    // Function to swap alternate elements of an array
    public static void swapAlternate(int arr[], int n) {
        // Iterate through the array, skipping every alternate element
        for (int i = 0; i < n - 1; i += 2) {
            int temp = arr[i]; // Store the current element
            arr[i] = arr[i + 1]; // Swap the current element with the next element
            arr[i + 1] = temp; // Place the stored element in the next position
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Number of test cases

        // Process each test case
        while (t > 0) {
            int n = s.nextInt(); // Size of the array for the current test case
            int[] arr = new int[n]; // Create an array to store input elements

            // Input elements into the array
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }

            // Swap alternate elements of the array
            swapAlternate(arr, n);

            // Print the modified array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Print a newline after printing the array

            t -= 1; // Decrement the number of test cases
        }
    }
}
