package JawaHW6;

import java.io.*;
import java.util.*;

public class task611 {
    static List<String> names = new ArrayList<>();
    static List<Integer> nums = new ArrayList<>();
    static List<Integer> counts = new ArrayList<>();
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
            nums.add(sb.nextInt());
            counts.add(sb.nextInt());
            weights.add(sb.nextDouble());
        }
        sb.close();
    }

    static void find() {
        double totalW = 0;
        int totalC = 0;
        for (int i = 0; i < nums.size(); i++) {
            totalW += weights.get(i);
            totalC += counts.get(i);
        }
        double avgAll = totalW / totalC;
        System.out.println("Загальна середня вага речі: " + avgAll);

        for (int i = 0; i < nums.size(); i++) {
            double avgOne = weights.get(i) / counts.get(i);
            if (Math.abs(avgOne - avgAll) <= 1) {
                System.out.println(names.get(nums.get(i) - 1) + " (№" + nums.get(i)
                        + "), середня вага речі: " + avgOne);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        read();
        find();
    }
}