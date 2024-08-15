/*Problem statement
For a given singly linked list of integers, arrange the nodes such that all the even number nodes are placed after the all odd number nodes. The relative order of the odd and even terms should remain unchanged.

Note :
1. No need to print the linked list, it has already been taken care. Only return the new head to the list.
2. Don't create a new linked list.
3.  Just change the data, instead rearrange the provided list.
Detailed explanation ( Input/output format, Notes, Images )
Input format:
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space. 
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format:
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 4 5 2 -1
Sample Output 1 :
1 5 4 2 
Sample Input 2 :
2
1 11 3 6 8 0 9 -1
10 20 30 40 -1
Sample Output 2 :
1 11 3 9 6 8 0
10 20 30 40 */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Where 'n' is the size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenAfterOddLL {
    // Node class to define the structure of each node in the linked list
    static class Node<T> {
        T data; // data stored in the node
        Node<T> next; // reference to the next node in the list

        // Constructor to initialize a node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Method to take input for the linked list
    public static Node<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node<Integer> head = null, tail = null; // Initialize head and tail pointers to null

        String[] datas = br.readLine().trim().split("\\s"); // Read input data as string array

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) { // Iterate over the data array until -1 is encountered
            int data = Integer.parseInt(datas[i]); // Parse string data to integer
            Node<Integer> newNode = new Node<>(data); // Create a new node with the parsed data

            if (head == null) { // If the list is empty, set the new node as both head and tail
                head = newNode;
                tail = newNode;
            } else { // Otherwise, append the new node to the end of the list
                tail.next = newNode;
                tail = newNode;
            }
            i += 1; // Move to the next element in the input array
        }

        return head; // Return the head of the constructed list
    }

    // Method to print the elements of the linked list
    public static void print(Node<Integer> head) {
        while (head != null) { // Traverse the list until reaching the end (null)
            System.out.print(head.data + " "); // Print the data of the current node
            head = head.next; // Move to the next node
        }

        System.out.println(); // Print a new line after printing all elements
    }

    // Method to rearrange the linked list such that all even numbers appear after
    // odd numbers
    public static Node<Integer> evenAfterOdd(Node<Integer> head) {
        if (head == null) { // If the list is empty, return null
            return null;
        }

        // Initialize pointers for even and odd lists
        Node<Integer> evenHead = null, oddHead = null, evenTail = null, oddTail = null;

        while (head != null) { // Traverse the original list
            if (head.data % 2 == 0) { // If the current node's data is even
                if (evenHead == null) { // If the even list is empty, set the current node as its head and tail
                    evenHead = head;
                    evenTail = head;
                } else { // Otherwise, append the current node to the end of the even list
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            } else { // If the current node's data is odd
                if (oddHead == null) { // If the odd list is empty, set the current node as its head and tail
                    oddHead = head;
                    oddTail = head;
                } else { // Otherwise, append the current node to the end of the odd list
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            }
            head = head.next; // Move to the next node in the original list
        }

        if (oddHead == null) { // If there are no odd nodes, return the even list
            return evenHead;
        } else { // Otherwise, concatenate the even list to the end of the odd list
            oddTail.next = evenHead;
        }

        if (evenHead != null) { // If the even list is not empty, set its tail's next pointer to null to
                                // terminate the list
            evenTail.next = null;
        }

        return oddHead; // Return the head of the rearranged list
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        while (t > 0) { // Iterate over each test case
            Node<Integer> head = takeInput(); // Take input for the linked list

            Node<Integer> newHead = evenAfterOdd(head); // Rearrange the linked list
            print(newHead); // Print the rearranged list

            t -= 1; // Move to the next test case
        }

        br.close(); // Close the BufferedReader to release system resources
    }
}
