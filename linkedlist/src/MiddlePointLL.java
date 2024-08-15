/*Problem statement
For a given singly linked list of integers, find and return the node present at the middle of the list.

Note :
If the length of the singly linked list is even, then return the first middle node.

Example: Consider, 10 -> 20 -> 30 -> 40 is the given list, then the nodes present at the middle with respective data values are, 20 and 30. We return the first node with data 20.
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space. 
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
 Output Format :
For each test case/query, print the data value of the node at the middle of the given list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5 
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
3
Sample Input 2 :
2 
-1
1 2 3 4 -1
Sample Output 2 :
2 */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Where 'n' is the size of the Singly Linked list
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiddlePointLL {

    // Node class to represent elements of the linked list
    static class Node<T> {
        T data; // Data of the node
        Node<T> next; // Reference to the next node

        // Constructor to initialize the node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Method to take input for the linked list
    public static Node<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node<Integer> head = null, tail = null;

        // Read input line and split it by spaces
        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        // Iterate through the input data array
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]); // Parse integer from string
            Node<Integer> newNode = new Node<>(data); // Create a new node with the parsed integer data
            if (head == null) {
                head = newNode; // If it's the first node, set it as the head
                tail = newNode; // Set tail as well
            } else {
                tail.next = newNode; // If it's not the first node, link it to the previous node
                tail = newNode; // Update the tail to the newly added node
            }
            i += 1; // Move to the next element in the input array
        }

        return head; // Return the head of the linked list
    }

    // Method to print the elements of the linked list
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " "); // Print the data of the current node
            head = head.next; // Move to the next node
        }

        System.out.println(); // Print a new line after printing all elements
    }

    // Method to find the middle point of the linked list
    public static Node<Integer> midPoint(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one element, return the head itself as the
                         // mid-point
        }
        Node<Integer> slow = head; // Slow pointer initially at the head
        Node<Integer> fast = head.next; // Fast pointer initially one step ahead of slow

        // Move slow pointer one step and fast pointer two steps until fast pointer
        // reaches the end of the list
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }
        return slow; // Return the node where slow pointer is pointing, which is the middle point
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        while (t > 0) {

            Node<Integer> head = takeInput(); // Take input for the linked list

            Node<Integer> mid = midPoint(head); // Find the middle point of the linked list

            if (mid != null) {
                System.out.println(mid.data); // Print the data of the middle node
            }

            t -= 1; // Decrement the test case counter
        }
    }
}
