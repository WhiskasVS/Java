public class RationalFraction {

    private int numerator;
    private int denominator;

    RationalFraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    RationalFraction(int numerator, int denominator) throws Exception {
        if(denominator == 0)
            throw new Exception("\nInvalid data. Denominator can't be equals 0!");
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }
    RationalFraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public int getNumerator() { return this.numerator; }
    public int getDenominator() { return this.denominator; }

    public void setNumerator(int numerator) {
        this.numerator = numerator / gcd(Math.abs(numerator), Math.abs(this.denominator));
        this.denominator /= gcd(Math.abs(numerator), Math.abs(this.denominator));
    }
    public void setDenominator(int denominator) throws Exception {
        if(denominator == 0)
            throw new Exception("\nInvalid data. Denominator can't be equals 0!");
        this.denominator = denominator / gcd(Math.abs(this.numerator), Math.abs(denominator));
        this.numerator /= gcd(Math.abs(this.numerator), Math.abs(denominator));
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }
}