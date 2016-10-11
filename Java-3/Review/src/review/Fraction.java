package review;

/**
 *
 * @author jhg95693
 */
public class Fraction implements Comparable
{
    private int num; // for numerator
    private int den; // for denominator

    /** Implicit constructor **/
    public Fraction(int num, int den)
    {
        this.num = num;
        this.den = den;
    }

    /** Explicit constructor **/
    public Fraction()
    {
        num = 0;
        den = 1;
    }

    /* Define a method that finds the sum of this Fraction and another one.
     * @param f the second addend of the addition
     * @return the sum of this Fraction and f
     */
    public Fraction add(Fraction f)
    {
        Fraction f1 = new Fraction(this.num * f.den + this.den * f.num, this.den * f.den);
        f1.simplify();
        return f1;
    }

    /** Define a method that simplifies this Fraction to its lowest terms **/
    public void simplify()
    {
        // 1. Find the gcd of the numerator and denominator
        int gcd = gcd(Math.abs(num), Math.abs(den));

        // 2. Divide num + den by gcd and assign it to num and den
        if (gcd != 1) {
            num = num/gcd;
            den = den/gcd;
        }
    }

    /** Define a method that compares whether this Fraction is equal to another Fraction
     * @param f the fraction the instance of this class is being compared to
     * @return a boolean stating whether the two fractions are equal **/
    public boolean equals(Fraction f)
    {
        return (this.num * f.den) == (this.den * f.num);
    }

    /** Define a method that finds the equivalent decimal value of this Fraction
     * @return
     */
    public double toDecimal()
    {
        return (double) num/(double) den;
    }

    public int gcd(int a, int b)
    {
        int c = ((a > b) ? b:a);
        if (a == 0) return b;
        else if (b == 0) return a;
        for (int i = c; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public int compareTo(Object o) {
        Fraction f = (Fraction) o;
        if (this.toDecimal() > f.toDecimal()) return 1;
        if (this.equals(f)) return 0;
        return -1;
    }
}
