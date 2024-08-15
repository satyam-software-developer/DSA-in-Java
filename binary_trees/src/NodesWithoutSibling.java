/* Problem statement
For a given Binary Tree of type integer, print all the nodes without any siblings.

Example Input :
1 4 5 6 -1 -1 7 20 30 80 90 -1 -1 -1 -1 -1 -1 -1 -1
Explanation:
The input tree when represented in a two-dimensional plane, it would look like this:     
alt txt

In respect to the root, node data in the left subtree that satisfy the condition of not having a sibling would be 6, taken in a top-down sequence. Similarly, for the right subtree, 7 is the node data without any sibling.

Since we print the siblings in the left-subtree first and then the siblings from the right subtree, taken in a top-down fashion, we print 6 7.
Example Output:
6 7  
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints the node data in a top to down fashion with reference to the root. 
Node data in the left subtree will be printed first and then the right subtree.
A single space will separate them all.
 Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
9     */

/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the tree
 * and H is the height of the tree.
 * 
 * H is equal to log(N) for a balanced tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NodesWithoutSibling {

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

    // Method to print all nodes without siblings
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        // If the left child is null and right child is not null, print the right child
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        }
        // If the left child is not null and right child is null, print the left child
        else if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }
        // Recursively print nodes without siblings for the left and right subtrees
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to construct the binary tree from level-order input
    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        // Queue to manage the nodes while constructing the tree
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        int start = 0;

        // Read the entire input line and split it into individual node values
        String[] nodeDatas = br.readLine().trim().split(" ");

        // If there is only one element and it is -1, the tree is empty
        if (nodeDatas.length == 1 && nodeDatas[0].equals("-1")) {
            return null;
        }

        // Parse the root data and create the root node
        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        // Add the root node to the queue
        pendingNodes.add(root);

        // Loop until there are no more nodes to process in the queue
        while (!pendingNodes.isEmpty()) {
            // Remove the front node from the queue
            BinaryTreeNode<Integer> currentNode = pendingNodes.poll();

            // Parse the left child data
            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;
            // If the left child is not null, create the node and add it to the queue
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.add(leftChild);
            }

            // Parse the right child data
            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;
            // If the right child is not null, create the node and add it to the queue
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }

        // Return the root of the constructed tree
        return root;
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Construct the binary tree from the input
        BinaryTreeNode<Integer> root = takeInput();

        // Print nodes without siblings
        printNodesWithoutSibling(root);
    }
}
