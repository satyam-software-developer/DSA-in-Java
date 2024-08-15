
/* Problem statement
Given an array 'arr' of random integers and an integer 'k', return the kth largest element in the array.



Note: Try to do this in O(n*log k) time.


Example:
Input:
5
3 2 5 1 4
2
Output:
4
Explanation:
Array in non increasing form is [5,4,3,2,1]. So the 2nd largest is 4.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains an integer 'n', that denotes the size of the array.
The next line contains 'n' space separated integers, that denote the value of the elements of the array 'arr'.
The next line contains an integer, that denotes the value of 'k'.
Output Format :
The output contains the kth largest element.
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
9
Explanation of sample input 1:
arr = [9,4,8,7,11,3]
Array 'arr' in non increasing form is [11,9,8,7,4,3]. So the 2nd largest is 9.
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
10
Constraints :
1 <= n <= 10^5
1 <= arr[i] <= 10^5
1 <= k <= n
Time Limit: 1 sec */

/*
 * Time complexity: O(N * log(K))
 * Space complexity: O(K)
 * 
 * where N is the size of the input array
 * and K is the number of largest element that is to be found
 */

import java.util.PriorityQueue; // For using the priority queue (min-heap)
import java.io.IOException; // For handling IO exceptions
import java.util.Scanner; // For using Scanner to read input

public class KthLargestElement {

    // Method to find the kth largest element in the input array
    public static int kthLargest(int n, int[] input, int k) {
        // Create a min-priority queue with a size of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements to the min-heap
        for (int i = 0; i < k; i++) {
            minHeap.add(input[i]);
        }

        // Process the remaining elements in the input array
        for (int i = k; i < n; i++) {
            // If the current element is larger than the smallest element in the min-heap
            if (input[i] > minHeap.peek()) {
                minHeap.poll(); // Remove the smallest element from the min-heap
                minHeap.add(input[i]); // Add the current element to the min-heap
            }
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }

    static Scanner s = new Scanner(System.in); // Create a Scanner instance for reading input

    public static void main(String[] args) throws NumberFormatException, IOException {

        int n = s.nextInt(); // Read the size of the array
        int input[] = new int[n]; // Initialize the input array with the size n

        // Read the elements of the array
        for (int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }

        int k = s.nextInt(); // Read the value of k

        // Find the kth largest element and print it
        System.out.println(kthLargest(n, input, k));
    }
}
