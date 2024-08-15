/* Problem statement
Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.

Note: If array size is even, take first mid as root.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line of input contains an integer, which denotes the value of n. The following line contains n space separated integers, that denote the values of array.
Output Format:
The first and only line of output contains values of BST nodes, printed in pre order traversal.
Constraints:
Time Limit: 1 second
Sample Input 1:
7
1 2 3 4 5 6 7
Sample Output 1:
4 2 1 3 6 5 7  */


/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the number of nodes in the input Array
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstructBST {

    // Class to represent a node in the binary tree
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Method to initiate the construction of BST from a sorted array
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        // Call the helper function with the full array range
        return SortedArrayToBSTHelper(arr, 0, n - 1);
    }

    // Helper method to construct BST recursively
    private static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int start, int end) {
        // Base case: when the start index exceeds the end index
        if (start > end) {
            return null;
        }

        // Find the middle element of the current array range
        int mid = start + (end - start) / 2;

        // Create a new tree node with the middle element
        BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(arr[mid]);

        // Recursively construct the left subtree with the left half of the current
        // range
        temp.left = SortedArrayToBSTHelper(arr, start, mid - 1);

        // Recursively construct the right subtree with the right half of the current
        // range
        temp.right = SortedArrayToBSTHelper(arr, mid + 1, end);

        // Return the constructed tree node
        return temp;
    }

    // Method to perform pre-order traversal of the BST and print the node values
    private static void preOrder(BinaryTreeNode<Integer> root) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // Print the data of the current node
        System.out.print(root.data + " ");

        // Recursively perform pre-order traversal on the left subtree
        preOrder(root.left);

        // Recursively perform pre-order traversal on the right subtree
        preOrder(root.right);
    }

    // Main method to drive the program
    public static void main(String[] args) throws IOException {
        // BufferedReader to read input from the console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read the array size from input
        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());

        // Initialize an array to store the input elements
        int[] arr = new int[len];

        // Check if the array has any elements
        if (len > 0) {
            // Read the array elements from input
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Construct the BST from the sorted array
        BinaryTreeNode<Integer> root = SortedArrayToBST(arr, len);

        // Print the pre-order traversal of the constructed BST
        preOrder(root);
    }
}
