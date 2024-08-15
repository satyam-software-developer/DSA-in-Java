/*
Problem statement
You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].

Now, in the given array/list, 'M' numbers are present twice and one number is present only once.

You need to find and return that number which is unique in the array/list.

 Note:
Unique element is always present in the array/list according to the given condition.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.
Output Format :
For each test case, print the unique element present in the array.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1 sec
Sample Input 1:
1
7
2 3 1 6 3 6 2
Sample Output 1:
1
Explanation: The array is [2, 3, 1, 6, 3, 6, 2]. Here, the numbers 2, 3, and 6 are present twice, 
and the number 1 is present only once. So, the unique number in this array is 1.
Sample Input 2:
2
5
2 4 7 2 7
9
1 3 1 3 6 6 7 10 7
Sample Output 2:
4
Explanation: In the first test case, the array is [2, 4, 7, 2, 7]. Here, 
the numbers 2 and 7 are present twice, and the number 4 is present only once. So, the unique number in this array is 4.

10
Explanation: In the second test case, the array is [1, 3, 1, 3, 6, 6, 7, 10, 7]. Here, 
the numbers 1, 3, 6, and 7 are present twice, and the number 10 is present only once. So, the unique number in this array is 10.

*/

package arrays;

import java.util.Scanner;

public class FindUnique {

    // Function to find the unique element in the array
    public static int findUnique(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            int j;
            // Iterate through the array again to compare elements with each other
            for (j = 0; j < arr.length; j++) {
                // If i and j are different indices and arr[i] equals arr[j], break the loop
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        break;
                    }
                }
            }
            // If j equals the length of the array, it means no other element is equal to
            // arr[i], so return arr[i]
            if (j == arr.length) {
                return arr[i];
            }
        }
        // If no unique element is found, return the maximum integer value
        return Integer.MAX_VALUE;
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Take the number of test cases as input from the user

        // Process each test case
        while (t > 0) {
            int n = s.nextInt(); // Take the size of the array as input from the user
            int[] arr = new int[n]; // Declare an array to store the elements of the array

            // Take input for each element of the array from the user
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }

            // Find and print the unique element in the array
            System.out.println(findUnique(arr));

            t -= 1; // Decrement the number of test cases
        }
    }

}
