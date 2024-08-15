/* 
Problem statement
Implement a polynomial class, that contains following functions -

1. setCoefficient -
This function sets coefficient for a particular degree value. If term with given degree is not there in the polynomial, then corresponding term (with specified degree and value) is added. If the term is already present in the polynomial, then previous coefficient value is replaced by given coefficient value.

2. add -
Adds two polynomials and returns a new polynomial which has the result.

3. subtract -
Subtracts two polynomials and returns a new polynomial which has the result.

4. multiply -
Multiplies two polynomials and returns a new polynomial which has the result.

5. print -
Prints all the terms (only terms with non zero coefficients are to be printed) in increasing order of degree.

Print pattern for a single term : "x"

And multiple terms should be printed separated by space. For more clarity, refer sample test cases.

Note : Only keep those terms which have non - zero coefficients.


Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first line of input contains count of the number of coefficients in polynomial 1(C1)
The next line of input has C1 degrees for polynomial 1.
The next line of input has C1 coefficients for polynomial 1.  
The next line of input contains count of the number of coefficients in polynomial 2(C2)
The next line of input has C2 degrees for polynomial 2.
The next line of input has C2 coefficients for polynomial 2.  
The next line of input has the choice for the function you want to implement.
Output Format:
The output will be printed in case of print function same as that of print function format.
Sample Input 1 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 1 :
P1 + P2 = 2x2 2x3 3x4 4x6
Sample Input 2 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 2 :
P1 - P2 = 2x3 -3x4 4x6

*/

package oops;

import java.util.Scanner;

public class PolynomialClass {
    int degCoeff[]; // Array to store the coefficients of the polynomial

    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     * then corresponding term (with specified degree and value) is added in the polynomial. If the degree
     * is already present in the polynomial then the previous coefficient is replaced by the new coefficient value passed as function argument.
    */
    public PolynomialClass() {
        degCoeff = new int[10]; // Initializes the degree coefficients array with a default size of 10
    }

    // Method to set the coefficient for a specific degree
    public void setCoefficient(int degree, int coeff) {
        if (degree > degCoeff.length - 1) { // If the degree is greater than the array length, resize the array
            // Create a new array with size = degree + 1
            int temp[] = degCoeff;
            degCoeff = new int[degree + 1];
            // Copy values from the temporary array to the degree coefficients array
            for (int i = 0; i < temp.length; i++) {
                degCoeff[i] = temp[i];
            }
        }
        degCoeff[degree] = coeff; // Set the coefficient for the specified degree
    }
    
    // Method to print all the terms (only terms with non-zero coefficients) in increasing order of degree
    public void print() {
        boolean firstTermPrinted = false;
        // Iterate through the degree coefficients array
        for (int i = 0; i < degCoeff.length; i++) {
            if (degCoeff[i] != 0) { // If the coefficient is non-zero
                if (firstTermPrinted) { // If it's not the first term, print a space before printing the term
                    System.out.print(" ");
                } else {
                    firstTermPrinted = true; // Set the flag to true after printing the first term
                }
                System.out.print(degCoeff[i] + "x" + i); // Print the term in the format: coefficientxdegree
            }
        }
        System.out.println(); // Print a newline after printing all the terms
    }

    // Method to add two polynomials and return a new polynomial with the result
    public PolynomialClass add(PolynomialClass p) {
        PolynomialClass ans = new PolynomialClass(); // Create a new PolynomialClass object to store the result
        int len = Math.max(degCoeff.length, p.degCoeff.length); // Determine the maximum length of the two polynomials
        for (int i = 0; i < len; i++) {
            int coeff1 = (i < degCoeff.length) ? degCoeff[i] : 0; // Get the coefficient for the current degree in the first polynomial
            int coeff2 = (i < p.degCoeff.length) ? p.degCoeff[i] : 0; // Get the coefficient for the current degree in the second polynomial
            ans.setCoefficient(i, coeff1 + coeff2); // Add the coefficients and set the result in the new polynomial
        }
        return ans; // Return the new polynomial with the result
    }
    
