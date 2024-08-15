/* Problem statement
You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).

Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Detailed explanation ( Input/output format, Notes, Images )
Input Format
The first line of input contains an integer 'N' representing 
the dimension of the maze.
The next N lines of input contain N space-separated 
integers representing the type of the cell.
Output Format :
For each test case, print the path from start position to destination position and only cells that are part of the solution path should be 1, rest all cells should be 0.

Output for every test case will be printed in a separate line.
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format. */


/*
 * Time complexity: O(2^k)
 * Space complexity: O(N^2)
 * where N is the size of maze 
 * and K is the number of cells in maze with
 * value equal to one(1)
 */

import java.io.*;
import java.util.*;

public class RatInAMazeAllPaths {

    // Method to print the solution matrix
    static void printsolution(int[][] solution, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
        }
        System.out.println();
    }

    // Recursive method to solve the maze and find all paths
    static void solveMaze(int maze[][], int solution[][], int x, int y, int n) {
        // Base case: if the rat reaches the destination (bottom-right corner)
        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1; // Mark the destination cell in the solution path
            printsolution(solution, n); // Print the current solution path
            System.out.println();
            return;
        }

        // Check if the current cell is out of bounds or blocked or already visited
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1) {
            return;
        }

        // Mark the current cell as part of the solution path
        solution[x][y] = 1;

        // Move in all four possible directions: up, down, left, right
        solveMaze(maze, solution, x - 1, y, n); // Move up
        solveMaze(maze, solution, x + 1, y, n); // Move down
        solveMaze(maze, solution, x, y - 1, n); // Move left
        solveMaze(maze, solution, x, y + 1, n); // Move right

        // Backtrack: unmark the current cell as part of the solution path
        solution[x][y] = 0;
    }

    // Method to initialize the solution matrix and start the maze solving process
    static void ratInAMaze(int maze[][], int n) {
        int[][] solution = new int[20][20]; // Initialize the solution matrix with a size of 20x20
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solution[i][j] = 0; // Set all cells in the solution matrix to 0
            }
        }
        solveMaze(maze, solution, 0, 0, n); // Start solving the maze from the top-left corner
    }

    // Main method to read input and start the program
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()); // Read the size of the maze
        int[][] maze = new int[20][20]; // Initialize the maze matrix with a size of 20x20
        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(tk.nextToken()); // Read each cell value of the maze
            }
        }
        ratInAMaze(maze, n); // Start finding all paths in the maze
    }
}
