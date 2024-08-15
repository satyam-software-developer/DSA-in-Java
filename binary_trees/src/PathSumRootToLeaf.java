/*Problem statement
For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.

Example:
alt txt

If you see in the above-depicted picture of Binary Tree, we see that there are a total of two paths, starting from the root and ending at the leaves which sum up to a value of K = 13.

The paths are:
a. 2 3 4 4
b. 2 3 8

One thing to note here is, there is another path in the right sub-tree in reference to the root, which sums up to 13 but since it doesn't end at the leaf, we discard it.
The path is: 2 9 2(not a leaf)
Detailed explanation ( Input/output format, Notes, Images )
 Input Format:
The first line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.

The second line of input contains an integer value K.
Output Format:
Lines equal to the total number of paths will be printed. All the node data in every path will be printed in a linear fashion taken in the order they appear from top to down bottom in the tree. A single space will separate them all.
Constriants:
1 <= N <= 10^5
0 <= K <= 10^8
Where N is the total number of nodes in the binary tree.

Time Limit: 1 second
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
13
 Sample Output 1:
2 3 4 4 
2 3 8
Sample Input 2:
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13
 Sample Output 2:
5 6 2
5 7 1 */

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

public class PathSumRootToLeaf {

    // Exception class for handling empty queue scenarios
    static class QueueEmptyException extends Exception {
    }

    // Node class represents an element in the linked list
    static class Node<T> {
        T data; // Data contained in the node
        Node<T> next; // Reference to the next node in the linked list

        // Constructor to initialize the node with data
        Node(T data) {
            this.data = data;
        }
    }

    // Queue implementation using linked list
    static class QueueUsingLL<T> {
        private Node<T> head; // Reference to the head of the queue
        private Node<T> tail; // Reference to the tail of the queue
        private int size = 0; // Number of elements in the queue

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
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Method to add an element to the queue
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

        // Method to remove and return the front element of the queue
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

    // Binary tree node class
    static class BinaryTreeNode<T> {
        T data; // Data contained in the node
        BinaryTreeNode<T> left; // Reference to the left child
        BinaryTreeNode<T> right; // Reference to the right child

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to print all root-to-leaf paths with a given sum
    private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String path, int currSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currSum += root.data;
            if (currSum == k) {
                System.out.println(path + root.data);
            }
            return;
        }
        rootToLeafPathsSumToK(root.left, k, path + root.data + " ", currSum + root.data);
        rootToLeafPathsSumToK(root.right, k, path + root.data + " ", currSum + root.data);
    }

    // Wrapper method to initiate the recursive path finding
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        rootToLeafPathsSumToK(root, k, "", 0);
    }

    // Method to read input and construct the binary tree
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int start = 0;

        // Read the input and split it into an array of node data strings
        String[] nodeDatas = br.readLine().trim().split(" ");

        // If there is only one element, return null as the tree is empty
        if (nodeDatas.length == 1) {
            return null;
        }

        // Parse the root data and create the root node
        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);

        // Process the input to construct the tree in level order
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

            // If the left child data is not -1, create the left child node and enqueue it
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }

            // Parse the right child data
            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            // If the right child data is not -1, create the right child node and enqueue it
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }

        // Return the constructed root of the tree
        return root;
    }

    // Main method
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the input and construct the binary tree
        BinaryTreeNode<Integer> root = takeInput();
        // Read the value of k
        int k = Integer.parseInt(br.readLine().trim());
        // Print all root-to-leaf paths with sum equal to k
        rootToLeafPathsSumToK(root, k);
    }
}
