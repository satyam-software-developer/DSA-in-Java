/*Problem statement
Write a program that takes a character as input and prints 1, 0, or -1 according to the following rules.



1, if the character is an uppercase alphabet (A - Z).
0, if the character is a lowercase alphabet (a - z).
-1, if the character is not an alphabet.


Example:
Input: The character is 'a'.

Output: 0

Explanation: The input character is lowercase, so our answer is 0.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The only line contains a single character.


Output format :
The only line contains 1, 0, or -1 according to the above rules.
Sample Input 1 :
v


Sample Output 1 :
0


Explanation of Sample Input 1:
The input character is lowercase, so our answer is 0.


Sample Input 2 :
V


Sample Output 2 :
1


Explanation of Sample Input 2:
The input character is uppercase, so our answer is 1.


Sample Input 3 :
#


Sample Output 3 :
-1


Explanation of Sample Input 3:
The input character is not an alphabet, so our answer is -1.


Constraints :
The input can be any single character.


Hint:
Can you check in which range of characters ‘CH’ lie to check its type? */

package conditionals_and_loops;

import java.util.Scanner;

public class CharacterCase {
    public static void main(String[] args) {

        // Scanner object for input
        Scanner s = new Scanner(System.in);

        // Read the character input
        char ch = s.next().charAt(0);

        // Check if the character is uppercase
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(1); // Print 1 for uppercase
        }
        // Check if the character is lowercase
        else if (ch >= 'a' && ch <= 'z') {
            System.out.println(0); // Print 0 for lowercase
        } else {
            System.out.println(-1); // Print -1 for non-alphabetic characters
        }

        // Alternative approach:
        // Scanner s = new Scanner(System.in);
        // char c = s.next().charAt(0);
        // if(c>=65 && c<=90){
        // System.out.println(1);
        // }
        // else if(c>=97 && c<=122){
        // System.out.println(0);
        // }
        // else{
        // System.out.println(-1);
        // }

        // Another alternative approach:
        // Scanner s=new Scanner(System.in);
        // char n = s.next().charAt(0);
        // int a=n;
        // if(a>=65 && a<=90)
        // {
        // System.out.print("1");
        // }
        // else if(a>=97 && a<=122)
        // {
        // System.out.print("0");
        // }
        // else
        // {
        // System.out.print("-1");
        // }
    }
}
