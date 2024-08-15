/*Problem statement
For a given a Binary Tree of integers, replace each of its data with the depth of the tree.

Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the in the depth of the given tree.

The modified tree will be printed in the in-order fashion.

Example:
Alt text

The above tree after updating will look like this:
Alt text

Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
Detailed explanation ( Input/output format, Notes, Images )
 Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The first and the only line of output prints the updated tree in the in-order fashion.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1sec
 Sample Input 1:
2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 
Sample Output 1:
2 1 2 0 2 1 2 
 Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
2 1 2 0 2 1 2  */

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

public class ReplaceNodeWithDepth {

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

    // Function to modify each node in the binary tree to store its depth
    private static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int level) {
        if (root == null) {
            return;
        }
        root.data = level;

        changeToDepthTreeHelper(root.left, level + 1); // Recursively process left subtree
        changeToDepthTreeHelper(root.right, level + 1); // Recursively process right subtree
    }

    // Function to initiate modification of each node to store its depth
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTreeHelper(root, 0); // Start recursive depth modification from root
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to build the binary tree from input
    public static BinaryTreeNode<Integer> takeInput()
            throws NumberFormatException, IOException, ReplaceNodeWithDepth.QueueEmptyException {
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        String[] nodeDatas = br.readLine().trim().split(" ");

        int start = 0;
        int rootData = Integer.parseInt(nodeDatas[start++]);
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = pendingNodes.dequeue();

            int leftChildData = Integer.parseInt(nodeDatas[start++]);
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }

            int rightChildData = Integer.parseInt(nodeDatas[start++]);
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }

        return root;
    }

    // Function to perform inorder traversal of the binary tree and print node data
    public static void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        inOrder(root.left); // Traverse left subtree recursively
        System.out.print(root.data + " "); // Print current node data
        inOrder(root.right); // Traverse right subtree recursively
    }

    // Main method to execute the program
    public static void main(String[] args)
            throws NumberFormatException, IOException, ReplaceNodeWithDepth.QueueEmptyException {
        BinaryTreeNode<Integer> root = takeInput(); // Build the binary tree from input

        changeToDepthTree(root); // Modify each node to store its depth

        inOrder(root); // Perform inorder traversal and print node data
    }
}
