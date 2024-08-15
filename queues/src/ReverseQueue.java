/*Problem statement
You have been given a queue that can store integers as the data. You are required to write a function that reverses the populated queue itself without using any other data structures.

Example:
Alt txt

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first list of input contains an integer 't' denoting the number of test cases/queries to be run.
Then the test cases follow.

The first line input for each test case/query contains an integer N, denoting the total number of elements in the queue.

The second line of input contains N integers separated by a single space, representing the order in which the elements are enqueued into the queue.
Output Format:
For each test case/query, the only line of output prints the order in which the queue elements are dequeued, all of them separated by a single space.

Output for every test case/query will be printed on a new line. 
Note:
You are not required to print the expected output explicitly, it has already been taken care of. Just make the changes in the input queue itself.
Constraints:
1 <= t <= 100
1 <= N <= 10^4
-2^31 <= data <= 2^31 - 1

Time Limit: 1sec 
Sample Input 1:
1
6
1 2 3 4 5 10
Note:
Here, 1 is at the front and 10 is at the rear of the queue.
Sample Output 1:
10 5 4 3 2 1
Sample Input 2:
2
5
2 8 15 1 10
3
10 20 30
Sample Output 2:
10 1 15 8 2 
30 20 10  */

/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the size of the input queue
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {

    // Function to reverse the elements of the queue
    public static void reverseQueue(Queue<Integer> input) {
        // Base case: if the queue has 0 or 1 element, it is already reversed
        if (input.size() <= 1) {
            return;
        }

        // Remove the front element
        int front = input.poll();

        // Recursively reverse the remaining queue
        reverseQueue(input);

        // Add the removed element to the back of the queue
        input.add(front);
    }

    // Function to take input from the user and create a queue
    public static Queue<Integer> takeInput() {
        Scanner s = new Scanner(System.in);

        // Read the number of elements in the queue
        int n = s.nextInt();

        // Initialize a new queue
        Queue<Integer> queue = new LinkedList<>();

        // Read 'n' elements and add them to the queue
        for (int i = 0; i < n; i++) {
            int var = s.nextInt();
            queue.add(var);
        }

        return queue;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Read the number of test cases
        int t = s.nextInt();

        // Loop through all test cases
        while (t > 0) {
            // Take input to create the queue
            Queue<Integer> queue = takeInput();

            // Reverse the queue
            reverseQueue(queue);

            // Print the reversed queue
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }

            // Print a new line after each test case
            System.out.println();

            // Decrement the test case counter
            t -= 1;
        }
    }
}
