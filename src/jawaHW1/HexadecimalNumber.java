package jawaHW1;

import java.util.Scanner;

public class HexadecimalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шістнадцяткове число: ");
        int number = scanner.nextInt(16);

        number = number - 1;

        System.out.printf("Шістнадцяткове число: %X%n", number);
        System.out.printf("Десяткове число: %d%n", number);

        scanner.close();
    }
}