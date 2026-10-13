package jawaHW1;

import java.util.Scanner;
import java.util.Locale;

public class Polynomials {
    static double polynomial1(double x) {
        double t = x * x + 1;
        return t * t;
    }

    static double polynomial2(double x) {
        double t = x * x;
        return (t + x) * (t + 1) + 1;
    }

    static double polynomial3(double x) {
        double t = x + 1;
        double t2 = t * t;
        return t2 * t2 * t;
    }

    static double polynomial4(double x) {
        double t = x * x * x;
        return t * t * t + t + 1;
    }

    static double polynomial5(double x) {
        double t = 2 * x;
        double t2 = t * t;
        return (t2 + t) * (t2 + 1) + 1;
    }

    static double polynomial6(double x) {
        double t = x * x;
        return x * (t * t + t + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Введіть x: ");
        double x = scanner.nextDouble();

        System.out.println("1) y = " + polynomial1(x));
        System.out.println("2) y = " + polynomial2(x));
        System.out.println("3) y = " + polynomial3(x));
        System.out.println("4) y = " + polynomial4(x));
        System.out.println("5) y = " + polynomial5(x));
        System.out.println("6) y = " + polynomial6(x));

        scanner.close();
    }
}
