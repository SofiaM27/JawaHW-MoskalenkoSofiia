package jawaHW4.task49;

public class Main {
    public static void main(String[] args) {
        Text text = new Text("Вивчаємо Java");

        Sentence first = new Sentence();
        first.addWord(new Word("Я"));
        first.addWord(new Word("вивчаю"));
        first.addWord(new Word("Java"));

        Sentence second = new Sentence();
        second.addWord(new Word("Це"));
        second.addWord(new Word("цікава"));
        second.addWord(new Word("мова"));

        text.appendText(first);
        text.appendText(second);

        text.printTitle();
        text.printText();
    }
}