
/* Problem statement
Miss. Noor Rashid is a teacher. She wants to give some chocolates to the students in her class. All the students sit in a line, and each of them has a score according to performance. Noor wants to give at least one chocolate to each student. She distributes chocolates to them such that If two students sit next to each other, then the one with the higher score must get more chocolates. Miss. Noor wants to save money, so she wants to minimize the total number of chocolates.

Note :
When two students have an equal score, they are allowed to have a different number of chocolates. 
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of the input contains an integer value of N. It denotes the total number of students in Noor's class.

The second line of the input contains N integer values denoting the score of each of the students. A single space will separate them.
Output Format:
Print the minimum number of chocolates Noor must give.
Constraints
1 <= N <= 10^5
1 <= score <= 10^5

Time Limit: 1 sec
Sample Input 1 :
4
1 4 4 6
Sample Output 1 :
6
Explanation:
One of the ways in which the chocolates can be distributed, such Noor has to give minimum number of chocolates, are: The first student can be given one chocolate, second student can be given two chocolates, third student can be one chocolate and fourth can be given two chocolates.  
Sample Input 2 :
3
8 7 5
Sample Output 2 :
6 */

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * where n is the number of elements in input array
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfChocolates {

    // Method to find the minimum number of chocolates needed
    public static int getMin(int arr[], int N) {
        int[] dp = new int[N]; // Array to store chocolates for each student

        // Every student should get at least one chocolate initially
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // Traverse from left to right to satisfy increasing score condition
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // Traverse from right to left to satisfy decreasing score condition
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        // Sum up the total number of chocolates needed
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dp[i];
        }

        return sum; // Return the total chocolates required
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for fast input

    // Method to take input for the scores of students
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim()); // Read the number of students
        int[] input = new int[size]; // Initialize the array for scores

        if (size == 0) { // If there are no students, return the empty array
            return input;
        }

        // Read the scores from input
        String[] strNums = br.readLine().split("\\s");
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input; // Return the array of scores
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput(); // Take input for the scores
        System.out.print(getMin(arr, arr.length)); // Print the minimum number of chocolates needed
    }
}
