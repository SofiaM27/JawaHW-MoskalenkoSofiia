package JawaaHW5;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task58 {

    public static int sumNumbersInString(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        int sum = 0;

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            sum += number;
        }

        return sum;
    }

    public static int sumStrings(String first, String second) {
        return sumNumbersInString(first)
                + sumNumbersInString(second);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перший рядок: ");
        String first = scanner.nextLine();

        System.out.print("Введіть другий рядок: ");
        String second = scanner.nextLine();

        int result = sumStrings(first, second);

        System.out.println("Результат додавання: " + result);
    }
}
