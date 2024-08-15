
/* Problem statement
Given a generic tree, print the post-order traversal of given tree.

The post-order traversal is: visit child nodes first and then root node.

For the given tree, the post order traversal will be 40 50 20 30 40 10
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 400 50 0 0 0 0 
Sample Output 1:
400 50 20 30 40 10
Explanation
For 10 , total 3 children are there : 20 30 40
For  20, total 2 children are there : 400 50
So, the output will be 400 50 20 30 40 10 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PostOrderTraversal {

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

    // Prints the post-order traversal of the tree
    public static void printPostOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (TreeNode<Integer> child : root.children) {
            printPostOrder(child);
        }
        System.out.print(root.data + " ");
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Takes tree input level-wise and constructs the tree
    public static TreeNode<Integer> takeInputLevelWise() throws IOException {
        // Queue of nodes that are entered themselves but their children aren't added
        // yet
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken()); // Read the root data
        TreeNode<Integer> root = new TreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                int numChild = Integer.parseInt(st.nextToken()); // Read the number of children for the current node
                for (int i = 0; i < numChild; i++) {
                    int currentChild = Integer.parseInt(st.nextToken()); // Read each child data
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

    public static void main(String[] args) throws IOException {
        TreeNode<Integer> root = takeInputLevelWise(); // Take input and construct the tree
        printPostOrder(root); // Print the post-order traversal of the tree
    }
}
