package Motorcyclist;
import java.io.Serializable;

public class Helmet extends Ammunition implements Serializable {
    Helmet() { super(); }
    public Helmet(String name, int cost, int weightInGram) throws MyExceptionForLab4B { super(name, cost, weightInGram); }
    public void setName(String name) { super.setName(name); }
    public void setWeight(int weight) throws MyExceptionForLab4B { super.setWeight(weight); }
    public void setCost( int cost) throws MyExceptionForLab4B { super.setCost(cost); }
}