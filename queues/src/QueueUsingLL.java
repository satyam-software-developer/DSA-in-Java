
/* Problem statement
Implement a Queue Data Structure specifically to store integer data using a Singly Linked List.

The data members should be private.

You need to implement the following public functions :

1. Constructor:
It initialises the data members as required.

2. enqueue(data) :
This function should take one argument of type integer. It enqueues the element into the queue and returns nothing.

3. dequeue() :
It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.

4. front() :
It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.

5. getSize() :
It returns the size of the queue at any given instance of time.

6. isEmpty() :
It returns a boolean value indicating whether the queue is empty or not.

Operations Performed on the Stack:
Query-1(Denoted by an integer 1): Enqueues an integer data to the queue.

Query-2(Denoted by an integer 2): Dequeues the data kept at the front of the queue and returns it to the caller.

Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the front of the queue but doesn't remove it, unlike the dequeue function.

Query-4(Denoted by an integer 4): Returns the current size of the queue.

Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the queue is empty or not.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line contains an integer 'q' which denotes the number of queries to be run against each operation on the queue. 
Then the test cases follow.

Every 'q' lines represent an operation that needs to be performed.

For the enqueue operation, the input line will contain two integers separated by a single space, representing the type of the operation in integer and the integer data being enqueued into the queue.

For the rest of the operations on the queue, the input line will contain only one integer value, representing the query being performed on the queue.
Output Format:
For Query-1, you do not need to return anything.
For Query-2, prints the data being dequeued from the queue.
For Query-3, prints the data kept on the front of the queue.
For Query-4, prints the current size of the queue.
For Query-5, prints 'true' or 'false'(without quotes).

Output for every query will be printed in a separate line.
 Note:
You are not required to print anything explicitly. It has already been taken care of. Just implement the functions.
Constraints:
1 <= q <= 10^5
1 <= x <= 5
-2^31 <= data <= 2^31 - 1 and data != -1

Where 'q' is the total number of queries being performed on the queue, 'x' is the range for every query and data represents the integer pushed into the queue. 

Time Limit: 1 second
Sample Input 1:
7
1 17
1 23
1 11
2
2
2
2
Sample Output 1:
17
23
11
-1
Sample Input 2:
3
2
1 10
4
Sample Output 2:
-1 
1 */

/*
 * Time complexity: O(1) [for all operations]
 * Space complexity: O(N)
 * 
 * where N is the number of operations
 */

 import java.util.Scanner; // Import Scanner class for reading input

 // Node class representing each element in the queue
 class Node {
     int data; // Data of the node
     Node next; // Reference to the next node
 
     // Constructor to initialize the node
     public Node(int data) {
         this.data = data;
         this.next = null;
     }
 }
 
 // Queue implementation using a linked list
 public class QueueUsingLL {
     private Node head; // Head (front) of the queue
     private Node tail; // Tail (rear) of the queue
     private int size; // Size of the queue
 
     // Constructor to initialize an empty queue
     public QueueUsingLL() {
         this.head = null;
         this.tail = null;
         this.size = 0;
     }
 
     // Method to get the size of the queue
     public int getSize() {
         return this.size;
     }
 
     // Method to check if the queue is empty
     public boolean isEmpty() {
         return this.size == 0;
     }
 
     // Method to add an element to the queue
     public void enqueue(int data) {
         Node newNode = new Node(data); // Create a new node with the given data
         if (this.head == null) { // If the queue is empty
             this.head = newNode; // Set both head and tail to the new node
             this.tail = newNode;
         } else {
             this.tail.next = newNode; // Link the new node at the end of the queue
             this.tail = newNode; // Update the tail to the new node
         }
         this.size++; // Increment the size of the queue
     }
 
     // Method to remove an element from the queue
     public int dequeue() {
         if (this.isEmpty()) {
             return -1; // Return -1 if the queue is empty
         }
         int ans = this.head.data; // Get the data from the front node
         this.head = this.head.next; // Move the head to the next node
         this.size--; // Decrement the size of the queue
         if (this.head == null) { // If queue becomes empty after dequeue
             this.tail = null; // Reset tail to null
         }
         return ans; // Return the dequeued data
     }
 
     // Method to get the front element of the queue
     public int front() {
         if (this.isEmpty()) {
             return -1; // Return -1 if the queue is empty
         }
         return this.head.data; // Return the data at the front of the queue
     }
 
     // Main method to run the queue operations
     public static void main(String[] args) {
         Scanner s = new Scanner(System.in); // Create a Scanner object to read input
         QueueUsingLL queue = new QueueUsingLL(); // Create an instance of QueueUsingLL
 
         int q = s.nextInt(); // Read the number of operations
 
         while (q > 0) {
             int choice = s.nextInt(); // Read operation choice
 
             switch (choice) {
                 case 1:
                     int input = s.nextInt(); // Read the element to enqueue
                     queue.enqueue(input); // Enqueue the element
                     break;
 
                 case 2:
                     System.out.println(queue.dequeue()); // Dequeue and print the result
                     break;
 
                 case 3:
                     System.out.println(queue.front()); // Get and print the front element
                     break;
 
                 case 4:
                     System.out.println(queue.getSize()); // Get and print the size of the queue
                     break;
 
                 default:
                     System.out.println(queue.isEmpty() ? "true" : "false"); // Check if the queue is empty
                     break;
             }
 
             q--; // Decrement the number of remaining operations
         }
 
         s.close(); // Close the scanner
     }
 }
 