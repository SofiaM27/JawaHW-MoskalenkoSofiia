package jawaHW4.task49;

public class Word {
    private final String value;

    public Word(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Слово не може бути порожнім.");
        }

        this.value = value.trim();
    }

    @Override
    public String toString() {
        return value;
    }
}