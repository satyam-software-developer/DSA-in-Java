/* 
Problem statement
Given an integer array A of size N, check if the input array can be divided in two groups G1 and G2 with following properties-

- Sum of both group elements are equal
- Group 1: All elements in the input, which are divisible by 5 
- Group 2: All elements in the input, which are divisible by 3 (but not divisible by 5). 
- Elements which are neither divisible by 5 nor by 3, can be put in either group G1 or G2 to satisfy the equal sum property. 
Group 1 and Group 2 are allowed to be unordered and all the elements in the Array A must belong to only one of the groups.



Return true, if array can be split according to the above rules, else return false.

Note: You will get marks only if all the test cases are passed.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : Integer N (size of array)
Line 2 : Array A elements (separated by space)
Output Format :
true or false
Constraints :
1 <= N <= 50
Sample Input 1 :
2
1 2
Sample Output 1 :
false
Sample Input 2 :
3
1 4 3
Sample Output 2 :
true
*/

package test4;

import java.util.Scanner;

public class SplitArray {

    // Method to check if it is possible to split the array into two parts with
    // equal sum
    public static boolean splitArray(int input[]) {
        return check(input, 0, 0, 0); // Start the recursive check with initial values
    }

    // Recursive method to explore all possible splits of the array
    public static boolean check(int input[], int startIndex, int lSum, int rSum) {
        // Base case: If we have processed all elements in the array
        if (startIndex == input.length) {
            // Check if the sums of the left and right partitions are equal
            return lSum == rSum;
        }
        // If the current element is divisible by 5, add it to the left sum
        if (input[startIndex] % 5 == 0) {
            lSum += input[startIndex];
        }
        // If the current element is divisible by 3, add it to the right sum
        else if (input[startIndex] % 3 == 0) {
            rSum += input[startIndex];
        }
        // If the current element is neither divisible by 5 nor by 3, explore both
        // options
        else {
            // Explore adding the current element to the left sum
            boolean leftAns = check(input, startIndex + 1, lSum + input[startIndex], rSum);
            // Explore adding the current element to the right sum
            boolean rightAns = check(input, startIndex + 1, lSum, rSum + input[startIndex]);
            // If either option leads to a valid split, return true
            return leftAns || rightAns;
        }
        // Move to the next element in the array and continue exploring
        return check(input, startIndex + 1, lSum, rSum);
    }

    // Main method to take input and call the splitArray method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Number of elements in the array
        int input[] = new int[n]; // Array to store the elements
        // Input the elements of the array
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        // Call the splitArray method and print the result
        System.out.println(splitArray(input));
    }

}
