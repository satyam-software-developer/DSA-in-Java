/*
Problem statement
You have been given two sorted arrays/lists(ARR1 and ARR2) of size N and M respectively, 
merge them into a third array/list such that the third array is also sorted.

Note:
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements of the first array/list.

Third line contains an integer 'M' representing the size of the second array/list.

Fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output Format :
For each test case, print the sorted array/list(of size N + M) in a single row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
0 <= M <= 10^5
Time Limit: 1 sec 
Note:
Consider the case when size of the two arrays is not same.
Sample Input 1 :
1
5
1 3 4 7 11
4
2 4 6 13
Sample Output 1 :
1 2 3 4 4 6 7 11 13 
Sample Input 2 :
2
3
10 100 500
7
4 7 9 25 30 300 450
4
7 45 89 90
0
Sample Output 2 :
4 7 9 10 25 30 100 300 450 500
7 45 89 90

*/

package arrays;

import java.util.Scanner; // Import the Scanner class from the java.util package for user input.

public class MergeTwoSortedArrays {
    // Method to merge two sorted arrays into one sorted array.
    public static int[] merge(int arr1[], int arr2[]) {
        // Create an array to store the merged array.
        int[] ans = new int[arr1.length + arr2.length];

        // Initialize indices for arr1, arr2, and ans arrays respectively.
        int i = 0, j = 0, k = 0;

        // Merge the arrays.
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) { // If the current element of arr1 is smaller.
                ans[k] = arr1[i]; // Store the element in the ans array.
                k += 1; // Move to the next index in ans.
                i += 1; // Move to the next element in arr1.
            } else { // If the current element of arr2 is smaller or equal.
                ans[k] = arr2[j]; // Store the element in the ans array.
                k += 1; // Move to the next index in ans.
                j += 1; // Move to the next element in arr2.
            }
        }

        // Copy remaining elements of arr1 if any.
        while (i < arr1.length) {
            ans[k] = arr1[i]; // Copy the element to ans.
            k += 1; // Move to the next index in ans.
            i += 1; // Move to the next element in arr1.
        }

        // Copy remaining elements of arr2 if any.
        while (j < arr2.length) {
            ans[k] = arr2[j]; // Copy the element to ans.
            k += 1; // Move to the next index in ans.
            j += 1; // Move to the next element in arr2.
        }
        return ans; // Return the merged array.
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input.
        int t = s.nextInt(); // Read the number of test cases from the user.

        while (t > 0) { // Loop through each test case.
            int n = s.nextInt(); // Read the size of the first array from the user.
            int[] arr1 = new int[n]; // Declare an array to store elements of the first array.

            // Read elements of the first array from the user.
            for (int i = 0; i < n; i++) {
                arr1[i] = s.nextInt(); // Read an element from the user and store it in the first array.
            }

            int m = s.nextInt(); // Read the size of the second array from the user.
            int[] arr2 = new int[m]; // Declare an array to store elements of the second array.

            // Read elements of the second array from the user.
            for (int i = 0; i < m; i++) {
                arr2[i] = s.nextInt(); // Read an element from the user and store it in the second array.
            }

            int[] ans = new int[m + n]; // Declare an array to store the merged array.
            ans = merge(arr1, arr2); // Call the merge method to merge the two arrays.

            // Print the merged array.
            for (int i = 0; i < m + n; i++) {
                System.out.print(ans[i] + " "); // Output each element of the merged array followed by a space.
            }
            System.out.println(); // Output an end-of-line character.
            t -= 1; // Decrement the number of test cases.
        }
    }
}
