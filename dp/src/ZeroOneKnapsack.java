
/* Problem statement
A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
Output Format :
Print the maximum value of V that the thief can steal.
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51 */

/*
 * Time Complexity : O(3^n)
 * Space Complexity : O(N)
 * 
 * Where N is the total number of weights
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneKnapsack {

    // Inner class to handle input
    static class Input {
        private int n; // Number of items
        private int[] weights; // Array of item weights
        private int[] values; // Array of item values
        private int maxWeight; // Maximum weight the knapsack can carry

        // Constructor to initialize the Input object
        public Input(int[] weights, int[] values, int n, int maxWeight) {
            this.n = n;
            this.weights = weights;
            this.values = values;
            this.maxWeight = maxWeight;
        }

        // Getter methods for accessing private fields
        public int getSize() {
            return this.n;
        }

        public int[] getWeights() {
            return this.weights;
        }

        public int[] getValues() {
            return this.values;
        }

        public int getMaxWeight() {
            return this.maxWeight;
        }
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input from the user
    public static Input takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Read the number of items

        if (n == 0) {
            return new Input(new int[0], new int[0], 0, 0); // If no items, return an empty Input object
        }

        String[] strWeights = br.readLine().trim().split(" "); // Read weights as a string array
        String[] strValues = br.readLine().trim().split(" "); // Read values as a string array
        int maxWeight = Integer.parseInt(br.readLine().trim()); // Read the maximum weight

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(strWeights[i]); // Convert weights to integers
            values[i] = Integer.parseInt(strValues[i]); // Convert values to integers
        }

        return new Input(weights, values, n, maxWeight); // Return a new Input object with the read values
    }

    // Method to solve the knapsack problem using recursion and memoization
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight, int[][] dp) {
        if (n == 0 || maxWeight == 0) {
            return 0; // Base case: no items or no capacity left
        }

        if (dp[n][maxWeight] != -1) {
            return dp[n][maxWeight]; // Return precomputed result if available
        }

        if (weights[n - 1] > maxWeight) {
            // If the item is too heavy, skip it
            dp[n][maxWeight] = knapsack(weights, values, n - 1, maxWeight, dp);
        } else {
            // Include the item
            int includeItem = values[n - 1] + knapsack(weights, values, n - 1, maxWeight - weights[n - 1], dp);
            // Exclude the item
            int excludeItem = knapsack(weights, values, n - 1, maxWeight, dp);
            // Take the maximum value of including or excluding the item
            dp[n][maxWeight] = Math.max(includeItem, excludeItem);
        }

        return dp[n][maxWeight]; // Return the computed value for the current subproblem
    }

    // Main method to run the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        Input input = takeInput(); // Read input

        int n = input.getSize(); // Get number of items
        int[] weights = input.getWeights(); // Get weights array
        int[] values = input.getValues(); // Get values array
        int maxWeight = input.getMaxWeight(); // Get maximum weight

        int[][] dp = new int[n + 1][maxWeight + 1]; // Initialize memoization table

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = -1; // Set initial values of the table to -1 (indicating not computed)
            }
        }

        // Compute and print the maximum value that can be stolen
        System.out.println(knapsack(weights, values, n, maxWeight, dp));
    }
}
