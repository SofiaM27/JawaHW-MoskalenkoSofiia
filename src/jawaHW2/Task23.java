package jawaHW2;

import java.util.Scanner;

public class Task23 {
    static void generate(int n, int k, int depth,
                         int[] result, boolean[] used) {
        if (depth == k) {
            for (int i = 0; i < k; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = i;
                generate(n, k, depth + 1, result, used);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть N і K: ");
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (n < 1 || k < 1 || k > n) {
            System.out.println("Потрібно, щоб 1 <= K <= N.");
            return;
        }

        System.out.println("Перестановки з N елементів:");
        generate(n, n, 0, new int[n], new boolean[n + 1]);

        System.out.println("Упорядковані вибірки з K елементів:");
        generate(n, k, 0, new int[k], new boolean[n + 1]);
    }
}