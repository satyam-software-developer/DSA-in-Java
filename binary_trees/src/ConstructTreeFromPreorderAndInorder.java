/* Problem statement
For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements. 
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.

The second line of input contains N integers, all separated by a single space. It represents the preorder-traversal of the binary tree.

The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^3
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
5 6 2 3 9 10 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9  */

/*
 * Time complexity: O(N^2)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input tree
 * and H is the height of the input tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromPreorderAndInorder {

    // Definition of the Binary Tree Node
    static class BinaryTreeNode<T> {
        T data; // Data held by the node
        BinaryTreeNode<T> left; // Reference to the left child node
        BinaryTreeNode<T> right; // Reference to the right child node

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper class to store preorder and inorder arrays
    static class Pair {
        int[] preOrder; // Array to store preorder traversal
        int[] inOrder; // Array to store inorder traversal

        // Constructor to initialize the Pair object with preorder and inorder arrays
        public Pair(int[] preOrder, int[] inOrder) {
            this.preOrder = preOrder;
            this.inOrder = inOrder;
        }
    }

    // Helper method to build the tree from preorder and inorder arrays
    private static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder,
            int inStart, int inEnd) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root node
        int rootVal = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootVal);

        // Find the index of the root element in inorder array
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inOrder[i]) {
                k = i;
                break;
            }
        }

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preOrder, preStart + 1, preStart + (k - inStart), inOrder, inStart, k - 1);
        root.right = buildTreeHelper(preOrder, preStart + (k - inStart) + 1, preEnd, inOrder, k + 1, inEnd);

        return root; // Return the constructed tree
    }

    // Public method to initiate the tree building
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length; // Length of the preorder array

        int preStart = 0; // Start index for preorder array
        int preEnd = n - 1; // End index for preorder array
        int inStart = 0; // Start index for inorder array
        int inEnd = n - 1; // End index for inorder array

        // Call the helper method to build the tree
        return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for input

    // Method to take input and return a Pair object containing preorder and inorder
    // arrays
    private static Pair takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Read the number of nodes

        int pre[] = new int[n]; // Array to store preorder traversal
        int in[] = new int[n]; // Array to store inorder traversal

        // Read preorder traversal from input
        String[] preOrder = br.readLine().trim().split(" ");
        // Read inorder traversal from input
        String[] inOrder = br.readLine().trim().split(" ");

        // Parse the input and populate the preorder and inorder arrays
        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(preOrder[i].trim());
            in[i] = Integer.parseInt(inOrder[i].trim());
        }

        return new Pair(pre, in); // Return the Pair object containing both arrays
    }

    // Method to print the tree in level-order fashion
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        // Use a queue to facilitate level-order traversal
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root); // Add the root node to the queue
        pendingNodes.add(null); // Add a marker for the end of the current level

        // Continue until the queue is empty
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll(); // Get and remove the front node

            if (frontNode == null) {
                System.out.println(); // End of the current level
                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null); // Add a marker for the next level
                }
            } else {
                System.out.print(frontNode.data + " "); // Print the node's data
                // Add left and right children to the queue
                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                }
                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                }
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        Pair input = takeInput(); // Take input for preorder and inorder arrays

        int[] preOrder = input.preOrder; // Get the preorder array
        int[] inOrder = input.inOrder; // Get the inorder array

        BinaryTreeNode<Integer> root = buildTree(preOrder, inOrder); // Build the tree

        printLevelWise(root); // Print the tree in level-order
    }
}
