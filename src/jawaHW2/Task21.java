package jawaHW2;

public class Task21 {
    public static void main(String[] args) {
        int a = 0x0A;
        int b = 0x0B;

        System.out.println("a = " + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b));

        System.out.println("a & b = " + Integer.toBinaryString(a & b));
        System.out.println("a | b = " + Integer.toBinaryString(a | b));
        System.out.println("a ^ b = " + Integer.toBinaryString(a ^ b));

        System.out.println("~a = " + Integer.toBinaryString(~a));
        System.out.println("~b = " + Integer.toBinaryString(~b));

        System.out.println("a << 1 = " + Integer.toBinaryString(a << 1));
        System.out.println("a >> 1 = " + Integer.toBinaryString(a >> 1));
        System.out.println("a >>> 1 = " + Integer.toBinaryString(a >>> 1));

        System.out.println("b << 1 = " + Integer.toBinaryString(b << 1));
        System.out.println("b >> 1 = " + Integer.toBinaryString(b >> 1));
        System.out.println("b >>> 1 = " + Integer.toBinaryString(b >>> 1));
    }
}