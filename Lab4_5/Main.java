import Computer.*;
import Motorcyclist.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyExceptionForLab4B {
        System.out.println("\nWelcome!");
        Scanner scanner = new Scanner(System.in);
        char choice;
        char ch = 'y';
        while (ch == 'y' || ch == 'Y') {
            System.out.println("\nChoose a way to work:");
            System.out.println("1. Work with Computer.");
            System.out.println("2. Work with Motorcyclist.");
            System.out.print("Your choice: ");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    WorkWithComputer();
                    break;
                case '2':
                    WorkWithMotorcyclist();
                    break;
                default:
                    System.out.println("\nInvalid data.You entered wrong operation.");
                    break;
            }
            System.out.print("\nIf you want to choose another way to work, press 'Y', if you don't - press any key: ");
            ch = scanner.next().charAt(0);
        }
    }

    private static void WorkWithComputer() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("Computer1.txt"))) {
            System.out.println("\nFile opened successfully.");
            Scanner scanner = new Scanner(System.in);
            String nameOfComputer = "", nameOfProcessor = "", nameOfRAM = "", nameOfWinchester = "", nameOfDrive = "";
            int sizeOfRAM = 0, sizeOfWinchester = 0, count = 1;
            String line = buffer.readLine();
            while (line != null) {
                switch (count) {
                    case 1:
                        nameOfComputer = line;
                        break;
                    case 2:
                        nameOfProcessor = line;
                        break;
                    case 3:
                        nameOfRAM = line;
                        break;
                    case 4:
                        try {
                            sizeOfRAM = Integer.parseInt(line.trim());
                        } catch (NumberFormatException exception) {
                            System.out.println("Number format exception:" + exception.getMessage());
                        }
                        break;
                    case 5:
                        nameOfWinchester = line;
                        break;
                    case 6:
                        try {
                            sizeOfWinchester = Integer.parseInt(line.trim());
                        } catch (NumberFormatException exception) {
                            System.out.println("Number format exception:" + exception.getMessage());
                        }
                        break;
                    case 7:
                        nameOfDrive = line;
                }
                line = buffer.readLine();
                count++;
            }

            Computer computer = new Computer(nameOfComputer, nameOfProcessor, nameOfRAM, sizeOfRAM, nameOfWinchester, sizeOfWinchester, nameOfDrive);
            char choice = 'y';
            while (choice == 'y') {
                System.out.println("\nSelect the operation you want to do:");
                System.out.println("1. Switch on computer.");
                System.out.println("2. Switch off computer.");
                System.out.println("3. Check viruses.");
                System.out.println("4. Display the size of the hard drive.");
                System.out.println("5. Set viruses.");
                System.out.println("6. Upset viruses.");
                System.out.println("7. Get status.");
                System.out.print("Your choice: ");
                choice = scanner.next().charAt(0);
                switch (choice) {
                    case '1':
                        computer.SwitchOn();
                        System.out.println("\nComputer is switched on.");
                        break;
                    case '2':
                        computer.SwitchOff();
                        System.out.println("\nComputer is switched off.");
                        break;
                    case '3':
                        if (computer.checkViruses())
                            System.out.println("\nComputer has viruses.");
                        else
                            System.out.println("\nComputer has no viruses.");
                        break;
                    case '4':
                        System.out.println("\nSize of winchester: " + computer.sizeOfWinchester() + " gb");
                        break;
                    case '5':
                        computer.setViruses();
                        System.out.println("\nViruses are installed.");
                        break;
                    case '6':
                        computer.upsetViruses();
                        System.out.println("Viruses removed.");
                        break;
                    case '7':
                        if (computer.Status())
                            System.out.println("\nComputer is turned on.");
                        else
                            System.out.println("\nComputer is turned off.");
                        break;
                    default:
                        System.out.println("\nInvalid data.You entered wrong operation.");
                        break;
                }
                System.out.print("\nIf you want to continue, press 'Y', if you don't - press any key: ");
                choice = scanner.next().charAt(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void WorkWithMotorcyclist() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("Motorcyclist.txt"))) {
            Scanner scanner = new Scanner(System.in);
            Ammunition[] ammunition = new Ammunition[5];
            String[] arrayName = new String[5];
            int[] arrayCost = new int[5];
            int[] arrayWeight = new int[5];

            int count1 = 0, count2 = 1;
            String line = buffer.readLine();
            String nameOfMotorcyclist = line;
            line = buffer.readLine();

            while (line != null) {
                if (count2 % 3 == 1)
                    arrayName[count1] = line;
                else if (count2 % 3 == 2) {
                    try {
                        arrayCost[count1] = Integer.parseInt(line.trim());
                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    try {
                        arrayWeight[count1] = Integer.parseInt(line.trim());
                        count1++;
                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
                count2++;
                line = buffer.readLine();
            }
            for (int i = 0; i < ammunition.length; i++) {
                switch (i) {
                    case 0:
                        ammunition[i] = new Suit(arrayName[i], arrayCost[i], arrayWeight[i]);
                        break;
                    case 1:
                        ammunition[i] = new Helmet(arrayName[i], arrayCost[i], arrayWeight[i]);
                        break;
                    case 2:
                        ammunition[i] = new Gloves(arrayName[i], arrayCost[i], arrayWeight[i]);
                        break;
                    case 3:
                        ammunition[i] = new Boots(arrayName[i], arrayCost[i], arrayWeight[i]);
                        break;
                    case 4:
                        ammunition[i] = new Protection(arrayName[i], arrayCost[i], arrayWeight[i]);
                        break;
                }
            }

            Motorcyclist motorcyclist = new Motorcyclist(nameOfMotorcyclist, ammunition);
            char choice = 'y';
            while (choice == 'y') {
                System.out.println("\nSelect the operation you want to do:");
                System.out.println("1. Display ammunition.");
                System.out.println("2. Display total cost.");
                System.out.println("3. Sort in descending order.");
                System.out.println("4. Display items of ammunition that correspond to a given range of price parameters");
                System.out.print("Your choice: ");
                choice = scanner.next().charAt(0);
                switch (choice) {
                    case '1':
                        System.out.println("\nAmmunition:\n");
                        for (int i = 0; i < ammunition.length; i++)
                            System.out.println(motorcyclist.getAmmunition()[i]);
                        break;
                    case '2':
                        System.out.println("\nTotal cost is equal " + motorcyclist.costOfAmmunition() + " $\n");
                        break;
                    case '3':
                        motorcyclist.sortByWeight();
                        System.out.println("\nAmmunition:\n");
                        for (int i = 0; i < ammunition.length; i++)
                            System.out.println(motorcyclist.getAmmunition()[i]);
                        break;
                    case '4':
                        Scanner scanner1 = new Scanner(System.in);
                        int min = 0, max = 0;
                        System.out.print("\nEnter min cost: ");
                        min = scanner1.nextInt();
                        System.out.print("Enter max cost: ");
                        max = scanner1.nextInt();
                        motorcyclist.displayByFixedDiapason(min, max);
                        break;
                    default:
                        System.out.println("\nInvalid data.You entered wrong operation.\n");
                        break;
                }
                System.out.print("If you want to continue, press 'Y', if you don't - press any key: ");
                choice = scanner.next().charAt(0);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}