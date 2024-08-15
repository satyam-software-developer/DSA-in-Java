/*
Problem statement
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. 
You need to print their intersection; An intersection for this problem can be defined 
when both the arrays/lists contain a particular value or to put it in other words, 
when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the first array/list(ARR1)

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements of the first the array/list.

Third line contains an integer 'M' representing the size of the second array/list.

Fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
For each test case, print the intersection elements in a row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1 sec 
Sample Input 1 :
2
6
2 6 8 5 4 3
4
2 3 4 7 
2
10 10
1
10
Sample Output 1 :
2 4 3
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
2 1 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, 
the intersection of the arrays also have two '2's. 
The first '2' of first array matches with the first '2' of the second array. 
Similarly, the second '2' of the first array matches with the second '2' if the second array.

*/

package arrays;

import java.util.Scanner;

public class IntersectionOfTwoArrays {

    // Function to find and print the intersection of two arrays
    public static void intersections(int arr1[], int arr2[]) {
        // Iterate through the elements of the first array
        for (int i = 0; i < arr1.length; i++) {
            // Iterate through the elements of the second array
            for (int j = 0; j < arr2.length; j++) {
                // If the current element of the first array is equal to the current element of
                // the second array
                if (arr1[i] == arr2[j]) {
                    // Print the common element
                    System.out.print(arr1[i] + " ");
                    // Mark the element in the second array as visited by assigning it to
                    // Integer.MIN_VALUE
                    arr2[j] = Integer.MIN_VALUE;
                    // Break out of the inner loop as the element is found
                    break;
                }
            }
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Take the number of test cases as input from the user

        // Process each test case
        while (t > 0) {
            int n = s.nextInt(); // Take the size of the first array as input from the user
            int[] arr1 = new int[n]; // Declare an array to store the elements of the first array

            // Take input for each element of the first array from the user
            for (int i = 0; i < n; i++) {
                arr1[i] = s.nextInt();
            }

            int m = s.nextInt(); // Take the size of the second array as input from the user
            int[] arr2 = new int[m]; // Declare an array to store the elements of the second array

            // Take input for each element of the second array from the user
            for (int i = 0; i < m; i++) {
                arr2[i] = s.nextInt();
            }

            // Find and print the intersection of the two arrays
            intersections(arr1, arr2);
            System.out.println(); // Print a newline after printing the intersection
            t -= 1; // Decrement the number of test cases
        }
    }

}
