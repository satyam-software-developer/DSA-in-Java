/* Problem statement
Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in different lines.

The output for the above tree should be 
10
20 30 40
40 50
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Level wise print
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50 */

import java.util.ArrayList;
import java.util.Scanner;

public class PrintLevelWise {

    // Exception class to handle empty queue scenarios
    static class QueueEmptyException extends Exception {
    }

    // A simple implementation of a queue using a linked list
    static class QueueUsingLL<T> {

        // Node class representing each element in the queue
        static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Pointer to the head of the queue
        private Node<T> tail; // Pointer to the tail of the queue
        private int size = 0; // Number of elements in the queue

        // Returns the current size of the queue
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
                throw new QueueEmptyException(); // Throws exception if queue is empty
            }
            return head.data;
        }

        // Adds an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);
            if (head == null) { // If the queue is empty
                head = newNode;
                tail = newNode;
            } else { // If the queue is not empty
                tail.next = newNode; // Link the new node at the end of the queue
                tail = newNode; // Update the tail to the new node
            }
            size++;
        }

        // Removes and returns the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) { // If the queue is empty
                throw new QueueEmptyException(); // Throws exception if queue is empty
            }
            if (head == tail) { // If there's only one element in the queue
                tail = null; // Update tail to null
            }
            T temp = head.data; // Store the data of the head node
            head = head.next; // Move the head to the next node
            size--;
            return temp; // Return the data of the dequeued node
        }
    }

    // Node class representing each node in the generic tree
    static class TreeNode<T> {
        T data; // Data stored in the node
        ArrayList<TreeNode<T>> children; // List of children nodes

        TreeNode(T data) {
            this.data = data; // Initialize node data
            children = new ArrayList<>(); // Initialize the children list
        }
    }

    // Function to print the tree in level-wise order
    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<>();
        q.enqueue(root);

        while (!q.isEmpty()) {
            int n = q.size(); // Number of nodes at current level
            while (n > 0) {
                TreeNode<Integer> node = null;
                try {
                    node = q.dequeue();
                } catch (QueueEmptyException e) {
                    e.printStackTrace();
                }
                System.out.print(node.data + " ");
                for (TreeNode<Integer> child : node.children) {
                    q.enqueue(child);
                }
                n--;
            }
            System.out.println();
        }
    }

    static Scanner s = new Scanner(System.in);

    // Function to take input level-wise and construct the tree
    public static TreeNode<Integer> takeInputLevelWise() {
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode = null;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
            int numChild = s.nextInt();
            for (int i = 0; i < numChild; i++) {
                int currentChild = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(currentChild);
                pendingNodes.enqueue(childNode);
                currentNode.children.add(childNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
    }
}
