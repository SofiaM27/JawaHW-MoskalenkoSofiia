package jawaHW1;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class PowerOfEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Введіть число від 0 до 10000: ");
        BigDecimal x = scanner.nextBigDecimal();

        if (x.compareTo(BigDecimal.ZERO) < 0 ||
                x.compareTo(new BigDecimal("10000")) > 0) {
            System.out.println("Помилка: число має бути від 0 до 10000.");
            scanner.close();
            return;
        }

        BigDecimal result = x.pow(8);
        System.out.printf(Locale.US, "x^8 = |%25.4f|%n", result);
        scanner.close();
    }
}
