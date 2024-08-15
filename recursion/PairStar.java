/* 
Problem statement
Given a string S, compute recursively a new string where identical chars 
that are adjacent in the original string are separated from each other by a "*".

Detailed explanation ( Input/output format, Notes, Images )
Input format :
String S
Output format :
Modified string
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a
*/

package recursion;

import java.util.Scanner;

// Defining a public class named PairStar
public class PairStar {
    
    // Method to add stars between adjacent characters if they are same
    public static String addStars(String s) {
        // Base case: if the string has one or fewer characters, return the string itself
        if (s.length() <= 1) {
            return s;
        }
        
        // Recursively call addStars function with the substring starting from the second character
        String out = addStars(s.substring(1));
        
        // If the first character is same as the second character, add a star between them
        if (s.charAt(0) == s.charAt(1)) {
            // Insert a '*' between the first and second character and concatenate with the rest of the string
            out = s.charAt(0) + "*" + s.charAt(1) + out.substring(1);
        } else {
            // If the first and second characters are different, keep the first character unchanged
            out = s.charAt(0) + out;
        }
        
        // Return the modified string
        return out;
    }

    // Main method
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner s = new Scanner(System.in);
        // Prompting the user to enter a string
        String input = s.nextLine();
        // Calling the addStars method with the input string and printing the result
        System.out.println(addStars(input));
    }
}
