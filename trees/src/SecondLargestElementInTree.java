
/* Problem statement
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40 */

import java.util.ArrayList;
import java.util.Scanner;

public class SecondLargestElementInTree {

    // Exception class to handle cases where the queue is empty
    static class QueueEmptyException extends Exception {
    }

    // Queue implementation using a linked list
    static class QueueUsingLL<T> {

        // Node class representing each element in the queue
        class Node<T> {
            T data;
            Node<T> next;

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

        // Returns the front element of the queue
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException();
            }

            return head.data;
        }

        // Adds an element to the queue
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

    // TreeNode class representing each node in the tree
    static class TreeNode<T> {
        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    // Pair class to store the first and second largest nodes
    static class Pair<T> {
        T first;
        T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    // Public method to find and return the second largest node in the tree
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        return findSecondLargestHelper(root).second;
    }

    // Helper method to find the second largest node
    public static Pair<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root) {
        if (root == null) {
            return new Pair<>(null, null); // If the root is null, return a pair with null values
        }

        Pair<TreeNode<Integer>> output = new Pair<>(root, null); // Initialize the output pair with root as the first

        // Traverse each child of the root
        for (TreeNode<Integer> child : root.children) {
            Pair<TreeNode<Integer>> childPair = findSecondLargestHelper(child); // Recursively find the largest and
                                                                                // second largest in the subtree

            // Update the output pair based on the values from the child pair
            if (childPair.first != null && childPair.first.data > output.first.data) {
                if (childPair.second == null || childPair.second.data < output.first.data) {
                    output.second = output.first;
                    output.first = childPair.first;
                } else {
                    output.first = childPair.first;
                    output.second = childPair.second;
                }
            } else if (childPair.first != null && !childPair.first.data.equals(output.first.data) &&
                    (output.second == null || childPair.first.data > output.second.data)) {
                output.second = childPair.first;
            } else if (childPair.first != null && childPair.first.data.equals(output.first.data) &&
                    childPair.second != null && (output.second == null || childPair.second.data > output.second.data)) {
                output.second = childPair.second;
            }
        }
        return output;
    }

    static Scanner s = new Scanner(System.in);

    // Method to take input level-wise and build the tree
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
                    int currentChild = s.nextInt(); // Read the data for each child
                    TreeNode<Integer> childNode = new TreeNode<>(currentChild);
                    pendingNodes.enqueue(childNode);
                    currentNode.children.add(childNode);
                }
            } catch (QueueEmptyException e) {
                // Do nothing
            }
        }
        return root; // Return the root of the constructed tree
    }

    // Main method to execute the program
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise(); // Build the tree from input
        TreeNode<Integer> ans = findSecondLargest(root); // Find the second largest node
        if (ans == null) {
            System.out.println(Integer.MIN_VALUE); // If no second largest node is found, print the minimum integer
                                                   // value
        } else {
            System.out.println(ans.data); // Print the data of the second largest node
        }
    }
}
