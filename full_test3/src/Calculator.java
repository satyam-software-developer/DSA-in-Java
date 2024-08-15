
/* Problem statement
Given a String s, consisting of non negative integers and +,- operators as well as brackets ( and ).

Your task is to solve the given string and print the output.

Detailed explanation ( Input/output format, Notes, Images )
Input Format:
First and only line contains the string s.
Output Format:
Print the result of the given string.
Constraints:
1 <= String length <= 20000
Sample Input 1:
(1+2)
Sample Output 1:
3
Sample Input 2:
(1+(4+5+2)-3)+(6+8)
Sample Output 2:
23 */

import java.util.*; // Import the necessary Java utility classes, including Stack.

public class Calculator {

    // Method to evaluate an expression from a stack.
    // This method assumes that the expression is in the correct order.
    public static int evaluateExpr(Stack<Object> stack) {

        int res = 0; // Initialize the result to 0.

        // If the stack is not empty, pop the top element to start the calculation.
        if (!stack.empty()) {
            res = (int) stack.pop(); // The first element is an integer, so cast it to int.
        }

        // Evaluate the expression until we find a closing parenthesis ')'.
        while (!stack.empty() && !((char) stack.peek() == ')')) {
            char sign = (char) stack.pop(); // Pop the sign (either '+' or '-').

            // Depending on the sign, add or subtract the next integer.
            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res; // Return the evaluated result.
    }

    // Method to calculate the value of a mathematical expression given as a string.
    public static int calculate(String s) {

        int operand = 0; // Initialize the current operand (number) to 0.
        int n = 0; // Initialize a counter to track the number of digits in the current operand.
        Stack<Object> stack = new Stack<Object>(); // Create a stack to store the operands and operators.

        // Iterate over the string from the end to the beginning.
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i); // Get the current character in the string.

            // If the character is a digit, form the operand in reverse order.
            if (Character.isDigit(ch)) {
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1; // Increment the counter to move to the next digit position.

            } else if (ch != ' ') { // If the character is not a space,
                if (n != 0) {
                    // Push the formed operand onto the stack when a non-digit is encountered.
                    stack.push(operand);
                    n = 0; // Reset the operand and counter for the next number.
                    operand = 0;
                }
                if (ch == '(') {
                    // If a '(' is encountered, evaluate the expression inside the parentheses.
                    int res = evaluateExpr(stack);
                    stack.pop(); // Remove the corresponding ')' from the stack.

                    // Push the result of the evaluated sub-expression back onto the stack.
                    stack.push(res);

                } else {
                    // For other non-digit characters (like operators), just push them onto the
                    // stack.
                    stack.push(ch);
                }

            }
        }

        // If there is any remaining operand after the loop, push it onto the stack.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any remaining elements in the stack.
        return evaluateExpr(stack);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create a Scanner object to take user input.
        String str = s.next(); // Read the input string (expression).
        System.out.println(calculate(str)); // Calculate and print the result.
    }
}
