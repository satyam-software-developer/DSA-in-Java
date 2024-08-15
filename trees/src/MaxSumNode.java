
/* Problem statement
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.

Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Representation of input

Sample Output 1 :
1
Explanation
Sum of node 1 and it's child (15) is maximum among all the nodes, so the output for this is 1. */

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSumNode {

    // Custom exception for handling empty queue scenarios
    static class QueueEmptyException extends Exception {
    }

    // Generic queue implementation using a linked list
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

    // Class to store a node and its sum
    static class MaxNodePair<T> {
        TreeNode<T> node; // The node with the maximum sum
        int sum; // The maximum sum
    }

    // Finds and returns the node with the maximum sum of its data and its
    // children's data
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        return maxSumNodeHelper(root).node;
    }

    // Helper function to find the node with the maximum sum
    public static MaxNodePair<Integer> maxSumNodeHelper(TreeNode<Integer> root) {
        if (root == null) {
            MaxNodePair<Integer> pair = new MaxNodePair<>();
            pair.node = null;
            pair.sum = Integer.MIN_VALUE;
            return pair;
        }
        int sum = root.data;
        for (TreeNode<Integer> child : root.children) {
            sum += child.data;
        }
        MaxNodePair<Integer> ans = new MaxNodePair<>();
        ans.node = root;
        ans.sum = sum;
        for (TreeNode<Integer> child : root.children) {
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);
            if (childAns.sum > ans.sum) {
                ans = childAns;
            }
        }
        return ans;
    }

    static Scanner s = new Scanner(System.in);

    // Takes tree input level-wise and constructs the tree
    public static TreeNode<Integer> takeInputLevelWise() {
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
        TreeNode<Integer> ans = maxSumNode(root); // Find the node with the maximum sum
        if (ans == null) {
            System.out.println(Integer.MIN_VALUE);
        } else {
            System.out.println(ans.data); // Print the data of the node with the maximum sum
        }
    }
}
