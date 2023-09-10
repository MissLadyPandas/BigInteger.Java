import java.math.BigInteger;

// rational class representation of rational number
public class Rational extends Number implements Comparable<Rational> {
	// private member variables for the numerator and denominator
    private BigInteger numerator;
    private BigInteger denominator;

    // default constructor that creates a rational object representing 0 (0/1)
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // main constructor that accepts the numerator and denominator as arguments
    public Rational(BigInteger numerator, BigInteger denominator) {
    	// finds the greatest common divisor of the numerator and denominator
        BigInteger gcd = gcd(numerator, denominator);
        // reduce the numerator and denominator by the greatest common denominator to make sure fraction is in simplest form
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    // private method calculating the greatest common divisor using the Euclidean algorithm
    private static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }
    
    // public getter method for numerator
    public BigInteger getNumerator() {
        return numerator;
    }
    
    // public getter method for denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // method that returns a rational object that represents the sum of this rational number and another 
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // method that returns a new rational object that represents the difference of this rational number and another
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

 // method that returns a new rational object that represents the product of this rational number and another
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
 // method that returns a new rational object that represents the quotient of this rational number and another
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    // overrides the default toString method to provide a string representation of the rational number 
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    // override the default equal method to check if two rational objects represent the same rational object number
    @Override
    public boolean equals(Object other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            return this.subtract(r).getNumerator().equals(BigInteger.ZERO);
        }
        return false;
    }

    // ovveride class methods for different numeric formats of the rational number
    @Override
    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    @Override
    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    // method used to compare the current rational object with another
    @Override
    public int compareTo(Rational o) {
        BigInteger difference = this.subtract(o).getNumerator();
        return difference.compareTo(BigInteger.ZERO);
    }
}
