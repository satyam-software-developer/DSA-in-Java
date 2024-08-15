/*
Problem statement
You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.

Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements(in ascending order) of the singly linked list separated by a single space.
 Output format :
For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
1
1 2 3 3 3 3 4 4 4 5 5 7 -1
Sample Output 1 :
1 2 3 4 5 7 
Sample Input 2 :
2
10 20 30 40 50 -1
10 10 10 10 -1
Sample Output 2 :
10 20 30 40 50
10 
*/

/*
 *  Time Complexity : O(n)
 *  Space Complexity : O(1)
 * Where 'n' is the size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EliminateDuplicates {

    // Define a static inner class for a linked list node
    static class Node<T> {
        T data; // Data of the node
        Node<T> next; // Reference to the next node in the linked list

        // Constructor to initialize the node with data
        public Node(T data) {
            this.data = data; // Set the data
            this.next = null; // Initialize next as null
        }
    }

    // Define a static inner class to handle operations related to the linked list
    static class Runner {

        // Initialize a static BufferedReader object to read input from the console
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Method to take input and create a linked list
        public static Node<Integer> takeInput() throws IOException {
            Node<Integer> head = null, tail = null; // Initialize head and tail as null

            // Read input line, trim and split by spaces
            String[] datas = br.readLine().trim().split("\\s");

            int i = 0; // Initialize loop counter
            // Iterate over the input data array
            while (i < datas.length && !datas[i].equals("-1")) {
                int data = Integer.parseInt(datas[i]); // Parse integer from string
                Node<Integer> newNode = new Node<Integer>(data); // Create a new node with the parsed data

                // If the head is null, set the new node as head and tail
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    // Otherwise, set the new node as the next node of tail and update tail
                    tail.next = newNode;
                    tail = newNode;
                }
                i += 1; // Increment loop counter
            }

            return head; // Return the head of the linked list
        }

        // Method to print the linked list
        public static void print(Node<Integer> head) {
            // Iterate over the linked list until head is null
            while (head != null) {
                System.out.print(head.data + " "); // Print data of the current node
                head = head.next; // Move to the next node
            }

            System.out.println(); // Print a new line after printing all nodes
        }

        // Method to remove duplicates from the linked list
        public static Node<Integer> removeDuplicates(Node<Integer> head) {
            // If the head is null, return null
            if (head == null) {
                return head;
            }
            Node<Integer> currHead = head; // Initialize current head as head of the linked list

            // Iterate over the linked list until the next node of current head is null
            while (currHead.next != null) {
                // If the data of current head and its next node are equal
                if (currHead.data.equals(currHead.next.data)) {
                    // Remove the next node by updating the next reference of current head
                    currHead.next = currHead.next.next;
                } else {
                    // Otherwise, move to the next node
                    currHead = currHead.next;
                }
            }
            return head; // Return the head of the modified linked list
        }
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Initialize BufferedReader object
        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        // Iterate over the test cases
        while (t > 0) {
            Node<Integer> head = Runner.takeInput(); // Take input and create a linked list
            head = Runner.removeDuplicates(head); // Remove duplicates from the linked list
            Runner.print(head); // Print the modified linked list

            t -= 1; // Decrement the number of test cases
        }
    }
}
