package Motorcyclist;
import java.io.Serializable;
import java.util.Objects;

public class Motorcyclist implements Serializable {
    private String name;
    private Ammunition[] ammunition;

    Motorcyclist() throws MyExceptionForLab4B {
        name = "Unknown";
        ammunition = new Ammunition[(int) (Math.random() * 5) + 1];
        for(int i = 0, j = 0; i < ammunition.length; i++) {
            j = (int) (Math.random() * 5) + 1;
            switch (j) {
                case 1:
                    ammunition[i] = new Boots("Unknown" , (int) (Math.random() * 7000), (int) (Math.random() * 4000));
                    break;
                case 2:
                    ammunition[i] = new Gloves("Unknown" , (int) (Math.random() * 7000), (int) (Math.random() * 4000));
                    break;
                case 3:
                    ammunition[i] = new Helmet("Unknown" , (int) (Math.random() * 7000), (int) (Math.random() * 4000));
                    break;
                case 4:
                    ammunition[i] = new Protection("Unknown" , (int) (Math.random() * 7000), (int) (Math.random() * 4000));
                    break;
                case 5:
                    ammunition[i] = new Suit("Unknown" , (int) (Math.random() * 7000), (int) (Math.random() * 4000));
                    break;
            }
        }
    }

    public Motorcyclist(String name, Ammunition[] ammunition) {
        this.name = name;
        this.ammunition = ammunition;
    }

    public String getName()
    {
        return name;
    }
    public Ammunition[] getAmmunition()
    {
        return ammunition;
    }

    public int costOfAmmunition() throws MyExceptionForLab4B {
        int cost = 0;
        for(int i = 0; i < ammunition.length; i++) {
            if(ammunition[i].getCost() < 0)
                throw new MyExceptionForLab4B("\nInvalid data. Cost can't be less than 0.\n");
            cost += ammunition[i].getCost();
        }
        return cost;
    }

    public void sortByWeight() {
        int size = this.ammunition.length;
        Ammunition[] buffer = new Ammunition[size];
        int[] buff = new int[size];
        for(int i = 0; i < size; i++)
            buff[i] = ammunition[i].getWeight();
        for(int i = 0, temp = 0; i < size; i++)
            for(int j = i; j < size; j++)
                if(buff[i] < buff[j]) {
                    temp = buff[i];
                    buff[i] = buff[j];
                    buff[j] = temp;
                }
        for(int i = 0 ; i < size; i++)
            for(int j = 0; j < size; j++)
                if(ammunition[j].getWeight() == buff[i]) {
                    buffer[i] = ammunition[j];
                    break;
                }
        ammunition = buffer;
    }

    public void displayByFixedDiapason(int fixedLengthLeft, int fixedRightLength) {
        int counter = 0;
        for(int i = 0; i < ammunition.length; i++) {
            if (ammunition[i].getCost() > fixedLengthLeft && ammunition[i].getCost() < fixedRightLength)
                counter++;
        }
        if (counter == 0) System.out.println("\nThere aren't ammunition in fixed diapason.\n");
        else {
            System.out.println("\nAmmunition fixed diapason:\n");
            for (int i = 0; i < ammunition.length; i++)
                if (ammunition[i].getCost() > fixedLengthLeft && ammunition[i].getCost() < fixedRightLength)
                    System.out.println(ammunition[i]);
        }
    }

    @Override
    public String toString() {
        String str = "Name of motorcyclist: " + this.name + "\n";
        for(int i = 0; i < this.ammunition.length; i++)
            str += ammunition[i].toString();
        return str;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, ammunition);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Motorcyclist motorcyclist = (Motorcyclist) obj;
        return (name == motorcyclist.name && ammunition.equals(motorcyclist.ammunition));
    }
}