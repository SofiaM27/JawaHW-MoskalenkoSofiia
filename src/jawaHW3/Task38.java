package jawaHW3;


import java.util.ArrayList;
import java.util.Scanner;

public class Task38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть довжину масиву: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Довжина масиву повинна бути додатною.");
            scanner.close();
            return;
        }

        int[] numbers = new int[n];
        System.out.println("Введіть " + n + " елементів масиву:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        ArrayList<int[]> segments = new ArrayList<>();
        int maxLength = 1;

        if (n == 1) {
            segments.add(new int[]{0, 0});
        } else {
            int start = 0;

            while (start < n - 1) {
                int direction = Integer.compare(numbers[start + 1], numbers[start]);
                int end = start + 1;

                while (end < n - 1 &&
                        Integer.compare(numbers[end + 1], numbers[end]) == direction) {
                    end++;
                }

                int length = end - start + 1;
                if (length > maxLength) {
                    maxLength = length;
                    segments.clear();
                }
                if (length == maxLength) {
                    segments.add(new int[]{start, end});
                }

                start = end;
            }
        }

        System.out.println("Найбільша довжина: " + maxLength);
        System.out.println("Всі монотонні відрізки максимальної довжини:");

        for (int[] segment : segments) {
            for (int i = segment[0]; i <= segment[1]; i++) {
                System.out.print(numbers[i]);
                if (i < segment[1]) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
