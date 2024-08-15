
/*Problem statement
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(n * logk) and space complexity should not be more than O(k).

Note: Order of elements in the output is not important.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of k.
Output Format :
The first and only line of output print k smallest elements. The elements in the output are separated by a single space. 
Constraints:
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output 1 :
1 2 3 5 
 */

/*
 * Time complexity: O(N * log(K))
 * Space complexity: O(K)
 * 
 * where N is the size of the input array
 * and K is the number of smallest elements that are to be found 
 */

import java.util.ArrayList; // For using ArrayList to store the k smallest elements
import java.util.Collections; // For using the Collections utility class
import java.util.PriorityQueue; // For using the priority queue (max-heap)
import java.io.IOException; // For handling IO exceptions
import java.util.Scanner; // For using Scanner to read input

public class KSmallestElements {

    // Method to find the k smallest elements in the input array
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        // Create a max-priority queue to keep track of the k smallest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add the first k elements of the input array to the priority queue
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        // Process the remaining elements of the input array
        for (int i = k; i < n; i++) {
            // If the current element is smaller than the largest element in the priority
            // queue
            if (input[i] < pq.peek()) {
                pq.poll(); // Remove the largest element from the priority queue
                pq.add(input[i]); // Add the current element to the priority queue
            }
        }

        // Create an ArrayList to store the k smallest elements
        ArrayList<Integer> output = new ArrayList<>();

        // Remove elements from the priority queue and add them to the output list
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }

        // Return the list of k smallest elements
        return output;
    }

    static Scanner sc = new Scanner(System.in); // Create a Scanner instance for reading input

    public static void main(String[] args) throws NumberFormatException, IOException {

        // Read the size of the input array
        int n = sc.nextInt();
        int input[] = new int[n]; // Initialize the input array with the size n

        // Read the elements of the input array
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        // Read the value of k
        int k = sc.nextInt();

        // Find the k smallest elements in the input array
        ArrayList<Integer> output = kSmallest(n, input, k);

        // Sort the output list to ensure the elements are in ascending order
        Collections.sort(output);

        // Print the k smallest elements separated by spaces
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
