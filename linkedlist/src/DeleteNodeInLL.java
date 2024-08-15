/* 
Problem statement
You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'POS'.

Note :
Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
Illustration :
The following images depict how the deletion has been performed.
Image-I :

Alt txt

Image-II :

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains the elements of the linked list separated by a single space. 
The second line contains the integer value of 'POS'. It denotes the position in the linked list from where the node has to be deleted.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
Print the resulting linked list of integers in a row, separated by a single space.
Note:

You are not required to print the output, it has already been taken care of. Just implement the function. 
Sample Input 1 :
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Explanation of Sample Output 1 :
The data in the node with index 3 is 2 which has been removed.
Sample Input 2 :
3 4 5 2 6 1 9 -1
0
Sample Output 2 :
4 5 2 6 1 9
Constraints :
0 <= N <= 10^5
POS >= 0

Time Limit: 1sec
Expected Complexity :
Time Complexity  : O(N)
Space Complexity  : O(1)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteNodeInLL {

    // Definition of a generic Node class
    static class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Reference to the next node in the list

        // Constructor to initialize the node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Nested static class to handle input, output, and operations on LinkedList
    static class Runner {

        // BufferedReader to read input from console
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Method to take input and create a LinkedList
        public static Node<Integer> takeInput() throws IOException {
            Node<Integer> head = null, tail = null;

            // Reading input line and splitting it by spaces
            String[] datas = br.readLine().trim().split("\\s");

            // Loop to iterate over input data and create nodes
            for (String data : datas) {
                int value = Integer.parseInt(data);
                // Check for sentinel value (-1) to stop input
                if (value == -1) {
                    break;
                }
                Node<Integer> newNode = new Node<Integer>(value);

                // Checking if it's the first node
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode; // Linking the new node to the end of the list
                    tail = newNode; // Updating the tail to the new node
                }
            }

            return head; // Returning the head of the created LinkedList
        }

        // Method to print the LinkedList
        public static void print(Node<Integer> head) {
            while (head != null) { // Loop to iterate over the LinkedList
                System.out.print(head.data + " "); // Printing data of the current node
                head = head.next; // Moving to the next node
            }

            System.out.println(); // Printing a new line after printing all nodes
        }

        // Method to delete a node at a given position in the LinkedList
        public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
            // If the list is empty
            if (head == null) {
                return head;
            }

            // Deleting the head node (pos = 0)
            if (pos == 0) {
                return head.next; // Return the next node as the new head
            }

            Node<Integer> current = head; // Variable to traverse the LinkedList
            // Loop to find the node at position (pos - 1)
            for (int i = 0; i < pos - 1 && current.next != null; i++) {
                current = current.next; // Moving to the next node
            }

            // If the position is out of bounds
            if (current == null || current.next == null) {
                return head;
            }

            // Deleting the node at the given position
            Node<Integer> temp = current.next;
            current.next = temp.next;
            temp = null; // Freeing up memory by removing reference to the deleted node

            return head; // Returning the updated head of the LinkedList
        }
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = 1;

        // Loop to run the program for each test case
        while (t > 0) {
            Node<Integer> head = Runner.takeInput(); // Taking input and creating LinkedList

            int pos = Integer.parseInt(Runner.br.readLine().trim()); // Reading position to delete node
            head = Runner.deleteNode(head, pos); // Deleting node at given position
            Runner.print(head); // Printing the modified LinkedList

            t--; // Decrementing the test case count
        }
    }
}
