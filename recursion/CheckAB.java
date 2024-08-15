/* 
Problem statement
Suppose you have a string, S, made up of only 'a's and 'b's. 
Write a recursive function that checks if the string was generated using the following rules:

a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
String S
Output format :
'true' or 'false'
Constraints :
1 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
abb
Sample Output 1 :
true
Sample Input 2 :
abababa
Sample Output 2 :
false
Explanation for Sample Input 2
In the above example, a is not followed by either "a" or "bb", instead it's followed by "b" which results in false to be returned.
*/

package recursion;

import java.util.Scanner;

// Defining a public class named CheckAB
public class CheckAB {

    // Method to check if the given string follows the 'a' followed by zero or more 'b's pattern
    public static boolean checkAB(String str) {
        // Base case: if the string is empty, return true
        if (str.length() == 0) {
            return true;
        }
        // If the first character is 'a'
        if (str.charAt(0) == 'a') {
            // Check if there are at least two characters remaining and if the next two characters are 'bb'
            if (str.substring(1).length() > 1 && str.substring(1, 3).equals("bb")) {
                // If 'bb' is found, recursively call checkAB with the substring after 'bb'
                return checkAB(str.substring(3));
            } else {
                // If 'bb' is not found, recursively call checkAB with the substring after 'a'
                return checkAB(str.substring(1));
            }
        }
        // If the first character is not 'a', return false
        return false;
    }

    // Main method
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner s = new Scanner(System.in);
        // Prompting the user to enter a string
        String input = s.next();
        // Calling the checkAB method with the input string and printing the result
        System.out.println(checkAB(input));
    }
}
