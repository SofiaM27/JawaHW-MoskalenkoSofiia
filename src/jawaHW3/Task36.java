package jawaHW3;


public class Task36 {
    public static void main(String[] args) {
        String[] words = {"Java", "Python", "C++", "JavaScript", "Kotlin"};

        System.out.println("Масив в один рядок:");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i < words.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n\nЕлементи масиву з індексами:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("Індекс " + i + ": " + words[i]);
        }
    }
}
