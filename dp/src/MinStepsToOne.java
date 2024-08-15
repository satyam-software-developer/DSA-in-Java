
/* Problem statement
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:

1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Write brute-force recursive solution for this.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 200

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
 * Time Complexity : O(3^n)
 * Space Complexity : O(n)
 * 
 * Where 'n' is the total number of steps 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOne {

    // Method to count the minimum number of steps to reduce the number to 1
    public static int countMinStepsToOne(int n) {
        // Base case: if n is 1, no steps are needed
        if (n == 1) {
            return 0;
        }

        // Initialize the steps to max value
        int subtractOne = Integer.MAX_VALUE;
        int divideByTwo = Integer.MAX_VALUE;
        int divideByThree = Integer.MAX_VALUE;

        // Recursive call for subtracting one step
        subtractOne = countMinStepsToOne(n - 1);

        // Recursive call for dividing by 2, if n is divisible by 2
        if (n % 2 == 0) {
            divideByTwo = countMinStepsToOne(n / 2);
        }

        // Recursive call for dividing by 3, if n is divisible by 3
        if (n % 3 == 0) {
            divideByThree = countMinStepsToOne(n / 3);
        }

        // Return the minimum steps among the three possible operations
        return 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
    }

    // BufferedReader for reading input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Main method to read input and call the countMinStepsToOne method
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Read the input number
        System.out.println(countMinStepsToOne(n)); // Print the minimum steps to reduce the number to 1
    }
}
