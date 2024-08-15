
/* Problem statement
You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).

Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true
Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
 false */
import java.util.Scanner;

public class RatInAMaze {

    // Method to check if a path exists for the rat to reach the destination
    public static boolean ratInAMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze, 0, 0, path);
    }

    // Helper method to solve the maze recursively
    public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
        int n = maze.length;

        // Check if (i, j) cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }

        // Include the cell in the current path
        path[i][j] = 1;

        // Destination cell
        if (i == n - 1 && j == n - 1) {
            return true;
        }

        // Explore further in all directions

        // Move down
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }

        // Move right
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }

        // Move up
        if (solveMaze(maze, i - 1, j, path)) {
            return true;
        }

        // Move left
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }

        // If none of the above moves work, backtrack
        path[i][j] = 0;
        return false;
    }

    // Main method to take input and start the maze solving process
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maze[][] = new int[n][n];

        // Read the maze input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = s.nextInt();
            }
        }

        // Check if there is a path and print the result
        System.out.println(ratInAMaze(maze));
    }
}
