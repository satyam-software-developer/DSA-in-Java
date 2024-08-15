/*Problem statement
Write a code to perform different operations on matrix.

1. Addition
 You are given two matrices return the addition of these two matrices.
2. Multiplication
Given two matrices return the matrix multiplication of them.(Both the matrices will always be multiplicable).
3. Transpose
Given a Matrix calculate the transpose of the matrix and return it. (Number of rows and columns will be same)
4. Rotate by 90
Given a Matrix, rotate the matrix by 90 degree in anticlockwise direction.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1: Operation to be performed
Line 2 : No of rows(n1) & No of columns(m1) (separated by space)
Line 3 : Row 1 elements (separated by space)
Line 4 : Row 2 elements (separated by space)
Line 5 : and so on
(If needed)
Line n1+2 : No of rows(n2) & No of columns(m2)(separated by space)
Line n1+3 : Row 1 elements (separated by space)
Line n1+4 : Row 2 elements (separated by space)
Line n1+5 : and so on
Sample Input 1 :
1
2 2
1 2
1 3
2 2
4 3
1 5
Sample output 1 :
5 5
2 8
Sample Input 2 :
2
2 2
1 2
1 3
2 2
4 3
1 5
Sample output 2 :
6 13
7 18
Sample Input 3 :
3
2 2
1 2
1 3
Sample output 3 :
1 1
2 3
Sample Input 4 :
4
2 2
1 2
1 3
Sample output 4 :
2 3
1 1
Note : Partial marking is there, so implementation of each function will give you some marks. */

import java.util.Scanner;

public class MatrixClass {
    int[][] matrix; // Instance variable to store the matrix

    // Constructor to initialize the matrix
    MatrixClass(int[][] mat) {
        matrix = mat;
    }

    // Method to add two matrices
    public static MatrixClass add(MatrixClass a, MatrixClass b) {
        int[][] ans = new int[a.matrix.length][a.matrix[0].length];
        // Loop through each element of the matrices and perform addition
        for (int i = 0; i < a.matrix.length; i++) {
            for (int j = 0; j < a.matrix[0].length; j++) {
                ans[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        // Return the result matrix as a new MatrixClass object
        return new MatrixClass(ans);
    }

    // Method to multiply two matrices
    public static MatrixClass multiply(MatrixClass a, MatrixClass b) {
        int[][] ans = new int[a.matrix.length][b.matrix[0].length];
        // Loop through each element of the result matrix
        for (int i = 0; i < a.matrix.length; i++) {
            for (int j = 0; j < b.matrix[0].length; j++) {
                for (int k = 0; k < a.matrix[0].length; k++) {
                    // Perform multiplication and accumulation
                    ans[i][j] += a.matrix[i][k] * b.matrix[k][j];
                }
            }
        }
        // Return the result matrix as a new MatrixClass object
        return new MatrixClass(ans);
    }

    // Method to transpose a matrix
    public static MatrixClass transpose(MatrixClass m) {
        int[][] transMatrix = new int[m.matrix[0].length][m.matrix.length];
        // Loop through each element of the original matrix and transpose
        for (int i = 0; i < m.matrix.length; i++) {
            for (int j = 0; j < m.matrix[0].length; j++) {
                transMatrix[j][i] = m.matrix[i][j];
            }
        }
        // Return the transposed matrix as a new MatrixClass object
        return new MatrixClass(transMatrix);
    }

    // Method to rotate a matrix
    public static MatrixClass rotate(MatrixClass m) {
        int rows = m.matrix.length;
        int cols = m.matrix[0].length;
        int[][] rotateMatrix = new int[cols][rows];
        // Loop through each element of the original matrix and rotate
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotateMatrix[j][rows - i - 1] = m.matrix[i][j];
            }
        }
        // Return the rotated matrix as a new MatrixClass object
        return new MatrixClass(rotateMatrix);
    }

    // Method to print the matrix
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int option = s.nextInt(); // Read the option
        if (option == 1 || option == 2) {
            // Read dimensions and elements for both matrices
            int r1 = s.nextInt();
            int c1 = s.nextInt();
            int[][] m1 = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    m1[i][j] = s.nextInt();
                }
            }
            MatrixClass mat1 = new MatrixClass(m1);
            int r2 = s.nextInt();
            int c2 = s.nextInt();
            int[][] m2 = new int[r2][c2];
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    m2[i][j] = s.nextInt();
                }
            }
            MatrixClass mat2 = new MatrixClass(m2);
            // Perform addition or multiplication based on the option
            MatrixClass ans = (option == 1) ? MatrixClass.add(mat1, mat2) : MatrixClass.multiply(mat1, mat2);
            ans.print(); // Print the result
        } else if (option == 3 || option == 4) {
            // Read dimensions and elements for the matrix
            int r1 = s.nextInt();
            int c1 = s.nextInt();
            int[][] m1 = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    m1[i][j] = s.nextInt();
                }
            }
            MatrixClass mat1 = new MatrixClass(m1);
            // Perform transpose or rotation based on the option
            MatrixClass ans = (option == 3) ? MatrixClass.transpose(mat1) : MatrixClass.rotate(mat1);
            ans.print(); // Print the result
        }
    }
}
