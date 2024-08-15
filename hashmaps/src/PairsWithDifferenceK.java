
/*Problem statement
You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.

Note: Take absolute difference between the elements of the array.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of K.
Output format :
The first and only line of output contains count of all such pairs which have an absolute difference of K. 
Constraints :
0 <= n <= 10^4
Time Limit: 1 sec
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2
Explanation
(5,2) and (1,4) are the possible combinations as their absolute difference is 3.
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6 */

/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the size of the input array
 */

import java.util.HashMap; // Import HashMap class
import java.io.BufferedReader; // Import BufferedReader class for reading input
import java.io.IOException; // Import IOException class for handling IO exceptions
import java.io.InputStreamReader; // Import InputStreamReader class for reading input stream
import java.util.StringTokenizer; // Import StringTokenizer class for parsing input

public class PairsWithDifferenceK {
    // Create a BufferedReader object to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Method to count pairs with a given difference k
    public static int getPairsWithDifferenceK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // HashMap to store element frequencies
        int pairCount = 0; // Initialize pair count to 0

        // Iterate through the array
        for (int i : arr) {
            int p1 = i + k; // Calculate the first possible pair value
            boolean flag = false;
            if (i == p1) {
                flag = true; // Set flag if the element itself forms the pair
            }
            if (map.containsKey(p1)) {
                pairCount += map.get(p1); // Add the frequency of p1 to pair count
            }
            int p2 = i - k; // Calculate the second possible pair value
            if (map.containsKey(p2) && !flag) {
                pairCount += map.get(p2); // Add the frequency of p2 to pair count if flag is not set
            }
            // Update the frequency of the current element in the HashMap
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1); // Increment the frequency
            } else {
                map.put(i, 1); // Initialize the frequency to 1
            }
        }
        return pairCount; // Return the total pair count
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine()); // Read the first line of input
        int n = Integer.parseInt(st.nextToken()); // Parse the number of elements in the array
        int arr[] = new int[n]; // Initialize the array with the given size

        st = new StringTokenizer(br.readLine()); // Read the second line of input
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // Parse each element and store it in the array
        }

        int k = Integer.parseInt(br.readLine()); // Parse the value of k
        System.out.println(getPairsWithDifferenceK(arr, k)); // Print the number of pairs with difference k
    }
}
