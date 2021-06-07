package Text;

import java.util.ArrayList;
import java.util.Comparator;

public class Sentence implements Comparator<Sentence> {
    private ArrayList<Word> words = new ArrayList<Word>();
    private int numberOfWords;

    Sentence() {}

    Sentence(ArrayList<Word> words) {
        for (Word word : words)
            words.add(word);
        numberOfWords = this.words.size();
    }

    public ArrayList<Word> getWords() {
        return this.words;
    }

    public int getNumberOfWords() {
        return this.numberOfWords;
    }

    @Override
    public int compare(Sentence o1, Sentence o2) {
        return o2.getWords().size() - o1.getWords().size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word + " ");
        }
        return sb.toString();
    }
}
