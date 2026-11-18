package JawaHW7;

import java.io.*;
import java.util.*;

public class Task76 {
    public static void main(String[] args) throws IOException {
        String[] names = {"Sofia", "Alina", "Oleh", "Maria", "Taras"};
        int[] ages = {20, 21, 22, 19, 23};

        Stack<Long> stack = new Stack<Long>();
        DataOutputStream out = new DataOutputStream(new FileOutputStream("records.bin"));
        for (int i = 0; i < names.length; i++) {
            stack.push((long) out.size());
            out.writeUTF(names[i]);
            out.writeInt(ages[i]);
        }
        out.close();

        long[] index = new long[stack.size()];
        for (int i = index.length - 1; i >= 0; i--) {
            index[i] = stack.pop();
        }

        RandomAccessFile file = new RandomAccessFile("records.bin", "r");
        int number = 3;
        file.seek(index[number]);
        String name = file.readUTF();
        int age = file.readInt();
        System.out.println("Record " + number + ": " + name + ", " + age);
        file.close();
    }
}