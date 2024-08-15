/* Problem statement
Given a linked list of 'N' nodes, which has nodes in alternating non-decreasing and non-increasing. Sort the list in non-decreasing order.

For Example:

If given linked list is 1->9->3->8->4 then it should be modified to 1->3->4->8->9.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
7
1 9 2 8 3 7 4 
Sample Output 1 :
1 2 3 4 7 8 9
Explanation to Sample Input 1 :
Since the given list is 1-> 9-> 2-> 8 -> 3 -> 7-> 4.
After sorting, it will be 1-> 2-> 3-> 4-> 7-> 8-> 9.
Sample Input 2 :
6
7 15 8 14 9 13
Sample Output 2 :
7 8 9 13 14 15    
Explanation to Sample Input 1 :
Since the given list is 7-> 15-> 8-> 14 -> 9 -> 13.
After sorting, it will be 7-> 8-> 9-> 13-> 14-> 15.
Expected Space Complexity:
Try to solve this problem in O(1) space complexity.


Constraints :
1 <= N <= 10^3
0 <= data <= 10^3 

Where 'N' is the length of the linked list.

Time Limit: 1 sec */


/*
 * Time Complexity: O(N logN)
 * Space Complexity: O(N logN)
 * Where N is number of nodes in the linked list.
 */

 import java.util.Scanner;

 // Node class for representing a node in a linked list
 class Node {
     int data;     // Data stored in the node
     Node next;    // Pointer to the next node in the list
 
     // Constructors
     Node() {
         this.data = 0;
         this.next = null;
     }
     Node(int data) {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next) {
         this.data = data;
         this.next = next;
     }
 }
 
 // Class Runner for handling input, executing sorting, and printing output
 class Runner {
     int N;        // Number of elements in the list
     Node head;    // Pointer to the head of the linked list
 
     // Method to take input from the user
     void takeInput() {
         Scanner scanner = new Scanner(System.in);
         N = scanner.nextInt();   // Read the number of elements
         head = null; // Initialize head pointer
         Node tail = null; // Pointer to the last node in the list
         int l = N;  // Counter for number of elements
         while (l-- > 0) {
             int data = scanner.nextInt(); // Read data from input
             if (data < 0) { // Check for valid input
                 System.out.println("Enter valid input"); // Display error message
                 System.exit(0); // Exit program
             }
             Node newNode = new Node(data); // Create a new node with the data
             if (head == null) { // Check if the list is empty
                 head = newNode; // Set the new node as the head
                 tail = newNode; // Set the new node as the tail
             } else {
                 tail.next = newNode; // Link the new node to the last node
                 tail = newNode; // Update the tail pointer
             }
         }
     }
 
     // Method to print the elements of the linked list
     void printList(Node head) {
         Node tail = head; // Temporary pointer to traverse the list
         while (tail != null) { // Loop until the end of the list is reached
             System.out.print(tail.data + " "); // Print the data of the current node
             tail = tail.next; // Move to the next node
         }
     }
 
     // Method to create a new copy of the linked list
     Node newLinkedList(Node head) {
         if (head == null) { // Check if the original list is empty
             return null; // Return null for an empty list
         }
         Node newLinkedList = new Node(head.data); // Create a new node with the data from the head node
         Node cur = newLinkedList; // Pointer to the current node in the new list
         head = head.next; // Move to the next node in the original list
         while (head != null) { // Loop until the end of the original list is reached
             cur.next = new Node(head.data); // Create a new node with the data from the original list
             cur = cur.next; // Move to the next node in the new list
             head = head.next; // Move to the next node in the original list
         }
         return newLinkedList; // Return the head of the new list
     }
 
    // Method to execute sorting on the linked list
void execute() {
    Node NodeCopy = newLinkedList(head); // Create a copy of the original list
    SortLinkedList sortLinkedList = new SortLinkedList(); // Instantiate SortLinkedList object
    Node ans = sortLinkedList.sortList(NodeCopy); // Sort the copied list
}

// Method to execute sorting on the original list and print the sorted list
void executeAndPrintOutput() {
    SortLinkedList sortLinkedList = new SortLinkedList(); // Instantiate SortLinkedList object
    Node ans = sortLinkedList.sortList(head); // Sort the original list
    printList(ans); // Print the sorted list
}

 }
 
 // Function to reverse a linked list
 class ReverseLinkedList {
     Node reverse(Node head) {
         Node temp = head; // Temporary pointer to traverse the list
         Node curr = head; // Pointer to the current node
         Node prev = null; // Pointer to the previous node
 
         while (temp != null) { // Loop until the end of the list is reached
             temp = temp.next; // Move to the next node
             curr.next = prev; // Update the next pointer of the current node to point to the previous node
             prev = curr; // Update the previous node pointer
             curr = temp; // Move to the next node
         }
 
         head = prev; // Update the head pointer to point to the new head of the reversed list
         return head; // Return the head of the reversed list
     }
 }
 
 // Function to merge two sorted linked lists
 class MergeSortedLinkedLists {
     Node merge(Node head1, Node head2) {
         if (head1 == null) { // If the first list is empty, return the second list
             return head2;
         }
         if (head2 == null) { // If the second list is empty, return the first list
             return head1;
         }
 
         Node h3 = null; // Pointer to the head of the merged list
         Node t3 = null; // Pointer to the tail of the merged list
 
         if (head1.data < head2.data) { // Determine the head of the merged list
             h3 = head1;
             t3 = head1;
             head1 = head1.next;
         } else {
             h3 = head2;
             t3 = head2;
             head2 = head2.next;
         }
 
         while (head1 != null && head2 != null) { // Merge the lists until one of them becomes empty
             if (head1.data < head2.data) {
                 t3.next = head1;
                 head1 = head1.next;
                 t3 = t3.next;
             } else {
                 t3.next = head2;
                 head2 = head2.next;
                 t3 = t3.next;
             }
         }
         if (head1 != null) { // If elements are remaining in the first list, append them to the merged list
             t3.next = head1;
         }
         if (head2 != null) { // If elements are remaining in the second list, append them to the merged list
             t3.next = head2;
         }
         return h3; // Return the head of the merged list
     }
 }
 
 // Function to sort a linked list in ascending order
 class SortLinkedList {
     Node sortList(Node head) {
         if (head == null || head.next == null) { // Base case: If the list is empty or contains only one element
             return head; // Return the list as it is already sorted
         }
 
         Node ascHead = null; // Pointer to the head of the ascending sublist
         Node ascTail = null; // Pointer to the tail of the ascending sublist
         Node descHead = null; // Pointer to the head of the descending sublist
         Node descTail = null; // Pointer to the tail of the descending sublist
 
         Node temp = head; // Temporary pointer to traverse the list
 
         ascHead = ascTail = temp; // Initialize the ascending sublist with the first node
         temp = temp.next; // Move to the next node
         descHead = descTail = temp; // Initialize the descending sublist with the second node
         temp = temp.next; // Move to the next node
 
         while (temp != null) { // Iterate through the remaining nodes of the list
             ascTail.next = temp; // Append the current node to the ascending sublist
             ascTail = ascTail.next; // Update the tail of the ascending sublist
             temp = temp.next; // Move to the next node
 
             if (temp != null) { // Check if there are more nodes remaining in the list
                 descTail.next = temp; // Append the current node to the descending sublist
                 descTail = descTail.next; // Update the tail of the descending sublist
                 temp = temp.next; // Move to the next node
             }
         }
 
         ascTail.next = null; // Terminate the ascending sublist
         descTail.next = null; // Terminate the descending sublist
 
         ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
         descHead = reverseLinkedList.reverse(descHead); // Reverse the descending sublist
 
         MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();
         Node ansHead = mergeSortedLinkedLists.merge(ascHead, descHead); // Merge the sorted ascending and descending sublists
 
         return ansHead; // Return the head of the sorted list
     }
 }
 
 // Main class
 public class SortLL {
     public static void main(String[] args) {
         Runner runner = new Runner(); // Create an instance of the Runner class
         runner.takeInput(); // Take input from the user
         runner.executeAndPrintOutput(); // Execute sorting and print the sorted list
     }
 }
 