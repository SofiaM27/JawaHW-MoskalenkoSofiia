package jawaHW3;


import java.util.Random;
import java.util.Scanner;

public class Task34 {
    public static void fillFromConsole(int[][] matrix, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value;
                do {
                    System.out.print("a[" + i + "][" + j + "] (від " + (-n) + " до " + n + "): ");
                    value = scanner.nextInt();
                } while (value < -n || value > n);
                matrix[i][j] = value;
            }
        }
    }

    public static void fillRandom(int[][] matrix, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір матриці n: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Розмір матриці повинен бути додатним.");
            scanner.close();
            return;
        }

        int[][] matrix = new int[n][n];

        System.out.println("1 - ввести елементи з консолі");
        System.out.println("2 - заповнити випадковими числами");
        System.out.print("Оберіть спосіб: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            fillFromConsole(matrix, n, scanner);
        } else if (choice == 2) {
            fillRandom(matrix, n);
        } else {
            System.out.println("Невірний вибір.");
            scanner.close();
            return;
        }

        System.out.println("Отримана матриця:");
        printMatrix(matrix, n);
        scanner.close();
    }
}
