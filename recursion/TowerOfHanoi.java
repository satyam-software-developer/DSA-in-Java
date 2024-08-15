/* 
Problem statement
Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. 
The objective of the puzzle is to move all disks from source rod to destination rod 
using third rod (say auxiliary). The rules are :

1) Only one disk can be moved at a time.
2) A disk can be moved only if it is on the top of a rod.
3) No disk can be placed on the top of a smaller disk.
Print the steps required to move n disks from source rod to destination rod.

Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Integer n
Output Format :
Steps in different lines (in one line print source and destination rod name separated by space)
Constraints :
0 <= n <= 20
Sample Input 1 :
2
Sample Output 1 :
a b
a c
b c
Sample Input 2 :
3
Sample Output 2 :
a c
a b
c b
a c
b a
b c
a c
*/

package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    
    // Recursive function to solve Tower of Hanoi problem
    // Moves disks from source to destination using auxiliary peg
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        // Base case: if there are no disks to move, return
        if (disks == 0) {
            return;
        }
        
        // Move (disks - 1) disks from source to auxiliary using destination as auxiliary
        towerOfHanoi(disks - 1, source, destination, auxiliary);
        
        // Move the largest disk from source to destination
        System.out.println(source + " " + destination);
        
        // Move (disks - 1) disks from auxiliary to destination using source as auxiliary
        towerOfHanoi(disks - 1, auxiliary, source, destination);
    }

    // Main function
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Input number of disks
        towerOfHanoi(n, 'a', 'b', 'c'); // Call the towerOfHanoi function with source ('a'), auxiliary ('b'), and destination ('c')
    }
}
