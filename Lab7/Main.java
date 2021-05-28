import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Europe.txt"));
             BufferedReader bufferedReader1 = new BufferedReader(new FileReader("Europe.txt"))) {
            System.out.println("\nWelcome!");
            Europe europe = new Europe();
            String buffer = bufferedReader.readLine(), bufferCountry = "", bufferDescription = "";
            int count = 0, bufferYear = 0;
            while (buffer != null) {
                switch (count % 3) {
                    case 0:
                        bufferCountry = buffer;
                        break;
                    case 1:
                        bufferYear = Integer.parseInt(buffer.trim());
                        break;
                    case 2:
                        bufferDescription = buffer;
                        europe.add(bufferCountry, bufferYear, bufferDescription);
                        break;
                }
                count++;
                buffer = bufferedReader.readLine();
            }
            Europe anonymousEurope = new Europe() {
                @Override
                public String getFirstHistory() {
                    if (getAllHistory().size() > 0)
                        return "Anonymous class object info:\n\n" + getHistory().get(0).toString();
                    return "Anonymous class object have no history.\n";
                }
            };
            count = 0;
            buffer = bufferedReader1.readLine();
            while (buffer != null) {
                switch (count % 3) {
                    case 0:
                        bufferCountry = buffer;
                        break;
                    case 1:
                        bufferYear = Integer.parseInt(buffer.trim());
                        break;
                    case 2:
                        bufferDescription = buffer;
                        anonymousEurope.add(bufferCountry, bufferYear, bufferDescription);
                        break;
                }
                count++;
                buffer = bufferedReader1.readLine();
            }
            System.out.println("\nAll history:\n");
            for (int i = 0; i < europe.getHistory().size(); i++) {
                System.out.println(europe.getAllHistory().get(i) + "\n");
            }
            System.out.println(anonymousEurope.getFirstHistory());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}