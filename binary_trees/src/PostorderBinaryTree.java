/* Problem statement
For a given Binary Tree of integers, print the post-order traversal.

ALTIMAGE

The postorder traversal for the given binary tree will be 40 50 20 30 10
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints the post-order traversal of the given binary tree.
Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
4 5 2 6 7 3 1 
Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
 Sample Output 1:
2 9 3 6 10 5  */

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

public class PostorderBinaryTree {

    // Custom exception for handling empty queue scenario
    static class QueueEmptyException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    // A generic queue implementation using linked list
    static class QueueUsingLL<T> {

        // Node class to represent each element in the linked list
        static class Node<T> {
            T data; // Data stored in the node
            Node<T> next; // Pointer to the next node in the list

            // Constructor to create a new node with given data
            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Head of the queue
        private Node<T> tail; // Tail of the queue
        private int size = 0; // Current size of the queue

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
            if (size == 0) {
                throw new QueueEmptyException(); // Throw exception if queue is empty
            }
            return head.data; // Return data of the head node
        }

        // Method to add an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element); // Create a new node with given element

            // If the queue is empty, both head and tail point to the new node
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode; // Link the new node at the end of the queue
                tail = newNode; // Update the tail to point to the new node
            }

            size++; // Increase the size of the queue
        }

        // Method to remove and return the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                throw new QueueEmptyException(); // Throw exception if queue is empty
            }
            if (head == tail) {
                tail = null; // If there's only one element, set tail to null
            }
            T temp = head.data; // Store the data of the head node
            head = head.next; // Move head to the next node
            size--; // Decrease the size of the queue
            return temp; // Return the data of the dequeued node
        }
    }

    // Node class for the binary tree
    static class BinaryTreeNode<T> {
        T data; // Data stored in the node
        BinaryTreeNode<T> left; // Left child of the node
        BinaryTreeNode<T> right; // Right child of the node

        // Constructor to create a new node with given data
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to perform postorder traversal of the binary tree
    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // Base case: If the node is null, return
        }

        postOrder(root.left); // Recursively traverse the left subtree
        postOrder(root.right); // Recursively traverse the right subtree
        System.out.print(root.data + " "); // Print the data of the node
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to build the binary tree from input
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        // Queue to store nodes whose children are yet to be added
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int start = 0;

        // Read the input and split it into an array of strings
        String[] nodeDatas = br.readLine().trim().split(" ");

        // Read the root data and create the root node
        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root); // Enqueue the root node

        // Loop until all nodes are processed
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the next node to process
            } catch (QueueEmptyException e) {
                return null; // If queue is empty, return null
            }

            // Read and process the left child
            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (leftChildData != -1) {
                // Create the left child node and link it to the current node
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild); // Enqueue the left child
            }

            // Read and process the right child
            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (rightChildData != -1) {
                // Create the right child node and link it to the current node
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild); // Enqueue the right child
            }
        }

        return root; // Return the root of the binary tree
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Build the binary tree from input
        BinaryTreeNode<Integer> root = takeInput();
        // Perform postorder traversal of the binary tree
        postOrder(root);
    }
}
