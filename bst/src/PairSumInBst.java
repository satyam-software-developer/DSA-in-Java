/* Problem statement
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).

Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of S.
Output format:
You have to print each pair in a different line (pair elements separated by space). The order of different pairs, to be printed, does not matter.
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input BST
 * and H is the height of the input BST
 */

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PairSumInBst {

    // Exception class for handling empty queue scenarios
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

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        // Returns the current size of the queue
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

    // Node class representing each node in the binary search tree
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Counts the total number of nodes in the binary search tree
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // Prints all pairs of nodes in the BST that sum to a given value S
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if (root == null) {
            return;
        }
        int totalCount = countNodes(root);
        int count = 0;
        Stack<BinaryTreeNode<Integer>> inorder = new Stack<>();
        Stack<BinaryTreeNode<Integer>> revInorder = new Stack<>();

        // Initialize the inorder traversal stack
        BinaryTreeNode<Integer> temp = root;
        while (temp != null) {
            inorder.push(temp);
            temp = temp.left;
        }

        // Initialize the reverse inorder traversal stack
        temp = root;
        while (temp != null) {
            revInorder.push(temp);
            temp = temp.right;
        }

        // Traverse the tree using two stacks
        while (count < totalCount - 1) {
            BinaryTreeNode<Integer> top1 = inorder.peek();
            BinaryTreeNode<Integer> top2 = revInorder.peek();

            // If the sum of the two nodes is equal to S, print them
            if (top1.data + top2.data == s) {
                System.out.println(top1.data + " " + top2.data);

                // Move the inorder traversal stack to the next node
                BinaryTreeNode<Integer> top = top1;
                inorder.pop();
                count++;
                if (top.right != null) {
                    top = top.right;
                    while (top != null) {
                        inorder.push(top);
                        top = top.left;
                    }
                }

                // Move the reverse inorder traversal stack to the next node
                top = top2;
                revInorder.pop();
                count++;
                if (top.left != null) {
                    top = top.left;
                    while (top != null) {
                        revInorder.push(top);
                        top = top.right;
                    }
                }
            } else if (top1.data + top2.data > s) {
                // If the sum is greater than S, move the reverse inorder stack
                BinaryTreeNode<Integer> top = top2;
                revInorder.pop();
                count++;
                if (top.left != null) {
                    top = top.left;
                    while (top != null) {
                        revInorder.push(top);
                        top = top.right;
                    }
                }
            } else {
                // If the sum is less than S, move the inorder stack
                BinaryTreeNode<Integer> top = top1;
                inorder.pop();
                count++;
                if (top.right != null) {
                    top = top.right;
                    while (top != null) {
                        inorder.push(top);
                        top = top.left;
                    }
                }
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // Reads the input and constructs the binary search tree
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);

        // Construct the tree using level order traversal
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

    // Main method to run the program
    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        int s = Integer.parseInt(br.readLine());
        printNodesSumToS(root, s);
    }
}
