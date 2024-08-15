/* Problem statement
Given a string S (that can contain multiple words), you need to find the word which has minimum length.

Note : If multiple words are of same length, then answer will be first minimum length word in the string. 
Words are seperated by single space only.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
String S
Output Format :
Minimum length word
Constraints :
1 <= Length of String S <= 10^5

Sample Input 1 :
this is test string
Sample Output 1 :
is
Sample Input 2 :
abc de ghihjk a uvw h j
Sample Output 2 :
a
*/


package test3;

import java.util.Scanner;

public class MinimumLengthWord {
    public static String minLengthWord(String input){
        int minStart = -1; // Initialize the starting index of the minimum length word
        int minLength = Integer.MAX_VALUE; // Initialize the minimum length to the maximum possible value
        int currentStart = 0; // Initialize the starting index of the current word
        int i = 0; // Initialize loop variable

        // Iterate through the input string
        for (; i < input.length(); i++){
            if(input.charAt(i) == ' '){ // Check if the current character is a space
                int currentWordLength = i - currentStart; // Calculate the length of the current word
                // Update minimum start index and length if the current word is shorter
                if(currentWordLength < minLength){
                    minStart = currentStart;
                    minLength = currentWordLength;
                }
                currentStart = i + 1; // Move to the next character after the space
            }
        }

        // Handle the case where the input string contains only one word
        if(minStart == -1){
            return input;
        } else {
            // Check the length of the last word in the input string
            int currentWordLength = i - currentStart;
            // Update minimum start index and length if the last word is shorter
            if(currentWordLength < minLength){
                minStart = currentStart;
                minLength = currentWordLength;
            }
            // Return the minimum length word using substring
            return input.substring(minStart, minStart + minLength);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read input from the console
		String str = s.nextLine(); // Read a line of input from the console

		System.out.println(minLengthWord(str)); // Call minLengthWord function and print the result
    }   
}
