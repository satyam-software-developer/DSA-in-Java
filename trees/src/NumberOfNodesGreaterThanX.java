
/* Problem statement
Given a tree and an integer x, find and return number of Nodes which are greater than x.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Single Line : First Integer denotes x and rest of the elements in level order form separated by space. Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of nodes greater than x
Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3
Explanation
Since x=35, the elements which are greater than 35 are 40, 40, 50, so the output for this is 3.
Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5
Explanation
Since x=10, the elements which are greater than 10 are 20, 30, 40,  40, 50, so the output for this is 5. */

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfNodesGreaterThanX {

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

    // Function to count the number of nodes greater than x
    public static int numNodeGreaterThanX(TreeNode<Integer> root, int x) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (root.data > x) {
            count++;
        }
        for (TreeNode<Integer> child : root.children) {
            count += numNodeGreaterThanX(child, x);
        }
        return count;
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
        int x = s.nextInt();
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(numNodeGreaterThanX(root, x));
    }
}
