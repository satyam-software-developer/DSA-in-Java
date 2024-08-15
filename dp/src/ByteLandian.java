/*Problem statement
Byteland has a very strange monetary system.

Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).

You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.

You have one gold coin. What is the maximum amount of American dollars you can get for it?

Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first and the only line of input contains a the integer value of 'n'. It is the number written on your coin.
Output format :
Print the the maximum amount of American dollars you can make.
Constraints :
0 <= n <= 10 ^ 9

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
13
Explanation of Sample Output 1 :
 You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
Sample Input 2 :
2
Sample Output 1 :
2
Explanation of Sample Output 2 :
If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them. It is better just to change the 2 coin directly into $2. */
/*
 * Time complexity: O(log(N))
 * Space complexity: O(log(N))
 * 
 * where N is the number of initial bytelandian gold coins
 */

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteLandian {

    // Method to calculate the maximum American dollars for a given Bytelandian coin
    // value
    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Base case: if n is 0 or 1, return n as it is
        if (n <= 1) {
            return n;
        }

        // Check if the value is already computed and stored in the memoization map
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calculate the value by breaking the coin into three parts: n/2, n/3, and n/4
        long breakDownValue = bytelandian(n / 2, memo) + bytelandian(n / 3, memo) + bytelandian(n / 4, memo);

        // Store the maximum value between the original coin value and the broken down
        // value in the memoization map
        memo.put(n, Math.max(n, breakDownValue));

        // Return the computed value for the coin
        return memo.get(n);
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Main method to read input and call the bytelandian method
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the input number
        long n = Long.parseLong(br.readLine().trim());
        // Create a HashMap for memoization
        HashMap<Long, Long> memo = new HashMap<Long, Long>();
        // Print the maximum American dollars that can be obtained
        System.out.println(bytelandian(n, memo));
    }
}
