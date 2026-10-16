package jawaHW1;

import java.util.Locale;
import java.util.Scanner;

public class TriangleCalculator {

    static double distance(double x1, double y1,
                           double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static double triangleArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
            return 0;
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        double a = 3;
        double b = 3.5 + 3 * Math.pow(2, -111);
        double c = b;

        System.out.println("Частина 1. Трикутник за сторонами");
        System.out.printf(Locale.US, "Периметр = %.4f%n", a + b + c);
        System.out.printf(Locale.US, "Площа = %.4f%n", triangleArea(a, b, c));

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Частина 2. Трикутник за координатами");
        System.out.println("Введіть x і y для A, B, C (порожні рядки допускаються):");

        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();

        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();

        double cx = scanner.nextDouble();
        double cy = scanner.nextDouble();

        double ab = distance(ax, ay, bx, by);
        double bc = distance(bx, by, cx, cy);
        double ca = distance(cx, cy, ax, ay);

        System.out.printf(Locale.US, "AB = %.4f%n", ab);
        System.out.printf(Locale.US, "BC = %.4f%n", bc);
        System.out.printf(Locale.US, "CA = %.4f%n", ca);

        System.out.printf(Locale.US, "Периметр = %.4f%n", ab + bc + ca);
        System.out.printf(Locale.US, "Площа = %.4f%n", triangleArea(ab, bc, ca));

        scanner.close();
    }
}
