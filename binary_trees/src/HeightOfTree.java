/* Problem statement
For a given Binary Tree of integers, find and return the height of the tree. Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.

Example:
ALTIMAGE

Height of the given tree is 3. 
Detailed explanation ( Input/output format, Notes, Images )
 Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The first and the only line of output prints the height of the given binary tree.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
0 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 -1 -1 -1 -1 -1
Sample Output 1:
3
Sample Input 2:
3 -1 -1
Sample Output 2:
1 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input tree
 * and H is the height of the input tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeightOfTree {

    // Custom exception for handling empty queue scenario
    static class QueueEmptyException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    // Class for implementing a queue using a linked list
    static class QueueUsingLL<T> {

        // Node structure for the linked list
        static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Head of the queue
        private Node<T> tail; // Tail of the queue
        private int size; // Current size of the queue

        // Constructor to initialize an empty queue
        public QueueUsingLL() {
            head = null;
            tail = null;
            size = 0;
        }

        // Method to get the current size of the queue
        public int size() {
            return size;
        }

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to get the front element of the queue without removing it
        public T front() throws QueueEmptyException {
            if (isEmpty()) {
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Method to add an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Method to remove and return the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (isEmpty()) {
                throw new QueueEmptyException();
            }
            T temp = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return temp;
        }
    }

    // Class representing a node in a binary tree
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        // Constructor to initialize a node with given data
        BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to calculate the height of a binary tree
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0; // Base case: height of null node is 0
        }
        int leftHeight = height(root.left); // Calculate height of left subtree recursively
        int rightHeight = height(root.right); // Calculate height of right subtree recursively
        return Math.max(leftHeight, rightHeight) + 1; // Height of current node is max of left and right subtree heights
                                                      // + 1
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to build the binary tree from input
    public static BinaryTreeNode<Integer> takeInput()
            throws NumberFormatException, IOException, QueueEmptyException {
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); // Queue to store nodes for level
                                                                                   // order traversal
        String[] nodeDatas = br.readLine().trim().split(" "); // Read input data and split into tokens

        int start = 0; // Index to track current position in the input data array
        int rootData = Integer.parseInt(nodeDatas[start++]); // Read root data from input
        if (rootData == -1) {
            return null; // If root data is -1, return null (empty tree)
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // Create root node
        pendingNodes.enqueue(root); // Enqueue root node for further processing

        // Process remaining nodes in the input data
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = pendingNodes.dequeue(); // Dequeue next node for processing

            // Read and process left child data
            int leftChildData = Integer.parseInt(nodeDatas[start++]);
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData); // Create left child node
                currentNode.left = leftChild; // Link left child to current node
                pendingNodes.enqueue(leftChild); // Enqueue left child for further processing
            }

            // Read and process right child data
            int rightChildData = Integer.parseInt(nodeDatas[start++]);
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData); // Create right child node
                currentNode.right = rightChild; // Link right child to current node
                pendingNodes.enqueue(rightChild); // Enqueue right child for further processing
            }
        }

        return root; // Return the root of the binary tree
    }

    // Main method to execute the program
    public static void main(String[] args) {
        try {
            BinaryTreeNode<Integer> root = takeInput(); // Build the binary tree from input
            int h = height(root); // Calculate the height of the binary tree
            System.out.println(h); // Print the height
        } catch (NumberFormatException | IOException | QueueEmptyException e) {
            e.printStackTrace(); // Handle any exceptions
        }
    }
}
