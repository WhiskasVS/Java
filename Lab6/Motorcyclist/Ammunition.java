package Motorcyclist;
import java.io.Serializable;
import java.util.Objects;

public class Ammunition implements Serializable {
    private String name;
    private int weightInGram;
    private int cost;

    Ammunition() {
        this.name = "Unknown";
        this.cost = 0;
        this.weightInGram = 0;
    }
    Ammunition(String name, int cost, int weight) throws MyExceptionForLab4B {
        this.name = name;
        if(cost < 0) throw new MyExceptionForLab4B("\nInvalid data. Cost can't be less than 0.\n");
        this.cost = cost;
        if(weight < 0) throw new MyExceptionForLab4B("\nInvalid data. Weight can't be less than 0.\n");
        this.weightInGram = weight;
    }

    public String getName()
    {
        return name;
    }
    public int getCost()
    {
        return cost;
    }
    public int getWeight()
    {
        return weightInGram;
    }

    public void setName(String name) { this.name = name; }
    public void setWeight(int weightInGram) throws MyExceptionForLab4B {
        if(weightInGram < 0)
            throw new MyExceptionForLab4B("\nInvalid data. Weight can't be less than 0.\n");
        this.weightInGram = weightInGram;
    }
    public void setCost(int cost) throws MyExceptionForLab4B
    {
        if(cost < 0)
            throw new MyExceptionForLab4B("\nInvalid data. Cost can't be less than 0.\n");
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nCost: " + getCost() + " $\nWeight: " + getWeight() + " gram\n";
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(name, weightInGram, cost);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Ammunition ammunition = (Ammunition) obj;
        return (name.equals(ammunition.name) && cost == ammunition.cost && weightInGram == ammunition.weightInGram);
    }
}
