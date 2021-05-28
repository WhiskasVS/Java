package Vehicle;
import java.security.InvalidParameterException;

public class Bicycle implements VehicleType {
    private String nameOwner;
    private String registrationNumber;
    private String mark;
    private String model;
    private String vin;
    private String typeOfDrivingForce;
    private String typeOfBrakes;
    private boolean tech;
    private boolean breakdown;
    private int fuel;
    private int quantityOfWheels;
    private int quantityOfGear;
    private int currentGear = 0;

    Bicycle() {
        nameOwner = registrationNumber = mark = model = vin = typeOfDrivingForce = "";
        tech = breakdown = false;
        fuel = 0;
    }

    public Bicycle(String nameOwner, String registrationNumber, String mark, String model, String vin, String typeOfDrivingForce,
                   String typeOfBrakes, boolean tech, boolean breakdown, int fuel, int quantityOfWheels, int quantityOfGear) throws Exception {
        this.nameOwner = nameOwner;
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.model = model;
        this.vin = vin;
        this.typeOfDrivingForce = typeOfDrivingForce;
        this.typeOfBrakes = typeOfBrakes;
        this.tech = tech;
        this.breakdown = breakdown;
        if (fuel < 0 || quantityOfWheels < 0 || quantityOfGear < 0)
            throw new InvalidParameterException("Invalid parameters!");
        this.fuel = fuel;
        this.quantityOfWheels = quantityOfWheels;
        this.quantityOfGear = quantityOfGear;

    }

    public String getNameOwner() {
        return this.nameOwner;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getMark() {
        return this.mark;
    }

    public String getModel() {
        return this.model;
    }

    public String getVin() {
        return this.vin;
    }

    public String getTypeOfDrivingForce() {
        return this.typeOfDrivingForce;
    }

    public String getTypeOfBrakes() {
        return this.typeOfBrakes;
    }

    public boolean getTech() {
        return this.tech;
    }

    public boolean getBreakdown() {
        return this.breakdown;
    }

    public int getFuel() {
        return this.fuel;
    }

    public int getQuantityOfWheels() {
        return this.quantityOfWheels;
    }

    public int getQuantityOfGear() {
        return this.quantityOfGear;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setTypeOfDrivingForce(String typeOfDrivingForce) {
        this.typeOfDrivingForce = typeOfDrivingForce;
    }

    public void setTypeOfBrakes(String typeOfBrakes) {
        this.typeOfBrakes = typeOfBrakes;
    }

    public void setTech(boolean tech) {
        this.tech = tech;
    }

    public void setBreakdown(boolean breakdown) {
        this.breakdown = breakdown;
    }

    public void setFuel(int fuel) {
        if (fuel < 0)
            throw new InvalidParameterException("Fuel cannot be less than 0!");
        this.fuel = fuel;
    }

    public void setQuantityOfWheels(int quantityOfWheels) {
        if (quantityOfWheels < 0)
            throw new InvalidParameterException("Quantity of wheels cannot be less than 0!");
        this.quantityOfWheels = quantityOfWheels;
    }

    public void setQuantityOfGear(int quantityOfGear) {
        if (quantityOfGear < 0)
            throw new InvalidParameterException("Quantity of gear cannot be less than 0!");
        this.quantityOfGear = quantityOfGear;
    }

    public void turnGear(boolean side) throws Exception {
        if (side && currentGear < quantityOfGear)
            currentGear++;
        else if (!side && currentGear > 1)
            currentGear--;
        else
            throw new Exception("Invalid argument.");
    }

    public void changeRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public void changeMark(String mark) { this.mark = mark; }
    public void changeModel(String model) { this.model = model; }
    public void changeVIN(String vin) { this.vin = vin; }
    public void changeOwner(String nameOwner) { this.nameOwner = nameOwner; }
    public void changeTypeOfDrivingForce(String typeOfDrivingForce) { this.typeOfDrivingForce = typeOfDrivingForce; }

    public void refuel(int fuel) {
        if (fuel < 0)
            throw new InvalidParameterException("Fuel cannot be less than zero!");
        this.setFuel(this.fuel + fuel);
    }

    public void repair() {
        this.breakdown = true;
        System.out.println("The repair was successful");
    }

    public void service() {
        System.out.println("Services...");
    }

    public void passATech() {
        this.tech = true;
        System.out.println("Tech is passed!");
    }
}