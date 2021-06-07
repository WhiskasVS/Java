import Text.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\nWelcome!");
        Scanner scanner = new Scanner(System.in);
        char choice;
        char ch = 'y';
        while (ch == 'y' || ch == 'Y') {
            System.out.println("\nChoose a way to work:");
            System.out.println("1. Work with text.");
            System.out.println("2. Work with Mask.");
            System.out.print("Your choice: ");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    WorkWithText();
                    break;
                case '2':
                    WorkWithMask();
                    break;
                default:
                    System.out.println("\nInvalid data.You entered wrong operation.");
                    break;
            }
            System.out.print("\nIf you want to choose another way to work, press 'Y', if you don't - press any key: ");
            ch = scanner.next().charAt(0);
        }
    }

    private static void WorkWithText() throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Text.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Result.txt", false))) {
            String text = "", buff1 = bufferedReader.readLine();
            while (buff1 != null) {
                text += buff1;
                buff1 = bufferedReader.readLine();
            }
            Marks marks = new Marks();
            String buffer = "";
            ArrayList<Word> words = new ArrayList<Word>();
            ArrayList<Integer> numberOfWords = new ArrayList<Integer>();
            ArrayList<Character> symbols = new ArrayList<Character>();

            for (int i = 0, j = 0; i < text.length(); i++, buffer = "") {
                if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z' || text.charAt(i) >= 'a' && text.charAt(i) <= 'z' ||
                        text.charAt(i) >= 'А' && text.charAt(i) <= 'я' || text.charAt(i) == 'ё') {
                    while (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z' || text.charAt(i) >= 'a' && text.charAt(i) <= 'z' ||
                            text.charAt(i) >= 'А' && text.charAt(i) <= 'я' || text.charAt(i) == 'ё') {
                        buffer += text.charAt(i);
                        i++;
                    }
                    words.add(new Word(buffer));
                    i--;
                    j++;
                } else if (exist(marks.getMarks(), text.charAt(i))) {
                    numberOfWords.add(j);
                    symbols.add(text.charAt(i));
                }
            }
            double min;
            Word bufferWord;
            for (int i = 0, minIndex = 0; i < words.size(); i++) {
                min = words.get(i).getDimension();
                minIndex = i;
                for (int j = i + 1; j < words.size(); j++) {
                    if (min > words.get(j).getDimension()) {
                        min = words.get(j).getDimension();
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    bufferWord = words.get(i);
                    words.set(i, words.get(minIndex));
                    words.set(minIndex, bufferWord);
                }
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0, j = 0; i < words.size(); i++) {
                if (i + 1 == numberOfWords.get(j)) {
                    str.append(words.get(i).getWord()).append(symbols.get(j)).append(" ");
                    j++;
                } else
                    str.append(words.get(i).getWord()).append(" ");
            }
            bufferedWriter.write(str.toString());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("\nSuccessful completion.");
    }

    private static void WorkWithMask() {
        try (BufferedReader reference = new BufferedReader(new FileReader("Reference.txt"))) {
            //String mask = "?_year_??_group.txt";
            String mask = "?_курс_??_группа.xls*";
            System.out.println("\nMask: " + mask);
            Mask maskArray = new Mask(mask.toCharArray());
            String fileName = reference.readLine();
            while(fileName != null) {
                if (maskArray.Equal(fileName.toCharArray()))
                    System.out.println("The file name \"" + fileName + "\" satisfies the mask.");
                else
                    System.out.println("The file name \"" + fileName + "\" doesn't satisfies the mask.");
                fileName = reference.readLine();
            }
            //BufferedReader reader = new BufferedReader(new FileReader(reference.readLine()))

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static boolean exist(char[] symbols, char symbol) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == symbol)
                return true;
        }
        return false;
    }
}