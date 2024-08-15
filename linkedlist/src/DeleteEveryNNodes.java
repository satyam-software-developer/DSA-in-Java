
/*Problem statement
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list. Indexing starts from 1.

To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list. You can return null in case where all nodes will be deleted.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains two integer values 'M,' and 'N,' respectively. A single space will separate them.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5 

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7. */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Where 'n' is size of the Singly Linked List
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteEveryNNodes {
    // Node class to represent a node in the linked list
    static class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Reference to the next node in the list

        // Constructor to initialize the node with data
        public Node(T data) {
            this.data = data;
        }
    }

    // Method to take input from the user and create a linked list
    public static Node<Integer> takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node<Integer> head = null, tail = null;

        // Read the input data separated by spaces
        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        // Iterate through the input data and create nodes for each element
        while (i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                // If head is null, assign the new node as both head and tail
                head = newNode;
                tail = newNode;
            } else {
                // Otherwise, append the new node to the end of the list
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head; // Return the head of the created linked list
    }

    // Method to print the elements of the linked list
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " "); // Print the data of the current node
            head = head.next; // Move to the next node
        }

        System.out.println(); // Print a new line after printing all elements
    }

    // Method to skip M nodes and delete N nodes in the linked list
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (M == 0 || N == 0 || head == null) {
            return head; // If M or N is 0, or the list is empty, return the original list
        }

        Node<Integer> currentNode = head; // Initialize a current node pointer to traverse the list
        Node<Integer> temp = null; // Temporary pointer to keep track of nodes to be retained

        while (currentNode != null) {
            int take = 0; // Counter to keep track of nodes to be retained
            int skip = 0; // Counter to keep track of nodes to be skipped

            // Traverse M nodes and retain them
            while (currentNode != null && take < M) {
                if (temp == null) {
                    temp = currentNode; // If temp is null, assign the current node to temp
                } else {
                    temp.next = currentNode; // Otherwise, append the current node to temp
                    temp = currentNode;
                }
                currentNode = currentNode.next; // Move to the next node
                take += 1; // Increment the take counter
            }

            // Traverse N nodes and skip them
            while (currentNode != null && skip < N) {
                currentNode = currentNode.next; // Move to the next node
                skip += 1; // Increment the skip counter
            }
        }

        if (temp != null) {
            temp.next = null; // Set the next of temp to null to terminate the list
        }
        return head; // Return the head of the modified linked list
    }

    // Main method to execute the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim()); // Read the number of test cases

        // Process each test case
        while (t > 0) {
            Node<Integer> head = takeInput(); // Take input to create the linked list
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]); // Read the value of M
            int n = Integer.parseInt(m_n[1]); // Read the value of N

            Node<Integer> newHead = skipMdeleteN(head, m, n); // Apply skipMdeleteN method to modify the list
            print(newHead); // Print the modified list

            t -= 1; // Decrement the test case count
        }
    }
}