    // Method to subtract two polynomials and return a new polynomial with the result
    public PolynomialClass subtract(PolynomialClass p) {
        PolynomialClass ans = new PolynomialClass(); // Create a new PolynomialClass object to store the result
        int len = Math.max(degCoeff.length, p.degCoeff.length); // Determine the maximum length of the two polynomials
        for (int i = 0; i < len; i++) {
            int coeff1 = (i < degCoeff.length) ? degCoeff[i] : 0; // Get the coefficient for the current degree in the first polynomial
            int coeff2 = (i < p.degCoeff.length) ? p.degCoeff[i] : 0; // Get the coefficient for the current degree in the second polynomial
            ans.setCoefficient(i, coeff1 - coeff2); // Subtract the coefficients and set the result in the new polynomial
        }
        return ans; // Return the new polynomial with the result
    }

    // Method to multiply two polynomials and return a new polynomial with the result
    public PolynomialClass multiply(PolynomialClass p) {
        PolynomialClass ans = new PolynomialClass(); // Create a new PolynomialClass object to store the result
        // Iterate through the coefficients of the first polynomial
        for (int i = 0; i < degCoeff.length; i++) {
            // Iterate through the coefficients of the second polynomial
            for (int j = 0; j < p.degCoeff.length; j++) {
                int termdeg = i + j; // Calculate the degree of the product term
                int termCoeff = degCoeff[i] * p.degCoeff[j]; // Calculate the coefficient of the product term
                int oldCoeff = ans.degCoeff[termdeg]; // Get the current coefficient for the product term
                ans.setCoefficient(termdeg, termCoeff + oldCoeff); // Add the new coefficient to the existing one and set it in the result polynomial
            }
        }
        return ans; // Return the new polynomial with the result
    }
    
    // Method to get the coefficient for a specific degree
    public int getCoeff(int degree) {
        if (degree < degCoeff.length) {
            return degCoeff[degree]; // Return the coefficient if the degree is within the array bounds
        } else {
            return 0; // Return 0 if the degree is out of bounds
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Read the count of coefficients in polynomial 1
        int degree1[] = new int[n];
        for (int i = 0; i < n; i++) {
            degree1[i] = s.nextInt(); // Read the degrees for polynomial 1
        }
        int coeff1[] = new int[n];
        for (int i = 0; i < n; i++) {
            coeff1[i] = s.nextInt(); // Read the coefficients for polynomial 1
        }
        PolynomialClass first = new PolynomialClass(); // Create an instance of PolynomialClass for polynomial 1
        for (int i = 0; i < n; i++) {
            first.setCoefficient(degree1[i], coeff1[i]); // Set coefficients for polynomial 1
        }
        n = s.nextInt(); // Read the count of coefficients in polynomial 2
        int degree2[] = new int[n];
        for (int i = 0; i < n; i++) {
            degree2[i] = s.nextInt(); // Read the degrees for polynomial 2
        }
        int coeff2[] = new int[n];
        for (int i = 0; i < n; i++) {
            coeff2[i] = s.nextInt(); // Read the coefficients for polynomial 2
        }
        PolynomialClass second = new PolynomialClass(); // Create an instance of PolynomialClass for polynomial 2
        for (int i = 0; i < n; i++) {
            second.setCoefficient(degree2[i], coeff2[i]); // Set coefficients for polynomial 2
        }
        int choice = s.nextInt(); // Read the choice for the function to implement
        PolynomialClass result;
        switch (choice) {
            // Add
            case 1:
                result = first.add(second); // Add two polynomials
                result.print(); // Print the result
                break;
            // Subtract
            case 2:
                result = first.subtract(second); // Subtract two polynomials
                result.print(); // Print the result
                break;
            // Multiply
            case 3:
                result = first.multiply(second); // Multiply two polynomials
                result.print(); // Print the result
                break;
        }

    }
}
