

package conditionals_and_loops;

// import the Scanner class to take user input
import java.util.Scanner;

// create a class named Calculator
public class Calculator {

    // create a main method
    public static void main(String[] args) {

        // declare variables to store two numbers and the operator
        double num1, num2;
        char operator;

        // create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // prompt the user to enter the first number
        System.out.println("Enter the first number:");
        num1 = sc.nextDouble();

        // prompt the user to enter the second number
        System.out.println("Enter the second number:");
        num2 = sc.nextDouble();

        // prompt the user to enter the operator (+, -, *, /, or %)
        System.out.println("Enter the operator (+, -, *, /, or %):");
        operator = sc.next().charAt(0);

        // declare a variable to store the result
        double result;

        // use a switch statement to perform the appropriate operation
        switch (operator) {
            case '+':
                // add the numbers and store the result
                result = num1 + num2;
                break;
            case '-':
                // subtract the numbers and store the result
                result = num1 - num2;
                break;
            case '*':
                // multiply the numbers and store the result
                result = num1 * num2;
                break;
            case '/':
                // divide the numbers and store the result
                result = num1 / num2;
                break;
            case '%':
                // find the remainder and store the result
                result = num1 % num2;
                break;
            default:
                // display an error message if the operator is invalid
                System.out.println("Invalid operator!");
                return; // exit the program
        }

        // display the result
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}



