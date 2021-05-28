import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithFile {
    WorkWithFile() {}

    public String outFile(String fileName) {
        ArrayList<String> arrayList = new ArrayList<>();
        String buffer = "", word = "";
        StringBuilder line = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            buffer = bufferedReader.readLine();
            while (buffer != null) {
                while (buffer.length() == 0)
                    buffer = bufferedReader.readLine();
                for (int i = 0; i < buffer.length(); i++, word = "") {
                    while ((buffer.charAt(i) >= 'A' && buffer.charAt(i) <= 'Z') || (buffer.charAt(i) >= 'a' && buffer.charAt(i) <= 'z')
                            || (buffer.charAt(i) >= 'А' && buffer.charAt(i) <= 'я') || (buffer.charAt(i) == 'ё')) {
                        word += buffer.charAt(i);
                        i++;
                        if (i == buffer.length())
                            break;
                    }
                    if (word.length() >= 3 && word.length() <= 5)
                        arrayList.add(word);
                }
                int numberOfWords = (arrayList.size() % 2 == 0) ? arrayList.size() : arrayList.size() - 1;
                if (arrayList.size() % 2 != 0)
                    arrayList.remove(arrayList.size() - 1);
                for (int i = 0; i < numberOfWords; i++) {
                    buffer = buffer.replaceFirst(arrayList.get(i), "");
                }
                line.append(buffer.trim() + "\n");
                buffer = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return line.toString();
    }

    public void inFile(String str, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), false))) {
            bufferedWriter.write(str);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}