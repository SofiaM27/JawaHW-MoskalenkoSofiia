package jawaHW4.task42home;

public class Product {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private int shelfLife;
    private int quantity;

    public Product(int id, String name, String upc,
                   String manufacturer, double price,
                   int shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Назва: " + name);
        System.out.println("UPC: " + upc);
        System.out.println("Виробник: " + manufacturer);
        System.out.println("Ціна: " + price + " грн");
        System.out.println("Термін зберігання: " + shelfLife + " днів");
        System.out.println("Кількість: " + quantity);
        System.out.println("-------------------------");
    }
}