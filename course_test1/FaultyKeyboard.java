/* 
Problem statement
Some of the keys on your keyboard are faulty. When you press a key, it may register more than once. That means if you want to type "code", the keyboard may interpret it as "code", "cccoddee" or "coode" or "codeeeee", etc. So, by pressing the keys C, O, D, and E in that order, you may get any of the above-mentioned words.

However, there are certain words that you will not get like, "cddde", "cod", "coeeeeed", etc.

You will be given 'N' pairs of words. The first word of each pair is what you intended to write and the second one is what the keyboard interprets it as. You need to figure out whether the second word can actually be a possible interpretation of the first word.

Detailed explanation ( Input/output format, Notes, Images )
Input format
The first line of the input contains a positive integer, N which represents the number of pairs of words
Every two lines after it will contain two words. The first one is what you typed, the second one is a potential interpretation of that word by the faulty keyboard.
Output format
The output will contain 'N' lines. Each line will be either "true" if the second word is a possible interpretation of the first word and "false" if it's not.
Constraints
1 <= N <= 10^5
1 <= L <= 10^6
where L is the total number of letters in all of the 2*N words
Time limit: 1 sec
Sample Input 1
2
code
cooodeee
hello
hheeeloo
Sample Output 1
true
false
*/
/*
 Time Complexity: O(N + M)
 Space Complexity: O(N + M)

 where N and M are the lengths of the two strings
*/

package course_test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class definition for FaultyKeyboard
public class FaultyKeyboard {

    // Inner static class Pair to represent a character and its count
    static class Pair {
        char character;
        int count;

        // Constructor for Pair class
        public Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }

        // Method to split a string into groups of characters and their counts
        public static List<Pair> makeGroups(String s) {
            List<Pair> ret = new ArrayList<>();
            char currChar = s.charAt(0);
            int currCharCount = 1;

            // Iterate through the string to form groups of characters and their counts
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == currChar) {
                    ++currCharCount;
                } else {
                    ret.add(new Pair(currChar, currCharCount));
                    currChar = s.charAt(i);
                    currCharCount = 1;
                }
            }
            // Add the last character and its count to the list
            ret.add(new Pair(currChar, currCharCount));

            return ret;
        }

        // Method to check if two strings can be typed with the same characters and
        // counts
        public static boolean canType(String s1, String s2) {
            // Generate character-count pairs for both strings
            List<Pair> group1 = makeGroups(s1);
            List<Pair> group2 = makeGroups(s2);

            // If the number of groups is different, strings cannot be typed the same way
            if (group1.size() != group2.size()) {
                return false;
            }

            // Iterate through groups and compare characters and counts
            for (int i = 0; i < group1.size(); ++i) {
                if (group1.get(i).character != group2.get(i).character) {
                    return false;
                } else if (group1.get(i).count > group2.get(i).count) {
                    return false;
                }
            }
            // If all comparisons pass, strings can be typed the same way
            return true;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner s = new Scanner(System.in);
        // Read the number of test cases
        int t = s.nextInt();
        // Consume newline character after reading integer
        s.nextLine();

        // Process each test case
        while (t-- > 0) {
            // Read the strings for the test case
            String a = s.nextLine();
            String b = s.nextLine();
            // Check if strings can be typed the same way and print result
            System.out.println(Pair.canType(a, b) ? "true" : "false");
        }
        // Close the Scanner object
        s.close();
    }
}
