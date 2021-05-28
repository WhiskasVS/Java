import Motorcyclist.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyExceptionForLab4B, IOException {
        System.out.println("\nWelcome!");
        Scanner scanner = new Scanner(System.in);
        char choice;
        char ch = 'y';
        while (ch == 'y' || ch == 'Y') {
            System.out.println("\nChoose a way to work:");
            System.out.println("1. Work with text.");
            System.out.println("2. Work with Motorcyclist.");
            System.out.println("3. Work with file.");
            System.out.print("Your choice: ");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    WorkWithText();
                    break;
                case '2':
                    WorkWithMotorcyclist();
                    break;
                case '3':
                    WorkWithFile file = new WorkWithFile();
                    File F = new File("D:\\Учёба\\Проекты\\2 курс\\Java\\Lab6\\ResultC");
                    boolean D = F.mkdir();
                    file.inFile(file.outFile("Example.txt"), "ResultC//ResultC.txt");
                    System.out.println("\nSuccessful completion.");
                    break;
                default:
                    System.out.println("\nInvalid data.You entered wrong operation.");
                    break;
            }
            System.out.print("\nIf you want to choose another way to work, press 'Y', if you don't - press any key: ");
            ch = scanner.next().charAt(0);
        }
    }

    private static void WorkWithText() {
        try (BufferedReader reference = new BufferedReader(new FileReader("Reference.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("ResultA.txt", false));
             BufferedReader reader = new BufferedReader(new FileReader(reference.readLine()))) {
            String in = reader.readLine();
            while (in != null) {
                while (in.length() == 0) {
                    writer.write("\n");
                    in = reader.readLine();
                }
                for (int i = 0; i < in.length(); i++) {
                    if (i == 0 && in.charAt(i) != ' ') {
                        in = in.substring(i, i + 1).toUpperCase() + in.substring(i + 1);
                        continue;
                    }
                    if (i != 0 && in.charAt(i - 1) == ' ' && in.charAt(i) != ' ')
                        in = in.substring(0, i) + in.substring(i, i + 1).toUpperCase() + in.substring(i + 1);
                }
                writer.write(in);
                in = reader.readLine();
            }
            System.out.println("\nSuccessful completion.");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void WorkWithMotorcyclist() throws MyExceptionForLab4B, IOException {
        Motorcyclist motorcyclist = new Motorcyclist();
        Connector connector = new Connector("File.dat");
        System.out.println("\nOur ammunition:\n");
        try {
            connector.toSerializeInFile(motorcyclist.getAmmunition());
            System.out.println("Serialization was successful.\n");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            connector.toDeserializeFromFile(motorcyclist.getAmmunition());
            System.out.println("Deserialization was successful.");
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}