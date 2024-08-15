/* Problem statement
Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.

That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.

Note: You don't need to return or print, just change the data of each node.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
In the output, data of the nodes of the tree are printed in level order form. Each level of the tree is printed on a separate line.
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25  */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input BST 
 * and H is the height of the input BST
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReplaceWithSumOfGreaterNodes {

    // Exception for handling empty queue scenarios
    static class QueueEmptyException extends Exception {
    }

    // Queue implementation using a linked list
    static class QueueUsingLL<T> {
        // Inner class representing a node in the queue
        static class Node<T> {
            T data; // Data stored in the node
            Node<T> next; // Pointer to the next node in the queue

            // Constructor to initialize node with data
            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Head of the queue
        private Node<T> tail; // Tail of the queue
        private int size = 0; // Size of the queue

        // Returns the number of elements in the queue
        public int size() {
            return size;
        }

        // Checks if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Returns the front element of the queue without removing it
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException(); // Throw exception if queue is empty
            }
            return head.data; // Return the data at the head of the queue
        }

        // Adds an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element); // Create a new node with the given element
            if (head == null) { // If queue is empty, set both head and tail to the new node
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
            if (head == null) { // Throw exception if queue is empty
                throw new QueueEmptyException();
            }
            if (head == tail) { // If there's only one element, set tail to null
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

        // Constructor to initialize a binary tree node with data
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Helper function to replace each node's data with the sum of all nodes >= to
    // it
    private static int replaceWithLargerNodesSumUtil(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) { // Base case: If the node is null, return the current sum
            return sum;
        }
        // Traverse the right subtree first to handle nodes with greater values
        sum = replaceWithLargerNodesSumUtil(root.right, sum);
        // Update the current node's data by adding the accumulated sum
        root.data += sum;
        // Update the sum to include the current node's new data
        sum = root.data;
        // Traverse the left subtree
        return replaceWithLargerNodesSumUtil(root.left, sum);
    }

    // Public function to start the replacement process
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        replaceWithLargerNodesSumUtil(root, 0); // Initialize sum as 0 and start the recursion
    }

    // Function to take level-order input and construct the BST
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken()); // Read the root data
        if (rootData == -1) {
            return null; // If root data is -1, the tree is empty
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root); // Add the root node to the queue

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the current node
            } catch (QueueEmptyException e) {
                return null; // Return null if the queue is empty (this should not happen)
            }
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) { // If left child data is not -1, create and link the left child
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild); // Add the left child to the queue
            }
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) { // If right child data is not -1, create and link the right child
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild); // Add the right child to the queue
            }
        }
        return root; // Return the root of the constructed BST
    }

    // Function to print the BST in level order
    public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) {
        if (root == null) { // If the tree is empty, do nothing
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root); // Start with the root node
        q.add(null); // Marker for end of level

        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> current = q.poll(); // Dequeue the current node
            if (current == null) { // If we encounter the level marker
                if (!q.isEmpty()) { // If there are more nodes to process, print a new line
                    System.out.println();
                    q.add(null); // Add marker for the next level
                }
            } else {
                System.out.print(current.data + " "); // Print the current node's data
                if (current.left != null) { // If the left child exists, enqueue it
                    q.add(current.left);
                }
                if (current.right != null) { // If the right child exists, enqueue it
                    q.add(current.right);
                }
            }
        }
    }

    // Main function to handle input, processing, and output
    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput(); // Read input and construct the BST
        replaceWithLargerNodesSum(root); // Replace node values with sum of greater nodes
        printLevelWiseAtDiffLevel(root); // Print the updated BST in level-order format
    }
}
