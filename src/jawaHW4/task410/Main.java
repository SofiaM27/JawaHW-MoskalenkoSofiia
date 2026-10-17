package jawaHW4.task410;

import jawaHW4.task410.accessories.Accessory;
import jawaHW4.task410.bouquet.Bouquet;
import jawaHW4.task410.flowers.Flower;
import jawaHW4.task410.flowers.Lily;
import jawaHW4.task410.flowers.Rose;
import jawaHW4.task410.flowers.Tulip;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        bouquet.addFlower(new Rose(80, 3, 60));
        bouquet.addFlower(new Tulip(50, 1, 35));
        bouquet.addFlower(new Lily(110, 2, 55));
        bouquet.addFlower(new Rose(75, 5, 45));

        bouquet.addAccessory(new Accessory("Стрічка", 20));
        bouquet.addAccessory(new Accessory("Пакування", 30));

        System.out.printf("Вартість букета: %.2f грн%n",
                bouquet.getTotalPrice());

        System.out.println("Квіти за свіжістю (від свіжіших):");

        bouquet.sortByFreshness();
        bouquet.printFlowers();

        System.out.println("Квіти з довжиною стебла від 40 до 60 см:");

        for (Flower flower : bouquet.findByStemLength(40, 60)) {
            System.out.println(flower);
        }
    }
}