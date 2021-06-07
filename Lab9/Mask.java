import java.security.InvalidParameterException;

public class Mask {
    char[] Mask;

    public Mask() {}
    public Mask(char[] array) {
        this.Mask = array;
    }

    public boolean Equal (char[] fileName) {
        int counter1 = 0, counter2 = 0, counter3 = 0;
        for(char i = '1'; i <= '5'; i++) {
            if (fileName[0] != i) counter1++;
        }
        if (counter1 == 5) return false;
        for (int i = 1; i <= 6; i++) {
            if (fileName[i] != this.Mask[i])
                return false;
        }
        for (char i = '0'; i <= '9'; i++) {
            if (fileName[7] != i) counter2++;
            if (fileName[8] != i) counter3++;
        }
        if (counter2 == 10 || counter3 == 10) return false;
        for (int i = 9; i <= 19; i++) {
            if (fileName[i] != this.Mask[i])
                return false;
        }
        return true;
    }
}