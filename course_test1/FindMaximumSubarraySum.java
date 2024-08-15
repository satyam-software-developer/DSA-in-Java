/*
Problem statement
You are given an integer array, arr, of size N and a positive integer K. 
Out of all subarrays of 'arr' of size K, find the sum of the subarray that has the maximum sum.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of the input contains two space-separated integers, N and K
The second line contains N space-separated integers which represent the elements of the array, arr
Output format:
The output only consists of a single integer, the sum of the subarray that has the maximum sum
Constraints:
1 <= N <= 10^6
1 <= K <= N
Time limit: 1 sec 
Sample Input 1:
4 1
1 2 3 4
Sample Output 1:
4
Sample Input 2:
6 2
2 7 3 6 7 7 
Sample Output 2:
14
Explanation for Sample Output 2:
There are 5 subarrays of size 2 in this array. They are {2, 7}, {7, 3}, {3, 6}, {6, 7}, {7, 7}. 
Since the subarray {7, 7} has the maximum sum among all the subarrays, the output will be 7 + 7 = 14
*/

/*
   Time complexity: O(N)
   Space complexity: O(1)

   where N is the size of the array


*/

package course_test1;

import java.util.Scanner;

// Class definition for FindMaximumSubarraySum
public class FindMaximumSubarraySum {
    // Main method
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner s = new Scanner(System.in);
        
        // Read the size of the array (N) and the subarray size (K)
        int N = s.nextInt();
        int K = s.nextInt();
        
        // Create an array to store the elements
        int[] arr = new int[N];

        // Read the elements of the array
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        // Find the maximum sum of subarrays of size K
        int maxSum = findMaxSumOfSubarrays(arr, K);
        
        // Print the maximum sum
        System.out.println(maxSum);
    }

    // Method to find the maximum sum of subarrays of size K
    public static int findMaxSumOfSubarrays(int[] arr, int K) {
        int N = arr.length;
        int currentSum = 0;

        // Calculate the sum of the first K elements
        for (int i = 0; i < K; i++) {
            currentSum += arr[i];
        }

        // Initialize maxSum with the sum of the first subarray
        int maxSum = currentSum;

        // Calculate the sum of subsequent subarrays of size K
        for (int i = K; i < N; i++) {
            // Update currentSum by subtracting the first element of the previous subarray
            // and adding the next element after the previous subarray
            currentSum = currentSum - arr[i - K] + arr[i];
            
            // Update maxSum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        // Return the maximum sum
        return maxSum;
    }
}
