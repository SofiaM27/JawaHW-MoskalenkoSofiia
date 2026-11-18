package JawaHW7;

import java.io.*;
import java.util.*;

public class Task77 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("input.txt");
        pw.println("banana");
        pw.println("apple");
        pw.println("cherry");
        pw.println("apricot");
        pw.close();

        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        br.close();

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}