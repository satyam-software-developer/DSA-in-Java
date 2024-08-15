
/* Problem statement
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.

Example:
alt txt

For the above-depicted tree, when printed in a level order fashion, the output would look like:

10
20 30 
40 50 60
Where each new line denotes the level in the tree.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
Sample Output 1:
10 
20 30 
40 50 60 
Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
8 
3 10 
1 6 14 
4 7 13  */

/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the number of nodes in the input tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

    // Method to print the binary tree in level order
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        // Create a queue
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

            if (frontNode == null) {
                System.out.println();

                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }
            } else {
                System.out.print(frontNode.data + " ");

                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                }
                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                }
            }
        }
    }

    // Method to read input and construct the binary tree
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        // Print the tree in level order
        printLevelWise(root);
    }
}
