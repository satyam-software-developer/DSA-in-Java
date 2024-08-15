
/*
Problem statement
For a given input string(str), write a function to print all the possible substrings.

Substring
A substring is a contiguous sequence of characters within a string. 
Example: "cod" is a substring of "coding". Whereas, "cdng" is not as the characters taken are not contiguous
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of input contains a string without any leading and trailing spaces. All the characters in the string would be in lower case.
Output Format:
Print the total number of substrings possible, where every substring is printed on a single line and hence the total number of output lines will be equal to the total number of substrings.
Note:
The order in which the substrings are printed, does not matter.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
abc
Sample Output 1:
a 
ab 
abc 
b 
bc 
c 
 Sample Input 2:
co
Sample Output 2:
c 
co 
o
*/

/*
 *  Time complexity: O(N^3)
 *  Space complexity: O(1)
 * 
 */

package strings;

import java.util.Scanner; // Import the Scanner class to read user input from the console.

public class AllSubstrings {

    // Method to print all possible substrings of the given string.
    public static void printSubstrings(String str) {
        int n = str.length(); // Get the length of the input string.

        // Iterate over each character in the string to generate substrings.
        for (int i = 0; i < n; ++i) {
            // For each starting index i, iterate over all possible ending indices j.
            for (int j = i; j < n; ++j) {
                // Print substrings starting from index i and ending at index j.
                for (int k = i; k <= j; ++k) {
                    System.out.print(str.charAt(k)); // Print the character at index k.
                }
                System.out.println(); // Move to the next line after printing each substring.
            }
        }
    }

    // Main method where the program execution begins.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input.
        String str = s.next(); // Read a string from the user.

        printSubstrings(str); // Call the method to print all substrings of the input string.
    }
}
