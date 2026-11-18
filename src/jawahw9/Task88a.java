package jawahw9;

import java.util.*;

public class Task88a {
    public static void main(String[] args) throws InterruptedException {
        int tills = 3;        // кількість кас
        int visitors = 12;    // кількість відвідувачів

        Restaurant restaurant = new Restaurant(tills, visitors);

        Cashier[] cashiers = new Cashier[tills];
        for (int i = 0; i < tills; i++) {
            cashiers[i] = new Cashier(i, restaurant);
            cashiers[i].start();
        }
        Visitor[] list = new Visitor[visitors];
        for (int i = 0; i < visitors; i++) {
            list[i] = new Visitor(i + 1, restaurant);
            list[i].start();
        }
        for (int i = 0; i < visitors; i++) {
            list[i].join();
        }
        for (int i = 0; i < tills; i++) {
            cashiers[i].join();
        }
        System.out.println("Ресторан закрито, усіх обслужено. Переходів між чергами: " + restaurant.moves);
    }
}

class Restaurant {
    private ArrayList<Visitor>[] queues;
    private int total;
    private int served = 0;
    int moves = 0;
    private Random random = new Random();

    @SuppressWarnings("unchecked")
    Restaurant(int tills, int total) {
        this.total = total;
        queues = new ArrayList[tills];
        for (int i = 0; i < tills; i++) {
            queues[i] = new ArrayList<Visitor>();
        }
    }

    synchronized void join(Visitor v) {
        int till = random.nextInt(queues.length);
        queues[till].add(v);
        System.out.println("Відвідувач " + v.number + " став у чергу до каси " + (till + 1)
                + " (там людей: " + queues[till].size() + ")");
        notifyAll();
    }

    synchronized void tryMove(Visitor v) {
        int mine = -1;
        int position = -1;
        for (int i = 0; i < queues.length; i++) {
            int p = queues[i].indexOf(v);
            if (p != -1) {
                mine = i;
                position = p;
            }
        }
        if (mine == -1) {
            return;
        }
        for (int j = 0; j < queues.length; j++) {
            if (j != mine && queues[j].size() < position) {
                queues[mine].remove(v);
                queues[j].add(v);
                moves++;
                System.out.println("   Відвідувач " + v.number + " перейшов з каси " + (mine + 1)
                        + " до каси " + (j + 1) + " (там людей: " + queues[j].size() + ")");
                notifyAll();
                return;
            }
        }
    }


    synchronized Visitor next(int till) throws InterruptedException {
        while (queues[till].isEmpty()) {
            if (served == total) {
                return null;
            }
            wait();
        }
        return queues[till].remove(0);
    }

    synchronized void oneServed() {
        served++;
        if (served == total) {
            notifyAll();
        }
    }
}

class Visitor extends Thread {
    int number;
    private Restaurant restaurant;
    volatile boolean done = false;
    private Random random = new Random();

    Visitor(int number, Restaurant restaurant) {
        this.number = number;
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            Thread.sleep(random.nextInt(1500));
            restaurant.join(this);
            while (!done) {
                Thread.sleep(100);
                restaurant.tryMove(this);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}

class Cashier extends Thread {
    private int till;
    private Restaurant restaurant;
    private Random random = new Random();

    Cashier(int till, Restaurant restaurant) {
        this.till = till;
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            Visitor v = restaurant.next(till);
            while (v != null) {
                System.out.println("      Каса " + (till + 1) + " обслуговує відвідувача " + v.number);
                Thread.sleep(300 + random.nextInt(500));
                v.done = true;
                restaurant.oneServed();
                v = restaurant.next(till);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}