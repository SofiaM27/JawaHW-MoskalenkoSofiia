package jawahw9;

import java.util.*;

public class Task86 {
    public static void main(String[] args) throws InterruptedException {
        Exchange exchange = new Exchange();
        Broker[] brokers = {
                new Broker("Іван", exchange, 0.4),
                new Broker("Олена", exchange, 0.5),
                new Broker("Петро", exchange, 0.8)   // Петро частіше продає
        };
        for (int i = 0; i < brokers.length; i++) {
            brokers[i].start();
        }
        for (int i = 0; i < brokers.length; i++) {
            brokers[i].join();
        }
        exchange.printResult();
    }
}

class Stock {
    String name;
    double startPrice;
    double price;
    int count;

    Stock(String name, double price, int count) {
        this.name = name;
        this.startPrice = price;
        this.price = price;
        this.count = count;
    }
}

class Exchange {
    Stock[] stocks = {
            new Stock("Apple", 150, 100),
            new Stock("Google", 120, 100),
            new Stock("Tesla", 200, 100),
            new Stock("Nokia", 20, 100)
    };
    boolean halted = false;

    double index() {
        double sum = 0;
        double start = 0;
        for (int i = 0; i < stocks.length; i++) {
            sum += stocks[i].price;
            start += stocks[i].startPrice;
        }
        return sum / start * 100;
    }

    synchronized boolean isHalted() {
        return halted;
    }

    synchronized boolean buy(int s, int qty, String broker) {
        if (halted) {
            return false;
        }
        Stock st = stocks[s];
        if (st.count < qty) {
            System.out.println(broker + " не зміг купити " + qty + " " + st.name + " (немає стільки)");
            return false;
        }
        st.count -= qty;
        st.price = st.price * (1 + 0.004 * qty);
        System.out.printf("%s купив %d %s, ціна %.2f, індекс %.2f%n", broker, qty, st.name, st.price, index());
        checkHalt();
        return true;
    }

    synchronized boolean sell(int s, int qty, String broker) {
        if (halted) {
            return false;
        }
        Stock st = stocks[s];
        st.count += qty;
        st.price = st.price * (1 - 0.004 * qty);
        System.out.printf("%s продав %d %s, ціна %.2f, індекс %.2f%n", broker, qty, st.name, st.price, index());
        checkHalt();
        return true;
    }

    void checkHalt() {
        if (index() < 92) {
            halted = true;
            System.out.println("!!! Індекс різко впав, торги призупинено !!!");
        }
    }

    void printResult() {
        System.out.println("--- Підсумок ---");
        for (int i = 0; i < stocks.length; i++) {
            System.out.printf("%s: ціна %.2f, на біржі %d акцій%n", stocks[i].name, stocks[i].price, stocks[i].count);
        }
        System.out.printf("Індекс: %.2f, торги %s%n", index(), halted ? "призупинено" : "тривали до кінця");
    }
}

class Broker extends Thread {
    private String name;
    private Exchange exchange;
    private double sellChance;
    private int[] portfolio = {30, 30, 30, 30};
    private Random random = new Random();

    Broker(String name, Exchange exchange, double sellChance) {
        this.name = name;
        this.exchange = exchange;
        this.sellChance = sellChance;
    }

    public void run() {
        for (int i = 0; i < 40; i++) {
            if (exchange.isHalted()) {
                System.out.println(name + " іде додому: торги зупинені");
                return;
            }
            int s = random.nextInt(portfolio.length);
            int qty = 1 + random.nextInt(10);
            if (random.nextDouble() < sellChance) {
                if (portfolio[s] >= qty && exchange.sell(s, qty, name)) {
                    portfolio[s] -= qty;
                }
            } else {
                if (exchange.buy(s, qty, name)) {
                    portfolio[s] += qty;
                }
            }
            try {
                Thread.sleep(random.nextInt(30));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}