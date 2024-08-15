/* Problem statement
For a given Binary Tree of integers, find and return the sum of all the nodes data.

Example:
ALTIMAGE

When we sum up all the nodes data together, we get 150. Hence, the output will be 150.
Detailed explanation ( Input/output format, Notes, Images )
 Input Format:
The first and the only line of input will contain the nodes data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The first and the only line of output prints the sum of all the nodes data present in the binary tree.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 3 4 6 -1 -1 -1 -1 -1
Sample Output 1:
 15
Explanation :
The binary tree formed using the input values: 2, 3, 4, 6, -1, -1, -1, -1, -1. Hence the sum is 15. 
ALTIMAGE

Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
 28 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input tree and H is the height of the input tree.
 */

import java.util.LinkedList; // Import the LinkedList class for use in the queue
import java.util.Queue; // Import the Queue interface for the BFS approach
import java.util.Scanner; // Import the Scanner class for reading input

// Define a class for the binary tree nodes
class BinaryTreeNode<T> {
    T data; // Data held by the node
    BinaryTreeNode<T> left; // Pointer to the left child
    BinaryTreeNode<T> right; // Pointer to the right child

    // Constructor to initialize the node with data and set children to null
    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Main class to find the sum of all nodes in a binary tree
public class SumOfNodes {

    // Function to compute the sum of all nodes in the binary tree
    public static int getSum(BinaryTreeNode<Integer> root) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }
        // Recursively compute the sum of the left and right subtrees
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        // Return the sum of the current node's data and the sums of the left and right
        // subtrees
        return (leftSum + rightSum + root.data);
    }

    // Function to build a binary tree from level order input
    public static BinaryTreeNode<Integer> buildTree(int[] nodes) {
        // If the input array is empty or the root node is -1, return null
        if (nodes.length == 0 || nodes[0] == -1) {
            return null;
        }

        // Create the root node with the first element in the array
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(nodes[0]);
        // Initialize a queue for level order tree construction
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Index to keep track of the current element in the array
        // Loop through the array to construct the tree
        while (i < nodes.length) {
            // Get the current node from the queue
            BinaryTreeNode<Integer> current = queue.poll();

            // If the left child is not null, create the left child and add it to the queue
            if (nodes[i] != -1) {
                current.left = new BinaryTreeNode<>(nodes[i]);
                queue.add(current.left);
            }
            i++;
            // If the right child is not null and within bounds, create the right child and
            // add it to the queue
            if (i < nodes.length && nodes[i] != -1) {
                current.right = new BinaryTreeNode<>(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        // Return the root of the constructed tree
        return root;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a scanner object for reading input

        // Read input values and split them into an array of strings
        String[] input = s.nextLine().split(" ");
        int[] nodes = new int[input.length];
        // Convert the array of strings to an array of integers
        for (int i = 0; i < input.length; i++) {
            nodes[i] = Integer.parseInt(input[i]);
        }

        // Build the binary tree from the input array
        BinaryTreeNode<Integer> root = buildTree(nodes);

        // Compute the sum of all nodes in the binary tree
        int sum = getSum(root);
        // Print the computed sum
        System.out.println(sum);

        s.close(); // Close the scanner object
    }
}
