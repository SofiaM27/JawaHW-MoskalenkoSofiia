package JawaaHW5;


import java.util.Scanner;

public class task57Home {

    public static String findLongestWord(String text) {
        String[] words = text.trim().split("\\s+");

        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    public static int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        return text.trim().split("\\s+").length;
    }

    public static String removeExtraSpacesAndOneLetterWords(String text) {
        String[] words = text.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 1) {
                if (result.length() > 0) {
                    result.append(" ");
                }

                result.append(word);
            }
        }

        return result.toString();
    }

    public static String normalizeSpaces(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }

    public static String distributeSpaces(String text) {
        String[] words = text.trim().split("\\s+");

        if (words.length == 0 || text.trim().isEmpty()) {
            return "";
        }

        if (words.length == 1) {
            return words[0];
        }

        int wordsLength = 0;

        for (String word : words) {
            wordsLength += word.length();
        }

        int spaces = 80 - wordsLength;
        int gaps = words.length - 1;

        if (spaces < gaps) {
            return String.join(" ", words);
        }

        int spacesPerGap = spaces / gaps;
        int extraSpaces = spaces % gaps;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);

            if (i < gaps) {
                int currentSpaces = spacesPerGap;

                if (extraSpaces > 0) {
                    currentSpaces++;
                    extraSpaces--;
                }

                for (int j = 0; j < currentSpaces; j++) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок:");
        String text = scanner.nextLine();

        System.out.println("\nРезультати:");

        System.out.println("1. Найдовше слово: "
                + findLongestWord(text));

        System.out.println("2. Кількість слів: "
                + countWords(text));

        System.out.println("3. Без зайвих пробілів та однолітерних слів: "
                + removeExtraSpacesAndOneLetterWords(text));

        System.out.println("4. Нормалізований рядок: "
                + normalizeSpaces(text));

        String formatted = distributeSpaces(text);

        System.out.println("5. Рядок з рівномірними пробілами:");
        System.out.println(formatted);
        System.out.println("Довжина рядка: " + formatted.length());
    }
}
