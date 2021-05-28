package Vehicle;
import java.security.InvalidParameterException;

public class ATV implements VehicleType {
    private String nameOwner;
    private String registrationNumber;
    private String mark;
    private String model;
    private String vin;
    private String typeOfDrivingForce;
    private boolean tech;
    private boolean breakdown;
    private boolean reinforcedBumper = false;
    private int fuel;

    ATV() {
        nameOwner = registrationNumber = mark = model = vin = typeOfDrivingForce = "";
        tech = breakdown = false;
        fuel = 0;
    }

    public ATV(String nameOwner, String registrationNumber, String mark, String model, String vin, String typeOfDrivingForce,
               boolean tech, boolean breakdown, int fuel) throws Exception {
        this.nameOwner = nameOwner;
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.model = model;
        this.vin = vin;
        this.typeOfDrivingForce = typeOfDrivingForce;
        this.tech = tech;
        this.breakdown = breakdown;
        if(fuel < 0)
            throw new InvalidParameterException("\nFuel cannot be less than 0!");
        this.fuel = fuel;

    }

    public String getNameOwner() { return this.nameOwner; }
    public String getRegistrationNumber() { return this.registrationNumber; }
    public String getMark() { return this.mark; }
    public String getModel() { return this.model; }
    public String getVin() { return this.vin; }
    public String getTypeOfDrivingForce() { return this.typeOfDrivingForce; }
    public boolean getTech() { return this.tech; }
    public boolean getBreakdown() { return this.breakdown; }
    public int getFuel() { return this.fuel; }
    public void setNameOwner(String nameOwner) { this.nameOwner = nameOwner; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public void setMark(String mark) { this.mark = mark; }
    public void setModel(String model) { this.model = model; }
    public void setVin(String vin) { this.vin = vin; }
    public void setTypeOfDrivingForce(String typeOfDrivingForce) { this.typeOfDrivingForce = typeOfDrivingForce; }
    public void setTech(boolean tech) { this.tech = tech; }
    public void setBreakdown(boolean breakdown) { this.breakdown = breakdown; }
    public void setFuel(int fuel) {
        if(fuel < 0) throw new InvalidParameterException("\nFuel cannot be less than 0!");
        this.fuel = fuel;
    }

    public void setReinforcedBumper() throws Exception {
        if(reinforcedBumper)
            throw new Exception("\nBumper already set!");
        reinforcedBumper = true;
    }
    public void upSetReinforcedBumper() throws Exception {
        if(!reinforcedBumper)
            throw new Exception("\nBumper already upset!");
        reinforcedBumper = false;
    }
    public void bumperStatus() {
        if(reinforcedBumper) System.out.println("Bumper set.");
        else System.out.println("Bumper upset.");
    }

    public void changeRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public void changeMark(String mark) { this.mark = mark; }
    public void changeModel(String model) { this.model = model; }
    public void changeVIN(String vin) { this.vin = vin; }
    public void changeOwner(String nameOwner) { this.nameOwner = nameOwner; }
    public void changeTypeOfDrivingForce(String typeOfDrivingForce) { this.typeOfDrivingForce = typeOfDrivingForce; }
    public void refuel(int fuel) {
        if(fuel < 0) throw new InvalidParameterException("\nFuel cannot be less than zero!");
        this.setFuel(this.fuel + fuel);
    }
    public void repair() {
        this.breakdown = true;
        System.out.println("\nThe repair was successful");
    }
    public void service() { System.out.println("Services..."); }
    public void passATech() {
        this.tech = true;
        System.out.println("\nTech is passed!");
    }
}