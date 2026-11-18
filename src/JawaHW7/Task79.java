package JawaHW7;

import java.util.*;

public class Task79 {
    static int play(List<Integer> list, int n, int k) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int pos = 0;
        while (list.size() > 1) {
            pos = (pos + k - 1) % list.size();
            list.remove(pos);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int n = 50000;
        int k = 2;

        long start = System.currentTimeMillis();
        int r1 = play(new ArrayList<Integer>(), n, k);
        long t1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        int r2 = play(new LinkedList<Integer>(), n, k);
        long t2 = System.currentTimeMillis() - start;

        System.out.println("ArrayList:  залишився " + r1 + ", час " + t1 + " мс");
        System.out.println("LinkedList: залишився " + r2 + ", час " + t2 + " мс");
    }
}