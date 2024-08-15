
/*Problem statement
Implement the function RemoveMin for the min priority queue class.

For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.

Note : main function is given for your reference which we are using internally to test the code. */

/*
 * Time complexity: O(log(N))
 * Space complexity: O(1)
 * 
 * where N is the size of the Priority Queue
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class RemoveMin {

    private ArrayList<Integer> heap; // ArrayList to store the heap elements

    // Constructor to initialize the heap
    public RemoveMin() {
        heap = new ArrayList<>();
    }

    // Method to check if the heap is empty
    boolean isEmpty() {
        return heap.size() == 0;
    }

    // Method to get the size of the heap
    int size() {
        return heap.size();
    }

    // Method to get the minimum element (root) of the heap
    // Throws an exception if the heap is empty
    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    // Method to insert an element into the heap
    void insert(int element) {
        heap.add(element); // Add the element to the end of the heap
        int childIndex = heap.size() - 1; // Get the index of the newly added element
        int parentIndex = (childIndex - 1) / 2; // Get the index of its parent

        // Percolate up: Swap the child and parent if the child is smaller than the
        // parent
        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex; // Update childIndex to the parent index
                parentIndex = (childIndex - 1) / 2; // Update parentIndex to the new parent
            } else {
                return; // Stop if the heap property is satisfied
            }
        }
    }

    // Method to remove and return the minimum element (root) of the heap
    // Throws an exception if the heap is empty
    int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        int ans = heap.get(0); // Store the minimum element to return later
        heap.set(0, heap.get(heap.size() - 1)); // Move the last element to the root
        heap.remove(heap.size() - 1); // Remove the last element

        // Heapify down: Restore the heap property by moving the root element down
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heap.size()) {
            if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex; // Update minIndex to left child if smaller
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex; // Update minIndex to right child if smaller
            }
            if (minIndex == index) {
                break; // Stop if the heap property is satisfied
            } else {
                int temp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);
                index = minIndex; // Update index to minIndex
                leftChildIndex = 2 * index + 1; // Update left child index
                rightChildIndex = 2 * index + 2; // Update right child index
            }
        }
        return ans; // Return the removed minimum element
    }

    // Main method to test the priority queue
    public static void main(String[] args) throws NumberFormatException, IOException {
        RemoveMin pq = new RemoveMin(); // Create a new RemoveMin instance
        Scanner sc = new Scanner(System.in); // Scanner for input
        int choice = sc.nextInt(); // Read the first choice

        while (choice != -1) {
            switch (choice) {
                case 1: // Insert
                    int element = sc.nextInt();
                    pq.insert(element);
                    break;
                case 2: // Get minimum element
                    try {
                        System.out.println(pq.getMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                    }
                    break;
                case 3: // Remove minimum element
                    try {
                        System.out.println(pq.removeMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                    }
                    break;
                case 4: // Get size
                    System.out.println(pq.size());
                    break;
                case 5: // Check if empty
                    System.out.println(pq.isEmpty());
                    break;
                default:
                    return;
            }
            choice = sc.nextInt(); // Read the next choice
        }
        sc.close(); // Close the scanner
    }
}

// Custom exception for priority queue operations
class PriorityQueueException extends Exception {

}
