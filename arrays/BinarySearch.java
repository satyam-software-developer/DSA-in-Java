
/*
Problem statement
You are given an integer array 'A' of size 'N', sorted in non-decreasing order. 
You are also given an integer 'target'.

Your task is to write a function to search for 'target' in the array 'A'. 
If it exists, return its index in 0-based indexing. 
If 'target' is not present in the array 'A', return -1.

Note:

You must write an algorithm whose time complexity is O(LogN)

Example:

Input: ‘N’ = 7 ‘target’ = 3
‘A’ = [1, 3, 7, 9, 11, 12, 45]

Output: 1

Explanation: A = [1, 3, 7, 9, 11, 12, 45],
The index of element '3' is 1.
Hence, the answer is '1'.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 'N', which denotes the size of the array/list.

The second line contains 'N' single space-separated integers representing the elements in the array/list.

The third line contains the value of 'target' to be searched for in the array/list.
Output Format :
Return the index at which 'target' is present for each test case, -1 otherwise.
Constraints :
1 <= N <= 10^5
1 <= A[i] <= 10^9
1 <= target <= 10^9
Time Limit: 1 sec
Sample Input 1:
7
1 3 7 9 11 12 45
3
Sample Output 1:
1
Explanation of sample output 1:
nums = [1, 3, 7, 9, 11, 12, 45],
The index of element '3' is 1.
Hence, the answer is '1'.

Sample Input 2:
7
1 2 3 4 5 6 7
9
Sample Output 2:
-1
Explanation of sample output 2:
nums = [1, 2, 3, 4, 5, 6, 7],
Element '9' doesn't exist.
Hence, the answer is '-1'.

*/

package arrays;

import java.util.Scanner;

public class BinarySearch {

    // Function to perform binary search on a sorted array
    public static int search(int[] nums, int x) {
        int n = nums.length - 1; // Length of the array (subtracting 1 to account for 0-based indexing)
        int s = 0, e = n - 1; // Initialize start and end indices for binary search

        // Perform binary search until start index is less than or equal to end index
        while (s <= e) {
            int mid = (s + e) / 2; // Calculate mid index of the array

            // If the element at mid index is equal to the target element x, return mid
            if (nums[mid] == x) {
                return mid;
            }
            // If the target element x is less than the element at mid index,
            // set end index to mid - 1 to search in the left half of the array
            else if (nums[mid] > x) {
                e = mid - 1;
            }
            // If the target element x is greater than the element at mid index,
            // set start index to mid + 1 to search in the right half of the array
            else {
                s = mid + 1;
            }
        }

        // If the target element x is not found in the array, return -1
        return -1;
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Take the size of the array as input from the user
        int arr[] = new int[n]; // Declare an array to store the input elements

        // Take input for each element of the array from the user
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int x = s.nextInt(); // Take the target element x as input from the user
        int result = search(arr, x); // Perform binary search on the array to find the index of the target element
        System.out.print(result); // Print the result of binary search
    }
}
