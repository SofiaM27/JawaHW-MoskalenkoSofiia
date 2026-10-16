package jawaHW4.task49;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private final String title;
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String title) {
        this.title = title;
    }

    public void appendText(Sentence sentence) {
        sentences.add(sentence);
    }

    public void printTitle() {
        System.out.println("Заголовок: " + title);
    }

    public void printText() {
        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }
}