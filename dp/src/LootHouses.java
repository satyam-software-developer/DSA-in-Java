
/* Problem statement
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line of input contains an integer value of 'n'. It is the total number of houses.

The second line of input contains 'n' integer values separated by a single space denoting the amount of money each house has.
Output format :
Print the the maximum money that can be looted.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90. */

/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 * where 'n' is the total number of houses
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LootHouses {

    // Method to calculate the maximum money that can be looted from houses
    public static int maxMoneyLooted(int[] houses) {
        int n = houses.length; // Get the number of houses

        // Special cases
        if (n == 0) {
            return 0; // If no houses, return 0
        }
        if (n == 1) {
            return houses[0]; // If one house, return the money in that house
        }

        // Array to store the maximum money that can be looted up to each house
        int[] maxMoneyCanBeLooted = new int[n];

        // Initialize the first two values
        maxMoneyCanBeLooted[0] = houses[0]; // The maximum money from the first house is the money in the first house
        maxMoneyCanBeLooted[1] = Math.max(houses[0], houses[1]); // The maximum money from the first two houses is the
                                                                 // max of either house

        // Loop through the houses starting from the third house
        for (int currHouse = 2; currHouse < n; currHouse++) {
            // The maximum money for the current house is the max of either:
            // - The maximum money up to the previous house
            // - The current house's money plus the maximum money up to two houses before
            maxMoneyCanBeLooted[currHouse] = Math.max(maxMoneyCanBeLooted[currHouse - 1],
                    (houses[currHouse] + maxMoneyCanBeLooted[currHouse - 2]));
        }

        // Return the maximum money that can be looted from all houses
        return maxMoneyCanBeLooted[n - 1];
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method to take input of house money values
    public static int[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Read the number of houses

        if (n == 0) {
            return new int[0]; // If no houses, return an empty array
        }

        // Read the money values of houses
        String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        // Convert the string values to integers and store in the array
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strNums[i]);
        }

        // Return the array of house money values
        return arr;
    }

    // Main method to read input and call the maxMoneyLooted method
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput(); // Take the input array
        System.out.println(maxMoneyLooted(arr)); // Print the maximum money that can be looted
    }
}
