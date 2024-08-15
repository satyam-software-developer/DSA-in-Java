
/* Problem statement
Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.

Note:
Assume that BST contains all unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of k.
Output Format:
The first and only line of output contains a boolean value. Print true, if node with data k is present, print false otherwise. 
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
false */

/*
     * Time complexity: O(H)
     * Space complexity: O(H)
     * 
     * Where H is the height of the input BST
     */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchInBST {

    // Definition of a generic Binary Tree Node class
    static class BinaryTreeNode<T> {
        T data; // Data stored in the node
        BinaryTreeNode<T> left; // Reference to the left child
        BinaryTreeNode<T> right; // Reference to the right child

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    /**
     * Method to search for a given integer 'k' in a Binary Search Tree (BST)
     * 
     * @param root The root of the BST
     * @param k    The integer to search for
     * @return true if 'k' is found in the BST, otherwise false
     */
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        // Base case: if the root is null, 'k' is not found
        if (root == null) {
            return false;
        }

        // If the data in the root matches 'k', return true
        if (root.data == k) {
            return true;
        }
        // If the data in the root is greater than 'k', search in the left subtree
        else if (root.data > k) {
            return searchInBST(root.left, k);
        }
        // If the data in the root is less than 'k', search in the right subtree
        else {
            return searchInBST(root.right, k);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Method to take input and construct a Binary Search Tree (BST)
     * 
     * @return The root of the constructed BST
     * @throws IOException If an input or output exception occurred
     */
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        // Read the first line of input
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());

        // If the root data is -1, the tree is empty, return null
        if (rootData == -1) {
            return null;
        }

        // Queue to manage nodes at different levels of the tree
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // Create the root node
        pendingNodes.add(root); // Add the root to the queue

        // While there are nodes in the queue
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = pendingNodes.poll(); // Remove the front node from the queue

            // Read the left child data
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData); // Create the left child node
                currentNode.left = leftChild; // Set the left child of the current node
                pendingNodes.add(leftChild); // Add the left child to the queue
            }

            // Read the right child data
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData); // Create the right child
                                                                                           // node
                currentNode.right = rightChild; // Set the right child of the current node
                pendingNodes.add(rightChild); // Add the right child to the queue
            }
        }
        return root; // Return the root of the constructed tree
    }

    /**
     * Main method to execute the program
     * 
     * @param args Command line arguments
     * @throws NumberFormatException If a number format exception occurs
     * @throws IOException           If an input or output exception occurs
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput(); // Take input and construct the BST
        int k = Integer.parseInt(br.readLine()); // Read the integer 'k' to search for
        System.out.println(searchInBST(root, k)); // Search for 'k' in the BST and print the result
    }
}
