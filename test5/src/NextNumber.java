/*Problem statement
Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).

Note: You don't need to print the elements, just update the elements and return the head of updated LL. Input Constraints:
1 <= Length of Linked List <=10^6.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements 
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0  */

import java.util.Scanner;

public class NextNumber {

    // Inner static class representing a node in the linked list
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        // Constructor to initialize a node with data
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    // Static nested class for the runner
    public static class Runner {
        static Scanner s = new Scanner(System.in);

        // Method to take input for a linked list from the user
        public static LinkedListNode<Integer> takeInput() {
            LinkedListNode<Integer> head = null, tail = null;
            int data = s.nextInt();
            // Loop to take input until -1 is encountered
            while (data != -1) {
                LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
                // If it's the first node
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    // If it's not the first node, attach it to the end of the list
                    tail.next = newNode;
                    tail = newNode;
                }
                data = s.nextInt();
            }
            return head;
        }

        // Method to print the linked list
        public static void print(LinkedListNode<Integer> head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }

        // Method to reverse a linked list
        static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
            LinkedListNode<Integer> current = head;
            LinkedListNode<Integer> prev = null;
            while (current != null) {
                LinkedListNode<Integer> temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            return prev;
        }

        // Method to find the next large number in the linked list
        public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
            head = reverse(head);
            int carry = 1, num;
            LinkedListNode<Integer> ptr = head, prev = null;
            while (ptr != null) {
                num = ((ptr.data) + carry) % 10;
                carry = ((ptr.data) + carry) / 10;
                ptr.data = num;
                prev = ptr;
                ptr = ptr.next;
            }
            if (carry == 1) {
                // If there's a carry after traversing the list, add a new node with value 1
                LinkedListNode<Integer> tail = new LinkedListNode<Integer>(carry);
                prev.next = tail;
            }
            return reverse(head);
        }

        // Main method to execute the program
        public static void main(String[] args) {
            // Take input for the linked list
            LinkedListNode<Integer> head = takeInput();
            // Find the next large number
            head = nextLargeNumber(head);
            // Print the result
            print(head);
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        // Call the main method of the Runner class to start the program
        Runner.main(args);
    }
}
