/*Problem statement
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions and return the new head to the list.

Note :
1. Remember, You need to swap the nodes, not only the data.
2. Indexing starts from 0.
3. No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains two integer values 'i,' and 'j,' respectively. A single space will separate them.
 Remember/consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9 
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40 
90 80 90 25 65 85 70  */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Where 'n' is size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapTwoNodesOfLL {

    // Inner class representing a node of the linked list
    static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize a node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Method to take input for the linked list
    public static Node<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node<Integer> head = null, tail = null;

        // Read input data separated by space
        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        // Iterate through input data until encountering "-1"
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Node<Integer> newNode = new Node<>(data);
            // If the linked list is empty, set the new node as head and tail
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode; // Append the new node to the end of the list
                tail = newNode; // Update tail to the new node
            }
            i += 1;
        }

        return head; // Return the head of the linked list
    }

    // Method to print the linked list
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " "); // Print the data of the current node
            head = head.next; // Move to the next node
        }
        System.out.println(); // Print a newline after printing the entire list
    }

    // Method to swap two nodes in a linked list
    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        // Check if the indices are the same or the list is empty
        if (i == j || head == null) {
            return head; // Return the original list if no swapping is required
        }

        Node<Integer> currentNode = head, prev = null;
        Node<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;

        int pos = 0;

        // Traverse the list to find the nodes at indices i and j
        while (currentNode != null && (firstNode == null || secondNode == null)) {
            if (pos == i) {
                firstNodePrev = prev;
                firstNode = currentNode;
            } else if (pos == j) {
                secondNodePrev = prev;
                secondNode = currentNode;
            }

            prev = currentNode;
            currentNode = currentNode.next;
            pos += 1;
        }

        // Check if both nodes are found
        if (firstNode == null || secondNode == null) {
            // One or both of the nodes are not found, so return the original list
            return head;
        }

        // Adjust the pointers to swap the nodes
        if (firstNodePrev != null) {
            firstNodePrev.next = secondNode;
        } else {
            head = secondNode;
        }
        if (secondNodePrev != null) {
            secondNodePrev.next = firstNode;
        } else {
            head = firstNode;
        }

        // Perform the actual swapping of the nodes
        Node<Integer> currentfirstNode = secondNode.next;
        secondNode.next = firstNode.next;
        firstNode.next = currentfirstNode;

        return head; // Return the head of the modified linked list
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            Node<Integer> head = takeInput();
            String[] i_j = br.readLine().trim().split("\\s");

            int i = Integer.parseInt(i_j[0]); // Index of the first node to be swapped
            int j = Integer.parseInt(i_j[1]); // Index of the second node to be swapped

            Node<Integer> newHead = swapNodes(head, i, j); // Call the method to swap nodes
            print(newHead); // Print the modified linked list

            t -= 1; // Decrement the test case count
        }
    }
}
