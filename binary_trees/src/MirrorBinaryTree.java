/* Problem statement
For a given Binary Tree of type integer, update it with its corresponding mirror image.

Example:
Alt text

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints the mirrored tree in a level-wise order. 
Each level will be printed on a new line. Elements printed at each level will be separated by a single line.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 
3 2 
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5 
6 10 
3 2 
9 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * Where N is the number of nodes in the input tree
 * and H is the height of the input tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirrorBinaryTree {

    // Custom exception for queue operations
    static class QueueEmptyException extends Exception {
    }

    // Implementation of a queue using a linked list
    static class QueueUsingLL<T> {

        // Node class representing each element in the queue
        static class Node<T> {
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

    // Method to update the binary tree to its mirror image
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        // Recursively mirror the left and right subtrees
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

        // Swap the left and right children
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to construct the binary tree from level-order input
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
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
            // Remove the front node from the queue
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

    // Method to print the binary tree in level-wise order
    private static void printLevelWise(BinaryTreeNode<Integer> root) {
        QueueUsingLL<BinaryTreeNode<Integer>> primary = new QueueUsingLL<>();
        QueueUsingLL<BinaryTreeNode<Integer>> secondary = new QueueUsingLL<>();

        primary.enqueue(root);

        while (!primary.isEmpty()) {
            BinaryTreeNode<Integer> current = null;
            try {
                current = primary.dequeue();
            } catch (QueueEmptyException e) {
                System.out.println("Not possible");
            }
            System.out.print(current.data + " ");
            if (current.left != null) {
                secondary.enqueue(current.left);
            }
            if (current.right != null) {
                secondary.enqueue(current.right);
            }
            if (primary.isEmpty()) {
                QueueUsingLL<BinaryTreeNode<Integer>> temp = secondary;
                secondary = primary;
                primary = temp;
                System.out.println();
            }
        }
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput();

        mirrorBinaryTree(root);
        printLevelWise(root);
    }
}
