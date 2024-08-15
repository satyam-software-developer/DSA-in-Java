/*Problem statement
Given a singly linked list of integers, reverse it using recursion and return the head to the modified list. You have to do this in O(N) time complexity where N is the size of the linked list.

 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^4
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
Sample Output 1 :
8 7 6 5 4 3 2 1
Sample Input 2 :
2
10 -1
10 20 30 40 50 -1
Sample Output 2 :
10 
50 40 30 20 10  */

/*
 *  Time Complexity : O(n)
 *  Space Complexity : O(n)
 * Where 'n' is size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLLRec {

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

    // Function to reverse a linked list recursively
    public static Node<Integer> reverseRec(Node<Integer> head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        // Reverse the rest of the list
        Node<Integer> reversed = reverseRec(head.next);
        // Reverse the link between the current node and the next node
        head.next.next = head;
        head.next = null;
        // Return the new head of the reversed list
        return reversed;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim()); // Number of test cases

        while (t > 0) {
            Node<Integer> head = takeInput(); // Take input for the linked list
            Node<Integer> newHead = reverseRec(head); // Reverse the linked list recursively
            print(newHead); // Print the reversed linked list
            t--; // Decrement the number of test cases
        }
    }
}
