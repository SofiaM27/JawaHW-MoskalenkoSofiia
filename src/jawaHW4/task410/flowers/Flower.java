package jawaHW4.task410.flowers;

public abstract class Flower {
    private final String name;
    private final double price;
    private final int freshness;
    private final double stemLength;

    protected Flower(String name, double price, int freshness, double stemLength) {
        if (price < 0 || freshness < 0 || stemLength <= 0) {
            throw new IllegalArgumentException("Некоректні дані квітки.");
        }

        this.name = name;
        this.price = price;
        this.freshness = freshness;
        this.stemLength = stemLength;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public double getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f грн, свіжість %d дн., стебло %.1f см",
                name, price, freshness, stemLength);
    }
}