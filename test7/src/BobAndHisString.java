
/* Problem statement
King Bob is in playful mood today. He started playing with string S. As he was playing, a weird question came in his mind. He wondered what is the maximum number of characters, between any two same characters in the string. He needs your help in solving this question. Can you help him solve this question?

Note: String S is composed of lowercase letters of the Latin alphabet. If there are no two same characters in the string, print -1.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains one integer T, denoting the number of test cases. 
Each of the next T line contains one string S.
Constraints:
1 < T < 10
1 < |S| < 100000, where S determines the length of the string.
String is composed of lowercase alphabets ranging from a to z.
Time limit : 1 sec
Output Format:
For each test case, output the maximum number of characters between any two same characters in the string. If there are no two same characters in the string, print -1. 
Print answer for each test case in a new line.
Sample Input 1:
2
aba
babcddc
Sample Output 1:
1
2
Explanation:
1) For string = aba
There is only one character between 2 occurrences of a.

2) For string = babcddc
There is one character between 2 occurrences of b, and 2 characters between 2 occurrences of c. So the answer is 2. */
import java.util.*;

public class BobAndHisString {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); // Scanner for reading input
        int t = scn.nextInt(); // Read the number of test cases

        while (t-- > 0) { // Loop through all test cases
            String s = scn.next(); // Read the string for the current test case
            int max = Integer.MIN_VALUE; // Initialize max distance to the smallest possible value
            int[] freq_map = new int[26]; // Array to store the first occurrence index of each character

            // Initialize the freq_map array with -1 indicating no occurrence yet
            for (int i = 0; i < 26; i++) {
                freq_map[i] = -1;
            }

            // Iterate through each character in the string
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a'; // Calculate the index for the character

                // If the character is encountered for the first time
                if (freq_map[index] == -1) {
                    freq_map[index] = i; // Store the index of the first occurrence
                } else {
                    int distance = i - freq_map[index]; // Calculate the distance between current and first occurrence
                    if (distance > max) { // Update max if the current distance is greater
                        max = distance;
                    }
                }
            }

            // If max is still the initial value, no repeating character was found
            if (max == Integer.MIN_VALUE) {
                System.out.println(-1); // Print -1 indicating no repeating characters
            } else {
                System.out.println(max - 1); // Print the maximum distance minus 1
            }
        }
    }
}
