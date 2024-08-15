/* Problem statement
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. 
You need to print their intersection; An intersection for this problem can be defined when both 
the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in ascending order.


Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains an integer 'N' representing the size of the first array/list.

The second line contains 'N' single space separated integers representing the elements of the first the array/list.

The third line contains an integer 'M' representing the size of the second array/list.

The fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
For each test case, print the intersection elements in a row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= M <= 10^4

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
2 3 4
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 2 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, the intersection of the arrays also have two '2's. 
The first '2' of first array matches with the first '2' of the second array. 
Similarly, the second '2' of the first array matches with the second '2' if the second array.
*/


package time_complexity;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayIntersection {

    // Function to find the intersection of two sorted arrays
    public static void intersection(int[] arr1, int[] arr2) {

        // Sort both arrays to perform intersection efficiently
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length; // Length of the first array
        int m = arr2.length; // Length of the second array

        int i = 0; // Pointer to iterate over arr1
        int j = 0; // Pointer to iterate over arr2

        // Iterate through both arrays to find the intersection
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) { // If elements are equal, print the common element
                System.out.print(arr1[i] + " ");
                i += 1;
                j += 1;
            } else if (arr1[i] < arr2[j]) { // If the element in arr1 is less than the element in arr2, move to the next element in arr1
                i += 1;
            } else { // If the element in arr2 is less than the element in arr1, move to the next element in arr2
                j += 1;
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt(); // Input number of test cases
        while (t > 0) {
            int n = s.nextInt(); // Input size of the first array
            int[] arr1 = new int[n]; // Create an array of size n

            // Input elements of the first array
            for (int i = 0; i < n; i++) {
                arr1[i] = s.nextInt();
            }

            int m = s.nextInt(); // Input size of the second array
            int[] arr2 = new int[m]; // Create an array of size m

            // Input elements of the second array
            for (int i = 0; i < m; i++) {
                arr2[i] = s.nextInt();
            }

            // Find and print the intersection of the two arrays
            intersection(arr1, arr2);

            System.out.println(); // Output a new line for the next test case
            t -= 1; // Decrement the number of test cases
        }
        s.close(); // Close the scanner after all input is processed
    }
}
