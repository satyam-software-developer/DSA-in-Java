
/*Problem statement
Implement the class for Max Priority Queue which includes following functions -

1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.

2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.

3. insert -
Given an element, insert that element in the priority queue at the correct position.

4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.

5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.

Note : main function is given for your reference which we are using internally to test the class.*/

/*
 * Time complexity: O(log(N)) [for insert and removeMax functions]
 * O(1) [for all other functions]
 * 
 * Space complexity: O(1) [for all functions]
 * 
 * where N is the size of the Priority Queue
 * 
 */

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class MaxPriorityQueue {
    private ArrayList<Integer> heap; // ArrayList to store the elements of the max priority queue

    // Constructor to initialize the heap
    public MaxPriorityQueue() {
        heap = new ArrayList<Integer>();
    }

    // Check if the priority queue is empty
    boolean isEmpty() {
        return heap.size() == 0;
    }

    // Get the size of the priority queue
    int getSize() {
        return heap.size();
    }

    // Get the maximum element from the priority queue
    int getMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // Return Integer.MIN_VALUE if the heap is empty
        }
        return heap.get(0); // The root of the heap is the maximum element
    }

    // Insert a new element into the priority queue
    void insert(int element) {
        heap.add(element); // Add the element to the end of the heap
        int childIndex = heap.size() - 1; // Index of the newly added element
        int parentIndex = (childIndex - 1) / 2; // Index of the parent element

        // Percolate up: Swap the child and parent if the child is larger than the
        // parent
        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                // Swap the child and parent
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                // Update childIndex and parentIndex to continue percolating up
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return; // Stop if the heap property is satisfied
            }
        }
    }

    // Remove and return the maximum element from the priority queue
    int removeMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // Return Integer.MIN_VALUE if the heap is empty
        }
        int ans = heap.get(0); // Store the maximum element to return later

        // Move the last element to the root and remove the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Heapify down: Restore the heap property by moving the root element down
        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        // While there are children to consider
        while (leftChildIndex < heap.size()) {
            // Find the larger of the two children
            if (heap.get(leftChildIndex) > heap.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex == index) {
                break; // Stop if the heap property is satisfied
            } else {
                // Swap the current element with the larger child
                int temp = heap.get(index);
                heap.set(index, heap.get(maxIndex));
                heap.set(maxIndex, temp);

                // Update index and child indices to continue heapifying down
                index = maxIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }
        return ans; // Return the removed maximum element
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        MaxPriorityQueue pq = new MaxPriorityQueue(); // Create a new MaxPriorityQueue instance
        Scanner sc = new Scanner(System.in); // Scanner for input
        int choice = sc.nextInt(); // Read the first choice

        while (choice != -1) {
            switch (choice) {
                case 1: // Insert
                    int element = sc.nextInt();
                    pq.insert(element);
                    break;
                case 2: // Get maximum element
                    System.out.println(pq.getMax());
                    break;
                case 3: // Remove maximum element
                    System.out.println(pq.removeMax());
                    break;
                case 4: // Get size
                    System.out.println(pq.getSize());
                    break;
                case 5: // Check if empty
                    System.out.println(pq.isEmpty());
                    break;
                default:
                    return; // Exit if an invalid choice is entered
            }
            choice = sc.nextInt(); // Read the next choice
        }
        sc.close(); // Close the scanner
    }
}
