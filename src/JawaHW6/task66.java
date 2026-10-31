package JawaHW6;

import java.io.*;
import java.util.*;

public class task66 {
    static List<String> names = new ArrayList<>();
    static List<int[]> items = new ArrayList<>();   // {номер, кількість}
    static List<Double> weights = new ArrayList<>();

    static void read() throws IOException {
        Scanner sp = new Scanner(new File("passengers.txt"));
        while (sp.hasNextLine()) {
            String s = sp.nextLine().trim();
            if (!s.isEmpty()) names.add(s);
        }
        sp.close();

        Scanner sb = new Scanner(new File("baggage.txt"));
        sb.useLocale(Locale.US);
        while (sb.hasNextInt()) {
            int num = sb.nextInt();
            int cnt = sb.nextInt();
            double w = sb.nextDouble();
            items.add(new int[]{num, cnt});
            weights.add(w);
        }
        sb.close();
    }

    static void print(int i) {
        int num = items.get(i)[0];
        System.out.println(names.get(num - 1) + " (№" + num + "), речей: "
                + items.get(i)[1] + ", вага: " + weights.get(i));
    }

    static void a() {
        double totalW = 0;
        int totalC = 0;
        for (int i = 0; i < items.size(); i++) {
            totalW += weights.get(i);
            totalC += items.get(i)[1];
        }
        double avgAll = totalW / totalC;
        System.out.println("а)");
        for (int i = 0; i < items.size(); i++) {
            double avgOne = weights.get(i) / items.get(i)[1];
            if (Math.abs(avgOne - avgAll) <= 1) print(i);
        }
    }

    static void b() {
        double avgCnt = 0;
        for (int[] it : items) avgCnt += it[1];
        avgCnt /= items.size();
        System.out.println("б)");
        for (int i = 0; i < items.size(); i++) {
            int c = items.get(i)[1];
            if (c > 2 && c > avgCnt) print(i);
        }
    }

    static void c() {
        int maxCnt = 0;
        for (int[] it : items) maxCnt = Math.max(maxCnt, it[1]);
        double minW = Double.MAX_VALUE;
        for (int i = 0; i < items.size(); i++)
            if (items.get(i)[1] == maxCnt) minW = Math.min(minW, weights.get(i));
        System.out.println("в)");
        for (int i = 0; i < items.size(); i++)
            if (items.get(i)[1] == maxCnt && weights.get(i) == minW) print(i);
    }

    public static void main(String[] args) throws IOException {
        read();
        a();
        b();
        c();
    }
}