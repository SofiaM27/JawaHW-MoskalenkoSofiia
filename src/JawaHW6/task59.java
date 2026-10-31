package JawaHW6;


import java.util.Scanner;

public class task59 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder(text);

        result.reverse();

        text = result.toString();

        System.out.println("Інверсія рядка: " + text);
    }
}
