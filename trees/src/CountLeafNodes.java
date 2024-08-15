/* Problem statement
Given a generic tree, count and return the number of leaf nodes present in the given tree. A node is said to be a leaf node if it's not having any child

Leaf nodes in the given tree are 40, 50, 30, 40. So the answer for this is 4.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of leaf nodes
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
4 */

import java.util.ArrayList;
import java.util.Scanner;

public class CountLeafNodes {

    // Custom exception for empty queue scenario
    static class QueueEmptyException extends Exception {
    }

    // Generic queue implementation using linked list
    static class QueueUsingLL<T> {

        // Node class to represent each element in the linked list
        static class Node<T> {
            T data; // Data stored in the node
            Node<T> next; // Reference to the next node

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Front of the queue
        private Node<T> tail; // Rear of the queue
        private int size = 0; // Size of the queue

        // Returns the size of the queue
        public int size() {
            return size;
        }

        // Checks if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Returns the front element of the queue
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException();
            }

            return head.data;
        }

        // Adds an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        // Removes and returns the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                throw new QueueEmptyException();
            }
            if (head == tail) {
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    // Generic tree node class
    static class TreeNode<T> {
        T data; // Data stored in the node
        ArrayList<TreeNode<T>> children; // List of children nodes

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    // Counts the number of leaf nodes in the tree
    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int count = 0;
        // Recursively count the leaf nodes in each child
        for (TreeNode<Integer> child : root.children) {
            count += countLeafNodes(child);
        }
        return count;
    }

    static Scanner s = new Scanner(System.in);

    // Takes tree input level-wise and constructs the tree
    public static TreeNode<Integer> takeInputLevelWise() {
        // Queue of nodes that are entered themselves but their children aren't added
        // yet
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int rootData = s.nextInt(); // Read the root data
        TreeNode<Integer> root = new TreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                int numChild = s.nextInt(); // Read the number of children for the current node
                for (int i = 0; i < numChild; i++) {
                    int currentChild = s.nextInt(); // Read each child data
                    TreeNode<Integer> childNode = new TreeNode<>(currentChild); // Create the child node
                    pendingNodes.enqueue(childNode);
                    currentNode.children.add(childNode); // Add the child node to the current node's children
                }
            } catch (QueueEmptyException e) {
                // Should never reach here
            }
        }
        return root; // Return the root of the constructed tree
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise(); // Take input and construct the tree
        System.out.println(countLeafNodes(root)); // Print the number of leaf nodes in the tree
    }
}
