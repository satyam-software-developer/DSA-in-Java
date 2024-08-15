
/* Problem statement
Given an array arr of N integers, we have to remove the elements from the array such that removal of each ith indexed element costs us the arr[i].

For removal of two elements from the array, we get to remove one element for free but the free element should be less than the two costing elements.

The task is to find the minimum cost to remove all the elements from the array.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains the integer N.
Each of the following N lines contains a single integer Ai, the array elements 
Constraints:
1 ≤ N ≤ 100000
1 ≤ Ai ≤ 100000
Time limit : 1 sec
Output Format:
The first and only line of output must contain the required minimal price .
Sample Input 1:
4
3
2
3
2 
Sample Output 1:
8
Sample Input 2:
6
6
4
5
5
5
5
Sample Output 2:
21
Explanation:
Clarification of the first example: First remove 3, 3 and 2 for free, cost=6. Now only 2 is left, so the total cost=3+3+2=8
Clarification of the second example: First remove 6,5 and get 5 to remove for free.Then remove 5,5 and get to remove 4 for free.So total cost=6+5+5+5=21. */
import java.util.Arrays; // Import the Arrays class for array manipulation
import java.util.Collections; // Import the Collections class for operations like sorting
import java.util.Scanner; // Import the Scanner class for taking user input

public class ArrayCost {

    // Method to read an array of integers from user input
    public static int[] getArray(Scanner s) {
        int n = s.nextInt(); // Read the size of the array
        int[] arr = new int[n]; // Initialize the array with the given size

        // Loop to fill the array with input values
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt(); // Read each integer and store it in the array
        }
        return arr; // Return the filled array
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for input
        int[] arr = getArray(s); // Call getArray to read the array from input

        // Convert the primitive int array to an Integer array for using with
        // Collections
        Integer[] objectArray = new Integer[arr.length];

        // Loop to copy elements from the int array to the Integer array
        for (int ctr = 0; ctr < arr.length; ctr++) {
            objectArray[ctr] = Integer.valueOf(arr[ctr]); // Convert int to Integer
        }

        // Sort the Integer array in descending order using reverseOrder
        Arrays.sort(objectArray, Collections.reverseOrder());

        int sol = 0; // Initialize the solution variable to store the final result

        // Loop to calculate the sum, skipping every third element
        for (int i = 0; i < objectArray.length; i++) {
            if (i % 3 == 2) { // If the index is a multiple of 3 (2nd, 5th, etc.), skip the element
                continue;
            }
            sol += objectArray[i]; // Add the element to the solution
        }

        // Print the final result
        System.out.println(sol);
    }
}
