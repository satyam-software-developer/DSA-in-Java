/* 
Problem statement
Aadil has been provided with a sentence in the form of a string as a function parameter. 
The task is to implement a function so as to change the sentence such that each word in the sentence is reversed. 
A word is a combination of characters without any spaces.

Example:
Input Sentence: "Hello I am Aadil"
The expected output will look, "olleH I ma lidaA".
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of input contains a string without any leading and trailing spaces. 
The input string represents the sentence given to Aadil.
Output Format:
You don't need to print anything just change the sentence(string) such that each word in the sentence is reversed. 
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

All the words in string are separated by a single space.

String does not contain any leading or trailing spaces.

Time Limit: 1 second
Sample Input 1:
Welcome to Coding Ninjas
Sample Output 1:
emocleW ot gnidoC sajniN
Sample Input 2:
Always indent your code
Sample Output 2:
syawlA tnedni ruoy edoc

*/

package strings;

import java.util.Scanner; // Import the Scanner class to read input from the console

public class ReverseEachWord {

    // Define a method to reverse each word in the given input string
    public static String reverseEachWord(String input) {
        // Convert the input string to a character array for easy manipulation
        char[] charArray = input.toCharArray();
        int ptrA = 0, ptrB = 0, i = 0;
        int len = charArray.length; // Get the length of the character array

        // Iterate through the character array to reverse each word
        while (true) {
            // Check if the current index reaches the end of the array or encounters a space
            // character
            if (i == len || charArray[i] == ' ') {
                ptrB = i - 1; // Set the end pointer to the previous character

                // Reverse the characters between the start and end pointers
                while (ptrA < ptrB) {
                    // Swap characters using a temporary variable
                    char temp = charArray[ptrA];
                    charArray[ptrA] = charArray[ptrB];
                    charArray[ptrB] = temp;
                    ptrA++; // Move the start pointer forward
                    ptrB--; // Move the end pointer backward
                }

                ptrA = i + 1; // Update the start pointer for the next word
                ptrB = ptrA; // Set the end pointer equal to the start pointer
            }
            // Check if the current index reaches the end of the array
            if (i == len) {
                break; // Exit the loop if the end of the array is reached
            }
            i++; // Move to the next character
        }
        // Convert the modified character array back to a string and return it
        return new String(charArray);
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input
        String str = s.nextLine(); // Read a line of input from the console
        String ans = reverseEachWord(str); // Call the reverseEachWord method to reverse each word
        System.out.println(ans); // Print the modified string with reversed words
    }
}
