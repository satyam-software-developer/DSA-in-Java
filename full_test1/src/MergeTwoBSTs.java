/*Problem statement
Given two binary search trees ,merge the two given balanced BSTs into a balanced binary search tree.

Note: You just have to return the root of the balanced BST.

Give solution of O(m+n) time complexity.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 :  Elements in level order form of first tree (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2: Elements in level order form of second tree (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Print the inorder form of new BST
Sample Input 1:
2 1 3 -1 -1 -1 -1
4 -1 -1
Sample Output 1:
 1 2 3 4  */
import java.util.*;

public class MergeTwoBSTs {

    // Static exception class for handling empty queue cases
    static class QueueEmptyException extends Exception {
    }

    // Static Queue implementation
    static class Queue<T> {

        // Node class for the queue to hold data and the reference to the next node
        static class Node<T> {
            T data;
            Node<T> next;

            // Constructor to initialize the node with data
            Node(T data) {
                this.data = data;
            }
        }

        // Head and tail references for the queue
        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        // Method to get the current size of the queue
        public int size() {
            return size;
        }

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to get the front element of the queue
        // Throws an exception if the queue is empty
        public T front() throws QueueEmptyException {
            if (size == 0) {
                throw new QueueEmptyException();
            }
            return head.data;
        }

        // Method to add an element to the queue
        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);

            // If the queue is empty, set the new node as both head and tail
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode; // Link the new node to the last node
                tail = newNode; // Update the tail to the new node
            }
            size++; // Increment the size of the queue
        }

        // Method to remove and return the front element of the queue
        // Throws an exception if the queue is empty
        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                throw new QueueEmptyException();
            }
            if (head == tail) {
                tail = null; // If there's only one element, reset the tail to null
            }
            T temp = head.data;
            head = head.next; // Move the head to the next node
            size--; // Decrement the size of the queue
            return temp; // Return the data of the removed node
        }
    }

    // Static BinaryTreeNode class for tree nodes
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        // Constructor to initialize the node with data
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    // Utility function for inorder traversal of the tree
    // Prints the tree data in sorted order
    static void inorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        inorder(node.left); // Recursively traverse the left subtree
        System.out.print(node.data + " "); // Print the data
        inorder(node.right); // Recursively traverse the right subtree
    }

    // Utility Method that stores inorder traversal of a tree in a list
    public static ArrayList<Integer> storeInorderUtil(BinaryTreeNode<Integer> node, ArrayList<Integer> list) {
        if (node == null)
            return list;

        // Recur on the left child
        storeInorderUtil(node.left, list);

        // Add the node's data to the list
        list.add(node.data);

        // Recur on the right child
        storeInorderUtil(node.right, list);

        return list;
    }

    // Method that stores the inorder traversal of a tree
    static ArrayList<Integer> storeInorder(BinaryTreeNode<Integer> node) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = storeInorderUtil(node, list1); // Recursively store inorder traversal
        return list2;
    }

    // Method that merges two ArrayLists into one sorted list
    static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {
        // list3 will contain the merge of list1 and list2
        ArrayList<Integer> list3 = new ArrayList<>();
        int i = 0;
        int j = 0;

        // Traverse through both ArrayLists
        while (i < m && j < n) {
            // Add the smaller element to list3
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements of list1 into list3
        while (i < m) {
            list3.add(list1.get(i));
            i++;
        }

        // Add remaining elements of list2 into list3
        while (j < n) {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }

    // Method that converts a sorted ArrayList to a balanced BST
    static BinaryTreeNode<Integer> ALtoBST(ArrayList<Integer> list, int start, int end) {
        // Base case
        if (start > end)
            return null;

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(list.get(mid));

        // Recursively construct the left subtree and make it left child of root
        node.left = ALtoBST(list, start, mid - 1);

        // Recursively construct the right subtree and make it right child of root
        node.right = ALtoBST(list, mid + 1, end);

        return node;
    }

    // Method that merges two BSTs into a single balanced BST
    static BinaryTreeNode<Integer> mergeTrees(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
        // Store inorder traversal of tree1 in list1
        ArrayList<Integer> list1 = storeInorder(node1);

        // Store inorder traversal of tree2 in list2
        ArrayList<Integer> list2 = storeInorder(node2);

        // Merge both lists into list3
        ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());

        // Convert the merged list into a balanced BST
        return ALtoBST(list3, 0, list3.size() - 1);
    }

    // Method to print the merged BST using inorder traversal
    static void printMergeTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        BinaryTreeNode<Integer> node = mergeTrees(root1, root2); // Merge the two trees
        inorder(node); // Print the merged tree using inorder traversal
    }

    // Scanner for taking user input
    static Scanner s = new Scanner(System.in);

    // Method to take input and construct a BST from user input
    public static BinaryTreeNode<Integer> takeInput() {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new Queue<>();

        int rootData = s.nextInt(); // Take root data input
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root); // Enqueue the root node

        // Construct the tree level by level using a queue
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue(); // Dequeue the front node
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = s.nextInt(); // Take left child data input
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild; // Set the left child
                pendingNodes.enqueue(leftChild); // Enqueue the left child
            }
            int rightChildData = s.nextInt(); // Take right child data input
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild; // Set the right child
                pendingNodes.enqueue(rightChild); // Enqueue the right child
            }
        }

        return root; // Return the root of the constructed tree
    }

    // Main method to run the program
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1 = takeInput(); // Take input for the first BST
        BinaryTreeNode<Integer> root2 = takeInput(); // Take input for the second BST

        printMergeTrees(root1, root2); // Merge and print the merged BST
    }
}
