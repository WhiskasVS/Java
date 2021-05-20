package Computer;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Computer implements Serializable {
    private String name;
    private Processor processor;
    private RAM ram;
    private Winchester winchester;
    private Drive drive;
    private boolean isSwitchedOn = true;
    private boolean viruses = false;
    Computer() {
        name = "";
        processor = new Processor();
        ram = new RAM();
        winchester = new Winchester();
        drive = new Drive();
    }
    Computer(String name, Processor processor, RAM ram, Winchester winchester, Drive drive) {
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.winchester = winchester;
        this.drive = drive;
    }
    public Computer(String name, String nameOfProcessor, String nameRAM, int sizeOfRAM, String nameOfWinchester, int sizeOfWinchester, String nameOfDrive) throws Exception {
        this.name = name;
        this.processor = new Processor(nameOfProcessor);
        this.ram = new RAM(nameRAM, sizeOfRAM);
        this.winchester = new Winchester(nameOfWinchester, sizeOfWinchester);
        this.drive = new Drive(nameOfDrive);
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public boolean Status()
    {
        return isSwitchedOn;
    }
    public void SwitchOn()
    {
        this.isSwitchedOn = true;
    }
    public void SwitchOff()
    {
        this.isSwitchedOn = false;
    }
    public void setViruses() { this.viruses = true; }
    public void upsetViruses() { this.viruses = false; }
    public boolean checkViruses()
    {
        return viruses;
    }
    public int sizeOfWinchester()
    {
        return winchester.getSize();
    }

    @Override
    public String toString() {
        return "Computer: \n" +
                "Name - " + name +
                "Processor - " + processor.toString() +
                "RAM - " + ram.toString() +
                "Winchester - " + winchester.toString() +
                "Drive - " + drive.toString();
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(name, ram, drive, winchester, processor);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Computer computer = (Computer) obj;
        return (name.equals(computer.name) && this.processor.equals(computer.processor) &&
                this.ram.equals(computer.ram) && this.drive.equals(computer.drive) &&
                this.winchester.equals(computer.winchester));
    }
}