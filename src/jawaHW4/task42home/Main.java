package jawaHW4.task42home;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
                new Product(1, "Молоко", "123456", "Яготинське", 45, 7, 20),
                new Product(2, "Хліб", "234567", "Київхліб", 30, 3, 15),
                new Product(3, "Молоко", "345678", "Галичина", 55, 10, 25),
                new Product(4, "Сир", "456789", "Комо", 120, 30, 10),
                new Product(5, "Хліб", "567890", "Кулиничі", 35, 5, 18),
                new Product(6, "Молоко", "678901", "Простоквашино", 50, 14, 12)
        };

        System.out.print("Введіть назву товару: ");
        String name = scanner.nextLine();

        System.out.println("\na) Товари із заданою назвою:");

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.printInfo();
            }
        }

        System.out.print("\nВведіть максимальну ціну: ");
        double maxPrice = scanner.nextDouble();

        System.out.println("\nb) Товари із заданою назвою та ціною:");

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)
                    && product.getPrice() <= maxPrice) {
                product.printInfo();
            }
        }

        System.out.print("\nВведіть мінімальний термін зберігання (днів): ");
        int minShelfLife = scanner.nextInt();

        System.out.println("\nc) Товари з більшим терміном зберігання:");

        for (Product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                product.printInfo();
            }
        }

        scanner.close();
    }
}