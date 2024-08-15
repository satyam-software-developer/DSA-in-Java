/*Problem statement
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.

Note: Assume that BST contains all unique elements.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of k.
Output Format :
The first line and only line of output prints the data of the nodes in the path from node k to root. The data of the nodes is separated by single space.
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2


Sample Output 1:
2 5 8 */

/*
 * Time complexity: O(H)
 * Space complexity: O(H)
 * 
 * where H is the height of the input BST
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FindPathInBst {

    // Custom exception for queue operations
    // This exception is thrown when trying to dequeue from an empty queue
    static class QueueEmptyException extends Exception {
    }

    // Implementation of a queue using linked list
    // This class provides a queue implementation with basic operations such as
    // enqueue, dequeue, and checking if the queue is empty
    static class QueueUsingLL<T> {

        // Node class for queue elements
        // Each node contains data and a reference to the next node
        static class Node<T> {
            T data;
            Node<T> next;

            // Constructor to initialize node with data
            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Points to the front of the queue
        private Node<T> tail; // Points to the rear of the queue
        private int size = 0; // Keeps track of the number of elements in the queue

        // Returns the number of elements in the queue
        public int size() {
            return size;
        }

        // Checks if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Returns the front element of the queue without removing it
        // Throws QueueEmptyException if the queue is empty
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Adds an element to the rear of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);
            if (head == null) {
                // If the queue is empty, both head and tail point to the new node
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, add the new node to the end and update the tail
                tail.next = newNode;
                tail = newNode;
            }
            size++; // Increase the size of the queue
        }

        // Removes and returns the front element of the queue
        // Throws QueueEmptyException if the queue is empty
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                throw new QueueEmptyException();
            }
            if (head == tail) {
                // If there is only one element, update tail to null
                tail = null;
            }
            T temp = head.data;
            head = head.next; // Move head to the next node
            size--; // Decrease the size of the queue
            return temp;
        }
    }

    // Node class for binary tree
    // Each node contains data and references to the left and right children
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        // Constructor to initialize node with data
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Method to get the path from node k to the root
    // Returns an ArrayList of integers representing the path
    // If the node with value k is not found, returns null
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return null;
        }
        if (root.data == k) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data); // Add the node data to the path
            return output;
        } else if (k < root.data) {
            // If k is less than the current node's data, search in the left subtree
            ArrayList<Integer> leftOutput = getPath(root.left, k);
            if (leftOutput != null) {
                leftOutput.add(root.data); // Add the current node's data to the path
            }
            return leftOutput;
        } else {
            // If k is greater than the current node's data, search in the right subtree
            ArrayList<Integer> rightOutput = getPath(root.right, k);
            if (rightOutput != null) {
                rightOutput.add(root.data); // Add the current node's data to the path
            }
            return rightOutput;
        }
    }

    // BufferedReader for input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Method to take input and build the BST
    // Returns the root node of the BST
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine()); // Read the first line of input
        int rootData = Integer.parseInt(st.nextToken()); // Read the root data
        if (rootData == -1) {
            return null; // If root data is -1, return null (empty tree)
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); // Create a queue for level-order
                                                                                   // traversal
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root); // Enqueue the root node

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the front node
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = Integer.parseInt(st.nextToken()); // Read the left child data
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData); // Create the left child node
                currentNode.left = leftChild; // Attach the left child to the current node
                pendingNodes.enqueue(leftChild); // Enqueue the left child
            }
            int rightChildData = Integer.parseInt(st.nextToken()); // Read the right child data
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData); // Create the right child
                                                                                           // node
                currentNode.right = rightChild; // Attach the right child to the current node
                pendingNodes.enqueue(rightChild); // Enqueue the right child
            }
        }
        return root; // Return the root of the built tree
    }

    // Main method to execute the program
    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput(); // Build the BST from input
        int k = Integer.parseInt(br.readLine()); // Read the value of k
        ArrayList<Integer> output = getPath(root, k); // Get the path from node k to the root
        if (output != null) {
            for (int i : output) {
                System.out.print(i + " "); // Print the path
            }
        }
    }
}
