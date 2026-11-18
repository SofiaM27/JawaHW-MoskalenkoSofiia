package jawahw9;

import java.util.*;

public class Task87 {
    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(3);
        Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(i + 1, parking);
            cars[i].start();
        }
        for (int i = 0; i < cars.length; i++) {
            cars[i].join();
        }
        System.out.println("--- Підсумок ---");
        System.out.println("Припарковалось: " + parking.parked);
        System.out.println("Поїхало на іншу стоянку: " + parking.left);
    }
}

class Parking {
    private boolean[] busy;
    int parked = 0;
    int left = 0;

    Parking(int places) {
        busy = new boolean[places];
    }

    synchronized int takePlace(long maxWait) throws InterruptedException {
        long end = System.currentTimeMillis() + maxWait;
        while (true) {
            for (int i = 0; i < busy.length; i++) {
                if (!busy[i]) {
                    busy[i] = true;
                    parked++;
                    return i;
                }
            }
            long rest = end - System.currentTimeMillis();
            if (rest <= 0) {
                left++;
                return -1;
            }
            wait(rest);
        }
    }

    synchronized void freePlace(int i) {
        busy[i] = false;
        notifyAll();
    }
}

class Car extends Thread {
    private int number;
    private Parking parking;
    private Random random = new Random();

    Car(int number, Parking parking) {
        this.number = number;
        this.parking = parking;
    }

    public void run() {
        try {
            Thread.sleep(random.nextInt(1000));
            System.out.println("Авто " + number + " під'їхало");
            int place = parking.takePlace(300);
            if (place == -1) {
                System.out.println("Авто " + number + " не дочекалось і поїхало на іншу стоянку");
                return;
            }
            System.out.println("Авто " + number + " стало на місце " + (place + 1));
            Thread.sleep(400 + random.nextInt(500));
            parking.freePlace(place);
            System.out.println("Авто " + number + " поїхало, місце " + (place + 1) + " вільне");
        } catch (InterruptedException e) {
            return;
        }
    }
}