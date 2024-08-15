
/* Problem statement
You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.

Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.

Example:
For a given input tree(refer to the image below):
1. Target Node: 5
2. K = 2
alt txt

Starting from the target node 5, the nodes at distance K are 7 4 and 1.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.

The second line of input contains two integers separated by a single space, representing the value of the target node and K, respectively.
Output Format:
All the node data at distance K from the target node will be printed on a new line.

The order in which the data is printed doesn't matter.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.
1 ≤ data of node ≤ 10^9
1 ≤ target ≤ 10^9

Time Limit: 1 sec
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1
Sample Output 1:
9
6
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 3
Sample Output 2:
4
5 */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input binary tree and 
 * H is the height of the input binary tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtDistanceKFromNode {

    // Class representing a node in the binary tree
    static class BinaryTreeNode<T> {
        T data; // Data stored in the node
        BinaryTreeNode<T> left; // Left child node
        BinaryTreeNode<T> right; // Right child node

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper function to print nodes that are K distance down from the given node
    private static void nodesAtDistanceKDown(BinaryTreeNode<Integer> root, int k) {
        // Base case: if root is null, return
        if (root == null) {
            return;
        }
        // If K is 0, print the current node's data
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        // Recur for left and right subtrees with reduced distance K-1
        nodesAtDistanceKDown(root.left, k - 1);
        nodesAtDistanceKDown(root.right, k - 1);
    }

    // Helper function to find the target node and print nodes at distance K
    private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int target, int k) {
        // Base case: if root is null, return -1
        if (root == null) {
            return -1;
        }
        // If the current node is the target node
        if (root.data == target) {
            // Print nodes at distance K down from the target node
            nodesAtDistanceKDown(root, k);
            return 0; // Return 0 to indicate the target node's level
        }

        // Recur for left subtree
        int leftDistance = nodesAtDistanceKHelper(root.left, target, k);
        // If target node is found in left subtree
        if (leftDistance != -1) {
            // Check if the current node is at distance K from target node
            if (leftDistance + 1 == k) {
                System.out.println(root.data);
            } else {
                // Otherwise, find nodes at distance K in the right subtree
                nodesAtDistanceKDown(root.right, k - leftDistance - 2);
            }
            return 1 + leftDistance; // Return distance of the current node from target
        }

        // Recur for right subtree
        int rightDistance = nodesAtDistanceKHelper(root.right, target, k);
        // If target node is found in right subtree
        if (rightDistance != -1) {
            // Check if the current node is at distance K from target node
            if (rightDistance + 1 == k) {
                System.out.println(root.data);
            } else {
                // Otherwise, find nodes at distance K in the left subtree
                nodesAtDistanceKDown(root.left, k - rightDistance - 2);
            }
            return 1 + rightDistance; // Return distance of the current node from target
        }
        return -1; // Return -1 if target node is not found
    }

    // Main function to initiate the process
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k) {
        nodesAtDistanceKHelper(root, target, k);
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to take input and build the binary tree
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        // Queue to manage nodes during tree construction
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        // Read node data as a single line and split into an array
        String[] nodeDatas = br.readLine().trim().split(" ");

        // If the array length is 1, return null (empty tree)
        if (nodeDatas.length == 1) {
            return null;
        }

        // Parse root node data and create the root node
        int rootData = Integer.parseInt(nodeDatas[0]);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        // Add root node to the queue
        pendingNodes.add(root);

        int i = 1; // Index for accessing node data array
        // Loop until there are pending nodes in the queue
        while (!pendingNodes.isEmpty()) {
            // Remove the front node from the queue
            BinaryTreeNode<Integer> currentNode = pendingNodes.poll();

            // Parse left child data and add to the current node
            int leftChildData = Integer.parseInt(nodeDatas[i++]);
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.add(leftChild);
            }

            // Parse right child data and add to the current node
            int rightChildData = Integer.parseInt(nodeDatas[i++]);
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }

        return root; // Return the root of the constructed binary tree
    }

    // Main method to run the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Construct the binary tree from input
        BinaryTreeNode<Integer> root = takeInput();
        // Read target node and K distance values
        String[] target_k = br.readLine().trim().split(" ");

        int target = Integer.parseInt(target_k[0].trim());
        int k = Integer.parseInt(target_k[1].trim());

        // Print nodes at distance K from the target node
        nodesAtDistanceK(root, target, k);
    }
}
