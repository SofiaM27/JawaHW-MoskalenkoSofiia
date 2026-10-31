package JawaaHW5;


import java.util.Scanner;

public class task57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String text = scanner.nextLine();

        String result = text.replaceAll(
                "\\b(small|large)\\b",
                "very $1"
        );

        System.out.println("Результат: " + result);
    }
}
