import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("\nWelcome!");
        System.out.println("\n====== Least Squares method ======");
        System.out.println("\nFormula for finding the resistance:");
        System.out.println("R = (U1 * I1 + U2 * I2 + ... + Un * In) / (I1^2 + I2^2 + ... + In^2)");
        ArrayList<Double> U = new ArrayList<>(Arrays.asList(0.27, 0.56, 0.9, 1.18, 1.49, 1.79,
                2.05, 2.42, 2.68, 3.01, 3.35, 3.56, 3.85, 4.18, 4.48, 4.79, 5.12, 5.45, 5.68, 5.9));
        ArrayList<Double> I = new ArrayList<>(Arrays.asList(0.1, 0.2, 0.3, 0.4, 0.5,
                0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9));
        Resistance resistance = new Resistance();
        System.out.print("\nR = ");
        System.out.println(resistance.calculateR(U, I));
    }
}