/*Problem statement
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.

Note:
Array A can contain duplicate elements as well.
Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0. 
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
Explanation
(2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2. */

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * where n is the size of input array
 */

import java.util.HashMap; // Import HashMap class from java.util package
import java.io.BufferedReader; // Import BufferedReader class for reading input
import java.io.IOException; // Import IOException class for handling input-output exceptions
import java.io.InputStreamReader; // Import InputStreamReader class for reading input from console

public class PairSumToZero {

    // Initialize BufferedReader to take input from the standard input (console)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input from the user
    public static int[] takeInput() throws IOException {
        // Read the first line which contains the size of the array
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size]; // Initialize an array of the given size

        // If size is 0, return the empty array
        if (size == 0) {
            return input;
        }

        // Read the next line containing the elements of the array
        String[] strNums;
        strNums = br.readLine().split("\\s");

        // Convert the input string array to integer array
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input; // Return the integer array
    }

    // Method to print the elements of the array
    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " "); // Print each element followed by a space
        }
        System.out.println(); // Print a newline at the end
    }

    // Method to find pairs of elements that sum to zero
    public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>(); // Initialize a HashMap to store the frequency of
                                                                       // each number
        int finalCount = 0; // Variable to store the final count of pairs that sum to zero

        // Populate the HashMap with the frequency of each number
        for (int i = 0; i < size; i++) {
            int key = input[i];
            if (h.containsKey(key)) {
                int value = h.get(key);
                h.put(key, value + 1); // Increment frequency value by 1 if key is already present in HashMap
            } else {
                h.put(key, 1); // Initialize frequency value to 1 if key is not already present in HashMap
            }
        }

        // Traverse the array and check if the negative of each key is present in the
        // HashMap
        for (int i = 0; i < size; i++) {
            int key = input[i];

            if (h.containsKey(-key) && h.get(key) != 0) {
                int times;

                if (key == (-key)) { // True in case of zero
                    int occurrences = h.get(key);
                    times = (occurrences * (occurrences - 1)) / 2; // Calculate pairs for zeros
                    finalCount = finalCount + times;
                    h.put(key, 0); // Set frequency to 0 to avoid counting again
                    continue;
                }

                times = h.get(key) * h.get(-key); // Calculate pairs for key and -key
                finalCount = finalCount + times;
                h.put(key, 0); // Set frequency to 0 to avoid counting again
                h.put(-key, 0); // Set frequency to 0 to avoid counting again
            }
        }

        return finalCount; // Return the final count of pairs that sum to zero
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput(); // Take input from the user
        System.out.print(PairSum(arr, arr.length)); // Print the count of pairs that sum to zero
    }
}
