/*Problem statement
You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.

Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
 Output format :
For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'.
 */

/*
 *  Time Complexity : O(n)
 *  Space Complexity : O(1)
 *  Where 'n' is the size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeLinkedList {

    // Node class representing a node in the linked list
    static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize a node with given data
        public Node(T data) {
            this.data = data;
        }
    }

    // BufferedReader object for input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to take input for the linked list
    public static Node<Integer> takeInput() throws IOException {
        Node<Integer> head = null, tail = null;

        // Read input data as a string, split it by whitespace, and iterate through it
        String[] datas = br.readLine().trim().split("\\s");
        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            // Create a new node with the current data
            Node<Integer> newNode = new Node<Integer>(data);
            // If the linked list is empty, set the new node as both head and tail
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, append the new node to the end of the list
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        // Return the head of the linked list
        return head;
    }

    // Function to print the linked list
    public static void print(Node<Integer> head) {
        // Iterate through the linked list and print each node's data
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to reverse a linked list
    private static Node<Integer> reverse(Node<Integer> head) {
        // Initialize previous node to null and current node to head
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        // Iterate through the list and reverse each node's pointer
        while (curr != null) {
            Node<Integer> next = curr.next; // Store the next node
            curr.next = prev; // Reverse the pointer to the previous node
            prev = curr; // Move previous to the current node
            curr = next; // Move current to the next node
        }
        // Return the new head of the reversed list
        return prev;
    }

    // Function to check if a linked list is a palindrome
    public static boolean isPalindrome(Node<Integer> head) {
        // If the list is empty or has only one node, it is a palindrome
        if (head == null || head.next == null) {
            return true;
        }
        // Find the middle of the list using slow and fast pointers
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half of the list
        Node<Integer> secondHalf = reverse(slow.next);
        // Compare the first half with the reversed second half
        Node<Integer> p1 = head;
        Node<Integer> p2 = secondHalf;
        while (p2 != null) {
            if (!p1.data.equals(p2.data)) { // If data does not match, it's not a palindrome
                return false;
            }
            p1 = p1.next; // Move p1 to the next node
            p2 = p2.next; // Move p2 to the next node
        }
        // Revert the reversed second half back to its original order
        reverse(secondHalf);
        return true; // Return true if the list is a palindrome
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        // Iterate through each test case
        while (t > 0) {
            Node<Integer> head = takeInput(); // Take input for the linked list
            boolean ans = isPalindrome(head); // Check if the list is a palindrome
            System.out.println(ans); // Print the result
            t--; // Decrement the number of test cases
        }
    }
}
