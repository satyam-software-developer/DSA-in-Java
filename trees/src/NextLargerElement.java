
/* Problem statement
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.

Return NULL if no node is present with value greater than n.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Integer n
Line 2 : Elements in level order form separated by space (as per done in class) in the given below order
node_data, n(number of children of node), n children, and so on for every element 
Output format :
Node with value just greater than n.
Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0 
Representation of Input

Sample Output 1 :
20
Explanation
In the given tree, the value which is just greater than 18 is 20.
Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
30 */

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
    static class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Pointer to the next node

        Node(T data) {
            this.data = data;
            this.next = null; // Initial next is null
        }
    }

    private Node<T> head; // Pointer to the front of the queue
    private Node<T> tail; // Pointer to the rear of the queue
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
public class NextLargerElement {

    // Function to find the node with the value just greater than n
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> nextLargerNode = null;
        // Check if the current node's data is greater than n
        if (root.data > n) {
            nextLargerNode = root;
        }
        // Recursively check all children
        for (TreeNode<Integer> child : root.children) {
            TreeNode<Integer> nextLargerInChild = findNextLargerNode(child, n);
            // Update the nextLargerNode if a better option is found
            if (nextLargerInChild != null) {
                if (nextLargerNode == null || nextLargerNode.data > nextLargerInChild.data) {
                    nextLargerNode = nextLargerInChild;
                }
            }
        }
        return nextLargerNode;
    }

    // Function to take tree input level-wise and construct the tree
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Read the integer n
        TreeNode<Integer> root = takeInputLevelWise(); // Construct the tree

        TreeNode<Integer> ans = findNextLargerNode(root, n);
        if (ans == null) {
            System.out.println("No node found"); // No node with value greater than n
        } else {
            System.out.println(ans.data); // Print the value of the node with value just greater than n
        }
    }
}
