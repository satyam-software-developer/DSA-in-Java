/*
Problem statement
Given an array/list(ARR) of length N, you need to find and return the sum of all the elements in the array/list.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5

Time Limit: 1sec
Sample Input 1:
1
3
9 8 9
Sample Output 1:
26
Sample Input 2:
2
5
1 2 3 4 5 
3
10 20 30 
Sample Output 2:
15
60

*/

package arrays;

import java.util.Scanner;

public class ReturnArraySum {
    // Function to calculate the sum of elements in an array
    public static int sum(int[] arr) {
        int ans = 0; // Initialize the sum to zero
        // Iterate through the array elements
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i]; // Add each element to the sum
        }
        return ans; // Return the total sum
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Number of test cases

        // Process each test case
        while (t > 0) {
            int size = s.nextInt(); // Size of the array for the current test case
            int[] input = new int[size]; // Create an array to store input elements

            // Input elements into the array
            for (int i = 0; i < size; ++i) {
                input[i] = s.nextInt();
            }

            // Calculate and print the sum of elements in the array
            System.out.println(sum(input));

            t -= 1; // Decrement the number of test cases
        }
    }
}
