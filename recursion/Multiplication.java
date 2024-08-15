/* 
Problem statement
Given two integers M & N, calculate and return their multiplication using recursion. 
You can only use subtraction and addition for your calculation. No other operators are allowed.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 1000
0 <= N <= 1000
Sample Input 1 :
3 
5
Sample Output 1 :
15
Sample Input 2 :
4 
0
Sample Output 2 :
0
*/

package recursion;

import java.util.Scanner;

public class Multiplication {

    // Function to perform multiplication of two integers recursively
    public static int multiplyTwoIntegers(int m, int n){
        // Base case: If either of the numbers is 0, the result is 0
        if(n == 0 || m == 0){
            return 0;
        }
        // Recursive case: Add 'm' 'n' times to achieve multiplication
        return m + multiplyTwoIntegers(m, n - 1);
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Input two integers from the user
		int m = s.nextInt();
		int n = s.nextInt();
        // Calculate and print the product of the two integers using the multiplyTwoIntegers method
		System.out.println(multiplyTwoIntegers(m, n));  
    }   
}

