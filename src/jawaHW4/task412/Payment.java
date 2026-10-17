package jawaHW4.task412;


import java.util.ArrayList;
import java.util.List;

public class Payment {
    private final List<Product> products = new ArrayList<>();

    private class Product {
        private final String name;
        private final double price;
        private final int quantity;

        Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        double getTotal() {
            return price * quantity;
        }

        void print() {
            System.out.printf("%s — %d шт. × %.2f грн = %.2f грн%n",
                    name, quantity, price, getTotal());
        }
    }

    public void addProduct(String name, double price, int quantity) {
        if (name == null || name.trim().isEmpty() || price < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Некоректні дані товару.");
        }

        products.add(new Product(name, price, quantity));
    }

    public void printReceipt() {
        double total = 0;

        System.out.println("Чек покупки:");

        for (Product product : products) {
            product.print();
            total += product.getTotal();
        }

        System.out.printf("Разом: %.2f грн%n", total);
    }

    public static void main(String[] args) {
        Payment payment = new Payment();

        payment.addProduct("Хліб", 35, 2);
        payment.addProduct("Молоко", 48, 1);
        payment.addProduct("Яблука", 30, 3);

        payment.printReceipt();
    }
}