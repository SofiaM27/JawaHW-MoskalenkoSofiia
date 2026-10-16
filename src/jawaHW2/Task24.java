package jawaHW2;

import java.util.Scanner;

public class Task24 {
    static long factorialWithLoop(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    static long factorialWithRecursion(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorialWithRecursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть натуральне число: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Число не є натуральним!");
            return;
        }

        if (n > 20) {
            System.out.println("Число занадто велике: 21! і більше не поміщається в long.");
            return;
        }

        System.out.println("Факторіал за допомогою циклу: "
                + factorialWithLoop(n));

        System.out.println("Факторіал за допомогою рекурсії: "
                + factorialWithRecursion(n));
    }
}
