/*Problem statement
You are given a ‘Binary Tree’.

Return the preorder traversal of the Binary Tree.

Example:
Input: Consider the following Binary Tree:
Example

Output: 
Following is the preorder traversal of the given Binary Tree: [1, 2, 5, 3, 6, 4]

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The only line contains elements in the level order form. The line consists of values of nodes separated by a single space. In case a node is null, we take -1 in its place.

For example, the input for the tree depicted in the below image will be:
alt text

1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1

Explanation :
Level 1 :
The root node of the tree is 1

Level 2 :
Left child of 1 = 2
Right child of 1 = 3

Level 3 :
Left child of 2 = 4
Right child of 2 = null (-1)
Left child of 3 = 5
Right child of 3 = 6

Level 4 :
Left child of 4 = null (-1)
Right child of 4 = 7
Left child of 5 = null (-1)
Right child of 5 = null (-1)
Left child of 6 = null (-1)
Right child of 6 = null (-1)

Level 5 :
Left child of 7 = null (-1)
Right child of 7 = null (-1)

The first not-null node(of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.

The input ends when all nodes at the last level are null(-1).

The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1


Output Format:
Return an array representing the preorder traversal of the given binary tree.


Note :
You do not need to print anything; it has already been taken care of. Just implement the given function.
Sample Input 1:
1 2 3 5 4 6 7 -1 -1 -1 -1 -1 -1 -1 -1


 Sample Output 1:
1 2 5 4 3 6 7


Explanation of Sample Input 1:
The Binary Tree given in the input is as follows:
Sample1

Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1


 Sample Output 2:
5 6 2 3 9 10


Explanation of Sample Input 2:
The Binary Tree given in the input is as follows:
Sample2

Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= n <= 100000
where 'n' is the number of nodes in the binary tree.

Time Limit: 1 sec */

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

public class PreorderBinaryTree {

    // Custom exception for handling empty queue scenario
    static class QueueEmptyException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    // A generic queue implementation using linked list
    static class QueueUsingLL<T> {

        // Node class to represent each element in the linked list
        static class Node<T> {
            T data; // Data stored in the node
            Node<T> next; // Pointer to the next node in the list

            // Constructor to create a new node with given data
            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head; // Head of the queue
        private Node<T> tail; // Tail of the queue
        private int size = 0; // Current size of the queue

        // Method to get the current size of the queue
        public int size() {
            return size;
        }

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to get the front element of the queue without removing it
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException(); // Throw exception if queue is empty
            }
            return head.data; // Return data of the head node
        }

        // Method to add an element to the end of the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element); // Create a new node with given element

            // If the queue is empty, both head and tail point to the new node
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode; // Link the new node at the end of the queue
                tail = newNode; // Update the tail to point to the new node
            }

            size++; // Increase the size of the queue
        }

        // Method to remove and return the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                throw new QueueEmptyException(); // Throw exception if queue is empty
            }
            if (head == tail) {
                tail = null; // If there's only one element, set tail to null
            }
            T temp = head.data; // Store the data of the head node
            head = head.next; // Move head to the next node
            size--; // Decrease the size of the queue
            return temp; // Return the data of the dequeued node
        }
    }

    // Node class for the binary tree
    static class BinaryTreeNode<T> {
        T data; // Data stored in the node
        BinaryTreeNode<T> left; // Left child of the node
        BinaryTreeNode<T> right; // Right child of the node

        // Constructor to create a new node with given data
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to perform preorder traversal of the binary tree
    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // Base case: If the node is null, return
        }
        System.out.print(root.data + " "); // Print the data of the node
        preOrder(root.left); // Recursively traverse the left subtree
        preOrder(root.right); // Recursively traverse the right subtree
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to build the binary tree from input
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        // Queue to store nodes whose children are yet to be added
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int start = 0;

        // Read the input and split it into an array of strings
        String[] nodeDatas = br.readLine().trim().split(" ");

        // Read the root data and create the root node
        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root); // Enqueue the root node

        // Loop until all nodes are processed
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the next node to process
            } catch (QueueEmptyException e) {
                return null; // If queue is empty, return null
            }

            // Read and process the left child
            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (leftChildData != -1) {
                // Create the left child node and link it to the current node
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild); // Enqueue the left child
            }

            // Read and process the right child
            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (rightChildData != -1) {
                // Create the right child node and link it to the current node
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild); // Enqueue the right child
            }
        }

        return root; // Return the root of the binary tree
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Build the binary tree from input
        BinaryTreeNode<Integer> root = takeInput();
        // Perform preorder traversal of the binary tree
        preOrder(root);
    }
}
