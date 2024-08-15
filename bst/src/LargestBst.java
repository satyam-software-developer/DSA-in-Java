
/*Problem statement
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.

Note :
The binary tree will be consisting of only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
The first and only line of output contains the height of the largest BST.
Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^6
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1


Sample Output 1:
2 */
/*
 * Time complexity: O(N)
 * Space complexity: O(H)
 * 
 * where N is the number of nodes in the input BST
 * and H is the height of the input BST
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.StringTokenizer;
 
 // Class to store information about the largest BST subtree
 class BstSubtreeReturn {
     int max; // Maximum value in the subtree
     int min; // Minimum value in the subtree
     int height; // Height of the subtree
     boolean isBST; // Boolean flag to check if the subtree is a BST
 }
 
 public class LargestBst {
 
     // Custom exception for an empty queue
     static class QueueEmptyException extends Exception {
     }
 
     // Custom queue implementation using linked list
     static class QueueUsingLL<T> {
 
         // Node class for the queue
         static class Node<T> {
             T data; // Data stored in the node
             Node<T> next; // Reference to the next node
 
             Node(T data) {
                 this.data = data;
             }
         }
 
         private Node<T> head; // Head of the queue
         private Node<T> tail; // Tail of the queue
         private int size = 0; // Size of the queue
 
         // Method to return the size of the queue
         public int size() {
             return size;
         }
 
         // Method to check if the queue is empty
         public boolean isEmpty() {
             return size == 0;
         }
 
         // Method to get the front element of the queue
         public T front() throws QueueEmptyException {
             if (size == 0) {
                 throw new QueueEmptyException();
             }
             return head.data;
         }
 
         // Method to add an element to the queue
         public void enqueue(T element) {
             Node<T> newNode = new Node<>(element); // Create a new node with the element
             if (head == null) { // If the queue is empty, set both head and tail to the new node
                 head = newNode;
                 tail = newNode;
             } else { // Otherwise, add the new node to the end of the queue
                 tail.next = newNode;
                 tail = newNode;
             }
             size++; // Increment the size of the queue
         }
 
         // Method to remove an element from the queue
         public T dequeue() throws QueueEmptyException {
             if (head == null) { // If the queue is empty, throw an exception
                 throw new QueueEmptyException();
             }
             if (head == tail) { // If the queue has only one element, set tail to null
                 tail = null;
             }
             T temp = head.data; // Store the data of the head node
             head = head.next; // Move the head to the next node
             size--; // Decrement the size of the queue
             return temp; // Return the data of the removed node
         }
     }
 
     // Binary tree node class
     static class BinaryTreeNode<T> {
         T data; // Data stored in the node
         BinaryTreeNode<T> left; // Left child of the node
         BinaryTreeNode<T> right; // Right child of the node
 
         public BinaryTreeNode(T data) {
             this.data = data;
         }
     }
 
     // Method to find the largest BST subtree
     public static BstSubtreeReturn largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
         if (root == null) {
             BstSubtreeReturn ans = new BstSubtreeReturn();
             ans.max = Integer.MIN_VALUE; // Set max to minimum integer value
             ans.min = Integer.MAX_VALUE; // Set min to maximum integer value
             ans.isBST = true; // An empty tree is considered a BST
             ans.height = 0; // Height of an empty tree is 0
             return ans;
         }
 
         // Recursively find the largest BST in the left and right subtrees
         BstSubtreeReturn left = largestBSTSubtreeHelper(root.left);
         BstSubtreeReturn right = largestBSTSubtreeHelper(root.right);
 
         // Check if the right subtree is a BST and its min value is greater than root's data
         if (!(right.isBST && right.min > root.data)) {
             right.isBST = false;
         }
         // Check if the left subtree is a BST and its max value is less than root's data
         if (!(left.isBST && left.max < root.data)) {
             left.isBST = false;
         }
 
         BstSubtreeReturn ans = new BstSubtreeReturn();
 
         // If either left or right subtree is not a BST, or root's data is not in the correct range
         if (!left.isBST || !right.isBST || root.data < left.max || root.data > right.min) {
             // Return the larger subtree
             if (left.height > right.height) {
                 left.isBST = false;
                 return left;
             } else {
                 right.isBST = false;
                 return right;
             }
         }
 
         // If the current tree is a BST
         ans.isBST = true;
         ans.min = Math.min(left.min, Math.min(right.min, root.data)); // Update min value
         ans.max = Math.max(left.max, Math.max(right.max, root.data)); // Update max value
         ans.height = Math.max(left.height, right.height) + 1; // Update height
         return ans;
     }
 
     // Method to find the height of the largest BST subtree
     public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
         return largestBSTSubtreeHelper(root).height;
     }
 
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     static StringTokenizer st;
 
     // Method to take input and build the binary tree
     public static BinaryTreeNode<Integer> takeInput() throws IOException {
         st = new StringTokenizer(br.readLine());
         int rootData = Integer.parseInt(st.nextToken()); // Read the root data
         if (rootData == -1) {
             return null; // If root data is -1, return null
         }
         QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
         BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // Create the root node
         pendingNodes.enqueue(root); // Add the root node to the queue
 
         while (!pendingNodes.isEmpty()) {
             BinaryTreeNode<Integer> currentNode;
             try {
                 currentNode = pendingNodes.dequeue(); // Dequeue the front node
             } catch (QueueEmptyException e) {
                 return null;
             }
             int leftChildData = Integer.parseInt(st.nextToken()); // Read the left child data
             if (leftChildData != -1) {
                 BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                 currentNode.left = leftChild; // Set the left child
                 pendingNodes.enqueue(leftChild); // Add the left child to the queue
             }
             int rightChildData = Integer.parseInt(st.nextToken()); // Read the right child data
             if (rightChildData != -1) {
                 BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                 currentNode.right = rightChild; // Set the right child
                 pendingNodes.enqueue(rightChild); // Add the right child to the queue
             }
         }
         return root; // Return the root of the constructed tree
     }
 
     // Main method to drive the program
     public static void main(String[] args) throws IOException {
         BinaryTreeNode<Integer> root = takeInput(); // Take input to construct the binary tree
         System.out.println(largestBSTSubtree(root)); // Print the height of the largest BST subtree
     }
 }
 