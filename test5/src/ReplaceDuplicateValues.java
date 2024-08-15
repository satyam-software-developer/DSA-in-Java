/* Problem statement
Given a linked list that contain some random integers from 1 to n with many duplicates. You need to replace each duplicate element that is present in the linked list with the values n+1, n+2, and so on (starting from left to right in given LL).

For eg. if input linked list is
1 3 1 4 4 2 1 -1
updated linked list should be -
1 3 5 4 6 2 7
n in the list is 4, so I have to replace each duplicate from left to right with 4, 5 and so on. In that way, element 1 (which is at index 2) will be replaced by 5, element 4 (which is present at index 4) by 6 and element 1 (which is present at index 6) by 7. You don't need to print the elements, just update the elements in LL.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Linked list elements (separated by space and terminated by-1)
Output Format :
Updated LL elements (separated by space)
Sample Input 1 :
1 3 1 4 4 2 1 -1
Sample Output 1 :
1 3 5 4 6 2 7 */

import java.util.Scanner;

// This class is named ReplaceDuplicateValues and is declared public, meaning it can be accessed from outside this file.
public class ReplaceDuplicateValues {

    // This static inner class represents a node in a singly linked list.
    static class LinkedListNode<T> {
        public T data;  // Data stored in the node.
        public LinkedListNode<T> next;  // Reference to the next node in the list.

        // Constructor to initialize the node with data.
        public LinkedListNode(T data) {
            this.data = data;
            this.next = null;  // Initially, there is no next node.
        }
    }

    // Scanner object for taking input from the user.
    private static Scanner s = new Scanner(System.in);

    // Method to input a linked list from the user.
    public static LinkedListNode<Integer> input() {
        int data = s.nextInt();  // Read the first integer input.

        LinkedListNode<Integer> head = null;  // Head of the linked list.
        LinkedListNode<Integer> tail = null;  // Tail of the linked list.
        // Continue taking input until -1 is encountered.
        while (data != -1) {
            // Create a new node with the input data.
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            // If the linked list is empty, make the new node the head and tail.
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {  // Otherwise, add the new node to the end of the list.
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();  // Read the next integer input.
        }
        return head;  // Return the head of the linked list.
    }

    // Method to print the elements of a linked list.
    public static void print(LinkedListNode<Integer> head) {
        // Traverse the linked list and print each node's data.
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;  // Move to the next node.
        }
    }

    // Method to replace duplicate values in the linked list.
    public static void changeLL(LinkedListNode<Integer> head) {
        int max = 0;  // Variable to store the maximum value encountered in the list.
        LinkedListNode<Integer> temp = head;  // Temporary node for traversing the list.
        // Find the maximum value in the linked list.
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        // Boolean array to keep track of whether a value has been encountered before.
        boolean[] done = new boolean[max + 1];
        // Initialize the array to false.
        for (int i = 0; i <= max; i++) {
            done[i] = false;
        }
        temp = head;  // Reset temp to the head of the list.
        // Traverse the list again to replace duplicate values.
        while (temp != null) {
            if (done[temp.data]) {  // If the value has been encountered before, replace it.
                temp.data = max + 1;  // Replace the duplicate value with max + 1.
                max++;  // Increment max.
            } else {  // Otherwise, mark the value as encountered.
                done[temp.data] = true;
            }
            temp = temp.next;  // Move to the next node.
        }
    }

    // Main method where the program execution begins.
    public static void main(String[] args) {
        LinkedListNode<Integer> head = input();  // Input a linked list.
        changeLL(head);  // Replace duplicate values.
        print(head);  // Print the modified linked list.
    }
}
