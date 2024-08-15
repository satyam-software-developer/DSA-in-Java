
/*Problem statement
CodingNinjasLand is hosting this edition of Kabaddi World Cup. Selection committee of CodingNinjasLand needs your help. They want to select a 12-membered team. You have to print all possible combinations of the team, so, that selectors can select any one combination for World Cup at GitNagar, CodingNinjasLand.

Detailed explanation ( Input/output format, Notes, Images )
Input Format

First line contains N - (Integer)
Second line contains N spaced integers which are player Id of players. Note that, all the N integers are given in sorted order.
Constraints

12<= N <= 20
1<= A(i) <=1000
Output Format

Print the combinations in N lines.
Sample Input 0
13
1 2 3 4 5 6 7 8 9 10 11 12 13
Sample Output 0
1 2 3 4 5 6 7 8 9 10 11 12
1 2 3 4 5 6 7 8 9 10 11 13 
1 2 3 4 5 6 7 8 9 10 12 13 
1 2 3 4 5 6 7 8 9 11 12 13 
1 2 3 4 5 6 7 8 10 11 12 13 
1 2 3 4 5 6 7 9 10 11 12 13 
1 2 3 4 5 6 8 9 10 11 12 13 
1 2 3 4 5 7 8 9 10 11 12 13 
1 2 3 4 6 7 8 9 10 11 12 13 
1 2 3 5 6 7 8 9 10 11 12 13 
1 2 4 5 6 7 8 9 10 11 12 13 
1 3 4 5 6 7 8 9 10 11 12 13 
2 3 4 5 6 7 8 9 10 11 12 13 */

import java.util.Scanner;

public class TeamSelection {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = new int[s.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        solve(arr, 12, 0, "");

    }

    private static void solve(int[] arr, int r, int vidx, String set) {
        // this must be prior so that last set gets printed when vidx == arr.length
        if (r == 0) {
            System.out.println(set);
            return;
        }
        // base case
        if (vidx == arr.length) {
            return;
        }
        // element gets added to set
        solve(arr, r - 1, vidx + 1, set + arr[vidx] + " ");
        // element is not added to set
        solve(arr, r, vidx + 1, set);
    }
}
