/* 
Problem statement
You have been given an array/list 'ARR' of integers. 
Your task is to find the second largest element present in the 'ARR'.

Note:
a) Duplicate elements may be present.

b) If no such element is present return -1.
Example:
Input: Given a sequence of five numbers 2, 4, 5, 6, 8.

Output:  6

Explanation:
In the given sequence of numbers, number 8 is the largest element, 
followed by number 6 which is the second-largest element. 
Hence we return number 6 which is the second-largest element in the sequence.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100
1 <= N <= 5000
-10 ^ 9 <= 'SIZE' <= 10 ^ 9 

Where ‘T’ is the total number of test cases, ‘N’ denotes the number of elements in the array and ‘SIZE’ denotes the range of the elements in the array.

Time limit: 1 sec.
Sample Input 1:
2
6
12 1 35 10 34 1
5
10 10 10 10 10
Sample Output 1:
34
-1
Explanation of sample input 1:
Test case 1: In the given sequence of numbers, number 35 is the largest element, followed by number 34 which is the second-largest element. 
Hence we return number 34 which is the second-largest element in the sequence.

Test case 2: In the given sequence of numbers, number 10 is the largest element. 
However, since all the elements are the same, the second largest element does not exist. So, we return -1.
Sample Input 2:
1
6
7 8 8 1 4 3 
Sample Output 2:
7
Explanation of sample input 2:
In the given sequence of numbers, 8 exists two times and is the largest element, followed by 7 which is the second-largest element. 
Hence we return the number 7 as the second-largest element.

*/

package arrays;

import java.util.Scanner; // Import the Scanner class for user input

public class SecondLargestInArray { // Define a class named SecondLargestInArray

    // Function to find the second largest element in the array
    public static int secondLargestElement(int[] arr, int n) {
        // Initialize variables to store the largest and second largest elements
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Iterate through the array to find the largest and second largest elements
        for (int i = 0; i < n; i++) {
            // Update largest and secondLargest accordingly
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        // If no second largest element is found, return -1
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        // Otherwise, return the second largest element
        return secondLargest;
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for user input
        int n = s.nextInt(); // Read the size of the array from the user
        int arr[] = new int[n]; // Declare an array to store the elements

        // Read elements of the array from the user
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt(); // Read an element from the user and store it in the array
        }

        int ans = secondLargestElement(arr, n); // Call the secondLargestElement function to get the second largest
                                                // element
        System.out.println(ans); // Print the second largest element
    }

}
