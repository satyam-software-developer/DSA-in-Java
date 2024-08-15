/*Problem statement
Write a program to input a name(as a single character) and marks of three tests as m1, m2, and m3 of a student considering all the three marks have been given in integer format.

Now, you need to calculate the average of the given marks and print it along with the name as mentioned in the output format section.

All the test marks are in integers and hence calculate the average in integer as well. That is, you need to print the integer part of the average only and neglect the decimal part.




Detailed explanation ( Input/output format, Notes, Images )
Constraints
Marks for each student lie in the range 0 to 100 (both inclusive)
Sample Test 1
Input:
R
0 100 99 
Output:
R 
66
 */


package lecture2;

import java.util.Scanner; // Importing the Scanner class from java.util package

public class AverageMarks { // Declaring the public class AverageMarks

    public static void main(String[] args) { // Declaring the main method
        
        Scanner s = new Scanner(System.in); // Creating a new Scanner object to read input from the standard input stream
        
        char name = s.next().charAt(0); // Reading the first character of the input string and storing it in the variable 'name'
        int m1, m2, m3; // Declaring variables to store three integer values

        // Reading three integer values from the standard input stream
        m1 = s.nextInt(); 
        m2 = s.nextInt();
        m3 = s.nextInt();

        // Calculating the average of the three integer values
        int avg = (m1 + m2 + m3) / 3;

        // Printing the name and average marks to the standard output stream
        System.out.println(name); 
        System.out.print(avg);
    }
}
