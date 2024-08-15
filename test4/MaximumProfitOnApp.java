/* 
Problem statement
You have made a smartphone app and want to set its subscription price such that the profit earned is maximised. 
There are certain users who will subscribe to your app only if their budget is greater than or equal to your price.

You will be provided with a list of size N having budgets of subscribers and you need to return the maximum profit that you can earn.

Lets say you decide that price of your app is Rs. x and there are N number of subscribers. So maximum profit you can earn is :

 m * x
where m is total number of subscribers whose budget is greater than or equal to x.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : N (No. of subscribers)
Line 2 : Budget of subscribers (separated by space)
Output Format :
 Maximum profit
Constraints :
1 <= N <= 10^6

1 <=budget[i]<=9999

Sample Input 1 :
4
30 20 53 14
Sample Output 1 :
60
Sample Output 1 Explanation :
Price of your app should be Rs. 20 or Rs. 30. For both prices, you can get the profit Rs. 60.
Sample Input 2 :
5
34 78 90 15 67
Sample Output 2 :
201
Sample Output 2 Explanation :
Price of your app should be Rs. 67. You can get the profit Rs. 201 (i.e. 3 * 67).
*/

package test4;

import java.util.Scanner;

public class MaximumProfitOnApp {

    // Method to merge two sorted arrays
    public static int[] merge(int arr1[], int arr2[]) {
        // Initialize indices for arr1, arr2, and output array
        int i = 0, j = 0, k = 0;
        // Create an output array with length equal to the sum of lengths of arr1 and arr2
        int output[] = new int[arr1.length + arr2.length];
        // Merge arr1 and arr2 into the output array
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                output[k++] = arr1[i++];
            } else {
                output[k++] = arr2[j++];
            }
        }
        // Copy remaining elements from arr1, if any
        while (i < arr1.length) {
            output[k++] = arr1[i++];
        }
        // Copy remaining elements from arr2, if any
        while (j < arr2.length) {
            output[k++] = arr2[j++];
        }
        // Return the merged array
        return output;
    }

    // Method to perform merge sort on an array
    public static int[] mergesort(int input[]) {
        // Base case: if the input array has 1 or fewer elements, it is already sorted
        if (input.length <= 1) {
            return input;
        }
        // Calculate the middle index
        int middle = input.length / 2;
        // Create left and right subarrays
        int lefthalf[] = new int[middle];
        int righthalf[] = new int[input.length - middle];
        // Copy elements from input array to left and right subarrays
        System.arraycopy(input, 0, lefthalf, 0, middle);
        System.arraycopy(input, middle, righthalf, 0, input.length - middle);
        // Recursively sort the left and right subarrays
        lefthalf = mergesort(lefthalf);
        righthalf = mergesort(righthalf);
        // Merge the sorted subarrays and return the result
        return merge(lefthalf, righthalf);
    }

    // Method to calculate the maximum profit from given budget
    public static int maximumProfit(int budget[]) {
        // Sort the budget using merge sort
        int sortedBudget[] = mergesort(budget);
        // Initialize maximum profit as the minimum integer value
        int maxProfit = Integer.MIN_VALUE;
        // Calculate profit for each budget value and update maxProfit if needed
        for (int i = 0; i < sortedBudget.length; i++) {
            int profit = sortedBudget[i] * (sortedBudget.length - i);
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        // Return the maximum profit
        return maxProfit;
    }

    // Main method to take input and call maximumProfit method
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner s = new Scanner(System.in);
        // Read the number of budget values from the user
        int n = s.nextInt();
        // Create an array to store the budget values
        int input[] = new int[n];
        // Read the budget values from the user
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        // Calculate and print the maximum profit
        System.out.println(maximumProfit(input));
    }
}
