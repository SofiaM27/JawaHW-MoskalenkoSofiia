package jawaHW1;

public class DefaultValues {
    int number;
    char symbol;
    String text;

    public static void main(String[] args) {
        DefaultValues obj = new DefaultValues();

        System.out.println("int = " + obj.number);
        System.out.println("char = [" + obj.symbol + "]");
        System.out.println("Код символу char = " + (int) obj.symbol);
        System.out.println("String = " + obj.text);
    }
}
