
/* Problem statement
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(nlogk) and space complexity should be not more than O(k).

Order of elements in the output is not important.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : Size of array (n)
Line 2 : Array elements (separated by space)
Line 3 : Integer k
Output Format :
k largest elements
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output :
12
16
20
25 */
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElement {

    // Method to find the k largest elements in the input array
    public static ArrayList<Integer> kLargest(int input[], int k) {
        // Priority queue to store the k largest elements, it acts as a min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Add the first k elements of the input array to the priority queue
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        // Process the remaining elements of the input array
        for (int i = k; i < input.length; i++) {
            // If the current element is greater than the smallest element in the priority
            // queue
            if (input[i] > pq.peek()) {
                pq.poll(); // Remove the smallest element
                pq.add(input[i]); // Add the current element
            }
        }

        // Create an ArrayList to store the k largest elements
        ArrayList<Integer> output = new ArrayList<Integer>();

        // Remove elements from the priority queue and add them to the output list
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }

        // Return the list of k largest elements
        return output;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Read the size of the input array
        int n = s.nextInt();

        // Initialize the input array
        int input[] = new int[n];

        // Read the elements of the input array
        for (int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }

        // Read the value of k
        int k = s.nextInt();

        // Find the k largest elements in the input array
        ArrayList<Integer> output = kLargest(input, k);

        // Print the k largest elements
        for (int i : output) {
            System.out.println(i);
        }
    }
}
