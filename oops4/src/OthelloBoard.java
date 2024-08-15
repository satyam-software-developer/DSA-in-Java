
/*Problem statement
Othello is a board game and you are expected to implement the move function for this game.

Arguments passed to the function are - a symbol of the player making the move and x y coordinates of the cell at which the player wishes to make the move.

The move function will be returning a boolean, false - if the move isn't feasible and true - if the move is feasible and this function will also make the move then i.e. make the required changes in the board.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Line 1 : Integer n (Total number of moves)
Line 2 : Player 1 coordinates, x and y (Two integers separated by space)
Line 3 : Player 2 coordinates, x and y (Two integers separated by space)
Note 1 : Number of moves (i.e. n) is always even and Player 1 always starts the game. Note 2 : If any player's coordinates are not valid, enter again till the right move. Main function is given for you reference.
Sample Input :
2
2 4
1 5
2 5
Sample Output :
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 
0 0 0 1 1 0 0 0 
0 0 0 2 1 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
false
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 1 2 0 0 
0 0 0 1 2 0 0 0 
0 0 0 2 1 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 */

import java.util.Scanner;

public class OthelloBoard {

    private static int board[][]; // 2D array representing the Othello board
    final static int player1Symbol = 1; // Symbol for Player 1
    final static int player2Symbol = 2; // Symbol for Player 2

    // Arrays to represent the 8 possible directions (N, NE, E, SE, S, SW, W, NW)
    private static int xDir[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
    private static int yDir[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

    // Constructor to initialize the Othello board with the starting configuration
    public OthelloBoard() {
        board = new int[8][8]; // 8x8 board
        board[3][3] = player1Symbol; // Initial position for Player 1
        board[3][4] = player2Symbol; // Initial position for Player 2
        board[4][3] = player2Symbol; // Initial position for Player 2
        board[4][4] = player1Symbol; // Initial position for Player 1
    }

    // Method to print the current state of the board
    public void print() {
        for (int i = 0; i < 8; i++) { // Iterate over rows
            for (int j = 0; j < 8; j++) { // Iterate over columns
                System.out.print(board[i][j] + " "); // Print each cell
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // Method to make a move for a given player at the specified coordinates
    public boolean move(int symbol, int x, int y) {
        // Check if the move is out of bounds or the cell is not empty
        if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] != 0) {
            return false; // Move is invalid
        }
        boolean movePossible = false; // Flag to check if the move is valid
        for (int i = 0; i < xDir.length; i++) { // Check all 8 directions
            int xStep = xDir[i]; // Step in x direction
            int yStep = yDir[i]; // Step in y direction
            int currentX = x + xStep; // Move to the next cell in x direction
            int currentY = y + yStep; // Move to the next cell in y direction
            int count = 0; // Count of opponent's pieces encountered
            while (currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8) {
                // If the cell is empty, break the loop
                if (board[currentX][currentY] == 0) {
                    break;
                }
                // If the cell has the opponent's symbol, continue in the same direction
                else if (board[currentX][currentY] != symbol) {
                    currentX += xStep; // Move further in x direction
                    currentY += yStep; // Move further in y direction
                    count++; // Increase the count of opponent's pieces
                }
                // If the cell has the player's symbol, conversion is possible
                else {
                    if (count > 0) { // Ensure at least one opponent's piece is in between
                        movePossible = true; // Valid move
                        int convertX = currentX - xStep; // Start converting back to the original position
                        int convertY = currentY - yStep; // Start converting back to the original position
                        while (convertX != x || convertY != y) { // Flip opponent's pieces
                            board[convertX][convertY] = symbol; // Convert to player's symbol
                            convertX = convertX - xStep; // Move back in x direction
                            convertY = convertY - yStep; // Move back in y direction
                        }
                    }
                    break; // Exit the loop as the move is complete
                }
            }
        }
        if (movePossible) {
            board[x][y] = symbol; // Place the player's symbol on the board
        }
        return movePossible; // Return whether the move was valid
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        OthelloBoard b = new OthelloBoard(); // Initialize the Othello board
        int n = s.nextInt(); // Number of moves

        boolean p1Turn = true; // Player 1 starts
        while (n > 0) { // Loop until all moves are made
            int x = s.nextInt(); // Read x coordinate
            int y = s.nextInt(); // Read y coordinate
            boolean ans = false; // Flag to check if the move was successful
            if (p1Turn) {
                ans = b.move(player1Symbol, x, y); // Player 1's move
            } else {
                ans = b.move(player2Symbol, x, y); // Player 2's move
            }
            if (ans) {
                b.print(); // Print the board if the move was successful
                p1Turn = !p1Turn; // Switch turns
                n--; // Decrease the number of moves left
            } else {
                System.out.println(ans); // Print false if the move was invalid
            }
        }
        s.close(); // Close the scanner
    }
}
