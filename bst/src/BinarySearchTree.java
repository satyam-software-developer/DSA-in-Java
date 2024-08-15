/* Problem statement
Implement the BST class which includes following functions -

1. insert -
Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.

2. search
Given an element, find if that is present in BST or not. Return true or false.

3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.

4. printTree (recursive) -
Print the BST in in the following format -

For printing a node with data N, you need to follow the exact format -

N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.

There is no space in between.

You need to print all nodes in the recursive format in different lines.

Sample Input 1:
6
1 2
1 3
1 1
4
2 2
4
Sample Output 1:
2:L:1,R:3
1:
3:
3:L:1,
1:
Explanation for sample Input 1:
Explanation: The first line 6 indicates that there are 6 operations to be performed on the BST.

The subsequent lines are the operations, which can be understood as follows:
1 2: Insert 2 into the BST.

1 3: Insert 3 into the BST.

1 1: Insert 1 into the BST.

4: Print the BST in the specified format.

2 2: Search for 2 in the BST.

4: Print the BST in the specified format. */

/*
 * Time complexity: O(H) [for all operations]
 * Space complexity: O(N)
 * where N is the number of nodes in the input BST
 * and H is the height of the input BST
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchTree {
    // Class representing a node in the binary search tree
    class BinaryTreeNode<T> {
        T data; // Data stored in the node
        BinaryTreeNode<T> left; // Reference to the left child node
        BinaryTreeNode<T> right; // Reference to the right child node

        // Constructor to initialize node with data
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    private BinaryTreeNode<Integer> root; // Root of the binary search tree

    // Public method to insert a new value into the BST
    public void insert(int data) {
        root = insert(data, root); // Call the recursive insert method
    }

    // Private recursive method to insert a new value into the BST
    private BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            // If the current root is null, create a new node with the given data
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode; // Return the new node to be attached to the tree
        }
        if (root.data >= data) {
            // If the data to insert is less than or equal to the current node's data,
            // insert it in the left subtree
            root.left = insert(data, root.left);
        } else {
            // If the data to insert is greater than the current node's data,
            // insert it in the right subtree
            root.right = insert(data, root.right);
        }
        return root; // Return the current root to maintain the tree structure
    }

    // Public method to remove a value from the BST
    public void remove(int data) {
        root = remove(data, root); // Call the recursive remove method
    }

    // Private recursive method to remove a value from the BST
    private BinaryTreeNode<Integer> remove(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null; // If the current root is null, return null (value not found)
        }
        if (data < root.data) {
            // If the data to remove is less than the current node's data,
            // search and remove it in the left subtree
            root.left = remove(data, root.left);
            return root; // Return the current root to maintain the tree structure
        } else if (data > root.data) {
            // If the data to remove is greater than the current node's data,
            // search and remove it in the right subtree
            root.right = remove(data, root.right);
            return root; // Return the current root to maintain the tree structure
        } else {
            // If the data matches the current node's data, this is the node to be removed
            if (root.left == null && root.right == null) {
                // If the node is a leaf node, simply remove it by returning null
                return null;
            } else if (root.left == null) {
                // If the node has only a right child, replace it with the right child
                return root.right;
            } else if (root.right == null) {
                // If the node has only a left child, replace it with the left child
                return root.left;
            } else {
                // If the node has both left and right children
                // Find the minimum value in the right subtree to replace the current node
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data; // Replace the current node's data with the minimum value
                root.right = remove(minNode.data, root.right); // Remove the minimum value node from the right subtree
                return root; // Return the current root to maintain the tree structure
            }
        }
    }

    // Public method to print the BST
    public void printTree() {
        printTree(root); // Call the recursive print method
    }

    // Private recursive method to print the BST
    private void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // If the current root is null, return (base case)
        }
        // Print the current node's data and its children's data
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L:" + root.left.data + ",");
        }
        if (root.right != null) {
            System.out.print("R:" + root.right.data);
        }
        System.out.println();
        printTree(root.left); // Recursively print the left subtree
        printTree(root.right); // Recursively print the right subtree
    }

    // Public method to search for a value in the BST
    public boolean search(int data) {
        return search(data, root); // Call the recursive search method
    }

    // Private recursive method to search for a value in the BST
    private boolean search(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false; // If the current root is null, return false (value not found)
        }
        if (root.data == data) {
            return true; // If the data matches the current node's data, return true
        } else if (data > root.data) {
            return search(data, root.right); // Search in the right subtree
        } else {
            return search(data, root.left); // Search in the left subtree
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for input
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BinarySearchTree bst = new BinarySearchTree(); // Create an instance of BinarySearchTree
        int choice, input;
        int q = Integer.parseInt(br.readLine()); // Read the number of operations
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine()); // Read the next line of input
            choice = Integer.parseInt(st.nextToken()); // Read the choice of operation
            switch (choice) {
                case 1: // Insert operation
                    input = Integer.parseInt(st.nextToken());
                    bst.insert(input);
                    break;
                case 2: // Remove operation
                    input = Integer.parseInt(st.nextToken());
                    bst.remove(input);
                    break;
                case 3: // Search operation
                    input = Integer.parseInt(st.nextToken());
                    System.out.println(bst.search(input));
                    break;
                default: // Print tree operation
                    bst.printTree();
                    break;
            }
        }
    }
}
