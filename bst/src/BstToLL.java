
/* Problem statement
Given a BST, convert it into a sorted linked list. You have to return the head of LL.

Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first and only line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
Output Format:
The first and only line of output prints the elements of sorted linked list.
Constraints:
Time Limit: 1 second
1<=n<=10^5
Note:
In case if you are facing any issue to solve this problem, please prefer to use the helper function.
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1


Sample Output 1:
2 5 6 7 8 10 */

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
import java.util.LinkedList;
import java.util.Queue;

// Custom exception for handling empty queue scenarios
class QueueEmptyException extends Exception {
}

// Queue implementation using linked list
class QueueUsingLL<T> {
    // Node class to represent each element in the queue
    static class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Pointer to the next node in the queue

        Node(T data) {
            this.data = data;
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

    // Returns the front element of the queue without removing it
    public T front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return head.data;
    }

    // Adds an element to the end of the queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Removes and returns the front element of the queue
    public T dequeue() throws QueueEmptyException {
        if (head == null) {
            throw new QueueEmptyException();
        }
        if (head == tail) {
            tail = null;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}

// Node class for Binary Tree
class BinaryTreeNode<T> {
    T data; // Data stored in the node
    BinaryTreeNode<T> left; // Pointer to the left child
    BinaryTreeNode<T> right; // Pointer to the right child

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

// Node class for Linked List
class LinkedListNode<T> {
    T data; // Data stored in the node
    LinkedListNode<T> next; // Pointer to the next node in the linked list

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class BstToLL {

    // Helper function to add a new node to the linked list
    public static LinkedListNode<Integer> addNode(BinaryTreeNode<Integer> currBSTNode,
            LinkedListNode<Integer> currLLNode) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(currBSTNode.data);
        currLLNode.next = newNode;
        return newNode;
    }

    // Helper function to convert BST to linked list using in-order traversal
    public static LinkedListNode<Integer> helper(BinaryTreeNode<Integer> currBSTNode,
            LinkedListNode<Integer> currLLNode) {
        if (currBSTNode == null) {
            return currLLNode;
        }

        // Traverse the left subtree
        currLLNode = helper(currBSTNode.left, currLLNode);

        // Add current BST node to linked list
        currLLNode = addNode(currBSTNode, currLLNode);

        // Traverse the right subtree
        currLLNode = helper(currBSTNode.right, currLLNode);

        return currLLNode;
    }

    // Main function to construct linked list from BST
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        // Dummy head to simplify edge cases
        LinkedListNode<Integer> dummyHead = new LinkedListNode<>(-1);
        // Convert the BST to a linked list
        helper(root, dummyHead);
        // Return the next node after dummy head as the real head of the linked list
        return dummyHead.next;
    }

    // Function to take level order input and construct BST
    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        // Queue to manage nodes for level order traversal
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = pendingNodes.poll();

            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.add(leftChild);
            }

            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        // Read input and construct the BST
        BinaryTreeNode<Integer> root = takeInput();
        // Convert the BST to a sorted linked list
        LinkedListNode<Integer> head = constructLinkedList(root);

        // Print the sorted linked list
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
