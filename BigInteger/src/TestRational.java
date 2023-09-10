import java.util.Scanner;
import java.math.BigInteger;

public class TestRational {
    public static void main(String[] args) {
    	// create scanner object for user input
        Scanner input = new Scanner(System.in);
        //prompts user for first rational number 
        System.out.print("Enter the first rational number (in the format 'a b' for a/b): ");
        // reads the numerator for the first rational number
        BigInteger numerator1 = input.nextBigInteger();
        // reads the denominator for the first rational number
        BigInteger denominator1 = input.nextBigInteger();

        // prompts user for second rational number
        System.out.print("Enter the second rational number (in the format 'a b' for a/b): ");
        // reads the numerator for the second rational number
        BigInteger numerator2 = input.nextBigInteger();
        // reads the denominator for the second rational number
        BigInteger denominator2 = input.nextBigInteger();

        //creates the first rational number using the first set of numbers
        Rational r1 = new Rational(numerator1, denominator1);
        // creates the second rational number using the second set of numbers
        Rational r2 = new Rational(numerator2, denominator2);

        //displays the addition output of the two rational numbers
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        //displays the subration output of the two rational numbers
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        //displays the multiplication output of the two rational numbers
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        //displays the division output of the two rational numbers
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        // converts the second rational number to a decimal and displays it
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}
