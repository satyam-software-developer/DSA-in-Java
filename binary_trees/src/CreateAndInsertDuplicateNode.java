
/* Problem statement
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.

The root will remain the same. So you just need to insert nodes in the given Binary Tree.

Example:
alt txt

After making the changes to the above-depicted tree, the updated tree will look like this.
alt txt

You can see that every node in the input tree has been duplicated and inserted to the left of itself.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format :
The updated tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
 Note:
You are not required to print anything explicitly. It has already been taken care of. Just implement the function to achieve the desired structure of the tree.
Hint:
First, store the left node. Next, insert a duplicate node to the left of the current node. Then, call the function for the stored left node, which will return a modified node. Attach this modified node to the left of the duplicate node. Finally, proceed to call the function for the right node of the root
Constraints :
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
Sample Output 1:
10 
10 30 
20 30 60 
20 50 60 
40 50 
40 
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 2:
8 
8 10 
5 10 
5 6 
2 6 7 
2 7 */

/*
 * Time complexity : O(N)
 * Space complexity : O(H)
 * 
 * where N is the Number of nodes in the tree
 * and H is the height of the tree.
 * 
 * H is equal to log(N) for a balanced tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateAndInsertDuplicateNode {

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

    // Method to insert duplicate nodes to the left of each node in the binary tree
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        // Create a new node with the same data as the current root
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
        // Store the left child of the current root
        BinaryTreeNode<Integer> rootLeft = root.left;

        // Set the left child of the current root to the new node
        root.left = newNode;
        // Set the left child of the new node to the stored left child
        newNode.left = rootLeft;

        // Recursively process the left and right subtrees
        insertDuplicateNode(rootLeft);
        insertDuplicateNode(root.right);
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

    // Method to print the binary tree in level order
    private static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

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

    // Main method
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the input and construct the binary tree
        BinaryTreeNode<Integer> root = takeInput();
        // Insert duplicate nodes into the tree
        insertDuplicateNode(root);
        // Print the modified tree in level order
        printLevelWise(root);
    }
}
