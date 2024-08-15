/*Problem statement
Given two integer arrays. Check if second array is a subset of first array.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Integer N1 
Line 2 : N1 integers separated be a single space
Line 1 : Integer N2 
Line 2 : N2 integers separated be a single space
Output Format :
 Boolean
Constraints :
 0 <= N1 <= 10^4
 0 <= N2 <= 10^4
Sample Input :
15
3 6 5 8 15 1 14 18 7 9 14 9 3 12 8 
4
18 6 9 8
Sample Output :
true */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckSubset {

    // Method to check if arr2 is a subset of arr1
    public static boolean isSubset(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the map with counts of elements from arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check if all elements in arr2 are present in arr1 with sufficient counts
        for (int num : arr2) {
            if (!map.containsKey(num) || map.get(num) == 0) {
                return false; // Element is not present or not enough counts
            }
            map.put(num, map.get(num) - 1); // Decrement the count
        }

        return true; // All elements of arr2 are present in arr1 with sufficient counts
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Read the size of the first array
        int n1 = s.nextInt();
        int[] arr1 = new int[n1];

        // Read elements of the first array
        for (int i = 0; i < n1; i++) {
            arr1[i] = s.nextInt();
        }

        // Read the size of the second array
        int n2 = s.nextInt();
        int[] arr2 = new int[n2];

        // Read elements of the second array
        for (int i = 0; i < n2; i++) {
            arr2[i] = s.nextInt();
        }

        // Check if arr2 is a subset of arr1 and print the result
        System.out.println(isSubset(arr1, arr2));
    }
}
