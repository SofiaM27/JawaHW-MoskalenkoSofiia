package jawaHW1;

public class CommandLineArguments {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Потрібно передати рівно 3 аргументи.");
            System.out.println("Наприклад: java jawaHW1.CommandLineArguments 3.5 abc 2.1");
            return;
        }

        double sum = 0;
        int count = 0;

        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + (i + 1) + ": " + args[i]);

            try {
                double number = Double.parseDouble(args[i]);
                if (Double.isFinite(number)) {
                    sum += number;
                    count++;
                }
            } catch (NumberFormatException e) {
            }
        }

        System.out.println("Сума числових аргументів = " + sum);
        System.out.println("Кількість дійсних чисел = " + count);
    }
}
