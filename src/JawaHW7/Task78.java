package JawaHW7;

public class Task78 {
    public static void main(String[] args) {
        String text = "Mama myla ramu. Rama chysta, mama rada! MAMA znovu myla ramu.";

        String clean = text.replace(".", " ").replace(",", " ").replace("!", " ").toLowerCase();
        String[] words = clean.split(" ");

        int total = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("")) {
                total++;
            }
        }

        for (int k = 0; k < args.length; k++) {
            int count = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(args[k].toLowerCase())) {
                    count++;
                }
            }
            double frequency = (double) count / total;
            System.out.println(args[k] + ": " + count + " з " + total + ", частота = " + frequency);
        }
    }
}