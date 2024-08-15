/*
Problem statement
You have been given an empty array(ARR) and its size N. 
The only input taken from the user will be N and you need not worry about the array.

Your task is to populate the array using the integer values in the range 1 to N(both inclusive) in the order - 1,3,5,.......,6,4,2.

Note:
You need not print the array. You only need to populate it.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

The first and the only line of each test case or query contains an integer 'N'.
Output Format :
For each test case, print the elements of the array/list separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4

Time Limit: 1sec
Sample Input 1 :
1
6
Sample Output 1 :
1 3 5 6 4 2
Explanation of Sample Input 1 :
Since the value of N is 6, the number will be stored in the array in such a fashion that 1 will appear at 0th index, then 2 at the last index, in a similar fashion 3 is stored at index 1. 
Hence the array becomes 1 3 5 6 4 2.
Sample Input 2 :
2
9
3
Sample Output 2 :
1 3 5 7 9 8 6 4 2
1 3 2

*/

package arrays;

import java.util.Scanner;

public class ArrangeNumbersInArray {

    // Function to arrange numbers in the array according to the given pattern
    public static void arrange(int[] arr, int n) {
        int left = 0; // Initialize the left pointer
        int right = n - 1; // Initialize the right pointer
        int counter = 1; // Initialize the counter for numbers

        // Iterate through the array until left pointer is less than or equal to right
        // pointer
        while (left <= right) {
            // If the counter is odd, place the number at the left pointer
            if (counter % 2 == 1) {
                arr[left] = counter;
                counter += 1;
                left += 1;
            }
            // If the counter is even, place the number at the right pointer
            else {
                arr[right] = counter;
                counter += 1;
                right -= 1;
            }
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Take the number of test cases as input from the user

        // Process each test case
        while (t > 0) {
            int n = s.nextInt(); // Take the size of the array as input from the user
            int[] arr = new int[n]; // Declare an array to store the arranged numbers

            // Arrange the numbers in the array according to the given pattern
            arrange(arr, n);

            // Print the arranged numbers in the array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Print a newline after printing each test case
            t -= 1; // Decrement the number of test cases
        }
    }
}
