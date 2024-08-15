/* Problem statement
Implement a Stack Data Structure specifically to store integer data using a Singly Linked List.

The data members should be private.

You need to implement the following public functions :

1. Constructor:
It initialises the data members as required.

2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.

3. pop() :
It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.

4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.

5. size() :
It returns the size of the stack at any given instance of time.

6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.

Operations Performed on the Stack:
Query-1(Denoted by an integer 1): Pushes an integer data to the stack.

Query-2(Denoted by an integer 2): Pops the data kept at the top of the stack and returns it to the caller.

Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the top of the stack but doesn't remove it, unlike the pop function.

Query-4(Denoted by an integer 4): Returns the current size of the stack.

Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the stack is empty or not.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints:
1 <= q <= 10^5
1 <= x <= 5
-2^31 <= data <= 2^31 - 1 and data != -1

Where 'q' is the total number of queries being performed on the stack, 'x' is the range for every query and data represents the integer pushed into the stack. 

Time Limit: 1 second
Sample Input 1:
6
1 13
1 47
4
5
2
3
Sample Output 1:
2
false
47
13
Sample Input 2:
4
5
2
1 10
5
Sample Output 2:
true
-1
false
 Explanation of Sample Input 2:
There are 4 queries in total.
The first one is Query-5: It tells whether the stack is empty or not. Since the stack is empty at this point, the output is  'true'.

The second one is Query-2: It pops the data from the stack. Since at this point in time, no data exist in the stack hence, it prints -1.

The third one is Query-1: It pushes the specified data 10 into the stack and since the function doesn't return anything, nothing is printed.

The fourth one is Query-5: It tells whether the stack is empty at this point or not. Since the stack has one element and hence it is not empty, false is printed.
				
 */

/*
 * Time complexity: O(1) [for all operations]
 * Space complexity: O(N)
 * 
 * where N is the number of operations
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
 // Node class represents each element in the stack
 class Node {
     private int data;   // Data stored in the node
     private Node next;  // Pointer to the next node
 
     // Constructor to initialize the node with data
     public Node(int data) {
         this.data = data;
         this.next = null;
     }
 
     // Getter for data
     public int getData() {
         return data;
     }
 
     // Getter for the next node
     public Node getNext() {
         return next;
     }
 
     // Setter for the next node
     public void setNext(Node next) {
         this.next = next;
     }
 }
 
 // StackUsingLL class represents the stack using a singly linked list
 public class StackUsingLL {
     private Node head; // Pointer to the top of the stack
     private int size;  // Current size of the stack
 
     // Constructor to initialize an empty stack
     public StackUsingLL() {
         this.head = null;
         this.size = 0;
     }
 
     // Pushes an element onto the stack
     public void push(int element) {
         Node newNode = new Node(element); // Create a new node with the element
         newNode.setNext(head);            // Link the new node to the current head
         head = newNode;                   // Update head to the new node
         size++;                           // Increment the size of the stack
     }
 
     // Pops the top element from the stack and returns it
     public int pop() {
         if (isEmpty()) {
             return -1; // Return -1 if the stack is empty
         }
         int data = head.getData(); // Get data from the head node
         head = head.getNext();     // Update head to the next node
         size--;                    // Decrement the size of the stack
         return data;               // Return the popped data
     }
 
     // Returns the top element without removing it
     public int top() {
         if (isEmpty()) {
             return -1; // Return -1 if the stack is empty
         }
         return head.getData(); // Return data from the head node
     }
 
     // Returns the current size of the stack
     public int size() {
         return size;
     }
 
     // Checks if the stack is empty
     public boolean isEmpty() {
         return head == null; // Return true if head is null, false otherwise
     }
 
     public static void main(String[] args) throws IOException {
         // BufferedReader for efficient input handling
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         // Initialize the stack
         StackUsingLL stack = new StackUsingLL();
 
         // Read the number of queries
         int q = Integer.parseInt(br.readLine().trim());
         // StringBuilder to store the output
         StringBuilder output = new StringBuilder();
 
         // Loop through each query
         for (int i = 0; i < q; i++) {
             // Read the entire line of input and split it into parts
             String[] query = br.readLine().trim().split(" ");
             // First part is the query type
             int choice = Integer.parseInt(query[0]);
 
             // Process the query based on the type
             switch (choice) {
                 case 1: // Push operation
                     int element = Integer.parseInt(query[1]); // Second part is the element to push
                     stack.push(element); // Push the element onto the stack
                     break;
 
                 case 2: // Pop operation
                     output.append(stack.pop()).append("\n"); // Pop the top element and add it to output
                     break;
 
                 case 3: // Top operation
                     output.append(stack.top()).append("\n"); // Get the top element and add it to output
                     break;
 
                 case 4: // Size operation
                     output.append(stack.size()).append("\n"); // Get the size and add it to output
                     break;
 
                 case 5: // IsEmpty operation
                     output.append(stack.isEmpty() ? "true" : "false").append("\n"); // Check if the stack is empty and add result to output
                     break;
 
                 default:
                     break; // Do nothing for unrecognized commands
             }
         }
 
         // Print the accumulated output
         System.out.print(output.toString());
     }
 }
 