
/*Problem statement
For a given Binary of type integer, find and return the ‘Diameter’.

Diameter of a Tree
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
Example:
alt txt

The maximum distance can be seen between the leaf nodes 8 and 9. 
The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1 
Sample Output 1:
9
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
5 */
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

// Pair class to store diameter and height of the tree
class Pair {
    int diameter; // Diameter of the tree
    int height; // Height of the tree

    // Constructor to initialize diameter and height
    public Pair(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

public class DiameterOfBinaryTree {

    // Custom exception to indicate an empty queue
    static class QueueEmptyException extends Exception {
    }

    // Implementation of a queue using a linked list
    static class QueueUsingLL<T> {

        // Node class representing each element in the queue
        static class Node<T> {
            T data; // Data held by the node
            Node<T> next; // Reference to the next node

            // Constructor to initialize the node with data
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

    // BinaryTreeNode class representing each node in the binary tree
    static class BinaryTreeNode<T> {
        T data; // Data held by the node
        BinaryTreeNode<T> left; // Reference to the left child
        BinaryTreeNode<T> right; // Reference to the right child

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null; // Initially, the left child is null
            this.right = null; // Initially, the right child is null
        }
    }

    // Recursive helper method to calculate the diameter and height of the tree
    private static Pair diameterHelper(BinaryTreeNode<Integer> root) {
        // Base case: if the root is null, return diameter and height as 0
        if (root == null) {
            return new Pair(0, 0);
        }

        // Recursively get the diameter and height of the left subtree
        Pair leftPair = diameterHelper(root.left);
        // Recursively get the diameter and height of the right subtree
        Pair rightPair = diameterHelper(root.right);

        // Diameter of the left subtree
        int leftDiameter = leftPair.diameter;
        // Diameter of the right subtree
        int rightDiameter = rightPair.diameter;
        // Distance between the deepest nodes of the left and right subtrees
        int dist = leftPair.height + rightPair.height + 1;

        // Calculate the diameter of the current tree
        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
        // Calculate the height of the current tree
        int height = Math.max(leftPair.height, rightPair.height) + 1;

        // Return the calculated diameter and height
        return new Pair(diameter, height);
    }

    // Method to calculate the diameter of the binary tree
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        Pair pair = diameterHelper(root);
        return pair.diameter;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to construct the binary tree from level-order input
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        // Queue to store the nodes at each level
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int start = 0;

        // Read the entire input line and split it into individual node values
        String[] nodeDatas = br.readLine().trim().split(" ");

        // If there is only one element and it is -1, the tree is empty
        if (nodeDatas.length == 1 && nodeDatas[0].equals("-1")) {
            return null;
        }

        // Parse the root data and create the root node
        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        // Add the root node to the queue
        pendingNodes.enqueue(root);

        // Loop until there are no more nodes to process in the queue
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }

            // Parse the left child data
            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;
            // If the left child is not null, create the node and add it to the queue
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }

            // Parse the right child data
            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;
            // If the right child is not null, create the node and add it to the queue
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }

        // Return the root of the constructed tree
        return root;
    }

    // Main method to execute the program
    public static void main(String[] args) throws IOException {
        // Take input to construct the binary tree
        BinaryTreeNode<Integer> root = takeInput();
        // Calculate the diameter of the binary tree
        int d = diameterOfBinaryTree(root);
        // Print the diameter
        System.out.println(d);
    }
}
