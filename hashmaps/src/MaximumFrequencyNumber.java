/*Problem statement
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.

If two or more elements are having the maximum frequency, return the element which occurs in the array first.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains most frequent element in the given array.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2
Sample Input 2 :
6
7 2 2 4 8 4
Sample Output 2 :
2
Explanation:
Here, both element '2' and element '4' have same frequency but '2' ocurr first in orignal array that's why we are returning '2' as output. */
/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * where n is size of input array
 */

import java.util.HashMap; // Import HashMap class from java.util package
import java.io.BufferedReader; // Import BufferedReader class from java.io package
import java.io.IOException; // Import IOException class from java.io package
import java.io.InputStreamReader; // Import InputStreamReader class from java.io package

public class MaximumFrequencyNumber {
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
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Method to find the number with the maximum frequency in the array
    public static int maxFrequencyNumber(int[] arr) {
        // Initialize a HashMap to store the frequency of each number
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // Iterate through the array and populate the HashMap
        for (int i : arr) {
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1); // Increment the frequency if the number is already present
            } else {
                hm.put(i, 1); // Initialize the frequency to 1 if the number is not present
            }
        }
        // Initialize variables to keep track of the maximum frequency and the
        // corresponding number
        int max = 0, ans = Integer.MIN_VALUE;
        // Iterate through the array again to find the number with the highest frequency
        for (int i : arr) {
            if (hm.get(i) > max) {
                max = hm.get(i); // Update the maximum frequency
                ans = i; // Update the number with the highest frequency
            }
        }
        return ans; // Return the number with the highest frequency
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput(); // Take input from the user
        System.out.println(maxFrequencyNumber(arr)); // Print the number with the highest frequency
    }
}
