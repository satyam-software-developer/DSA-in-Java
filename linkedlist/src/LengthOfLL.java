/* 
Problem statement
For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.

 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line contains the value of 'i'. It denotes the position in the given singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case, print the node data at the 'i-th' position of the linked list(if exists).

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
0
*/


/*
 * Time Complexity : O(n)
 * Space Complexity : o(n)
 * where n is size of singly linked list
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Definition of the main class LengthOfLL
public class LengthOfLL {

    // Inner class definition for Node
    static class Node {
        public int data;      // Data stored in the node
        public Node next;     // Reference to the next node in the linked list

        // Default constructor initializes data to 0 and next to null
        Node() {
            this.data = 0;
            this.next = null;
        }

        // Parameterized constructor initializes data to given value and next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Parameterized constructor initializes both data and next to given values
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Runner class
    static class Runner {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Buffered Reader for input

        // Method to take input from the user and create a linked list
        public static Node takeInput() throws IOException {
            Node head = null, tail = null;  // Initialize head and tail pointers to null

            // Read a line of input and split it into an array of strings
            String[] datas = br.readLine().trim().split("\\s");

            int i = 0;
            // Loop through the array of strings until -1 is encountered or end of array
            while (i < datas.length && !datas[i].equals("-1")) {
                int data = Integer.parseInt(datas[i]);  // Convert string to integer
                Node newNode = new Node(data);           // Create a new node with the integer data

                // If the linked list is empty, set head and tail to the new node
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    // If the linked list is not empty, append the new node to the end
                    tail.next = newNode;
                    tail = newNode;                     // Update tail to the new node
                }
                i += 1;  // Move to the next string in the array
            }

            return head;  // Return the head of the linked list
        }

        // Method to print the elements of the linked list
        public static void print(Node head) {
            // Loop through the linked list and print each element
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;  // Move to the next node
            }
            System.out.println();  // Print a new line after printing all elements
        }

        // Method to calculate the length of the linked list
        public static int length(Node head) {
            int len = 0;                                // Initialize length variable to 0
            Node temp = head;                           // Create a temporary node pointer and initialize it to head

            // Loop through the linked list and count nodes until null is reached
            while (temp != null) {
                len++;                                  // Increment length
                temp = temp.next;                       // Move to the next node
            }

            return len;                                  // Return the length of the linked list
        }
    }

    // Main method to run the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        Runner runner = new Runner();  // Create an instance of the Runner class
        int t = 1;                     // Number of test cases (set to 1 for this example)

        // Loop through each test case
        while (t > 0) {
            LengthOfLL.Node head = runner.takeInput();   // Take input and create a linked list
            System.out.println(Runner.length(head));     // Print the length of the linked list
            System.out.println();

            t -= 1;                                       // Decrement the test case counter
        }
    }
}
