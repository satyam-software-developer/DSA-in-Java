/*
Problem statement
You have been given a random integer array/list(ARR) and a number X. 
Find and return the number of triplets in the array/list which sum to X.

Note :
Given array/list can contain duplicate elements.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains an integer 'X'.
Output format :
For each test case, print the total number of triplets present in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 50
0 <= N <= 10^2
0 <= X <= 10^9
Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7 
12
Sample Output 1:
5
Sample Input 2:
2
7
1 2 3 4 5 6 7 
19
9
2 -5 8 -6 0 5 10 11 -3
10
Sample Output 2:
0
5


 Explanation for Input 2:
Since there doesn't exist any triplet with sum equal to 19 for the first query, we print 0.

For the second query, we have 5 triplets in total that sum up to 10. They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)

*/

package arrays;

import java.util.Scanner;

public class TripletSum {
    // Function to find the number of triplets whose sum is equal to x
    public static int findTriplet(int[] arr, int x) {
        int numTriplets = 0; // Initialize the count of triplets

        // Iterate through the array to find triplets
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // If the sum of elements at indices i, j, and k is equal to x, increment
                    // numTriplets
                    if (arr[i] + arr[j] + arr[k] == x) {
                        numTriplets += 1;
                    }
                }
            }
        }
        return numTriplets; // Return the total number of triplets whose sum is x
    }

    // Main function
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int t = sr.nextInt(); // Number of test cases

        // Process each test case
        while (t > 0) {
            int n = sr.nextInt(); // Size of the array for the current test case
            int[] arr = new int[n]; // Create an array to store input elements

            // Input elements into the array
            for (int i = 0; i < n; i++) {
                arr[i] = sr.nextInt();
            }

            int x = sr.nextInt(); // Target sum

            // Find and print the number of triplets whose sum is x
            System.out.println(findTriplet(arr, x));

            t -= 1; // Decrement the number of test cases
        }
    }
}
