/* Problem statement
Given a singly linked list of integers, sort it using 'Bubble Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
0 <= M <= 10^3
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90  */

/*
 * Time Complexity : O(n^2)
 * Space Complexity : O(1)
 * Where 'n' is size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Main class for Bubble Sort on a Linked List
public class BubbleSortLL {

    // Node class representing individual elements of the linked list
    static class Node<T> {
        T data; // Data of the node
        Node<T> next; // Reference to the next node

        // Constructor to initialize node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // LinkedList class representing the linked list data structure
    static class LinkedList {
        Node<Integer> head; // Reference to the head of the linked list

        // Method to take input for the linked list
        public Node<Integer> takeInput() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Node<Integer> head = null, tail = null;

            // Read input data as a string array
            String[] datas = br.readLine().trim().split("\\s");

            // Loop through the input data array
            for (String data : datas) {
                // Break the loop if input is -1
                if (data.equals("-1"))
                    break;
                // Parse the integer value
                int val = Integer.parseInt(data);
                // Create a new node with the parsed value
                Node<Integer> newNode = new Node<>(val);
                // If the list is empty, set head and tail to the new node
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    // Otherwise, add the new node to the end of the list
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            // Return the head of the linked list
            return head;
        }

        // Method to print the elements of the linked list
        public void print(Node<Integer> head) {
            // Iterate through the linked list
            while (head != null) {
                // Print the data of the current node
                System.out.print(head.data + " ");
                // Move to the next node
                head = head.next;
            }
            // Print a new line after printing all elements
            System.out.println();
        }

        // Method to calculate the length of the linked list
        private int length(Node<Integer> head) {
            int count = 0;
            // Iterate through the linked list and count nodes
            while (head != null) {
                head = head.next;
                count++;
            }
            // Return the count of nodes
            return count;
        }

        // Method to perform bubble sort on the linked list
        public Node<Integer> bubbleSort(Node<Integer> head) {
            // Get the length of the linked list
            int n = length(head);

            // Outer loop for passes
            for (int i = 0; i < n - 1; i++) {
                Node<Integer> prev = null;
                Node<Integer> curr = head;

                // Inner loop for comparisons
                for (int j = 0; j < n - i - 1; j++) {
                    // Compare current node with the next node
                    if (curr.data <= curr.next.data) {
                        prev = curr;
                        curr = curr.next;
                    } else {
                        // Swap nodes if necessary
                        if (prev == null) {
                            Node<Integer> fwd = curr.next;
                            head = head.next;
                            curr.next = fwd.next;
                            fwd.next = curr;
                            prev = fwd;
                        } else {
                            Node<Integer> fwd = curr.next;
                            prev.next = fwd;
                            curr.next = fwd.next;
                            fwd.next = curr;
                            prev = fwd;
                        }
                    }
                }
            }
            // Return the head of the sorted linked list
            return head;
        }
    }

    // Main method
    public static void main(String[] args) throws IOException {
        // Create an instance of the LinkedList class
        LinkedList list = new LinkedList();
        // Take input for the linked list and get its head
        Node<Integer> head = list.takeInput();
        // Perform bubble sort on the linked list
        head = list.bubbleSort(head);
        // Print the sorted linked list
        list.print(head);
    }
}
