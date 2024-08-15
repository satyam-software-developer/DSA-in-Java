
/* Problem statement
Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.

LCA
LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
Example:
In this example, the green coloured node is the LCA to A and B.
Alt Text

Note:
It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection from Y, then Y is the lowest common ancestor.
Example:
Alt Text

Note:

1. If out of 2 nodes only one node is present, return that node. 
2. If both are not present, return -1.
3. all the node data will be unique.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1 */

/*
 * Time complexity: O(H)
 * Space complexity: O(H)
 * 
 * where H is the height of the input BST
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LcaOfBst {

    // Exception for handling empty queue scenarios
    static class QueueEmptyException extends Exception {
    }

    // Queue implementation using linked list
    static class QueueUsingLL<T> {
        static class Node<T> {
            T data; // Data stored in the node
            Node<T> next; // Pointer to the next node in the queue

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Head of the queue
        private Node<T> tail; // Tail of the queue
        private int size = 0; // Size of the queue

        // Returns the size of the queue
        public int size() {
            return size;
        }

        // Checks if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Returns the front element of the queue without removing it
        public T front() throws QueueEmptyException {
            if (size == 0) { // If the queue is empty, throw an exception
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Adds an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element); // Create a new node with the given element
            if (head == null) { // If the queue is empty, set both head and tail to the new node
                head = newNode;
                tail = newNode;
            } else { // Otherwise, add the new node to the end and update the tail
                tail.next = newNode;
                tail = newNode;
            }
            size++; // Increment the size of the queue
        }

        // Removes and returns the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) { // If the queue is empty, throw an exception
                throw new QueueEmptyException();
            }
            if (head == tail) { // If there is only one element, set tail to null
                tail = null;
            }
            T temp = head.data; // Store the data to return
            head = head.next; // Move head to the next node
            size--; // Decrement the size of the queue
            return temp; // Return the data of the removed element
        }
    }

    // Node class for Binary Tree
    static class BinaryTreeNode<T> {
        T data; // Data stored in the node
        BinaryTreeNode<T> left; // Pointer to the left child
        BinaryTreeNode<T> right; // Pointer to the right child

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Helper function to find the LCA in a BST
    public static BinaryTreeNode<Integer> getLCAUtil(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null || root.data == a || root.data == b) {
            // If root is null or root's data matches a or b, root is the LCA
            return root;
        }
        if (root.data < a && root.data < b) {
            // If both a and b are greater than root, LCA is in the right subtree
            return getLCAUtil(root.right, a, b);
        } else if (root.data > a && root.data > b) {
            // If both a and b are smaller than root, LCA is in the left subtree
            return getLCAUtil(root.left, a, b);
        }
        // Otherwise, root is the LCA
        BinaryTreeNode<Integer> leftLCA = getLCAUtil(root.left, a, b);
        BinaryTreeNode<Integer> rightLCA = getLCAUtil(root.right, a, b);
        if (leftLCA != null && rightLCA != null) {
            // If both leftLCA and rightLCA are not null, root is the LCA
            return root;
        } else if (leftLCA != null) {
            // If leftLCA is not null, return leftLCA
            return leftLCA;
        }
        // Otherwise, return rightLCA
        return rightLCA;
    }

    // Function to find the LCA in a BST and return its data
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> node = getLCAUtil(root, a, b);
        return (node == null) ? -1 : node.data;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Function to take level order input and construct the BST
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) { // If the root data is -1, the tree is empty
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root); // Add the root node to the queue

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the current node
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) { // If left child data is not -1, create the left child node
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild; // Link the left child to the current node
                pendingNodes.enqueue(leftChild); // Add the left child to the queue
            }
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) { // If right child data is not -1, create the right child node
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild; // Link the right child to the current node
                pendingNodes.enqueue(rightChild); // Add the right child to the queue
            }
        }
        return root; // Return the root of the constructed BST
    }

    public static void main(String[] args) throws IOException {
        // Read input and construct the BST
        BinaryTreeNode<Integer> root = takeInput();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // Read the first node value
        int b = Integer.parseInt(st.nextToken()); // Read the second node value
        // Find and print the LCA of the two nodes
        System.out.println(getLCA(root, a, b));
    }
}
