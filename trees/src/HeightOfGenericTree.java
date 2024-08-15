/* Problem statement
Given a generic tree, find and return the height of given tree. The height of a tree is defined as the longest distance from root node to any of the leaf node. Assume the height of a tree with a single node is 1.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains data of the nodes of the tree in level order form. The order is: data for root node, number of children to root node, data of each of child nodes and so on and so forth for each node. The data of the nodes of the tree is separated by space.  

For the above tree, height will be 3 as the leaf nodes which are present at longest distance are 40, 50.(10->20->40) or (10->20->50).
Output Format :
The first and only line of output prints the height of the given generic tree.
Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1:
3 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the tree and 
 * H is the height/depth of the tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HeightOfGenericTree {

    // Exception class to handle the scenario when trying to dequeue from an empty
    // queue
    static class QueueEmptyException extends Exception {
    }

    // Implementation of a generic queue using a linked list
    static class QueueUsingLL<T> {

        // Node class representing an element in the queue
        static class Node<T> {
            T data; // Data stored in the node
            Node<T> next; // Pointer to the next node

            // Constructor to initialize the node with data
            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Pointer to the front of the queue
        private Node<T> tail; // Pointer to the rear of the queue
        private int size = 0; // Number of elements in the queue

        // Method to get the size of the queue
        public int size() {
            return size;
        }

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to get the front element of the queue without removing it
        public T front() throws QueueEmptyException {
            if (size == 0) { // If the queue is empty, throw an exception
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Method to add an element to the rear of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element); // Create a new node with the given element
            if (head == null) { // If the queue is empty
                head = newNode;
                tail = newNode;
            } else { // If the queue is not empty
                tail.next = newNode; // Link the new node to the end of the queue
                tail = newNode; // Update the tail to the new node
            }
            size++; // Increment the size of the queue
        }

        // Method to remove and return the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) { // If the queue is empty, throw an exception
                throw new QueueEmptyException();
            }
            if (head == tail) { // If there's only one element in the queue
                tail = null; // Update the tail to null
            }
            T temp = head.data; // Store the data of the head node
            head = head.next; // Move the head to the next node
            size--; // Decrement the size of the queue
            return temp; // Return the data of the dequeued node
        }
    }

    // Class representing a node in a generic tree
    static class TreeNode<T> {
        T data; // Data stored in the node
        ArrayList<TreeNode<T>> children; // List of child nodes

        // Constructor to initialize the node with data
        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<>(); // Initialize the list of children
        }
    }

    // Method to calculate the height of the generic tree
    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) { // If the tree is empty
            return 0;
        }
        int maxChildHeight = 0; // Variable to store the maximum height among the children
        for (TreeNode<Integer> child : root.children) { // Iterate through each child of the root
            int childHeight = getHeight(child); // Recursively calculate the height of each child
            if (childHeight > maxChildHeight) { // Update the maximum height if a taller child is found
                maxChildHeight = childHeight;
            }
        }
        return maxChildHeight + 1; // Return the height of the tree
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader to read input
    static StringTokenizer st;

    // Method to take input level-wise and construct the tree
    public static TreeNode<Integer> takeInputLevelWise() throws IOException {
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); // Queue to store nodes whose children are
                                                                             // to be added
        st = new StringTokenizer(br.readLine()); // Tokenize the input
        int rootData = Integer.parseInt(st.nextToken()); // Read the root data
        TreeNode<Integer> root = new TreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root); // Enqueue the root node

        while (!pendingNodes.isEmpty()) { // While there are nodes in the queue
            TreeNode<Integer> currentNode = null;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the front node
            } catch (QueueEmptyException e) {
                e.printStackTrace(); // Print the stack trace if an exception occurs
                return null; // Return null if an exception occurs
            }
            int numChild = Integer.parseInt(st.nextToken()); // Read the number of children
            for (int i = 0; i < numChild; i++) { // Iterate through each child
                int currentChild = Integer.parseInt(st.nextToken()); // Read the child data
                TreeNode<Integer> childNode = new TreeNode<>(currentChild); // Create a new child node
                pendingNodes.enqueue(childNode); // Enqueue the child node
                currentNode.children.add(childNode); // Add the child to the current node's children list
            }
        }
        return root; // Return the constructed tree
    }

    public static void main(String[] args) throws IOException {
        TreeNode<Integer> root = takeInputLevelWise(); // Take input and construct the tree
        if (root != null) { // If the tree is not null
            System.out.println(getHeight(root)); // Print the height of the tree
        }
    }
}
