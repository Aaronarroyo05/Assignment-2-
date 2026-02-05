/**
 * CSCI 271 - Assignment II
 * Fraction class implementing exact arithmetic with normalization.
 */
public class Fraction {

    private final long numerator;
    private final long denominator;

    /**
     * Constructs a new Fraction a/b in reduced, normalized form.
     * Normalization rules:
     *  - Denominator is never negative (if b < 0, flip both signs).
     *  - gcd(|a|, |b|) is used to reduce.
     *  - Denominator may be 0 to represent Infinity, -Infinity, or NaN.
     */
    public Fraction(long a, long b) {
        if (b < 0) {
            a = -a;
            b = -b;
        }

        long g = gcd(a, b); // always > 0
        a /= g;
        b /= g;

        this.numerator = a;
        this.denominator = b;
    }

    /**
     * Constructs a new Fraction a/1.
     */
    public Fraction(long a) {
        this(a, 1);
    }

    /**
     * Euclidean algorithm for gcd, always returns > 0.
     * Handles the (0,0) case by returning 1 as per assignment spec.
     */
    private static long gcd(long a, long b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        if (a == 0) {
            a = 1;
        }
        return a;
    }

    /**
     * String representation:
     *  - "NaN" if 0/0
     *  - "Infinity" if >0/0
     *  - "-Infinity" if <0/0
     *  - "n" if denominator == 1
     *  - "n/d" otherwise
     */
    @Override
    public String toString() {
        if (denominator == 0) {
            if (numerator == 0) {
                return "NaN";
            } else if (numerator > 0) {
                return "Infinity";
            } else {
                return "-Infinity";
            }
        }

        if (denominator == 1) {
            return Long.toString(numerator);
        }

        return numerator + "/" + denominator;
    }

    /**
     * Returns a new Fraction equal to this + f.
     */
    public Fraction add(Fraction f) {
        long n = this.numerator * f.denominator + f.numerator * this.denominator;
        long d = this.denominator * f.denominator;
        return new Fraction(n, d);
    }

    /**
     * Returns a new Fraction equal to this - f.
     */
    public Fraction subtract(Fraction f) {
        long n = this.numerator * f.denominator - f.numerator * this.denominator;
        long d = this.denominator * f.denominator;
        return new Fraction(n, d);
    }

    /**
     * Returns a new Fraction equal to this * f.
     */
    public Fraction multiply(Fraction f) {
        long n = this.numerator * f.numerator;
        long d = this.denominator * f.denominator;
        return new Fraction(n, d);
    }

    /**
     * Returns a new Fraction equal to this / f.
     */
    public Fraction divide(Fraction f) {
        long n = this.numerator * f.denominator;
        long d = this.denominator * f.numerator;
        return new Fraction(n, d);
    }

    /**
     * Returns a new Fraction that is the negative of this.
     *  - negate(Infinity) = -Infinity
     *  - negate(-Infinity) = Infinity
     *  - negate(NaN) = NaN
     */
    public Fraction negate() {
        return new Fraction(-this.numerator, this.denominator);
    }

    /**
     * Returns a new Fraction equal to this^n, where n may be zero or negative.
     * Basic rules:
     *  - x^0 = 1 for any x != 0/0
     *  - (0/0)^n = NaN
     *  - For n > 0: (a/b)^n = a^n / b^n
     *  - For n < 0: (a/b)^n = (b^|n|) / (a^|n|)
     * Note: long overflow is ignored as per typical assignment scope.
     */
    public Fraction pow(int n) {
        // NaN stays NaN for any exponent
        if (this.denominator == 0 && this.numerator == 0) {
            return new Fraction(0, 0); // NaN
        }

        if (n == 0) {
            // Anything except NaN to the 0 is 1
            return new Fraction(1, 1);
        }

        boolean negativeExponent = n < 0;
        int exp = Math.abs(n);

        long baseNum = this.numerator;
        long baseDen = this.denominator;

        // Repeated multiplication (simple, clear; not optimized)
        long numPow = 1;
        long denPow = 1;

        for (int i = 0; i < exp; i++) {
            numPow *= baseNum;
            denPow *= baseDen;
        }

        if (negativeExponent) {
            // (a/b)^(-n) = (b^n)/(a^n)
            return new Fraction(denPow, numPow);
        } else {
            return new Fraction(numPow, denPow);
        }
    }

    // Getters (optional, but can help in testing if needed)
    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
}
