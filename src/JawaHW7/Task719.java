package JawaHW7;

public class Task719 {
    static int[] encrypt(String text, int[] k1, int[] k2) {
        int[] c = new int[text.length()];
        for (int i = 0; i < c.length; i++) {
            c[i] = text.charAt(i) ^ k1[i % k1.length] ^ k2[i % k2.length];
        }
        return c;
    }

    public static void main(String[] args) {
        String text = "HelloWorldHowAreYouToday";
        int[] key1 = {'k', 'e', 'y'};
        int[] key2 = {'a', 'b'};
        int[] cipher = encrypt(text, key1, key2);
        int n = text.length();

        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = text.charAt(i) ^ cipher[i];
        }

        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && k[i] != k[j]) {
                j = pi[j - 1];
            }
            if (k[i] == k[j]) {
                j++;
            }
            pi[i] = j;
        }
        int p = n - pi[n - 1];

        int[] k1 = new int[p];
        int[] k2 = new int[p];
        for (int j = 0; j < p; j++) {
            k1[j] = 'A';
            k2[j] = k1[j] ^ k[j];
        }

        System.out.println("Довжина ефективного ключа: " + p);
        System.out.print("K1: ");
        for (int j = 0; j < p; j++) System.out.print(k1[j] + " ");
        System.out.print("\nK2: ");
        for (int j = 0; j < p; j++) System.out.print(k2[j] + " ");
        System.out.println();

        int[] check = encrypt(text, k1, k2);
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (check[i] != cipher[i]) ok = false;
        }
        System.out.println("Збігається з зашифрованим текстом: " + ok);
    }
}
