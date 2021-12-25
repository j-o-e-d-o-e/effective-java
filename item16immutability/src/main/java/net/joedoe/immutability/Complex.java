package net.joedoe.immutability;

public class Complex {
    private final double re;
    private final double im;
    // common use cases to avoid object creation
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);


    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // public static factory and private constructor (instead of final class declaration)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public double getRealPart() {
        return re;
    }

    public double getImaginaryPart() {
        return im;
    }

    // functional approach, i.e. methods return the result of applying a function
    // to their operand without modifying it => enables immutability
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Complex)) return false;
        Complex c = (Complex) o;
        // See page 47 to find out why we use compare instead of ==
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
