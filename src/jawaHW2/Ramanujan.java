package jawaHW2;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Ramanujan {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Вкажіть число n як аргумент програми.");
            System.out.println("Приклад: java Ramanujan 87539319");
            return;
        }

        int n = Integer.parseInt(args[0]);

        if (n < 1) {
            System.out.println("n має бути додатним числом.");
            return;
        }

        TreeMap<Long, ArrayList<String>> sums = new TreeMap<>();

        for (int a = 1; (long) a * a * a < n; a++) {
            for (int b = a + 1;
                 (long) a * a * a + (long) b * b * b <= n;
                 b++) {

                long sum = (long) a * a * a +
                        (long) b * b * b;

                if (!sums.containsKey(sum)) {
                    sums.put(sum, new ArrayList<>());
                }

                sums.get(sum).add(a + "^3 + " + b + "^3");
            }
        }

        boolean found = false;

        for (Map.Entry<Long, ArrayList<String>> entry : sums.entrySet()) {
            if (entry.getValue().size() >= 2) {
                found = true;
                System.out.print(entry.getKey() + " = ");
                System.out.println(String.join(" = ", entry.getValue()));
            }
        }

        if (!found) {
            System.out.println("Таких чисел до " + n + " немає.");
        }
    }
}