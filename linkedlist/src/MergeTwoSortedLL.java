/* Problem statement
You have been given two sorted(in ascending order) singly linked lists of integers.

Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.

Note :
Try solving this in O(1) auxiliary space.

No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the first sorted singly linked list separated by a single space. 

The second line of the input contains the elements of the second sorted singly linked list separated by a single space. 
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output :
For each test case/query, print the resulting sorted singly linked list, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists. 

Time Limit: 1sec
Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12 
Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2 :
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100 */

/*
 * Time Complexity : O(N + M)
 * Space Complexity : O(1)
 * Where 'N' and 'M' are the sizes of the first and second Singly Linked Lists respectively.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoSortedLL {

    // Define a nested static class for the nodes of the linked list
    static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize a node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Create a static BufferedReader object for taking input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to take input for a linked list and return its head
    public static Node<Integer> takeInput() throws IOException {
        Node<Integer> head = null, tail = null;

        // Read input data as strings and split them by space
        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        // Loop through the input data array until reaching the end marker "-1"
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]); // Convert string data to integer
            Node<Integer> newNode = new Node<Integer>(data); // Create a new node with the data
            if (head == null) {
                head = newNode; // If head is null, assign newNode as head and tail
                tail = newNode;
            } else {
                tail.next = newNode; // Otherwise, add newNode to the end of the list
                tail = newNode; // Update tail to newNode
            }
            i += 1; // Move to the next input data
        }

        return head; // Return the head of the linked list
    }

    // Function to print the elements of a linked list
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " "); // Print the data of the current node
            head = head.next; // Move to the next node
        }
        System.out.println(); // Print a newline after printing all elements
    }

    // Function to merge two sorted linked lists
    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
        // If one of the lists is empty, return the other list
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // Initialize pointers for the new merged list
        Node<Integer> newHead = null, newTail = null;

        // Determine the head of the merged list based on the smaller first element
        if (head1.data <= head2.data) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }

        // Merge the two lists by iterating through both lists
        while (head1 != null && head2 != null) {
            // Compare the first elements of both lists and append the smaller one to the
            // merged list
            if (head1.data <= head2.data) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }

        // If one list is longer than the other, append the remaining nodes to the
        // merged list
        if (head1 != null) {
            newTail.next = head1;
        }
        if (head2 != null) {
            newTail.next = head2;
        }

        // Advance newTail to the last node of the merged list
        while (newTail.next != null) {
            newTail = newTail.next;
        }

        return newHead; // Return the head of the merged list
    }

    // Main method to take input, merge two sorted lists, and print the merged list
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            // Take input for the two sorted linked lists
            Node<Integer> head1 = takeInput();
            Node<Integer> head2 = takeInput();

            // Merge the two sorted linked lists
            Node<Integer> newHead = mergeTwoSorteds(head1, head2);

            // Print the merged list
            print(newHead);

            t -= 1; // Decrement the test case count
        }
    }
}
