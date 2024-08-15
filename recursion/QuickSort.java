/* 
Problem statement
Given the 'start' and the 'end'' positions of the array 'input'. 
Your task is to sort the elements between 'start' and 'end' using quick sort.

Note :
Make changes in the input array itself.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Integer N i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)
Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
1 2 3 5 7
Sample Output 2 :
1 2 3 5 7 
Constraints :
1 <= N <= 10^3
0 <= input[i] <= 10^9
*/

/*
 *  Time Complexity : O('N' * log('N'))
 *  Space Complexity : O(log('N'))
 *  where 'N' is size of input array
 */


package recursion;

import java.util.Scanner;

public class QuickSort {
    // Function to partition the array
    public static int partitionArray(int input[], int start, int end){
        // Choose pivot
        int pivot = input[start];

        // Count elements smaller than pivot and swap
        int count = 0;
        for(int i = start + 1; i <= end; i++){
            if(input[i] <= pivot){
                count++;
            }
        }
        int pivotIndex = start + count;
        int temp = input[start];
        input[start] = input[pivotIndex];
        input[pivotIndex] = temp;

        // Ensure left half contains elements smaller than pivot
        // and right half contains larger elements
        int i = start, j = end;
        while(i <= pivotIndex && input[i] <= pivot){
            i++;
        }
        while(j >= pivotIndex && input[j] > pivot){
            j--;
        }
        if(i < pivotIndex && j > pivotIndex){
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
        return pivotIndex; // Return pivot index
    }

    // Function to perform quicksort
    public static void quickSort(int input[], int start, int end){
        if(start >= end){
            return; // Base case: if array has 0 or 1 element, it is already sorted
        }
        int pivotIndex = partitionArray(input, start, end);
        quickSort(input, start, pivotIndex -1); // Recursively sort left subarray
        quickSort(input, pivotIndex + 1, end); // Recursively sort right subarray
    }

    // Function to take input from user
    public static int[] takeInput(){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt(); // Input size of array
        int[] input = new int[size]; // Create an array to store the input elements
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt(); // Input each element of the array
        }
        return input; // Return the input array
    }

    // Main function
    public static void main(String[] args) {
        int[] input = takeInput(); // Take input array from user
        quickSort(input, 0, input.length - 1); // Sort the input array using quicksort
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " "); // Print the sorted array
        }
    }
}

