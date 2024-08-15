
/* Problem statement
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :

1<=N<=10 For Example:
For a chessboard of size 4*4
The configurations are 
alt text

Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0  */

import java.util.Scanner;

public class NQueens {

    // Method to initiate the process of placing N Queens on an NxN board
    public static void placeNQueens(int n) {
        int board[][] = new int[n][n]; // Initialize an NxN board with all cells set to 0
        palaceQueens(board, 0, n); // Start placing queens from the first row
    }

    // Recursive method to place queens on the board
    private static void palaceQueens(int[][] board, int row, int n) {
        // Base case: if all queens are placed, print the board configuration
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " "); // Print the current board
                }
            }
            System.out.println();
            return; // Return after printing the board
        }

        // Try placing a queen in each column of the current row
        for (int j = 0; j < n; j++) {
            // Check if it's safe to place the queen at board[row][j]
            if (isBoardSafe(board, row, j)) {
                board[row][j] = 1; // Place the queen
                palaceQueens(board, row + 1, n); // Recur to place the queen in the next row
                board[row][j] = 0; // Backtrack: remove the queen and try next column
            }
        }
    }

    // Method to check if it's safe to place a queen at board[row][col]
    private static boolean isBoardSafe(int board[][], int row, int col) {
        int n = board.length;

        // Check for another queen in the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check for another queen in the lower-right diagonal
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check for another queen in the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check for another queen in the lower-left diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check for another queen in the same column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        return true; // Return true if no conflicts are found
    }

    // Main method to read input and start the N-Queens solution
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Read the size of the board (N)
        placeNQueens(n); // Start placing N Queens on the board
    }
}
