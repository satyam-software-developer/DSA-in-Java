/*Problem statement
Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.

 Note :
Assume that the Indexing for the linked list always starts from 0.

No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
 input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains a single integer depicting the value of 'i'.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M

Time Limit:  2 sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Sample Input 2 :
2
30 -1
0
10 20 30 50 60 -1
4
Sample Output 2 :
10 20 30 50  */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Where 'n' is size of the Singly  Linked List
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteNodeRecursively {

    // Inner class representing a node in the linked list
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

    // Function to delete a node recursively at the given position
    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
        // If the list is empty or position is invalid, return head
        if (head == null || pos < 0) {
            return head;
        }
        // If position is 0, return the next node (delete the current node)
        if (pos == 0) {
            return head.next;
        }
        // Recursively call the function for the next node with decremented position
        head.next = deleteNodeRec(head.next, pos - 1);
        return head;
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        // Iterate through each test case
        while (t > 0) {
            Node<Integer> head = takeInput(); // Take input for the linked list
            int pos = Integer.parseInt(br.readLine().trim()); // Read the position of the node to delete
            Node<Integer> newHead = deleteNodeRec(head, pos); // Delete node recursively
            print(newHead); // Print the modified linked list
            t--; // Decrement the number of test cases
        }
    }
}
