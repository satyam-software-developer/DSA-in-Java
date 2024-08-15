/* 
Problem statement
You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'

 Write a function to add a node to the list with the 'data' at the specified position, 'pos.'

Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the position is greater than the length of the singly linked list, you should return the same linked list without any change.
 Illustration :
The following images depict how the insertion has been taken place.
Image-I :

Alt txt

Image-II :

Alt txt

Image-III :

Alt txt

Image-IV :

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the linked list separated by a single space. 

The second line contains the two integer values of 'data' and 'pos' separated by a single space, respectively
Reminder/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case, print the resulting singly linked list of integers in a row, separated by a single space.

Output for every test case will be printed in a separate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
pos >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 100
Sample Output 1 :
3 4 5 100 2 6 1 9
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0 20
10 98 7 66 8 -1
5 99
Sample Output 2 :
20 3 4 5 2 6 1 9
10 98 7 66 8 99 

*/

/*
 *   Time Complexity : O(min(i, n))
 *   Space Complexity : O(1)
 *   where 'i' is the position where the new node is to be inserted
 *   and 'n' being the size of the Singly Linked List
 * 
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
 public class InsertNodeInLL {
     
     // Definition of a generic Node class
     static class Node<T> {
         T data;          // Data stored in the node
         Node<T> next;    // Reference to the next node in the list
         
         // Constructor to initialize the node with data
         public Node(T data) {
             this.data = data;
         }
     }
     
     // Nested static class to handle input, output, and operations on LinkedList
     static class Runner {
         static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         // Method to take input and create a LinkedList
         public static Node<Integer> takeInput() throws IOException {
             Node<Integer> head = null, tail = null;  // Initializing head and tail of the LinkedList
     
             // Reading input line and splitting it by spaces
             String[] datas = br.readLine().trim().split("\\s");
     
             int i = 0;
             // Loop to iterate over input data and create nodes
             while(i < datas.length && !datas[i].equals("-1")) {
                 int data = Integer.parseInt(datas[i]);  // Parsing string data to integer
                 Node<Integer> newNode = new Node<Integer>(data);  // Creating a new node with parsed data
                 
                 // Checking if it's the first node
                 if(head == null) {
                     head = newNode;
                     tail = newNode;
                 }
                 else {
                     tail.next = newNode;  // Linking the new node to the end of the list
                     tail = newNode;        // Updating the tail to the new node
                 }
                 i += 1;  // Incrementing index to read next data
             }
     
             return head;  // Returning the head of the created LinkedList
         }
         
         // Method to print the LinkedList
         public static void print(Node<Integer> head){
             while(head != null) {  // Loop to iterate over the LinkedList
                 System.out.print(head.data + " ");  // Printing data of the current node
                 head = head.next;  // Moving to the next node
             }
             
             System.out.println();  // Printing a new line after printing all nodes
         }
         
         // Method to insert a node at a given position in the LinkedList
         public static Node<Integer> insert(Node<Integer> head, int pos, int data){
             int currPos = 0;  // Variable to keep track of current position
 
             Node<Integer> newNode = new Node<Integer>(data);  // Creating a new node with given data
 
             // Inserting at the beginning (pos = 0)
             if(pos == 0){
                 newNode.next = head;  // Linking the new node to the current head
                 head = newNode;       // Updating head to the new node
                 return head;          // Returning the updated head
             }
             
             Node<Integer> temp = head;  // Temporary node to traverse the LinkedList
             // Loop to find the node at position (pos - 1)
             while(temp != null && currPos < (pos - 1)){
                 temp = temp.next;  // Moving to the next node
                 currPos++;         // Incrementing position
             }
             
             // If reached the end of the list before finding the position
             if(temp == null){
                 return head;  // Returning the unchanged head
             }
 
             // Linking the new node to the next node at the given position
             newNode.next = temp.next;
             // Linking the previous node to the new node
             temp.next = newNode;
 
             return head;  // Returning the updated head of the LinkedList
         }
     }
     
     // Main method to execute the program
     public static void main(String[] args) throws NumberFormatException, IOException {
         Runner runner = new Runner();  // Creating an instance of the Runner class
         
         // Reading the number of test cases
         int t = Integer.parseInt(Runner.br.readLine().trim());
 
         // Loop to run the program for each test case
         while (t > 0) {
             Node<Integer> head = Runner.takeInput();  // Taking input and creating LinkedList
             String[] pos_data = Runner.br.readLine().trim().split("\\s");  // Reading position and data
 
             int pos = Integer.parseInt(pos_data[0]);  // Parsing position
             int data = Integer.parseInt(pos_data[1]);  // Parsing data
 
             head = Runner.insert(head, pos, data);  // Inserting node at given position
             Runner.print(head);  // Printing the modified LinkedList
 
             t -= 1;  // Decrementing the test case count
         }
     }
 }
 