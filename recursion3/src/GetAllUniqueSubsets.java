
/* Problem statement
You are given an sorted integer array of size 'n'.

Your task is to find and return all the unique subsets of the input array.

Subsets are arrays of length varying from 0 to 'n', that contain elements of the array. But the order of elements should remain the same as in the input array.

Note:
The order of subsets is not important. You can return the subsets in any order. However, in the output, you will see the subsets in lexicographically sorted order.

Constraints :
1 <= n <= 15
1 <= arr[i] <= 100

Time Limit: 1 sec
Example:
Input: 'n' = 3, 'arr' = [12, 15, 20]

Output: [[], [12], [12, 15], [12, 15, 20], [12, 20], [15], [15, 20], [20]]

Sample Explanation: Since there are no repeated numbers, a total of 8 subsets are generated.
Constraints :
1 <= n <= 15
1 <= arr[i] <= 100

Time Limit: 1 sec
Example:
Input: 'n' = 3, 'arr' = [12, 15, 20]

Output: [[], [12], [12, 15], [12, 15, 20], [12, 20], [15], [15, 20], [20]]

Sample Explanation: Since there are no repeated numbers, a total of 8 subsets are generated.
Input Format :
The first line will contain the value of ‘n’.

The second line will contain n integers, denoting the array 'arr' elements.
Output format :
Return all unique subsets in any order.
Note :
You don't need to print anything. It has already been taken care of. Just implement the given function.
Sample Input 1 :
3
12 15 20
Sample Output 1 :
[] (this represents an empty array)
12 
12 15 
12 15 20 
12 20 
15 
15 20 
20 
Explanation Of Sample Input 1 :
Since there are no repeated numbers, 8 subsets are generated.
Sample Input 2 :
3
1 1 2
Sample Output 2 :
[]    
1 
1 1 
1 1 2 
1 2 
2 
Explanation Of Sample Input 2 :
Since there are repeated numbers, the total number of unique subsets is 6.
Expected Time Complexity :
The expected time complexity is O(k * 2^n), where n is the size of the array and 'k' is the average size of a subset.
Expected Space Complexity :
The expected time complexity is O(k * 2^n), where n is the size of the array and 'k' is the average size of a subset. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetAllUniqueSubsets {

    // This method returns all unique subsets of the given input array
    public static ArrayList<ArrayList<Integer>> getSubsets(int[] input) {
        // Sort the input array (if it's not already sorted)
        Arrays.sort(input);

        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> currentSubset = new ArrayList<>();
        generateSubsets(input, 0, currentSubset, subsets);

        return subsets;
    }

    // This is a helper method to generate subsets
    private static void generateSubsets(int[] input, int index, ArrayList<Integer> currentSubset,
            ArrayList<ArrayList<Integer>> subsets) {
        // Add the current subset to the list of subsets
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < input.length; i++) {
            // Skip duplicates
            if (i > index && input[i] == input[i - 1]) {
                continue;
            }
            // Add the current element to the subset
            currentSubset.add(input[i]);

            // Recursively generate subsets starting from the next index
            generateSubsets(input, i + 1, currentSubset, subsets);

            // Remove the current element from the subset to backtrack
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // This method prints all unique subsets of the given input array
    public static void printSubsets(int[] input) {
        ArrayList<ArrayList<Integer>> subsets = getSubsets(input);

        // Print the subsets
        for (ArrayList<Integer> subset : subsets) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // This method takes input from the user and returns it as an array
    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt(); // Read the size of the array
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt(); // Read each element of the array
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput(); // Take array input from the user
        printSubsets(input); // Print all unique subsets of the input array
    }
}
