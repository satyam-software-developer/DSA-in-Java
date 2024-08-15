/* Problem statement
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format
The first and only line of output contains length of the longest subarray whose sum is zero.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 
Note
You don't have to print anything. Just complete the definition of the function given and return the value accordingly. */

/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the size of the input array
 */

import java.util.HashMap; // Import HashMap class for storing prefix sums
import java.io.BufferedReader; // Import BufferedReader class for reading input
import java.io.IOException; // Import IOException class for handling IO exceptions
import java.io.InputStreamReader; // Import InputStreamReader class for reading input stream
import java.util.StringTokenizer; // Import StringTokenizer class for parsing input

public class LongestSubarrayZeroSum {
    // Create a BufferedReader object to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Method to find the length of the longest subarray with zero sum
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // HashMap to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // Calculate the prefix sum for the array
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        int len = 0; // Initialize the length of the longest subarray to 0

        // Iterate through the array to find the longest subarray with zero sum
        for (int i = 0; i < n; i++) {
            // If the prefix sum is zero, update the length of the longest subarray
            if (arr[i] == 0) {
                if (len < i + 1) {
                    len = i + 1;
                }
            }
            // If the prefix sum has been seen before, update the length of the longest
            // subarray
            else if (map.containsKey(arr[i])) {
                if (len < i - map.get(arr[i])) {
                    len = i - map.get(arr[i]);
                }
            }
            // If the prefix sum is seen for the first time, store its index
            else {
                map.put(arr[i], i);
            }
        }
        return len; // Return the length of the longest subarray with zero sum
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine()); // Read the first line of input
        int n = Integer.parseInt(st.nextToken()); // Parse the number of elements in the array
        int arr[] = new int[n]; // Initialize the array with the given size

        st = new StringTokenizer(br.readLine()); // Read the second line of input
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // Parse each element and store it in the array
        }

        System.out.println(lengthOfLongestSubsetWithZeroSum(arr)); // Print the length of the longest subarray with zero
                                                                   // sum

    }
}
