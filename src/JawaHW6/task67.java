package JawaHW6;

import java.io.*;
import java.util.*;

public class task67 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть n: ");
        int n = in.nextInt();

        Scanner f = new Scanner(new File("F.txt"));
        PrintWriter g = new PrintWriter("G.txt");

        int count = 0;
        int max = 0;
        while (f.hasNextInt()) {
            int x = f.nextInt();
            if (count == 0 || x > max) max = x;
            count++;
            if (count == n) {
                g.println(max);
                count = 0;
            }
        }
        if (count > 0) g.println(max);

        f.close();
        g.close();
    }
}