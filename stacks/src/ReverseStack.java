/* Problem statement
You have been given two stacks that can store integers as the data. Out of the two given stacks, one is populated and the other one is empty. You are required to write a function that reverses the populated stack using the one which is empty.

For Example:
Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains an integer N, denoting the total number of elements in the stack.

The second line of input contains N integers separated by a single space, representing the order in which the elements are pushed into the stack.
Output Format:
The only line of output prints the order in which the stack elements are popped, all of them separated by a single space. 
Note:
You are not required to print the expected output explicitly, it has already been taken care of. Just make the changes in the input stack itself.
Constraints:
1 <= N <= 10^3
-2^31 <= data <= 2^31 - 1

Time Limit: 1sec 
Sample Input 1:
6
1 2 3 4 5 10
Note:
Here, 10 is at the top of the stack.
Sample Output 1:
1 2 3 4 5 10
Note:
Here, 1 is at the top of the stack.
Sample Input 2:
5
2 8 15 1 10
Sample Output 2:
2 8 15 1 10 */

/*
 * Time complexity: O(N^2)
 * Space complexity: O(N)
 * 
 * where N is the size of the input stack
 */

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

    // Recursive function to reverse the input stack using an extra stack
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
        // Base case: If the stack has 1 or no elements, it's already reversed
        if (input.size() <= 1) {
            return;
        }

        // Remove the last element from the input stack
        int lastElement = input.pop();

        // Recursively reverse the remaining stack
        reverseStack(input, extra);

        // Transfer all elements from input stack to extra stack
        while (!input.isEmpty()) {
            int top = input.pop();
            extra.push(top);
        }

        // Push the last element (previously popped) onto the now-empty input stack
        input.push(lastElement);

        // Transfer all elements back from extra stack to input stack, maintaining the
        // reversed order
        while (!extra.empty()) {
            int top = extra.pop();
            input.push(top);
        }
    }

    // Function to take input from the user and create a stack with those inputs
    public static Stack<Integer> takeInput() {
        Scanner s = new Scanner(System.in);

        // Read the number of elements to be added to the stack
        int size = s.nextInt();
        Stack<Integer> input = new Stack<>();

        // If no elements are to be added, return the empty stack
        if (size == 0) {
            return input;
        }

        // Read elements and push them onto the stack
        for (int i = 0; i < size; i++) {
            int var = s.nextInt();
            input.push(var);
        }

        return input;
    }

    // Main function to test stack reversal
    public static void main(String[] args) {
        // Take input to create the initial stack
        Stack<Integer> input = takeInput();
        // Create an empty stack to use as auxiliary space for reversing
        Stack<Integer> empty = new Stack<>();

        // Reverse the input stack
        reverseStack(input, empty);

        // Print all elements from the reversed stack
        while (!input.isEmpty()) {
            System.out.print(input.pop() + " ");
        }
    }

}
