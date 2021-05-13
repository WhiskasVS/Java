public class Point {

    private RationalFraction x;
    private RationalFraction y;
    private RationalFraction z;

    Point() {
        this.x = new RationalFraction();
        this.y = new RationalFraction();
        this.z = new RationalFraction();
    }
    Point(RationalFraction x, RationalFraction y, RationalFraction z) throws Exception {
        this.x = new RationalFraction(x.getNumerator(), x.getDenominator());
        this.y = new RationalFraction(y.getNumerator(), y.getDenominator());
        this.z = new RationalFraction(z.getNumerator(), z.getDenominator());
    }
    Point(int numerator1, int denominator1, int numerator2, int denominator2,
          int numerator3, int denominator3) throws Exception {
        this.x = new RationalFraction(numerator1, denominator1);
        this.y = new RationalFraction(numerator2, denominator2);
        this.z = new RationalFraction(numerator3, denominator3);
    }

    public RationalFraction getX() { return this.x; }
    public RationalFraction getY() { return this.y; }
    public RationalFraction getZ() { return this.z; }

    public void setX(RationalFraction x) throws Exception {
        this.x.setNumerator(x.getNumerator());
        this.x.setDenominator(x.getDenominator());
    }
    public void setY(RationalFraction y) throws Exception {
        this.y.setNumerator(y.getNumerator());
        this.y.setDenominator(y.getDenominator());
    }
    public void setZ(RationalFraction z) throws Exception {
        this.z.setNumerator(z.getNumerator());
        this.z.setDenominator(z.getDenominator());
    }
    public void setX(int numerator, int denominator) throws Exception {
        this.x.setNumerator(numerator);
        this.x.setDenominator(denominator);
    }
    public void setY(int numerator, int denominator) throws Exception {
        this.y.setNumerator(numerator);
        this.y.setDenominator(denominator);
    }
    public void setZ(int numerator, int denominator) throws Exception {
        this.z.setNumerator(numerator);
        this.z.setDenominator(denominator);
    }

    public double coordX() {
        return (double)this.x.getNumerator()/this.x.getDenominator();
    }
    public double coordY() {
        return (double)this.y.getNumerator()/this.y.getDenominator();
    }
    public double coordZ() {
        return (double)this.z.getNumerator()/this.z.getDenominator();
    }

    public double DistanceBetweenPoint(Point point) {
        return Math.sqrt(Math.pow(this.coordX() - point.coordX(), 2)
                + Math.pow(this.coordY() - point.coordY(), 2)
                + Math.pow(this.coordZ() - point.coordZ(), 2));
    }
    public double DistanceBetweenO() {
        return Math.sqrt(Math.pow(this.coordX(), 2) + Math.pow(this.coordY(), 2)
                + Math.pow(this.coordZ(), 2));
    }
}