
/* Problem statement
Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.

 'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

Example :
Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains a single integer depicting the value of 'k'.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= k <= M

Time Limit:  1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 9 10 -1
4


Sample Output 1 :
4 3 2 1 8 7 6 5 10 9
Sample Input 2 :
2
1 2 3 4 5 -1
0
10 20 30 40 -1
4
Sample Output 2 :
1 2 3 4 5 
40 30 20 10  */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(n / k)
 * for each Linked List of sizes n, 
 * n/k or (n/k) + 1 calls will be made during the recursion.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KReverseLL {
    // Define a Node class representing a node in the linked list
    static class Node<T> {
        T data;
        Node<T> next;

        // Constructor to initialize the data of the node
        public Node(T data) {
            this.data = data;
        }
    }

    // BufferedReader to read input from the console
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input and create a linked list
    public static Node<Integer> takeInput() throws IOException {
        Node<Integer> head = null, tail = null;

        // Read space-separated integers from input and create nodes
        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
                // If head is null, set the new node as head and tail
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, append the new node to the tail
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
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

    // Method to perform k-reverse on a linked list
    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        if (k == 0 || k == 1) {
            return head; // If k is 0 or 1, no need to reverse, return the head
        }
        Node<Integer> current = head;
        Node<Integer> fwd = null;
        Node<Integer> prev = null;

        int count = 0;

        // Reverse first k nodes of the linked list
        while (count < k && current != null) {
            fwd = current.next; // Store the next node
            current.next = prev; // Reverse the pointer of current node
            prev = current; // Move prev to current node
            current = fwd; // Move current to next node
            count++;
        }
        if (fwd != null) {
            head.next = kReverse(current, k); // Recursively call kReverse for the remaining list
        }
        return prev; // Return the new head of the reversed sublist
    }

    // Main method to read input, perform k-reverse, and print the result
    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        // Loop through each test case
        while (t > 0) {

            Node<Integer> head = takeInput(); // Read the input linked list
            int k = Integer.parseInt(br.readLine().trim()); // Read the value of k

            Node<Integer> newHead = kReverse(head, k); // Perform k-reverse
            print(newHead); // Print the reversed linked list

            t -= 1; // Decrement the number of test cases
        }

    }
}
