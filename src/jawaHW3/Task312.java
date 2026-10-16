package jawaHW3;


import java.util.Scanner;

public class Task312 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість копійок: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Сума не може бути від'ємною");
            return;
        }

        int minCoins = Integer.MAX_VALUE;
        int best50 = 0, best25 = 0, best10 = 0, best1 = 0;

        for (int a = 0; a <= n / 50; a++) {
            for (int b = 0; b <= (n - a * 50) / 25; b++) {
                int rest = n - a * 50 - b * 25;

                int c = rest / 10;
                int d = rest % 10;

                int total = a + b + c + d;

                if (total < minCoins) {
                    minCoins = total;
                    best50 = a;
                    best25 = b;
                    best10 = c;
                    best1 = d;
                }
            }
        }

        System.out.println("Найкращий спосіб:");

        int[] coins = {50, 25, 10, 1};
        int[] counts = {best50, best25, best10, best1};

        for (int i = 0; i < coins.length; i++) {
            if (counts[i] > 0) {
                System.out.print(coins[i] + " коп");

                if (counts[i] > 1) {
                    System.out.print(" * " + counts[i]);
                }

                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println("Кількість монет: " + minCoins);

        scanner.close();
    }
}
