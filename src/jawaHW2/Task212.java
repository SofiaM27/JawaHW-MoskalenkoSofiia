package jawaHW2;

import java.util.Scanner;

public class Task212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = 0;
        long sum = 0;

        while (true) {
            System.out.print("a[" + index + "]=");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            sum += number;
            index++;
        }

        System.out.println("Сума введених чисел: " + sum);
    }
}