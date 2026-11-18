package jawahw9;

import java.util.*;

public class Task87a {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        int clients = 10;
        int t1 = 0, t2 = 1500;
        int t3 = 600, t4 = 1200;
        int t5 = 300, t6 = 800;

        CallCenter center = new CallCenter(n);
        Client[] list = new Client[clients];
        for (int i = 0; i < clients; i++) {
            list[i] = new Client(i + 1, center, t1, t2, t3, t4, t5, t6);
            list[i].start();
        }
        for (int i = 0; i < clients; i++) {
            list[i].join();
        }
        System.out.println("--- Підсумок ---");
        System.out.println("Усього дзвінків: " + center.calls);
        System.out.println("З них відмов (усі оператори зайняті): " + center.refused);
    }
}

class CallCenter {
    private boolean[] busy;
    int calls = 0;
    int refused = 0;

    CallCenter(int n) {
        busy = new boolean[n];
    }

    synchronized int call() {
        calls++;
        for (int i = 0; i < busy.length; i++) {
            if (!busy[i]) {
                busy[i] = true;
                return i;
            }
        }
        refused++;
        return -1;
    }

    synchronized void finish(int operator) {
        busy[operator] = false;
    }
}

class Client extends Thread {
    private int number;
    private CallCenter center;
    private int t1, t2, t3, t4, t5, t6;
    private Random random = new Random();

    Client(int number, CallCenter center, int t1, int t2, int t3, int t4, int t5, int t6) {
        this.number = number;
        this.center = center;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
    }

    int between(int a, int b) {
        return a + random.nextInt(b - a + 1);
    }

    public void run() {
        try {
            Thread.sleep(between(t1, t2));
            int operator = center.call();
            while (operator == -1) {
                System.out.println("Клієнт " + number + ": усі оператори зайняті, кладе слухавку");
                Thread.sleep(between(t5, t6));
                System.out.println("Клієнт " + number + " передзвонює");
                operator = center.call();
            }
            System.out.println("Клієнт " + number + " розмовляє з оператором " + (operator + 1));
            Thread.sleep(between(t3, t4));
            center.finish(operator);
            System.out.println("   Клієнт " + number + " закінчив розмову, оператор " + (operator + 1) + " вільний");
        } catch (InterruptedException e) {
            return;
        }
    }
}