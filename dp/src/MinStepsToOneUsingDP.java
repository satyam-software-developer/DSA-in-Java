/*Problem statement
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:

1.) Subtract 1 from it. (n = n - ­1) ,
2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 10 ^ 6
Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 
Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 ­- 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1   */

/*
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 * 
 * where 'n' is the total number of steps
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOneUsingDP {

    // Method to count the minimum number of steps to reduce the number to 1 using
    // Dynamic Programming
    public static int countMinStepsToOne(int n) {
        // Base case: if n is 1, no steps are needed
        if (n == 1) {
            return 0;
        }

        // Array to store the minimum number of steps to reach each number from 1 to n
        int[] minSteps = new int[n + 1];

        // Initialize the base case for dynamic programming
        minSteps[1] = 0;

        // Iterate from 2 to n to fill the minSteps array
        for (int currStep = 2; currStep <= n; currStep++) {
            // Initialize the steps to max value
            int subtractOne = Integer.MAX_VALUE;
            int divideByTwo = Integer.MAX_VALUE;
            int divideByThree = Integer.MAX_VALUE;

            // Calculate steps for subtracting one
            subtractOne = minSteps[currStep - 1];

            // Calculate steps for dividing by 2, if current step is divisible by 2
            if (currStep % 2 == 0) {
                divideByTwo = minSteps[currStep / 2];
            }

            // Calculate steps for dividing by 3, if current step is divisible by 3
            if (currStep % 3 == 0) {
                divideByThree = minSteps[currStep / 3];
            }

            // Store the minimum steps among the three possible operations
            minSteps[currStep] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
        }

        // Return the minimum number of steps to reach n
        return minSteps[n];
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Main method to read input and call the countMinStepsToOne method
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Read the input number
        int n = Integer.parseInt(br.readLine().trim());
        // Print the minimum steps to reduce the number to 1
        System.out.println(countMinStepsToOne(n));
    }
}
