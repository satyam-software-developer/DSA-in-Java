
/*Problem statement
Raj is throwing a birthday party. He wants to invite as many friends as possible. He wants a large wooden table to accommodate his friends. There is constraint for this: space in the room. The number of friends a table can accommodate is equal to its perimeter (the sum of all side lengths). The furniture must be placed so that the edges are parallel to the edges of the flat.

You will be given layout of the flat and you have to tell maximum number of friends that he can accommodate in his room.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains two integers R and C (1 <= R, C <= 400), these are the dimensions of the flat.
Each of the following R rows contain exactly C characters. Characters can be '.', 'X'. '.' character means that cell is free and can be used for placing wooden table. 'X' means that cell is blocked and hence, cannot be used.
Constraints:
Time Limit: 1 second
Output format:
Print the maximum number of friends Raj can accommodate, if he buys his table. 
Sample Input 1
2 2
..
..
Sample Output 1:
7
Sample Input 1
4 4
X.XX
X..X
..X.
..XX 
Sample Output 1:
9
Explanation:
Please refer to the image below for explanation:
Alt Text */

import java.util.*;

public class MaximumInvitations {

    // Method to calculate the perimeter of a rectangle given its width and height
    static int peri(int w, int h) {
        return w * 2 + h * 2;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Read the dimensions of the grid
        int n = s.nextInt(); // Number of rows
        int m = s.nextInt(); // Number of columns
        s.nextLine(); // Consume the remaining newline character

        // Initialize a 2D character array to store the grid
        char[][] arr = new char[n][m];

        // Initialize an array to keep track of consecutive empty cells ('.') in each
        // column
        int[] cnt = new int[m];

        // Variable to track the maximum perimeter found
        int max = 0;

        // Loop through each row in the grid
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLine().toCharArray(); // Read the row and convert it to a character array

            // Update the count of consecutive empty cells in each column
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '.') {
                    cnt[j]++; // Increment the count if the cell is empty
                } else {
                    cnt[j] = 0; // Reset the count if the cell is blocked
                }
            }

            // Calculate the maximum perimeter for rectangles ending in the current row
            for (int j = 0; j < m; j++) {
                int h = cnt[j]; // Height of the rectangle is the count of consecutive empty cells in the column
                int w = 1; // Initialize the width of the rectangle as 1

                // Expand the width of the rectangle to the right
                if (h > 0) { // Only expand if there is a height
                    for (int k = j + 1; k < m; k++) {
                        if (cnt[k] < h) { // Stop expanding if a shorter column is encountered
                            break;
                        }
                        w++;
                    }

                    // Expand the width of the rectangle to the left
                    for (int k = j - 1; k > 0; k--) {
                        if (cnt[k] < h) { // Stop expanding if a shorter column is encountered
                            break;
                        }
                        w++;
                    }
                }

                // Update the maximum perimeter found so far
                max = Math.max(max, peri(w, h));
            }
        }

        // Output the maximum perimeter minus 1 (since the question likely requires this
        // adjustment)
        System.out.println(max - 1);
    }
}
