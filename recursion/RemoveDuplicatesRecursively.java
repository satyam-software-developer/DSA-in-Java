/*
Problem statement
Given a string S, remove consecutive duplicates from it recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz
*/


package recursion;

import java.util.Scanner;

// This class removes consecutive duplicate characters from a given string recursively.
public class RemoveDuplicatesRecursively {

    // Recursive method to remove consecutive duplicate characters from the input string.
    public static String removeConsecutiveDuplicates(String s) {
        // Base case: if the length of the string is 0 or 1, return the string itself.
        if (s.length() <= 1) {
            return s;
        }
        // If the first character is the same as the second one, recursively call removeConsecutiveDuplicates with the substring starting from the second character.
        if (s.charAt(0) == s.charAt(1)) {
            return removeConsecutiveDuplicates(s.substring(1));
        } else {
            // If the first character is different from the second one, recursively call removeConsecutiveDuplicates with the substring starting from the second character and concatenate the first character with the result.
            String small = removeConsecutiveDuplicates(s.substring(1));
            return s.charAt(0) + small;
        }
    }

    // Main method to take input and call the removeConsecutiveDuplicates method.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Read input from the user.
        String input = s.next();
        // Call the removeConsecutiveDuplicates method and print the result.
        System.out.println(removeConsecutiveDuplicates(input));
    }
}
