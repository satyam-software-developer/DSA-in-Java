/*Problem statement
 Given a singly linked list of integers, sort it using 'Merge Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90  */

/*
 * Time Complexity : O(n * logn)
 * Space Complexity : O(logn)
 * Where 'n' is size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortLL {
    // Define the Node class for a generic linked list
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // BufferedReader for taking input from the user
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input for the linked list
    public static Node<Integer> takeInput() throws IOException {
        Node<Integer> head = null, tail = null;

        // Read input line and split it by space to get individual integers
        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        // Iterate through the input array and create nodes
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Node<Integer> newNode = new Node<Integer>(data);
            // If head is null, set the new node as head and tail
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

        return head;
    }

    // Method to print the linked list
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Method to find the middle node of a linked list
    private static Node<Integer> findMid(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Method to merge two sorted linked lists
    private static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node<Integer> newHead = null, newTail = null;
        // Determine the head of the merged list based on the smaller first element
        if (head1.data <= head2.data) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }

        // Merge the two lists by iterating through both lists
        while (head1 != null && head2 != null) {
            // Compare the first elements of both lists and append the smaller one to the
            // merged list
            if (head1.data <= head2.data) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }

        // If one list is longer than the other, append the remaining nodes to the
        // merged list
        if (head1 != null) {
            newTail.next = head1;
        }
        if (head2 != null) {
            newTail.next = head2;
        }

        // Advance newTail to the last node of the merged list
        while (newTail.next != null) {
            newTail = newTail.next;
        }

        return newHead; // Return the head of the merged list
    }

    // Method to perform merge sort on a linked list
    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Find the middle node of the linked list
        Node<Integer> mid = findMid(head);

        // Split the linked list into two halves from the middle node
        Node<Integer> half1 = head;
        Node<Integer> half2 = mid.next;
        mid.next = null;

        // Recursively sort both halves of the linked list
        half1 = mergeSort(half1);
        half2 = mergeSort(half2);

        // Merge the sorted halves
        Node<Integer> finalHead = merge(half1, half2);

        return finalHead;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            // Take input for each test case
            Node<Integer> head = takeInput();

            // Perform merge sort on the linked list
            Node<Integer> newHead = mergeSort(head);

            // Print the sorted linked list
            print(newHead);

            t -= 1;
        }
    }
}
