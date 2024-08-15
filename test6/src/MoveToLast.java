/* Problem statement
Given a linked list and a key in it, the task is to move all occurrences of given key to end of linked list, keeping order of all other elements same.

Return the updated head of LL.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : Elements of the linked list ending with -1 (-1 not included)
Line 2 : Key n, Element which has to shifted
Output Format :
Updated linked list
Constraints :
1 <= size of list <= 100

Sample Input 1:
1 2 2 3 4 5 -1
2
Sample Output 1:
1 3 4 5 2 2 
Sample Input 2:
1 1 2 3 4 -1
1
Sample Output 2:
2 3 4 1 1 */

import java.util.Scanner;

public class MoveToLast {

    // Inner class representing a node in the linked list
    static class Node<T> {
        public T data; // Data held by the node
        public Node<T> next; // Reference to the next node in the list

        // Constructor to initialize a new node with given data
        public Node(T data) {
            this.data = data;
        }
    }

    // Function to move all occurrences of 'n' to the end of the list
    public static Node<Integer> func(Node<Integer> head, int n) {
        if (head == null) { // If the list is empty, return null
            return null;
        }

        Node<Integer> temp = head, prev = null, last = null;
        int len = 1;

        // Find the length of the list and the last node
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        last = temp; // Set the last node
        temp = head;

        // Iterate through the list to move 'n' to the end
        for (int i = 0; i < len; i++) {
            if (temp.data == n) { // If current node's data is 'n'
                if (prev == null) { // If 'n' is at the head of the list
                    head = head.next; // Move head to the next node
                    last.next = temp; // Link the current node to the end
                    temp = head; // Move to the next node
                    last = last.next; // Update the last node
                    last.next = null; // Ensure the last node points to null
                } else { // If 'n' is not at the head
                    prev.next = temp.next; // Bypass the current node
                    last.next = temp; // Link the current node to the end
                    temp = temp.next; // Move to the next node
                    last = last.next; // Update the last node
                    last.next = null; // Ensure the last node points to null
                }
            } else { // If current node's data is not 'n'
                prev = temp; // Move to the next node
                temp = temp.next;
            }
        }
        return head; // Return the modified list
    }

    // Function to create a linked list from user input
    public static Node<Integer> createlist(Scanner s) {
        Node<Integer> head = null; // Initialize head of the list
        Node<Integer> rear = null; // Initialize rear of the list
        int data = s.nextInt(); // Read the first data item
        while (data != -1) { // Continue until -1 is entered
            Node<Integer> newnode = new Node<Integer>(data); // Create a new node
            if (head == null) { // If list is empty, set new node as head
                head = newnode;
                rear = head;
            } else { // If list is not empty, append the new node to the end
                rear.next = newnode;
                rear = rear.next;
            }
            data = s.nextInt(); // Read the next data item
        }
        return head; // Return the created list
    }

    // Function to print the linked list
    public static void print(Node<Integer> head) {
        while (head != null) { // Iterate through the list
            System.out.print(head.data + " "); // Print current node's data
            head = head.next; // Move to the next node
        }
        System.out.println(); // Print a new line at the end
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for input
        Node<Integer> head1 = createlist(s); // Create a list from user input
        int n = s.nextInt(); // Read the value to be moved to the end
        head1 = func(head1, n); // Move all occurrences of 'n' to the end
        print(head1); // Print the modified list
        s.close(); // Close the Scanner object
    }
}
