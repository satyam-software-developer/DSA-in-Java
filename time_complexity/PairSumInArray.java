/* Problem statement
You have been given an integer array/list(ARR) and a number 'num'. 
Find and return the total number of pairs in the array/list which sum to 'num'.

Note:
Given array/list can contain duplicate elements. 
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains an integer 'num'.
Output format :
For each test case, print the total number of pairs present in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= num <= 10^9

Time Limit: 1 sec
Sample Input 1:
1
9
1 3 6 2 5 4 3 2 4
7
Sample Output 1:
7
Sample Input 2:
2
9
1 3 6 2 5 4 3 2 4
12
6
2 8 10 5 -2 5
10
Sample Output 2:
0
2


 Explanation for Input 2:
Since there doesn't exist any pair with sum equal to 12 for the first query, we print 0.

For the second query, we have 2 pairs in total that sum up to 10. They are, (2, 8) and (5, 5).
*/



/*
 *   Time Complexity : O(n * log(n))
 *   Space Complexity : O(1)
 *   Where 'n' is the size of the Array/List
 * 
 */

package time_complexity;

import java.util.Arrays;
import java.util.Scanner;

public class PairSumInArray {

    // Function to find the number of pairs in the array with the given sum
    public static int pairSum(int[] arr, int num) {
        // Sort the array in non-decreasing order
        Arrays.sort(arr);

        // Initialize pointers for the start and end of the array
        int startIndex = 0;
        int endIndex = arr.length - 1;

        // Initialize the count of pairs
        int numPair = 0;

        // Loop until the start index is less than the end index
        while (startIndex < endIndex) {
            // If the sum of elements at the start and end indices is less than the target number
            if (arr[startIndex] + arr[endIndex] < num) {
                startIndex++;
            } 
            // If the sum of elements at the start and end indices is greater than the target number
            else if (arr[startIndex] + arr[endIndex] > num) {
                endIndex--;
            } 
            // If the sum of elements at the start and end indices is equal to the target number
            else {
                int elementAtStart = arr[startIndex];
                int elementAtEnd = arr[endIndex];

                // If both elements are equal
                if (elementAtStart == elementAtEnd) {
                    // Calculate the total number of occurrences of the element in the array
                    int totalElementsFromStartToEnd = (endIndex - startIndex) + 1;
                    // Calculate the number of pairs formed by these occurrences
                    numPair += (totalElementsFromStartToEnd * (totalElementsFromStartToEnd - 1) / 2);
                    return numPair;
                }

                // Move the start index to the next distinct element
                int tempStartIndex = startIndex + 1;
                while (tempStartIndex <= endIndex && arr[tempStartIndex] == elementAtStart) {
                    tempStartIndex += 1;
                }

                // Move the end index to the previous distinct element
                int tempEndIndex = endIndex - 1;
                while (tempEndIndex >= tempStartIndex && arr[tempEndIndex] == elementAtEnd) {
                    tempEndIndex -= 1;
                }

                // Calculate the number of elements from the start and end indices
                int totalElementsFromStart = (tempStartIndex - startIndex);
                int totalElementsFromEnd = (endIndex - tempEndIndex);

                // Update the count of pairs
                numPair += (totalElementsFromStart * totalElementsFromEnd);

                // Update the start and end indices
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return numPair;
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt(); // Input number of test cases

        // Iterate over each test case
        while (t > 0) {
            int n = s.nextInt(); // Input size of the array
            int arr[] = new int[n]; // Create an array of size 'n'

            // Input the elements of the array
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt(); // Input elements of the array
            }

            int x = s.nextInt(); // Input the target sum 'x'

            // Output the number of pairs with the given sum
            System.out.println(pairSum(arr, x));

            t -= 1; // Decrement the number of test cases
        }
        s.close(); // Close the scanner
    }
}
