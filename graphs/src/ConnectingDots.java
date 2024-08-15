
/*Problem statement
Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:

1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.

Detailed explanation ( Input/output format, Notes, Images )
Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns of the board. 
Each of the following N lines contain M characters. Please note that characters are not space separated. Each character is an uppercase Latin letter.
Output Format :
For C++: Print true if there is a cycle in the board, else print false.
For Java: Print 1 if there is a cycle in the board, else print 0.
Constraints :
2 <= N <= 1000
2 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
3 4
AAAA
ABCA
AAAA
Sample Output 1:
true */

/*
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 * 
 * where N and M are the rows and columns respectively of the board
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectingDots {

    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    int[][] visited;
    int findCycle = 0;

    void dfs(String[] board, int x, int y, int fromX, int fromY, char needColor, int n, int m) {
        // Base cases for DFS
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (board[x].charAt(y) != needColor) {
            return;
        }
        if (visited[x][y] == 1) {
            findCycle = 1;
            return;
        }

        visited[x][y] = 1;

        // Exploring the 4 possible directions
        for (int f = 0; f < 4; f++) {
            int nextX = x + dx[f];
            int nextY = y + dy[f];

            // Skipping the previous cell to avoid trivial cycle
            if (nextX == fromX && nextY == fromY) {
                continue;
            }
            dfs(board, nextX, nextY, x, y, needColor, n, m);
        }
    }

    int solve(String[] board, int n, int m) {
        visited = new int[n][m];

        // Initialize the visited array
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }

        // Start DFS from each unvisited cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    dfs(board, i, j, -1, -1, board[i].charAt(j), n, m);
                    if (findCycle == 1) {
                        return findCycle; // Cycle found, return immediately
                    }
                }
            }
        }
        return findCycle; // No cycle found
    }

    // Function to take input
    public static String[] takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split("\\s");

        int N = Integer.parseInt(strNums[0]);
        int M = Integer.parseInt(strNums[1]);

        String[] Graph = new String[N];

        for (int i = 0; i < N; ++i) {
            Graph[i] = br.readLine(); // Read each row of the board
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] Graph = takeInput(); // Take input
        ConnectingDots cd = new ConnectingDots(); // Create an instance of the class
        if (cd.solve(Graph, Graph.length, Graph[0].length()) == 1) {
            System.out.println("true"); // Cycle found
        } else {
            System.out.println("false"); // No cycle found
        }
    }
}
