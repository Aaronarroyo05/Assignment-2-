/**
 * CSCI 271 - Assignment II
 * Test program for the Fraction class.
 *
 * Each test block is labeled with the condition it checks.
 */
public class TestFraction {

    public static void main(String[] args) {

        System.out.println("=== Task 1: Normalization & Constructors ===");

        // Condition: reduction and sign normalization
        // new Fraction(6, -24) -> -1/4
        Fraction t1a = new Fraction(6, -24);
        System.out.println("Test 1a (6, -24) expected -1/4: " + t1a);

        // Condition: zero numerator becomes 0/1
        // new Fraction(0, 8) -> 0/1
        Fraction t1b = new Fraction(0, 8);
        System.out.println("Test 1b (0, 8) expected 0: " + t1b);

        // Condition: single-argument constructor a -> a/1
        Fraction t1c = new Fraction(16);
        System.out.println("Test 1c (16) expected 16: " + t1c);

        System.out.println("\n=== Task 2: toString() Special Values ===");

        // Condition: negative denominator reduced and printed correctly
        Fraction t2a = new Fraction(8, -6); // -> -4/3
        System.out.println("Test 2a (8, -6) expected -4/3: " + t2a);

        // Condition: Infinity (positive)
        Fraction t2b = new Fraction(23, 0); // -> Infinity
        System.out.println("Test 2b (23, 0) expected Infinity: " + t2b);

        // Condition: -Infinity
        Fraction t2c = new Fraction(-6, 0); // -> -Infinity
        System.out.println("Test 2c (-6, 0) expected -Infinity: " + t2c);

        // Condition: denominator = 1 prints just numerator
        Fraction t2d = new Fraction(7, 1); // -> "7"
        System.out.println("Test 2d (7, 1) expected 7: " + t2d);

        // Condition: NaN (0/0)
        Fraction t2e = new Fraction(0, 0); // -> NaN
        System.out.println("Test 2e (0, 0) expected NaN: " + t2e);

        System.out.println("\n=== Task 3: Arithmetic Operations ===");

        // Condition: add with regular fractions
        Fraction a1 = new Fraction(1, 3);
        Fraction a2 = new Fraction(1, 6);
        Fraction addRes = a1.add(a2); // 1/3 + 1/6 = 1/2
        System.out.println("Add 1/3 + 1/6 expected 1/2: " + addRes);

        // Condition: subtract with regular fractions
        Fraction s1 = new Fraction(5, 4);
        Fraction s2 = new Fraction(1, 2);
        Fraction subRes = s1.subtract(s2); // 5/4 - 1/2 = 3/4
        System.out.println("Subtract 5/4 - 1/2 expected 3/4: " + subRes);

        // Condition: multiply with regular fractions
        Fraction m1 = new Fraction(2, 3);
        Fraction m2 = new Fraction(3, 5);
        Fraction mulRes = m1.multiply(m2); // 2/3 * 3/5 = 2/5
        System.out.println("Multiply 2/3 * 3/5 expected 2/5: " + mulRes);

        // Condition: divide with regular fractions
        Fraction d1 = new Fraction(4, 5);
        Fraction d2 = new Fraction(2, 3);
        Fraction divRes = d1.divide(d2); // (4/5) / (2/3) = 12/10 = 6/5
        System.out.println("Divide 4/5 / 2/3 expected 6/5: " + divRes);

        // Condition: negate regular fraction
        Fraction n1 = new Fraction(3, 7);
        Fraction negRes = n1.negate(); // -3/7
        System.out.println("Negate 3/7 expected -3/7: " + negRes);

        // Condition: negate Infinity, -Infinity, NaN
        Fraction inf = new Fraction(5, 0);   // Infinity
        Fraction ninf = new Fraction(-5, 0); // -Infinity
        Fraction nan = new Fraction(0, 0);   // NaN
        System.out.println("Negate Infinity expected -Infinity: " + inf.negate());
        System.out.println("Negate -Infinity expected Infinity: " + ninf.negate());
        System.out.println("Negate NaN expected NaN: " + nan.negate());

        // Condition: operations involving Infinity and NaN
        // Infinity + 1/2 -> Infinity
        Fraction infPlus = inf.add(new Fraction(1, 2));
        System.out.println("Infinity + 1/2 expected Infinity: " + infPlus);

        // Infinity + (-Infinity) -> NaN
        Fraction infPlusNegInf = inf.add(ninf);
        System.out.println("Infinity + -Infinity expected NaN: " + infPlusNegInf);

        // NaN + 1/3 -> NaN
        Fraction nanPlus = nan.add(new Fraction(1, 3));
        System.out.println("NaN + 1/3 expected NaN: " + nanPlus);

        System.out.println("\n=== Task 3: pow(int n) ===");

        // Condition: positive exponent
        Fraction p1 = new Fraction(2, 3);
        Fraction p1pow3 = p1.pow(3); // (2/3)^3 = 8/27
        System.out.println("(2/3)^3 expected 8/27: " + p1pow3);

        // Condition: zero exponent (non-NaN)
        Fraction p2 = new Fraction(5, 7);
        Fraction p2pow0 = p2.pow(0); // -> 1
        System.out.println("(5/7)^0 expected 1: " + p2pow0);

        // Condition: negative exponent
        Fraction p3 = new Fraction(2, 5);
        Fraction p3powMinus2 = p3.pow(-2); // (2/5)^-2 = (5^2)/(2^2) = 25/4
        System.out.println("(2/5)^-2 expected 25/4: " + p3powMinus2);

        // Condition: pow on NaN stays NaN
        Fraction nanPow2 = nan.pow(2);
        System.out.println("NaN^2 expected NaN: " + nanPow2);

        // Condition: pow on Infinity
        Fraction infPow2 = inf.pow(2); // Infinity^2 -> Infinity
        System.out.println("Infinity^2 expected Infinity: " + infPow2);

        System.out.println("\n=== Full Example from Assignment Description ===");

        // Fraction a = new Fraction(16);
        Fraction a = new Fraction(16);

        // Fraction b = new Fraction(3,5).add(new Fraction(7));
        Fraction b = new Fraction(3, 5).add(new Fraction(7));

        // Fraction c = new Fraction(6,7);
        Fraction c = new Fraction(6, 7);

        // Fraction result = c.multiply(a.divide(b));
        Fraction result = c.multiply(a.divide(b));

        System.out.println("Expected 240/133: " + result);
    }
}
