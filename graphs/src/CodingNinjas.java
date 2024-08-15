
/* Problem statement
Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .

There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix. 
Each of the following N lines contain M characters. Please note that characters are not space separated.
Output Format :
Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
Constraints :
1 <= N <= 1000
1 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1
Sample Input 2:
5 5
DANDO
NNINJ
AXGJC
INJAA
CODDI
Sample Output 2:
0 */

/*
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 * where N and M are the rows and columns respectively of the board
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingNinjas {
    // Direction vectors for 8 possible movements
    int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    String pattern = "CODINGNINJA"; // The pattern we need to search
    int[][] used; // To keep track of visited cells

    // Function to check if a cell is within the bounds of the matrix
    int validPoint(int x, int y, int N, int M) {
        return (x >= 0 && x < N && y >= 0 && y < M) ? 1 : 0;
    }

    // DFS function to search for the pattern starting from (x, y)
    int DFS(String[] G, int x, int y, int index, int N, int M) {
        if (index == 11) { // If we have matched the entire pattern
            return 1;
        }
        used[x][y] = 1; // Mark this cell as visited
        int found = 0;

        // Explore all 8 directions
        for (int[] direction : directions) {
            int newx = x + direction[0];
            int newy = y + direction[1];

            // Check if the new cell is valid, matches the current character of the pattern,
            // and is not visited
            if (validPoint(newx, newy, N, M) == 1 && G[newx].charAt(newy) == pattern.charAt(index)
                    && used[newx][newy] == 0) {
                found = found | DFS(G, newx, newy, index + 1, N, M); // Recursively search the next character
            }
        }

        used[x][y] = 0; // Backtrack by unmarking this cell
        return found; // Return if the pattern is found or not
    }

    // Function to initiate the search for the pattern in the entire matrix
    int solve(String[] Graph, int N, int M) {
        used = new int[N][M];

        // Search for the pattern starting with the character 'C'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph[i].charAt(j) == 'C') {
                    if (DFS(Graph, i, j, 1, N, M) == 1) {
                        return 1; // If the pattern is found, return 1
                    }
                }
            }
        }
        return 0; // If the pattern is not found, return 0
    }

    // Function to take input
    public static String[] takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split("\\s");
        int N = Integer.parseInt(strNums[0]); // Number of rows
        int M = Integer.parseInt(strNums[1]); // Number of columns

        String[] Graph = new String[N];
        for (int i = 0; i < N; i++) {
            Graph[i] = br.readLine(); // Read each row of the matrix
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] Graph = takeInput(); // Take input
        CodingNinjas codingNinjas = new CodingNinjas(); // Create an instance of the CodingNinjas class
        int result = codingNinjas.solve(Graph, Graph.length, Graph[0].length()); // Call the solve function
        System.out.println(result); // Print the result
    }
}
