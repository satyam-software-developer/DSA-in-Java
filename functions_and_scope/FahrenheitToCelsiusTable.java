/*Problem statement
Given three values - Start Fahrenheit Value (S), End Fahrenheit value (E) and Step Size (W), you need to convert all Fahrenheit values from Start to End at the gap of W, into their corresponding Celsius values and print the table.

Note:
You don't have to write the main function or take input. It has already been taken care of and you need to just print the integer value . Just write the code that prints Fahrenheit to Celsius table in the function itself.
Formula is C = (F - 32) * 5/9
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
3 integers - S, E and W respectively
Output Format :
Fahrenheit to Celsius conversion table. One line for every Fahrenheit and Celsius Fahrenheit value. Fahrenheit value and its corresponding Celsius value should be separate by tab ("\t")
Constraints :
0 <= S <= 1000
0 <= E <= 1000
0 <= W <= 1000
Sample Input 1:
0 
100 
20
Sample Output 1:
0   -17
20  -6
40  4
60  15
80  26
100 37
Sample Input 2:
120 
200 
40
Sample Output 2:
120 48
160 71
200 93
Explanation for Sample Output 2 :
Start value is 120, end value is 200 and step size is 40. Therefore, the values we need to convert are 120, 120 + 40 = 160, and 160 + 40 = 200. 
The formula for converting Fahrenheit to Celsius is:
Celsius Value = (5/9)*(Fahrenheit Value - 32)  
Plugging 120 into the formula, the celsius value will be (5 / 9)*(120 - 32) => (5 / 9) * 88 => (5 * 88) / 9 => 440 / 9 => 48.88
But we'll only print 48 because we are only interested in the integral part of the value. */

package functions_and_scope;

import java.util.Scanner;

public class FahrenheitToCelsiusTable {
    // Method to print the Fahrenheit to Celsius conversion table
    public static void printFahrenheitTable(int start, int end, int step) {
        // Initialize a variable to store the current Fahrenheit value
        int currentValue = start;
        
        // Loop to iterate through the Fahrenheit values within the specified range
        while (currentValue <= end) {
            // Calculate the Celsius value using the conversion formula
            int celsiusValue = (int) ((5.0 / 9) * (currentValue - 32));
            
            // Print the current Fahrenheit and corresponding Celsius values
            System.out.println(currentValue + "\t" + celsiusValue);
            
            // Increment the current Fahrenheit value by the specified step
            currentValue += step;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to read user input

        // Read the starting, ending, and step values for the Fahrenheit table
        int start = s.nextInt();
        int end = s.nextInt();
        int step = s.nextInt();

        // Call the method to print the Fahrenheit to Celsius table
        printFahrenheitTable(start, end, step);
    }
}
