import Vehicle.*;
import Doctor.*;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\nWelcome!");
        Scanner scanner = new Scanner(System.in);
        char choice;
        char ch = 'y';
        while (ch == 'y' || ch == 'Y') {
            System.out.println("\nChoose a way to work:");
            System.out.println("1. Work with Vehicle.");
            System.out.println("2. Work with Doctor.");
            System.out.print("Your choice: ");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    ATV atv = new ATV("Iosif", "2328a32", "superClass", "krutaya", "123def23214f", "motor", false, false, 50);
                    Bicycle bicycle = new Bicycle("Iosif", "3e3223", "superDuperClass", "classnaya", "473847823ufh", "pedals", "disc", false, false, 0, 2, 7);
                    Motorcycle motorcycle = new Motorcycle("Iosif", "42389de", "superPuperClass", "superskaya", "4324237g34", "motor", false, false, 65, 6, 240);
                    Scooter scooter = new Scooter("Iosif", "4329fue3", "superDuperPuperClass", "luchshaya", "120e909fw", "motor", false, true, 0);
                    System.out.println("\nMotorcycle:");
                    System.out.println("Registration number: " + motorcycle.getRegistrationNumber());
                    motorcycle.changeRegistrationNumber("8349e0");
                    System.out.println("New registration number: " + motorcycle.getRegistrationNumber());
                    System.out.println("\nCurrent gear of motorcycle is equal " + motorcycle.getCurrentGear() + ".");
                    motorcycle.turnGear(true);
                    motorcycle.turnGear(true);
                    motorcycle.turnGear(true);
                    System.out.println("Current gear of motorcycle is equal " + motorcycle.getCurrentGear() + ".");
                    System.out.println("\nATV:");
                    atv.bumperStatus();
                    atv.setReinforcedBumper();
                    atv.bumperStatus();
                    System.out.println("\nBicycle:");
                    System.out.println("Type of brakes bicycle: " + bicycle.getTypeOfBrakes() + ".");
                    System.out.println("\nScooter:");
                    scooter.getBreakdownStatus();
                    scooter.repair();
                    scooter.getBreakdownStatus();
                    System.out.println();
                    scooter.getTypeOfScooter();
                    scooter.makeElectric();
                    scooter.getTypeOfScooter();
                    break;
                case '2':
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Doctor.txt"))) {
                        String bufferName = "", bufferPlace = "", bufferSpeciality = "";
                        int bufferAge = 0, count = 0;
                        String buffer = bufferedReader.readLine();
                        while (buffer != null) {
                            switch (count) {
                                case 0:
                                    bufferName = buffer;
                                    break;
                                case 1:
                                    bufferPlace = buffer;
                                    break;
                                case 2:
                                    bufferSpeciality = buffer;
                                    break;
                                case 3:
                                    bufferAge = Integer.parseInt(buffer.trim());
                                    break;
                            }
                            count++;
                            buffer = bufferedReader.readLine();
                        }
                        Neurosurgeon neurosurgeon = new Neurosurgeon(bufferName, bufferPlace, bufferSpeciality, bufferAge);
                        Surgeon doctor = new Neurosurgeon(bufferName, bufferPlace, bufferSpeciality, bufferAge);
                        doctor.makeSimpleOperation();
                        neurosurgeon.makeAHardOperation();
                        System.out.println();
                    } catch (IOException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                default:
                    System.out.println("\nInvalid data.You entered wrong operation.");
                    break;
            }
            System.out.print("\nIf you want to choose another way to work, press 'Y', if you don't - press any key: ");
            ch = scanner.next().charAt(0);
        }
    }
}