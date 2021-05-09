import java.util.Scanner;
import java.util.*;
import java.text.*;

/**
 * A class for finding a number consisting only of different digits
 * @author Sidorenko Victoria Olegovna
 * @version 1.0
 */
public class WorkWithNumbers {

    /**
     * Function for finding the number of digits in a number
     * @param number - the number under study
     * @return Returns the number of digits
     */
    public static int getCountsOfDigits(int number) {
        int count = (number == 0) ? 1 : 0;
        while(number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    /**
     * Boolean function for finding a special number
     * @param number - the number under study
     */
    private static boolean SpecialNumber(int number) {
        int count = getCountsOfDigits(number);
        int[] array = new int[count];
        for(int i = count - 1; i >= 0; i--, number /= 10)
            array[i] = number % 10;
        for(int i = 0 ; i < count - 1; i++)
            for(int j = i + 1; j < count; j++) {
                if(array[i] == array[j]) return false;
            }
        return true;
    }

    /** Main Function
     * Checks the user-specified numbers, outputs the result
     * and information about the developer (last name and first name)
     * and the program (date and time of receipt and delivery of the task)
     */
    public static void main(String[] args){
        try {
            System.out.println("\nWelcome!\n");
            Scanner in = new Scanner(System.in);
            System.out.println("Select an option:");
            System.out.println("1. Option A");
            System.out.println("2. Option C");
            System.out.print("Your choice: ");
            int choice;
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter the number of elements: ");
                    int quantityOfNumbers;
                    quantityOfNumbers = in.nextInt();

                    int[] array = new int[quantityOfNumbers];
                    for (int i = 0; i < quantityOfNumbers; i++) {
                        System.out.print("Enter the " + (i + 1) + " element: ");
                        array[i] = in.nextInt();
                    }
                    for (int i = 0; i < quantityOfNumbers; i++) {
                        if (SpecialNumber(array[i])) {
                            System.out.println("\nThe special number is " + array[i] + ".");
                            break;
                        } else if (i == quantityOfNumbers - 1)
                            System.out.println("\nThere is no special number.");
                    }

                    System.out.println("\nDeveloper: Sidorenko Victoria");
                    System.out.println("Getting a task:       20.02.2021 11:00:00 AM");
                    Date dateNow = new Date();
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss a");
                    System.out.println("Presentation of work: " + formatForDateNow.format(dateNow));
                    break;
                case 2:
                    System.out.print("\nEnter the matrix size: ");
                    int size;
                    size = in.nextInt();
                    Matrix matrix = new Matrix(size);
                    matrix.RandomMatrix();
                    System.out.println("\nYour matrix:");
                    matrix.ShowMatrix();
                    System.out.println("\n90 degree rotation:");
                    matrix.RotateTo90();
                    matrix.ShowMatrix();
                    System.out.println("\n180 degree rotation:");
                    matrix.RotateTo90();
                    matrix.ShowMatrix();
                    System.out.println("\n270 degree rotation:");
                    matrix.RotateTo90();
                    matrix.ShowMatrix();
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}