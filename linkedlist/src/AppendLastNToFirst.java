/* Problem statement
You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.

Hint:
Identify how many pointers you require and try traversing them to right places and connect nodes accordingly also don't forget to disconnect what's required else it could create cycles.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space. 

The second line contains the integer value 'N'. It denotes the number of nodes to be moved from last to the front of the singly linked list.
Output format :
For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
0 <= N < M
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
2
1 2 3 4 5 -1
3
10 20 30 40 50 60 -1
5
Sample Output 1 :
3 4 5 1 2
20 30 40 50 60 10
Sample Input 2 :
1
10 6 77 90 61 67 100 -1
4
Sample Output 2 :
90 61 67 100 10 6 77 
 Explanation to Sample Input 2 :
We have been required to move the last 4 nodes to the front of the list. Here, "90->61->67->100" is the list which represents the last 4 nodes. When we move this list to the front then the remaining part of the initial list which is, "10->6->77" is attached after 100. Hence, the new list formed with an updated head pointing to 90. 
*/

/*
   Time Complexity : O(n)
   Space Complexity : O(1)
   Where 'n' is the size of the Singly Linked List

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendLastNToFirst {

    // Define a nested static class for the nodes of the linked list
    static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize the node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Function to take input and create a linked list
    public static Node<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node<Integer> head = null, tail = null;

        // Read the input line and split it into array of strings
        String[] datas = br.readLine().trim().split("\\s");

        // Loop through the array to create nodes and link them
        for (String data : datas) {
            // Break the loop if "-1" is encountered
            if (data.equals("-1")) {
                break;
            }
            // Convert string data to integer
            int val = Integer.parseInt(data);
            // Create a new node with the integer data
            Node<Integer> newNode = new Node<>(val);
            // If head is null, set the new node as head and tail
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, link the new node to the existing list and update the tail
                tail.next = newNode;
                tail = newNode;
            }
        }
        // Return the head of the linked list
        return head;
    }

    // Function to print the linked list
    public static void print(Node<Integer> head) {
        // Loop through the list and print each node's data
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        // Move to the next line after printing all nodes
        System.out.println();
    }

    // Function to compute the length of the linked list
    public static int length(Node<Integer> head) {
        int len = 0;
        // Loop through the list and increment length for each node
        while (head != null) {
            len++;
            head = head.next;
        }
        // Return the computed length
        return len;
    }

    // Function to append the last N nodes to the beginning of the linked list
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
        // Return if the list is empty or n is non-positive
        if (head == null || n <= 0) {
            return head;
        }

        // Compute the length of the linked list
        int len = length(head);

        // Handle cases where n is greater than or equal to the length of the list
        n = n % len;

        // If n becomes 0 after modulo operation, return the original list
        if (n == 0) {
            return head;
        }

        // Initialize fast and slow pointers to head
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        // Store the initial head to be used later
        Node<Integer> initialHead = head;

        // Move fast pointer to the Nth node
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers till fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Store the new head after appending
        Node<Integer> newHead = slow.next;
        // Disconnect the list from the slow pointer
        slow.next = null;
        // Connect the end of the list to the initial head
        fast.next = initialHead;

        // Return the new head of the modified list
        return newHead;
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        // Loop through each test case
        while (t > 0) {
            // Take input for the linked list
            Node<Integer> head = takeInput();
            // Read the value of N
            int n = Integer.parseInt(br.readLine().trim());
            // Append the last N nodes to the first
            head = appendLastNToFirst(head, n);
            // Print the modified linked list
            print(head);
            // Decrement the test case count
            t--;
        }
    }
}
