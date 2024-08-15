/*Problem statement
For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.

To print the information of a node with data D, you need to follow the exact format :

           D:L:X,R:Y

Where D is the data of a node present in the binary tree. 
X and Y are the values of the left(L) and right(R) child of the node.
Print -1 if the child doesn't exist.
Example:
alt text

For the above depicted Binary Tree, the level order travel will be printed as followed:

1:L:2,R:3
2:L:4,R:-1
3:L:5,R:6
4:L:-1,R:7
5:L:-1,R:-1    
6:L:-1,R:-1
7:L:-1,R:-1

Note: There is no space in between while printing the information for each node.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
Information of all the nodes in the Binary Tree will be printed on a different line where each node will follow a format of D:L:X,R:Y, without any spaces in between.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
8:L:3,R:10
3:L:1,R:6
10:L:-1,R:14
1:L:-1,R:-1
6:L:4,R:7
14:L:13,R:-1
4:L:-1,R:-1
7:L:-1,R:-1
13:L:-1,R:-1
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
 Sample Output 2:
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:-1
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1 */
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

public class PrintLevelWise {

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
                this.next = null;
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
                // If the queue is empty, both head and tail point to the new node
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, add the new node to the end and update the tail
                tail.next = newNode;
                tail = newNode;
            }

            size++; // Increment the size of the queue
        }

        // Removes and returns the front element of the queue
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                throw new QueueEmptyException();
            }
            if (head == tail) {
                tail = null; // If there's only one element, update tail to null
            }
            T temp = head.data; // Store the data of the head node
            head = head.next; // Move the head to the next node
            size--; // Decrement the size of the queue
            return temp; // Return the data of the removed node
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

    // Method to print the binary tree in level-order fashion with the specified
    // format
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // If the tree is empty, return immediately
        }

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root); // Add the root node to the queue

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll(); // Get and remove the front node
            System.out.print(frontNode.data + ":L:");

            if (frontNode.left != null) {
                // If the left child exists, add it to the queue and print its data
                pendingNodes.add(frontNode.left);
                System.out.print(frontNode.left.data + ",R:");
            } else {
                // If the left child does not exist, print -1
                System.out.print("-1,R:");
            }

            if (frontNode.right != null) {
                // If the right child exists, add it to the queue and print its data
                pendingNodes.add(frontNode.right);
                System.out.println(frontNode.right.data);
            } else {
                // If the right child does not exist, print -1
                System.out.println("-1");
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to construct the binary tree from level-order input
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        int start = 0;

        // Read input and split it into an array of node data strings
        String[] nodeDatas = br.readLine().trim().split(" ");

        // If the input is a single "-1", return null indicating an empty tree
        if (nodeDatas.length == 1 && nodeDatas[0].equals("-1")) {
            return null;
        }

        // Parse the root data and create the root node
        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root); // Add the root node to the queue

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Get and remove the front node
            } catch (QueueEmptyException e) {
                return null; // This should not happen
            }

            // Parse the left child data
            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (leftChildData != -1) {
                // If the left child exists, create and link the left child node
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild); // Add the left child to the queue
            }

            // Parse the right child data
            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (rightChildData != -1) {
                // If the right child exists, create and link the right child node
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild); // Add the right child to the queue
            }
        }

        return root; // Return the root of the constructed binary tree
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput(); // Construct the binary tree from input
        printLevelWise(root); // Print the tree in level-order fashion
    }
}
