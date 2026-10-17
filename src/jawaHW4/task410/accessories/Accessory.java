package jawaHW4.task410.accessories;


public class Accessory {
    private final String name;
    private final double price;

    public Accessory(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною.");
        }

        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f грн", name, price);
    }
}