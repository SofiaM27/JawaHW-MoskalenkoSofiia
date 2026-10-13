package jawaHW2;

import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число, номер біта і значення біта (0 або 1): ");
        long number = scanner.nextLong();
        int position = scanner.nextInt();
        int bit = scanner.nextInt();

        if (number < 0 || number > 0xFFFFFFFFL ||
                position < 1 || position > 32 ||
                (bit != 0 && bit != 1)) {
            System.out.println("Некоректні дані!");
            return;
        }

        long mask = 1L << (position - 1);

        if (bit == 1) {
            number = number | mask;
        } else {
            number = number & ~mask;
        }

        System.out.println(number + " 0x" +
                Long.toHexString(number).toUpperCase() +
                " " + Long.toBinaryString(number));
    }
}