/* 
Problem statement
Determine if a given string ‘S’ is a palindrome using recursion. 
Return a Boolean value of true if it is a palindrome and false if it is not.

Note: You are not required to print anything, just implement the function. Example:
Input: s = "racecar"
Output: true
Explanation: "racecar" is a palindrome.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of the input contains string S.
Output format:
Return a boolean value True or False.
Sample Input 1:
abbba
Sample Output 1:
true
Explanation Of Sample Input 1 :
“abbba” is a palindrome
Sample Input 2:
abcd
Sample Output 2:
false
Explanation Of Sample Input 2 :
“abcd” is not a palindrome.
Constraints:
0 <= |S| <= 10^6
where |S| represents the length of string S.


/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * Where N is the length of the string.
 */

package recursion;

import java.util.Scanner;

public class CheckPalindrome {
    //Helper function to check if a string is a palindrome recursively.
    private static boolean isPalindromeHelper(String str, int left, int right){
        // Base case: If the left and right pointers meet or cross each other, the string is a palindrome.
        if(left >= right){
            return true;
        }
        // Recursive case: Check if the characters at the left and right pointers are equal.
        if(str.charAt(left) == str.charAt(right)){
            // Recurse for the substring by moving the left pointer to the right and the right pointer to the left.
            return isPalindromeHelper(str, left + 1, right - 1);
        }
        // If the characters at the left and right pointers  are not equal, the string is not a palindrome.
        return false;
    }
    // Function to check if a string is a palindrome.
    public static boolean isPalindrome(String S){
        // Call the helper function to perform the recursive palindrome check.
        // Pass the left pointer as 0 and the right pointer as the last index of the string.
        return isPalindromeHelper(S, 0, S.length() - 1);
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(isPalindrome(str));

        
    }
}
