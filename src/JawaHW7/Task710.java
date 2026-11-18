package JawaHW7;

import java.io.*;
import java.util.*;

public class Task710 {
    static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        int[] x = {0, 1, 2, 0, 2, 5};
        int[] y = {0, 1, 2, 1, 1, 0};
        int n = x.length;

        HashMap<String, HashSet<Integer>> map = new HashMap<String, HashSet<Integer>>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = y[j] - y[i];
                int b = x[i] - x[j];
                int g = gcd(a, b);
                a = a / g;
                b = b / g;
                if (a < 0 || (a == 0 && b < 0)) {
                    a = -a;
                    b = -b;
                }
                int c = a * x[i] + b * y[i];
                String key = a + " " + b + " " + c;

                if (!map.containsKey(key)) {
                    map.put(key, new HashSet<Integer>());
                }
                map.get(key).add(i);
                map.get(key).add(j);
            }
        }

        PrintWriter out = new PrintWriter("lines.txt");
        for (String key : map.keySet()) {
            String[] p = key.split(" ");
            out.println(p[0] + "x + " + p[1] + "y = " + p[2] + ", точок: " + map.get(key).size());
        }
        out.close();
    }
}