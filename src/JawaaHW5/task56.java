package JawaaHW5;


import java.util.Scanner;

public class task56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String text = scanner.nextLine();

        StringBuilder result1 = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isDigit(ch)) {
                continue;
            }

            result1.append(ch);

            if (ch == '+' || ch == '-') {
                result1.append(ch);
            }
        }

        String result2 = text.replaceAll("\\+(?=\\d)", "");

        String result3 = text.replaceAll("(?<=c)b", "");

        String result4 = text.replace("ph", "f");

        String result5 = text.replaceAll(" {2,}", " ");

        System.out.println("\nРезультати:");

        System.out.println("1. " + result1);
        System.out.println("2. " + result2);
        System.out.println("3. " + result3);
        System.out.println("4. " + result4);
        System.out.println("5. " + result5);
    }
}
