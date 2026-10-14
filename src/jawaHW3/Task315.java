package jawaHW3;

import java.util.Scanner;

public class Task315 {
    public static void main(String[] args) {
        String code;

        if (args.length > 0) {
            code = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть 11-значне число: ");
            code = scanner.nextLine().trim();
        }

        if (!code.matches("[0-9]{11}")) {
            System.out.println("Помилка: введіть рівно 11 цифр.");
            return;
        }

        long number = Long.parseLong(code);
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            int digit = (int) (number % 10);

            if (i % 2 == 0) {
                sum += digit * 3;
            } else {
                sum += digit;
            }

            number /= 10;
        }

        int control = (10 - sum % 10) % 10;

        System.out.println("Повний UPC: " + code + control);
    }
}
