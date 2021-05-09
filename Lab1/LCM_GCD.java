import java.util.Scanner;

public class LCM_GCD {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        System.out.println("\nWelcome!\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int num = in.nextInt();

        int[] sequence = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter the " + (i + 1) + " element: ");
            sequence[i] = in.nextInt();
        }

        int buf1 = sequence[0], buf2 = sequence[0];
        long GCD = 0, LCM = 0;
        for (int i = 1; i < num; i++) {
            GCD = gcd(buf1, sequence[i]);
            LCM = lcm(buf2, sequence[i]);
            buf1 = (int)GCD;
            buf2 = (int)LCM;
        }

        System.out.printf("\nThe Greatest Common Divisor is %d.\n", GCD);
        System.out.printf("The Least Common Multiple is %d.\n", LCM);

        in.close();
    }
}