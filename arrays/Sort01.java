/*
Problem statement
You have been given an integer array/list(ARR) of size N that contains only integers, 0 and 1. 
Write a function to sort this array/list. Think of a solution which scans the array/list only once and don't require use of an extra array/list.

Note:
You need to change in the given array/list itself. Hence, no need to return or print anything. 
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers(all 0s and 1s) representing the elements in the array/list.
Output format :
For each test case, print the sorted array/list elements in a row separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1:
1
7
0 1 1 0 1 0 1
Sample Output 1:
0 0 0 1 1 1 1
Sample Input 2:
2
8
1 0 1 1 0 1 0 1
5
0 1 0 1 0
Sample Output 2:
0 0 0 1 1 1 1 1
0 0 0 1 1 

*/



package arrays;

import java.util.Scanner;

public class Sort01 {
    // Function to sort an array of 0s and 1s
    public static void sortZeroesAndOne(int[] arr) {
        int nextZero = 0; // Initialize the index where the next 0 should be placed

        // Iterate through the array elements
        for (int i = 0; i < arr.length; i++) {
            // If the current element is 0, swap it with the element at nextZero index
            if (arr[i] == 0) {
                int temp = arr[nextZero]; // Store the value at nextZero index
                arr[nextZero] = arr[i]; // Place the 0 at nextZero index
                arr[i] = temp; // Place the stored value (1) at the current index
                nextZero += 1; // Move nextZero index forward
            }
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

            // Sort the array of 0s and 1s
            sortZeroesAndOne(arr);

            // Print the sorted array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Print a newline after printing the array

            t -= 1; // Decrement the number of test cases
        }
    }
}

