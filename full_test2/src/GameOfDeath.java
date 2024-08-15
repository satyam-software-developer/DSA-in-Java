
/* Problem statement
There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed. The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise). In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom.

Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.

Find the position of last person to survive.

Sample input 1:
4 2
Sample output 1:
1
(Skip 1 , kill 2 , Skip 3 , Kill 4)
(Skip 1 , Kill 4, So 1 survives)
Sample input 2:
50 10
Sample output 2:
36 */

import java.util.*;

public class GameOfDeath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Read the number of people in the circle
        int n = s.nextInt();

        // Read the step count for elimination
        int k = s.nextInt();

        // Find and print the safe position
        System.out.println(find(n, k));
    }

    // Method to find the safe position using recursion
    public static int find(int n, int k) {
        // Base case: if there is only one person left, they are the safe position
        if (n == 1)
            return 1;

        // Recursive case: find the safe position in a smaller circle and adjust for the
        // current step
        return (find(n - 1, k) + k - 1) % n + 1;
    }
}
