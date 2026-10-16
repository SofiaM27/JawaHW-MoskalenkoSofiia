package jawaHW3;


import java.util.Scanner;

public class Task37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int characters = 0;
        int words = 0;
        int lines = 0;

        System.out.println("Введіть текст. Для завершення введіть STOP в окремому рядку:");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("STOP")) {
                break;
            }

            lines++;
            characters += line.codePointCount(0, line.length());

            if (!line.trim().isEmpty()) {
                words += line.trim().split("\\s+").length;
            }
        }

        System.out.println("Кількість символів: " + characters);
        System.out.println("Кількість слів: " + words);
        System.out.println("Кількість рядків: " + lines);
        scanner.close();
    }
}
