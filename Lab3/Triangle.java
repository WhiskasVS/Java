public class Triangle {

    private int AB;
    private int BC;
    private int AC;

    public Triangle()
    {
        this.AB = this.BC = this.AC = 1;
    }
    public Triangle(int AB, int BC, int AC) throws Exception {
        if(AB < 1 || BC < 1 || AC < 1)
            throw new Exception("\nInvalid data. All sides must be bigger than 0!");
        if(AB >= BC + AC || AC >= BC + AB || BC >= AB + AC)
            throw new Exception("\nInvalid data. It is not a triangle!");
        this.AB = AB;
        this.BC = BC;
        this.AC = AC;
    }

    public int getAB() { return this.AB; }
    public int getBC() { return this.BC; }
    public int getAC() { return this.AC; }

    public void setAB(int AB) throws Exception {
        if(AB < 1) throw new Exception("\nInvalid data. AB can't be less than 1!");
        if(AB >= BC + AC || AC >= BC + AB || BC >= AB + AC)
            throw new Exception("\nInvalid data. It is not a triangle!");
        this.AB = AB;
    }
    public void setBC(int BC) throws Exception {
        if(BC < 1) throw new Exception("\nInvalid data. BC can't be less than 1!");
        if(AB >= BC + AC || AC >= BC + AB || BC >= AB + AC)
            throw new Exception("\nInvalid data. It is not a triangle!");
        this.BC = BC;
    }
    public void setAC(int AC) throws Exception {
        if(AC < 1) throw new Exception("\nInvalid data. AC can't be less than 1!");
        if(AB >= BC + AC || AC >= BC + AB || BC >= AB + AC)
            throw new Exception("\nInvalid data. It is not a triangle!");
        this.AC = AC;
    }

    public boolean isEquilateral() { return (this.AB == this.AC && this.BC == this.AB) ? true : false; }
    public boolean isIsosceles() {
        if((AB == BC && AB != AC) || (AB == AC && AB != BC) || (AC == BC && AC != AB))
            return true;
        return false;
    }
    public boolean isRectangular() {
        if((Math.pow(AB,2) == (Math.pow(BC,2) + Math.pow(AC,2)))
                || (Math.pow(AC,2) == (Math.pow(BC,2) + Math.pow(AB,2)))
                || (Math.pow(BC,2) == (Math.pow(AB,2) + Math.pow(AC,2))))
            return true;
        return false;
    }
    public boolean isArbitrary() {
        if(!this.isEquilateral() && !this.isIsosceles() && !this.isRectangular())
            return true;
        return false;
    }

    public int perimeter() { return AB + AC + BC; }
    public double square() {
        if(this.isEquilateral())
            return (Math.pow(AB,2) * Math.sqrt(3) / 4);
        double p = (double) this.perimeter() / 2;
        return (Math.sqrt(p * (p - AB) * (p - AC) * (p - BC)));
    }

    public void Show() {
        if(this.isEquilateral())
            System.out.println("\nThis triangle is equilateral.");
        else if(this.isIsosceles())
            System.out.println("\nThis triangle is isosceles.");
        else if(this.isRectangular())
            System.out.println("\nThis triangle is rectangular.");
        else
            System.out.println("\nThis triangle is arbitrary.");
        //System.out.println("AB = " + AB);
        //System.out.println("AC = " + AC);
        //System.out.println("BC = " + BC);
        System.out.println("Square = " + this.square());
        System.out.println("Perimeter = " + this.perimeter());
    }
}