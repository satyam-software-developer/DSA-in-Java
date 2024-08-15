
/* Problem statement
Given a linked list of size N. You need to reverse every k nodes (where k is an input to the function) in the linked list.

Input:

First line contains length of linked list and next line contains the linked list elements.
Output:

Single line of output which contains the linked list with every k group elements reversed.
Example:

Input:
8 1 2 2 4 5 6 7 8 4

Output:
4 2 2 1 8 7 6 5

Explanation:
Since, k = 4. So, we have to reverse every group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5. */

import java.util.*;

// Node class representing each element in the linked list
class Node {
    int data; // Data stored in the node
    Node next; // Pointer to the next node

    // Constructor to initialize the node with a value
    Node(int key) {
        data = key;
        next = null;
    }
}

public class ReverseLinkedList {

    // Method to reverse the linked list in groups of size 'k'
    public static Node reverse(Node head, int k) {
        Node prev = null; // Previous node pointer (initially null)
        Node curr = head; // Current node pointer (starting from the head)
        Node next = null; // Next node pointer to keep track of the next node
        int count = 0; // Counter to keep track of nodes processed

        // Reverse the first 'k' nodes of the linked list
        while (count < k && curr != null) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move the prev pointer forward
            curr = next; // Move the curr pointer forward
            count++; // Increment the counter
        }

        // Recursively reverse the remaining linked list and connect it back
        if (next != null) {
            head.next = reverse(next, k); // Reverse the next group and connect to the current group
        }

        // Return the new head of the reversed list
        return prev;
    }

    static Node head; // Head pointer for the linked list

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner object to read input

        int n = s.nextInt(); // Read the number of nodes in the linked list
        int a = s.nextInt(); // Read the first node value
        Node head = new Node(a); // Create the head node
        Node prev = head; // Pointer to the previous node (starting from head)

        // Loop to read the remaining node values and create the linked list
        for (int i = 0; i < n - 1; i++) {
            a = s.nextInt(); // Read the next node value
            Node newnode = new Node(a); // Create a new node
            prev.next = newnode; // Link the previous node to the new node
            prev = newnode; // Move the prev pointer forward
        }

        int k = s.nextInt(); // Read the value of 'k' (size of groups to reverse)

        // Call the reverse method to reverse the linked list in groups of size 'k'
        Node ans = reverse(head, k);
        prev = ans; // Pointer to traverse the reversed list

        // Loop to print the reversed linked list
        for (int i = 0; i < n; i++) {
            System.out.print(prev.data + " "); // Print the current node's data
            prev = prev.next; // Move the pointer to the next node
        }
    }
}
