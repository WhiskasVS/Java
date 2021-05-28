package Doctor;

public class Neurosurgeon extends Surgeon {

    Neurosurgeon() {
        super();
        this.speciality = "Neurosurgeon";
    }

    public Neurosurgeon(String name, String placeOfWork, String speciality, int age) throws Exception {
        super(name, placeOfWork, speciality, age);
        if (!speciality.toUpperCase().equals("Neurosurgeon".toUpperCase()))
            this.speciality = "Neurosurgeon";
    }

    public void makeAHardOperation() {
        int random = (int) (Math.random() * 10);
        if (random != 3 && random != 7 && random != 0 && random != 8)
            System.out.print("\nThe operation was successful.");
        else
            System.out.print("\nThe operation was unsuccessful.");
    }
}