/*
Problem statement
You have been given an integer array/list(ARR) of size N. 
It has been sorted(in increasing order) and then rotated by some number 'K' (K is greater than 0) in the right hand direction.

Your task is to write a function that returns the value of 'K', that means, the index from which the array/list has been rotated.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.
Output Format :
For each test case, print the value of 'K' or the index from which which the array/list has been rotated.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
2 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1:
1
6
5 6 1 2 3 4
Sample Output 1:
2
Sample Input 2:
2
5
3 6 8 9 10
4
10 20 30 1
Sample Output 2:
0
3

*/

package arrays;

import java.util.Scanner; // Import the Scanner class for user input

public class CheckArrayRotation { // Define a class named CheckArrayRotation

    // Function to check if the array is rotated and find the rotation count
    public static int arrayRotateCheck(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // Iterate through the array till the second last element
            if (arr[i] > arr[i + 1]) { // If the current element is greater than the next element
                return (i + 1); // Return the index of the next element, indicating the rotation count
            }
        }
        return 0; // If no rotation is found, return 0
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input
        int t = s.nextInt(); // Read the number of test cases from the user
        while (t > 0) { // Loop through each test case
            int n = s.nextInt(); // Read the size of the array from the user
            int arr[] = new int[n]; // Declare an array to store the elements
            for (int i = 0; i < n; i++) { // Loop to read elements of the array
                arr[i] = s.nextInt(); // Read an element from the user and store it in the array
            }
            int ans = arrayRotateCheck(arr); // Call the arrayRotateCheck function to find the rotation count
            System.out.println(ans); // Print the rotation count
            t = t - 1; // Decrement the number of test cases
        }
    }
}
