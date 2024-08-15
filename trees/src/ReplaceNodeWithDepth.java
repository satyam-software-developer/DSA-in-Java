
/* Problem statement
In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything. Depth of a node is defined as the distance of the node from root. You may assume that depth of root node is 0.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Elements in level order form separated by space (as per done in class) in the below given order:
node_data, n (number of children of node), n children, and so on for every element `
Output format :
Print the depth of each node level wise.
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Representation of Input:

Sample Output 1 : (Level wise, each level in new line)
0 
1 1 1 
2 2
Explanation
Since root is 10 , so it's depth is 0
Node 20, 30 , 40 are present at 1st level , so their depth is 1.
Node 40,50 are present at 2nd level, so their depth is 2. */

import java.util.ArrayList;
import java.util.Scanner;

public class ReplaceNodeWithDepth {

    // Exception class to handle cases where the queue is empty
    static class QueueEmptyException extends Exception {
    }

    // Queue implementation using a linked list
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

    // TreeNode class representing each node in the tree
    static class TreeNode<T> {
        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    // Method to replace each node's data with its depth value
    public static void replacedWithDepthValue(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        replacedWithDepthValue(root, 0);
    }

    public static void replacedWithDepthValue(TreeNode<Integer> root, int depth) {
        root.data = depth;

        for (TreeNode<Integer> child : root.children) {
            replacedWithDepthValue(child, depth + 1);
        }
    }

    static Scanner s = new Scanner(System.in);

    // Method to take input level-wise and build the tree
    public static TreeNode<Integer> takeInputLevelWise() {
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int rootData = s.nextInt(); // Read the root data
        TreeNode<Integer> root = new TreeNode<>(rootData); // Create the root node
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                int numChild = s.nextInt(); // Read the number of children for the current node
                for (int i = 0; i < numChild; i++) {
                    int currentChild = s.nextInt(); // Read the data for each child
                    TreeNode<Integer> childNode = new TreeNode<>(currentChild);
                    pendingNodes.enqueue(childNode);
                    currentNode.children.add(childNode);
                }
            } catch (QueueEmptyException e) {
                // Do nothing
            }
        }
        return root; // Return the root of the constructed tree
    }

    // Method to print the tree level-wise
    public static void printTreeLevelWise(TreeNode<Integer> root) {
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        pendingNodes.enqueue(null);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                if (currentNode == null) {
                    System.out.println();
                    if (!pendingNodes.isEmpty()) {
                        pendingNodes.enqueue(null);
                    } else {
                        break;
                    }
                } else {
                    System.out.print(currentNode.data + " ");
                    for (TreeNode<Integer> child : currentNode.children) {
                        pendingNodes.enqueue(child);
                    }
                }
            } catch (QueueEmptyException e) {
                // Do nothing
            }
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise(); // Build the tree from input
        replacedWithDepthValue(root); // Replace each node's data with its depth value
        printTreeLevelWise(root); // Print the tree level-wise
    }
}
