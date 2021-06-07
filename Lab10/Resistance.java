import java.util.ArrayList;

public class Resistance {
    ArrayList<Double> U;
    ArrayList<Double> I;

    Resistance() {
        U = new ArrayList<Double>();
        I = new ArrayList<Double>();
    }

    Resistance(int size) throws Exception {
        if (size < 0)
            throw new Exception("Size can't be less than 0.");
        U = new ArrayList<Double>(size);
        I = new ArrayList<Double>(size);
    }

    Resistance(ArrayList<Double> U, ArrayList<Double> I) {
        this.U = new ArrayList<Double>();
        this.I = new ArrayList<Double>();
        for (int i = 0; i < U.size(); i++)
            this.U.add(U.get(i));
        for (int i = 0; i < I.size(); i++)
            this.I.add(I.get(i));
    }

    public ArrayList<Double> getU() {
        return this.U;
    }

    public ArrayList<Double> getI() {
        return this.I;
    }

    public void setU(ArrayList<Double> U) {
        this.U.clear();
        for (int i = 0; i < U.size(); i++)
            this.U.add(U.get(i));
    }

    public void setI(ArrayList<Double> I) {
        this.I.clear();
        for (int i = 0; i < I.size(); i++)
            this.U.add(I.get(i));
    }

    public Double calculateRWithOwnIandU() throws Exception {
        if (I.size() != U.size())
            throw new Exception("Size of U and I is not equals.");
        int n = I.size();
        double up = 0.0, down = 0.0;
        for (int i = 0; i < n; i++) {
            up += (I.get(i)) * (U.get(i));
            down += (I.get(i)) * (I.get(i));
        }
        return (up / down);
    }

    public Double calculateR(ArrayList<Double> U, ArrayList<Double> I) throws Exception {
        if (I.size() != U.size())
            throw new Exception("Size of U and I is not equals.");
        this.U.clear();
        this.I.clear();
        int n = I.size();
        for (int i = 0; i < n; i++) {
            this.U.add(U.get(i));
            this.I.add(I.get(i));
        }
        double up = 0.0, down = 0.0;
        for (int i = 0; i < n; i++) {
            up += (this.I.get(i)) * (this.U.get(i));
            down += (this.I.get(i)) * (this.I.get(i));
        }
        return (up / down);
    }
}