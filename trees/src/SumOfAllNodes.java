/*Problem statement
Given a generic tree, count and return the sum of all nodes present in the given tree.

For the above tree , total sum of all nodes is 10 + 30 + 50 + 25 + 5 + 45 + 56 + 34 = 225
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Sum of all nodes
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
190
Explananation
For 10, 3 children are there : 20, 30, 40
For 20. 2 children are there : 40, 50
For 30, 40, 40, 50 no child is there , so the answer for this is 10+20+30+40+40+50 = 190 */

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfAllNodes {

    // Exception class to handle empty queue scenarios
    class QueueEmptyException extends Exception {
    }

    // A simple implementation of a queue using a linked list
    class QueueUsingLL<T> {

        // Node class representing each element in the queue
        class Node<T> {
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
    class TreeNode<T> {
        T data; // Data stored in the node
        ArrayList<TreeNode<T>> children; // List of children nodes

        TreeNode(T data) {
            this.data = data; // Initialize node data
            children = new ArrayList<>(); // Initialize the children list
        }
    }

    // Function to calculate the sum of all nodes in the tree
    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0; // Return 0 if the root is null (base case)
        }
        int total = root.data; // Start with the root's data
        for (int i = 0; i < root.children.size(); ++i) { // Iterate over all children
            total += sumOfAllNode(root.children.get(i)); // Add the sum of all children recursively
        }
        return total; // Return the total sum
    }

    static Scanner s = new Scanner(System.in); // Scanner for taking input

    // Function to take input level-wise and construct the tree
    public TreeNode<Integer> takeInputLevelWise() {
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); // Queue of nodes to process
        int rootData = s.nextInt(); // Read root data
        TreeNode<Integer> root = new TreeNode<>(rootData); // Create root node
        pendingNodes.enqueue(root); // Enqueue root node

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue a node
                int numChild = s.nextInt(); // Read the number of children
                for (int i = 0; i < numChild; i++) { // For each child
                    int currentChild = s.nextInt(); // Read child data
                    TreeNode<Integer> childNode = new TreeNode<>(currentChild); // Create child node
                    pendingNodes.enqueue(childNode); // Enqueue child node
                    currentNode.children.add(childNode); // Add child node to current node's children
                }
            } catch (QueueEmptyException e) {
                e.printStackTrace(); // Print the stack trace if an exception occurs
            }
        }
        return root; // Return the root of the constructed tree
    }

    public static void main(String[] args) {
        SumOfAllNodes solution = new SumOfAllNodes(); // Create an instance of the class
        TreeNode<Integer> root = solution.takeInputLevelWise(); // Construct the tree
        System.out.println(sumOfAllNode(root)); // Print the sum of all nodes in the tree
    }
}
