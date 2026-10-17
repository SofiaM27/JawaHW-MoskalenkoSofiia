package jawaHW4.task49;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Sentence {
    private final List<Word> words = new ArrayList<>();

    public void addWord(Word word) {
        words.add(word);
    }

    @Override
    public String toString() {
        StringJoiner text = new StringJoiner(" ");

        for (Word word : words) {
            text.add(word.toString());
        }

        return text.toString() + ".";
    }
}