/*Problem statement
Amit has been working with an organization called 'Money Traders' for the past few years. The organization is into the money trading business. His manager assigned him a task. For a given array/list of stock's prices for N days, find the stock's span for each day.

The span of the stock's price today is defined as the maximum number of consecutive days(starting from today and going backwards) for which the price of the stock was less than today's price.

For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85], then the stock spans will be [1, 1, 1, 2, 1, 4, 6].

Explanation:
On the sixth day when the price of the stock was 75, the span came out to be 4, because the last 4 prices(including the current price of 75) were less than the current or the sixth day's price.

Similarly, we can deduce the remaining results.
Amit has to return an array/list of spans corresponding to each day's stock's price. Help him to achieve the task.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains an integer N, denoting the total number of days.

The second line of input contains the stock prices of each day. A single space will separate them.
Output Format:
The only line of output will print the span for each day's stock price. A single space will separate them.
Note:
You are not required to print the expected output explicitly. It has already been taken care of. Just store the values of output in the spans array.
Constraints:
0 <= N <= 10^7
1 <= X <= 10^9
Where X denotes the stock's price for a day.

Time Limit: 1 second
Sample Input 1:
4
10 10 10 10
Sample Output 1:
1 1 1 1 
Sample Input 2:
8
60 70 80 100 90 75 80 120
Sample Output 2:
1 2 3 4 1 1 2 8  */

/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * where N is the number of days
 */

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

    // Method to calculate stock span values for each day
    public static int[] stockSpan(int[] price) {
        Stack<Integer> stk = new Stack<>(); // Stack to keep track of indices of days
        int n = price.length; // Total number of days

        int[] output = new int[n]; // Array to store span values

        stk.push(0); // Push the index of the first day to the stack
        output[0] = 1; // Span of the first day is always 1

        // Iterate through the price array from the second day
        for (int i = 1; i < n; ++i) {
            // Pop elements from stack while stack is not empty and the current price
            // is greater than the price at index stored at the top of the stack
            while (!stk.isEmpty() && price[stk.peek()] < price[i]) {
                stk.pop();
            }
            // If stack is empty, it means no earlier day has a higher price
            // So the span is the number of days including today
            if (stk.isEmpty()) {
                output[i] = i + 1;
            } else {
                // Otherwise, the span is the difference between the current day
                // and the index of the last higher price
                output[i] = i - stk.peek();
            }
            // Push the current day index onto the stack
            stk.push(i);
        }
        return output; // Return the array containing span values
    }

    // Method to take input from the user
    public static int[] takeInput() {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input
        int size = s.nextInt(); // Read the size of the input array
        int[] input = new int[size]; // Create an array to hold the prices

        // If size is 0, return the empty array
        if (size == 0) {
            return input;
        }
        // Read the prices from the user and store them in the array
        for (int i = 0; i < size; i++) {
            input[i] = s.nextInt();
        }

        return input; // Return the array of prices
    }

    // Method to print the elements of an array
    public static void printArray(int[] arr) {
        // Iterate through the array and print each element
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Print a newline after printing all elements
    }

    public static void main(String[] args) {
        int[] input = takeInput(); // Read the input prices from the user

        int[] output = stockSpan(input); // Calculate the stock spans

        printArray(output); // Print the span values
    }
}
