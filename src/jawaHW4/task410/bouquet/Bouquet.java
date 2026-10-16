package jawaHW4.task410.bouquet;


import jawaHW4.task410.accessories.Accessory;
import jawaHW4.task410.flowers.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bouquet {
    private final List<Flower> flowers = new ArrayList<>();
    private final List<Accessory> accessories = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public double getTotalPrice() {
        double total = 0;

        for (Flower flower : flowers) {
            total += flower.getPrice();
        }

        for (Accessory accessory : accessories) {
            total += accessory.getPrice();
        }

        return total;
    }

    public void sortByFreshness() {
        flowers.sort(Comparator.comparingInt(Flower::getFreshness));
    }

    public List<Flower> findByStemLength(double from, double to) {
        if (from > to) {
            throw new IllegalArgumentException("Неправильний діапазон.");
        }

        List<Flower> found = new ArrayList<>();

        for (Flower flower : flowers) {
            if (flower.getStemLength() >= from && flower.getStemLength() <= to) {
                found.add(flower);
            }
        }

        return found;
    }

    public void printFlowers() {
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }
}