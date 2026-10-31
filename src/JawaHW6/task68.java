package JawaHW6;

import java.io.*;
import java.util.*;

public class task68 {
    static class Toy {
        String name;
        double price;
        int ageFrom, ageTo;

        Toy(String name, double price, int ageFrom, int ageTo) {
            this.name = name;
            this.price = price;
            this.ageFrom = ageFrom;
            this.ageTo = ageTo;
        }

        public String toString() {
            return name + ", " + price + " грн, " + ageFrom + "-" + ageTo + " р.";
        }
    }

    static List<Toy> toys = new ArrayList<>();

    static void read() throws IOException {
        Scanner sc = new Scanner(new File("toys.txt"));
        sc.useLocale(Locale.US);
        while (sc.hasNext()) {
            String name = sc.next();
            double price = sc.nextDouble();
            int a = sc.nextInt();
            int b = sc.nextInt();
            toys.add(new Toy(name, price, a, b));
        }
        sc.close();
    }

    static void a() {
        System.out.println("а)");
        for (Toy t : toys)
            if (t.price <= 40) System.out.println(t);
    }

    static void b() {
        System.out.println("б)");
        for (Toy t : toys)
            if (t.ageFrom == 3 && t.ageTo == 7) System.out.println(t);
    }

    static void c() {
        double max = 0;
        for (Toy t : toys) max = Math.max(max, t.price);
        System.out.println("в)");
        for (Toy t : toys)
            if (max - t.price <= 50) System.out.println(t);
    }

    static void d() {
        Toy best = null;
        for (Toy t : toys)
            if (t.name.equals("конструктор") && (best == null || t.price > best.price))
                best = t;
        System.out.println("г)");
        System.out.println(best == null ? "Конструкторів немає" : best);
    }

    static void e() {
        System.out.println("д)");
        for (Toy t : toys)
            if (t.name.equals("кубик")) System.out.println(t);
    }

    static void f() {
        double minSum = Double.MAX_VALUE;
        int bi = -1, bj = -1;
        for (int i = 0; i < toys.size(); i++)
            for (int j = i + 1; j < toys.size(); j++) {
                double s = toys.get(i).price + toys.get(j).price;
                if (s < minSum) {
                    minSum = s;
                    bi = i;
                    bj = j;
                }
            }
        System.out.println("е)");
        if (bi != -1 && minSum <= 20)
            System.out.println(toys.get(bi) + " і " + toys.get(bj));
        else
            System.out.println("Такої пари немає");
    }

    static void g() {
        System.out.println("є)");
        for (Toy t : toys)
            if (t.name.equals("конструктор") && t.price == 22
                    && t.ageFrom == 5 && t.ageTo == 10)
                System.out.println(t);
    }

    public static void main(String[] args) throws IOException {
        read();
        a();
        b();
        c();
        d();
        e();
        f();
        g();
    }
}