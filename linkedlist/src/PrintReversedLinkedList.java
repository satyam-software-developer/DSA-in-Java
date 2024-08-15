/*Problem statement
You have been given a singly linked list of integers. Write a function to print the list in a reverse order.

To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.

Note :
You can’t change any of the pointers in the linked list, just print the linked list in the reverse order.
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Output format :
For each test case, print the singly linked list of integers in a reverse fashion, in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^3


Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
Sample Input 2 :
2
1 2 3 -1
10 20 30 40 50 -1
Sample Output 2 :
3 2 1
50 40 30 20 10 */

/*
 *  Time Complexity : O(n)
 *  Space Complexity : O(n)
 *  Where 'n' is the size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintReversedLinkedList {

    // Define a generic Node class for the linked list
    static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize a node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Define a static nested class called Runner
    static class Runner {

        // BufferedReader to read input
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Method to take input for linked list from the user
        public static Node<Integer> takeInput() throws IOException {
            Node<Integer> head = null, tail = null;

            // Read input line and split it by space to get individual data elements
            String[] datas = br.readLine().trim().split("\\s");

            int i = 0;
            // Loop through the input data until "-1" is encountered
            while (i < datas.length && !datas[i].equals("-1")) {
                int data = Integer.parseInt(datas[i]);
                Node<Integer> newNode = new Node<Integer>(data);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                i += 1;
            }

            return head; // Return the head of the linked list
        }

        // Method to print the linked list
        public static void print(Node<Integer> head) {
            while (head != null) {
                System.out.print(head.data + " "); // Print data of the current node
                head = head.next; // Move to the next node
            }

            System.out.println(); // Print a newline after printing the linked list
        }

        // Method to print the linked list in reverse order using recursion
        public static void printReverse(Node<Integer> root) {
            if (root == null) {
                return; // Base case: If the root is null, return
            }
            printReverse(root.next); // Recursively call printReverse on the next node
            System.out.print(root.data + " "); // Print the data of the current node
        }
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        // Iterate through each test case
        while (t > 0) {
            Node<Integer> head = Runner.takeInput(); // Take input for linked list
            Runner.printReverse(head); // Print the linked list in reverse order
            System.out.println(); // Print a newline after printing each test case

            t -= 1; // Decrement the test case count
        }
    }
}
