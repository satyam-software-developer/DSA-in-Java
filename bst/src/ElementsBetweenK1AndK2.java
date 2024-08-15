/* Problem statement
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).

Print the elements in increasing order.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
The following line contains two integers, that denote the value of k1 and k2.
Output Format:
 The first and only line of output prints the elements which are in range k1 and k2 (both inclusive). Print the elements in increasing order.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10 */

/*
     * Binary Tree Node class
     * 
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
     * public BinaryTreeNode(T data){this.data = data; }}
     */

/*
 * Time complexity: O(N)
   Space complexity: O(H)
   
   where N is the number of nodes in the input BST and 
   H is the height of the input BST
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ElementsBetweenK1AndK2 {

    // Custom exception class for handling queue empty condition
    static class QueueEmptyException extends Exception {
    }

    // Generic Queue implementation using Linked List
    static class QueueUsingLL<T> {

        // Node class representing each element in the linked list
        static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        // Method to return the current size of the queue
        public int size() {
            return size;
        }

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to return the front element of the queue without removing it
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Method to add an element to the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);

            // If the queue is empty, both head and tail will point to the new node
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, add the new node at the end and update the tail
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

            // If the queue has only one element, update tail to null
            if (head == tail) {
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    // Class representing a node in the binary tree
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Method to print the elements in range k1 to k2 (inclusive) in increasing
    // order
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // If the current node's data is within the range
        if (root.data >= k1 && root.data <= k2) {
            // Recursively process the left subtree
            elementsInRangeK1K2(root.left, k1, k2);
            // Print the current node's data
            System.out.print(root.data + " ");
            // Recursively process the right subtree
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data < k1) {
            // If the current node's data is less than k1, process the right subtree
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data > k2) {
            // If the current node's data is greater than k2, process the left subtree
            elementsInRangeK1K2(root.left, k1, k2);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Method to take input and construct the binary tree from level-order data
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);

        // Loop to construct the tree using the input data
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        // Construct the binary tree from input data
        BinaryTreeNode<Integer> root = takeInput();
        st = new StringTokenizer(br.readLine());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());
        // Print elements in range [k1, k2]
        elementsInRangeK1K2(root, k1, k2);
    }
}
