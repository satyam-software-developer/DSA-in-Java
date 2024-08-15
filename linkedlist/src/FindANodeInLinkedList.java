/*
Problem statement
You have been given a singly linked list of integers. Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.

Note :
Assume that the Indexing for the singly linked list always starts from 0.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 'T' which denotes the number of test cases. 

The first line of each test case or query contains the elements of the singly linked list separated by a single space. 

The second line contains the integer value 'N'. It denotes the data to be searched in the given singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence -1 would never be a list element.
Output format :
For each test case, return the index/position of 'N' in the singly linked list. Return -1, otherwise.

Output for every test case will be printed in a separate line.
Note:
You do not need to print anything; it has already been taken care of. Just implement the given function.
 Constraints :
1 <= T <= 10^2
0 <= M <= 10^5

Where 'M' is the size of the singly linked list.

Time Limit: 1 sec
Sample Input 1 :
2
3 4 5 2 6 1 9 -1
5
10 20 30 40 50 60 70 -1
6
Sample Output 1 :
2
-1
 Explanation for Sample Output 1:
In test case 1, 'N' = 5 appears at position 2 (0-based indexing) in the given linked list.

In test case 2, we can see that 'N' = 6 is not present in the given linked list.
Sample Input 2 :
2
1 -1
2
3 4 5 2 6 1 9 -1
6
Sample Output 2 :
-1
4
 Explanation for Sample Output 2:
In test case 1, we can see that 'N' = 2 is not present in the given linked list.

In test case 2, 'N' = 6 appears at position 4 (0-based indexing) in the given linked list.
*/

/*
 *  Time Complexity : O(N)
 *  Space Complexity : O(1)
 * 
 * Where 'N' is the size of singly linked list.
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
 public class FindANodeInLinkedList {
 
     // Define a static nested class for the Node of the LinkedList.
     static class Node<T> {
         T data;          // Data of the node
         Node<T> next;    // Reference to the next node in the LinkedList
 
         // Constructor to initialize a node with given data
         public Node(T data) {
             this.data = data;
         }
     }
 
     // Define a static nested class for the Runner to perform operations on LinkedList.
     static class Runner {
 
         // Method to take input for the LinkedList
         public static Node<Integer> takeInput() throws IOException {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
             Node<Integer> head = null, tail = null;  // Initialize head and tail pointers as null
 
             // Read input line and split it into array of strings
             String[] datas = br.readLine().trim().split("\\s");
 
             int i = 0;
             // Iterate through the array until "-1" is encountered or end of array
             while (i < datas.length && !datas[i].equals("-1")) {
                 int data = Integer.parseInt(datas[i]);  // Convert string to integer
                 Node<Integer> newNode = new Node<Integer>(data);  // Create a new node with the data
 
                 // If it's the first node, set it as head and tail
                 if (head == null) {
                     head = newNode;
                     tail = newNode;
                 } else {
                     // Otherwise, add the node to the end of the list and update the tail
                     tail.next = newNode;
                     tail = newNode;
                 }
 
                 i += 1;  // Move to the next element in the array
             }
 
             return head;  // Return the head of the constructed LinkedList
         }
 
         // Method to print the LinkedList
         public static void print(Node<Integer> head) {
             while (head != null) {
                 System.out.print(head.data + " ");  // Print the data of the current node
                 head = head.next;  // Move to the next node
             }
 
             System.out.println();  // Print a newline after printing all nodes
         }
 
         // Method to find the position of a node with given data in the LinkedList
         public static int findNode(Node<Integer> head, int n) {
             int pos = 0;  // Initialize position counter to 0
 
             // Traverse the LinkedList until the end
             while (head != null) {
                 // If the current node's data matches the target data, return the position
                 if (head.data.equals(n)) {
                     return pos;
                 }
                 head = head.next;  // Move to the next node
                 pos++;  // Increment the position counter
             }
             return -1;  // Return -1 if the target data is not found in the LinkedList
         }
     }
 
     // Main method to execute the program
     public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         int t = Integer.parseInt(br.readLine().trim());  // Read the number of test cases
 
         // Iterate through each test case
         while (t > 0) {
 
             Node<Integer> head = Runner.takeInput();  // Take input for the LinkedList
             int n = Integer.parseInt(br.readLine().trim());  // Read the target data to find
 
             // Find and print the position of the target data in the LinkedList
             System.out.println(Runner.findNode(head, n));
 
             t -= 1;  // Decrement the test case counter
         }
     }
 }
 