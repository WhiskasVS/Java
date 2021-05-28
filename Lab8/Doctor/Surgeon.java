package Doctor;
import java.util.Scanner;

public class Surgeon implements Doctor {
    private String name;
    private String placeOfWork;
    protected String speciality;
    private int age;
    private Scanner scanner = new Scanner(System.in);

    Surgeon() {
        name = "Unknown";
        placeOfWork = "Unknown";
        speciality = "Unknown";
        age = 20 + (int) (Math.random() * 35);
    }

    Surgeon(String name, String placeOfWork, String speciality, int age) throws Exception {
        this.name = name;
        this.placeOfWork = placeOfWork;
        this.speciality = speciality;
        if (age < 20 || age > 75)
            throw new Exception("This person cannot be doctor without education or too old.");
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getPlaceOfWork() {
        return this.placeOfWork;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public int getAge() {
        return this.age;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setAge(int age) throws Exception {
        if (age < 20 || age > 75)
            throw new Exception("This person cannot be doctor without education or too old.");
        this.age = age;
    }

    public void makeSimpleOperation() {
        int random = (int) (Math.random() * 1001);
        if (random > 4)
            System.out.print("\nThe operation was successful.");
        else
            System.out.print("\nThe operation was unsuccessful.");
    }

    public String writeOutAPrescription() {
        System.out.print("Enter a prescription: ");
        return scanner.nextLine();
    }

    public String prescribeTreatment() {
        System.out.print("Treatment: ");
        return scanner.nextLine();
    }

    public String makeADiagnosis() {
        System.out.print("Enter a diagnosis: ");
        return scanner.nextLine();
    }
}