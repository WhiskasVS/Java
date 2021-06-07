package Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Word implements Comparator<Word> {
    String word;
    private double dimension;

    Word() {}

    Word(ArrayList<Character> arrayList) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++)
            stringBuilder.append(arrayList.get(i));
        this.word = stringBuilder.toString();
        Dimension();
    }

    public Word(String word) throws Exception {
        this.word = word;
        Dimension();
    }

    public double getDimension() {
        return this.dimension;
    }

    public String getWord() {
        return this.word;
    }

    public int length() {
        return this.word.length();
    }

    public void setDimension(double dimension) throws Exception {
        if (dimension < 0.0)
            throw new Exception("Dimension cannot be than 0!");
        this.dimension = dimension;
    }

    public void setWord(String word) throws Exception {
        this.word = word;
        Dimension();
    }

    private void Dimension() throws Exception {
        char[] alphabet = {'а', 'е', 'и', 'о', 'у', 'э', 'ю', 'я', 'a', 'e', 'y', 'u', 'i', 'o'};
        int count = 0;
        for (int i = 0; i < this.word.length(); i++) {
            if (exist(alphabet, this.word.charAt(i)))
                count++;
        }
        double buffDimension = (double) count / (double) this.word.length();
        setDimension(buffDimension);
    }

    private boolean exist(char[] symbols, char symbol) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == symbol)
                return true;
        }
        return false;
    }

    @Override
    public int compare(Word w1, Word w2) {
        if (w1.getDimension() < w2.getDimension()) {
            return -1;
        } else if (w1.getDimension() > w2.getDimension()) {
            return 1;
        } else {
            return 0;
        }
    }
}
