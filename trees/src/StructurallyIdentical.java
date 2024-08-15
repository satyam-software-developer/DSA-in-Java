
/* Problem statement
Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Tree 1 elements in level order form separated by space (as per done in class) in the following order:
root_data, n (number of children of root), n children, and so on for every element.
Line 2 : Tree 2 elements in level order form separated by space (as per done in class). Order is - `
root_data, n (number of children of root), n children, and so on for every element.
Output format :
true or false
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Explanation
If we draw the tree for the above inputs, both the trees will look like this. So the answer for this is true.


Sample Input 2 :
10 3 20 30 40 2 40 50 0 0 0 0 
10 3 2 30 40 2 40 50 0 0 0 0
Sample Output 2:
false */

import java.util.ArrayList;
import java.util.Scanner;

// Define custom exception for queue operations
class QueueEmptyException extends Exception {
    // Custom exception to be thrown when queue operations are invalid due to an
    // empty queue
}

// Queue implementation using linked list
class QueueUsingLL<T> {

    // Node class to represent each element in the linked list
    class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Reference to the next node

        Node(T data) {
            this.data = data;
            this.next = null; // Initial next is null
        }
    }

    private Node<T> head; // Reference to the front of the queue
    private Node<T> tail; // Reference to the rear of the queue
    private int size; // Size of the queue

    public QueueUsingLL() {
        this.head = null; // Queue starts empty
        this.tail = null;
        this.size = 0; // Initial size is 0
    }

    // Returns the number of elements in the queue
    public int size() {
        return size;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the front element of the queue
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException(); // Throw exception if queue is empty
        }
        return head.data;
    }

    // Adds an element to the end of the queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element); // Create a new node with the element
        if (head == null) { // If queue is empty
            head = newNode; // Both head and tail will point to the new node
            tail = newNode;
        } else {
            tail.next = newNode; // Link the new node to the end of the queue
            tail = newNode; // Update the tail to the new node
        }
        size++; // Increment the size of the queue
    }

    // Removes and returns the front element of the queue
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException(); // Throw exception if queue is empty
        }
        T data = head.data; // Retrieve the data from the front node
        head = head.next; // Move head to the next node
        if (head == null) {
            tail = null; // If queue is now empty, update tail to null
        }
        size--; // Decrement the size of the queue
        return data; // Return the removed data
    }
}

// TreeNode class representing a node in the generic tree
class TreeNode<T> {
    T data; // Data stored in the node
    ArrayList<TreeNode<T>> children; // List of children nodes

    TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>(); // Initialize the children list
    }
}

// Main class
public class StructurallyIdentical {

    // Function to check if two trees are structurally identical
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true; // Both trees are empty
        }
        if (root1 == null || root2 == null) {
            return false; // One tree is empty while the other is not
        }
        if (!root1.data.equals(root2.data)) {
            return false; // Data at the current nodes do not match
        }
        if (root1.children.size() != root2.children.size()) {
            return false; // Number of children does not match
        }
        // Recursively check each pair of children
        for (int i = 0; i < root1.children.size(); i++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(i))) {
                return false; // Trees are not identical if any child pair does not match
            }
        }
        return true; // Trees are identical if all checks pass
    }

    // Function to take tree input level-wise and construct the tree
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in); // Scanner for reading input
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); // Queue to manage nodes
        int rootData = s.nextInt(); // Read root data
        TreeNode<Integer> root = new TreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root); // Enqueue the root node

        // Process nodes level-wise
        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the next node to process
                int numChild = s.nextInt(); // Read the number of children
                for (int i = 0; i < numChild; i++) {
                    int childData = s.nextInt(); // Read child data
                    TreeNode<Integer> childNode = new TreeNode<>(childData); // Create a child node
                    pendingNodes.enqueue(childNode); // Enqueue the child node
                    currentNode.children.add(childNode); // Add the child node to the current node's children
                }
            } catch (QueueEmptyException e) {
                e.printStackTrace(); // Print stack trace if an unexpected queue error occurs
            }
        }
        return root; // Return the constructed tree
    }

    // Main function to execute the program
    public static void main(String[] args) {
        TreeNode<Integer> root1 = takeInputLevelWise(); // Construct the first tree
        TreeNode<Integer> root2 = takeInputLevelWise(); // Construct the second tree
        System.out.println(checkIdentical(root1, root2)); // Check if the trees are identical and print result
    }
}
