
/*Problem statement
You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.

You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.

Note:
1. Best solution takes O(n) time.
2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence is earlier in the array.
Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
Output format:
The first and only line of output contains starting and ending element of the longest consecutive sequence. If the length of  the longest consecutive sequence is 1, then just print the starting element.
Constraints :
0 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
Sample Output 1 :
8 12 
Explanation:The longest consecutive sequence here is [8, 9, 10, 11, 12]. So the output is the start and end of this sequence: [8, 12].
Sample Input 2 :
7
3 7 2 1 9 8 41
Sample Output 2 :
7 9
Explanation:There are two sequences of equal length here: [1,2,3] and [7,8,9]. But since [7,8,9] appears first in the array (7 comes before 1), we return this sequence. So the output is [7,9].
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 16
Explanation:The longest consecutive sequence here is [15,16]. So the output is [15,16]. */

import java.util.Map; // Import the Map interface
import java.util.HashMap; // Import the HashMap class
import java.util.ArrayList; // Import the ArrayList class
import java.io.BufferedReader; // Import the BufferedReader class for reading input
import java.io.IOException; // Import the IOException class for handling IO exceptions
import java.io.InputStreamReader; // Import the InputStreamReader class for reading input stream

public class LongestConsecutiveSequence {

    // Create a BufferedReader object to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input from the user
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim()); // Read and parse the size of the array
        int[] input = new int[size]; // Initialize the array with the given size

        // If the size is zero, return the empty array
        if (size == 0) {
            return input;
        }

        // Read the input line, split it by spaces, and store it in an array
        String[] strNums = br.readLine().split("\\s");

        // Parse each element of the string array to an integer and store it in the
        // input array
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input; // Return the input array
    }

    // Method to print an ArrayList of integers
    public static void printArray(ArrayList<Integer> arr) {
        // Iterate through the ArrayList and print each element
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println(); // Print a newline at the end
    }

    // Method to find the longest consecutive increasing sequence in the input array
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        // HashMap to keep track of visited elements
        Map<Integer, Boolean> vis = new HashMap<>();
        // HashMap to keep track of the indices of elements
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the maps with the elements of the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            map.put(num, i); // Store the index of the current element
            // Initialize the visited map for the current element if not already present
            if (!vis.containsKey(num)) {
                vis.put(num, false);
            }
        }

        // List to store the result
        ArrayList<Integer> ls = new ArrayList<>();

        // Variables to keep track of the longest sequence
        int globalMaxSequenceLength = 1;
        int globalMinStartIndex = 0;

        // Iterate through the array to find the longest consecutive sequence
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int currentMinStartIndex = i; // Initialize the current minimum start index
            int count = 0;
            int tempNum = num;

            // Forward traversal to find the length of the sequence
            while (vis.containsKey(tempNum) && !vis.get(tempNum)) {
                vis.put(tempNum, true); // Mark visited elements as true
                count++;
                tempNum++;
            }

            // Backward traversal to find the length of the sequence
            tempNum = num - 1;
            while (vis.containsKey(tempNum) && !vis.get(tempNum)) {
                vis.put(tempNum, true); // Mark visited elements as true
                count++;
                currentMinStartIndex = map.get(tempNum); // Update the current minimum start index
                tempNum--;
            }

            // Update the global maximum sequence length and start index if a longer
            // sequence is found
            if (count > globalMaxSequenceLength) {
                globalMaxSequenceLength = count;
                globalMinStartIndex = currentMinStartIndex;
            } else if (count == globalMaxSequenceLength) {
                // Update the start index if the current sequence is equal in length but has a
                // smaller start index
                if (currentMinStartIndex < globalMinStartIndex) {
                    globalMinStartIndex = currentMinStartIndex;
                }
            }
        }

        int globalStartNum = arr[globalMinStartIndex]; // Get the starting number of the longest sequence
        ls.add(globalStartNum); // Add the starting number to the result list

        // If the sequence length is greater than 1, add the end number of the sequence
        if (globalMaxSequenceLength > 1) {
            ls.add(globalStartNum + globalMaxSequenceLength - 1);
        }

        return ls; // Return the result list containing the longest consecutive increasing sequence
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput(); // Take input from the user
        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(arr); // Find the longest consecutive increasing
                                                                            // sequence
        printArray(ans); // Print the result
    }
}
