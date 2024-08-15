/* Problem statement
1. You are given two linked lists. Data of each node of these linked lists contain a digit from the range: [0, 9].

2. The linked lists represent two numbers.

3. You have to print the product of these two numbers.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
Input has already been managed for cpp and java submissions. In cpp and java, you have to just write a function which receives head nodes of two linked lists. The sizes of linked lists are N and M, respectively.
For other languages, the first line of input contains list of N space separated integers, terminated by -1. The following line of input also contains list of M space separated integers, terminated by -1. The integers form the data of nodes of two linked list.   
Constraints:
N and M lies in the range: [1, 1000].
0 <= |Node Data| <= 9
Output format:
Print the product of numbers, represented by two linked lists.
Sample Input:
1 2 3 4 5 -1
1 2 3 -1
Sample Output:
1 5 1 8 4 3 5 */

/*
 * Linked List Node Class
 * 
 * class LinkedListNode<T>{
 *   T data;
 *   LinkedListNode<T> next;
 * 
 *    public LinkedListNode(T data){
 * 
 *        this.data = data;
 *        this.next = null;
 *    }
 * }
 */

import java.util.Scanner;

public class MultiplyTwoLinkedLists {

    // Class representing a node in a linked list
    static class LinkedListNode<T> {
        T data; // Data of the node
        LinkedListNode<T> next; // Reference to the next node

        // Constructor to initialize a node with data
        public LinkedListNode(T data) {
            this.data = data;
            this.next = null; // Initialize next as null
        }
    }

    // Method to calculate the length of a linked list
    private static int length(LinkedListNode<Integer> head) {
        int len = 0; // Initialize length counter
        while (head != null) { // Traverse the list until the end
            len += 1; // Increment length counter
            head = head.next; // Move to the next node
        }
        return len; // Return the length of the list
    }

    // Method to reverse a linked list iteratively
    private static LinkedListNode<Integer> reverseIteratively(LinkedListNode<Integer> head) {
        if (head == null) { // Check if the list is empty
            return null; // Return null if the list is empty
        }
        LinkedListNode<Integer> prev = null; // Initialize previous node as null
        LinkedListNode<Integer> curr = head; // Start with the head node
        LinkedListNode<Integer> currNext = curr.next; // Reference to the next node

        // Traverse the list and reverse pointers
        while (curr != null && currNext != null) {
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move previous to the current node
            curr = currNext; // Move current to the next node
            currNext = currNext.next; // Move next to the next node's next
        }

        if (curr != null) { // Check if the current node is not null
            curr.next = prev; // Reverse the last node's pointer
        }

        return curr; // Return the new head of the reversed list
    }

    // Method to create a linked list of a given size initialized with zeros
    private static LinkedListNode<Integer> makeLLOfSize(int n) {
        int nc = 0; // Initialize node counter

        LinkedListNode<Integer> head = null; // Initialize head of the list
        LinkedListNode<Integer> tail = null; // Initialize tail of the list

        // Create 'n' nodes initialized with zero
        while (nc < n) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(0); // Create a new node with data 0

            if (head == null) { // If the list is empty
                head = newNode; // Set new node as head
                tail = newNode; // Set new node as tail
            } else {
                tail.next = newNode; // Add new node to the end of the list
                tail = newNode; // Update the tail reference
            }
            nc += 1; // Increment node counter
        }
        return head; // Return the head of the list
    }

    // Method to add a node with value 0 at the beginning of the linked list
    private static LinkedListNode<Integer> addFirst(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(0); // Create a new node with data 0
        if (head == null) { // If the list is empty
            head = newNode; // Set new node as head
        } else {
            newNode.next = head; // Point new node to the current head
            head = newNode; // Update head to the new node
        }
        return head; // Return the new head of the list
    }

    // Method to multiply two linked lists representing numbers
    public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        head1 = reverseIteratively(head1); // Reverse the first linked list
        head2 = reverseIteratively(head2); // Reverse the second linked list

        int len1 = length(head1); // Get the length of the first list
        int len2 = length(head2); // Get the length of the second list

        LinkedListNode<Integer> first = head1; // Pointer to traverse the first list
        LinkedListNode<Integer> second = head2; // Pointer to traverse the second list

        int carry = 0; // Initialize carry for multiplication
        LinkedListNode<Integer> res1 = makeLLOfSize(len1 + len2 + 1); // Initialize the result list

        // Outer loop to traverse the second list
        while (second != null) {
            LinkedListNode<Integer> res2 = makeLLOfSize(len1 + len2 + 1); // Initialize a temporary result list
            first = head1; // Reset first pointer to head1
            LinkedListNode<Integer> temp2 = res2; // Pointer to traverse the temporary result list
            LinkedListNode<Integer> temp1 = res1; // Pointer to traverse the main result list
            carry = 0; // Reset carry

            // Inner loop to traverse the first list and perform multiplication
            while (first != null) {
                int ans = temp1.data + carry + second.data * first.data; // Calculate the product and add carry
                temp2.data = ans % 10; // Store the unit place of the result
                carry = ans / 10; // Update carry with the remaining part
                temp2 = temp2.next; // Move to the next node in the temporary result list
                temp1 = temp1.next; // Move to the next node in the main result list
                first = first.next; // Move to the next node in the first list
            }
            if (carry != 0) { // If there is any carry left after the inner loop
                int ans = temp1.data + carry; // Add carry to the current node
                temp2.data = ans; // Store the result
            }

            res1 = res2; // Update the main result list
            head1 = addFirst(head1); // Add a leading zero to the first list

            second = second.next; // Move to the next node in the second list
        }

        res1 = reverseIteratively(res1); // Reverse the result list

        printL(res1); // Print the result
    }

    // Method to print a linked list
    private static void printL(LinkedListNode<Integer> head) {
        if (head == null) { // Check if the list is empty
            return; // Return if the list is empty
        }
        // Skip leading zeros
        while (head != null && head.data == 0) {
            head = head.next; // Move to the next node if the current node is zero
        }
        // Print remaining nodes
        while (head != null) {
            System.out.print(head.data + " "); // Print the data of the current node
            head = head.next; // Move to the next node
        }
        System.out.println(); // Print a newline after the list
    }

    // Method to take input from the user and create a linked list
    public static LinkedListNode<Integer> takeInput(Scanner s) {
        LinkedListNode<Integer> head = null; // Initialize head of the list
        LinkedListNode<Integer> tail = null; // Initialize tail of the list

        int data = s.nextInt(); // Read data from the user

        // Create nodes until the user enters -1
        while (data != -1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data); // Create a new node with the input data

            if (head == null) { // If the list is empty
                head = newNode; // Set new node as head
                tail = newNode; // Set new node as tail
            } else {
                tail.next = newNode; // Add new node to the end of the list
                tail = newNode; // Update the tail reference
            }
            data = s.nextInt(); // Read next data from the user
        }
        return head; // Return the head of the list
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object for input

        // Take input for the two linked lists
        LinkedListNode<Integer> head1 = takeInput(s); // Read first linked list
        LinkedListNode<Integer> head2 = takeInput(s); // Read second linked list

        // Multiply the two linked lists
        multiply(head1, head2); // Call the multiply method

        s.close(); // Close the Scanner object
    }
}
