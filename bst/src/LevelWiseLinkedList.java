
/* Problem statement
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format :
Each level linked list is printed in new line (elements are separated by space).
Constraints:
Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
5 
6 10 
2 3 
9 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input BST
 * and H is the height of the input BST
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LevelWiseLinkedList {

    // Exception to indicate queue is empty
    static class QueueEmptyException extends Exception {
    }

    // Custom queue implementation using linked list
    static class QueueUsingLL<T> {

        // Node class for the queue
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

        // Method to return the size of the queue
        public int size() {
            return size;
        }

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to get the front element of the queue
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Method to add an element to the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<T>(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Method to remove an element from the queue
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
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Linked list node class
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    // Method to create linked lists for each level of the binary tree
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        // Queue to manage nodes at each level
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        int currentLevelRemaining = 1; // Number of nodes remaining in the current level
        int nextLevelCount = 0; // Number of nodes in the next level

        LinkedListNode<Integer> currentLevelHead = null;
        LinkedListNode<Integer> currentLevelTail = null;
        ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();

        // Loop until there are no more nodes to process
        while (!pendingNodes.isEmpty()) {
            // Get the next node
            BinaryTreeNode<Integer> currentNode = pendingNodes.poll();
            LinkedListNode<Integer> newNode = new LinkedListNode<>(currentNode.data);

            // Build the linked list for the current level
            if (currentLevelHead == null) {
                currentLevelHead = newNode;
                currentLevelTail = newNode;
            } else {
                currentLevelTail.next = newNode;
                currentLevelTail = newNode;
            }

            // Add left and right children to the queue
            if (currentNode.left != null) {
                pendingNodes.add(currentNode.left);
                nextLevelCount++;
            }
            if (currentNode.right != null) {
                pendingNodes.add(currentNode.right);
                nextLevelCount++;
            }

            currentLevelRemaining--;

            // If the current level is done, reset for the next level
            if (currentLevelRemaining == 0) {
                output.add(currentLevelHead);
                currentLevelHead = null;
                currentLevelTail = null;
                currentLevelRemaining = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return output;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Method to take input and build the binary tree
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);

        // Loop to build the tree from input
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

    // Method to print the linked list nodes
    private static void print(LinkedListNode<Integer> temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to drive the program
    public static void main(String[] args) throws IOException {
        // Read input and construct the binary tree
        BinaryTreeNode<Integer> root = takeInput();
        // Create linked lists for each level
        ArrayList<LinkedListNode<Integer>> output = constructLinkedListForEachLevel(root);
        // Print the linked lists
        if (output != null) {
            for (LinkedListNode<Integer> head : output) {
                print(head);
            }
        }
    }
}
