package jawahw9;

import java.util.*;

public class Task86a {
    public static void main(String[] args) throws InterruptedException {
        int t1 = 300;
        int t2 = 500;

        MessageQueue queue = new MessageQueue();
        Producer producer = new Producer(queue, t1, 8);
        Consumer consumer = new Consumer(queue, t2);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Усі повідомлення оброблено");
    }
}

class MessageQueue {
    private LinkedList<String> list = new LinkedList<String>();
    private boolean finished = false;

    synchronized void put(String message) {
        list.addLast(message);
        notifyAll();
    }

    synchronized String take() throws InterruptedException {
        while (list.isEmpty()) {
            if (finished) {
                return null;
            }
            wait();
        }
        return list.removeFirst();
    }

    synchronized int size() {
        return list.size();
    }

    synchronized void finish() {
        finished = true;
        notifyAll();
    }
}

class Producer extends Thread {
    private MessageQueue queue;
    private int t1;
    private int count;

    Producer(MessageQueue queue, int t1, int count) {
        this.queue = queue;
        this.t1 = t1;
        this.count = count;
    }

    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                Thread.sleep(t1);
                queue.put("Повідомлення " + i);
                System.out.println("Надійшло: Повідомлення " + i + " (у черзі " + queue.size() + ")");
            }
        } catch (InterruptedException e) {
            return;
        }
        queue.finish();
    }
}

class Consumer extends Thread {
    private MessageQueue queue;
    private int t2;

    Consumer(MessageQueue queue, int t2) {
        this.queue = queue;
        this.t2 = t2;
    }

    public void run() {
        try {
            String message = queue.take();
            while (message != null) {
                Thread.sleep(t2);
                System.out.println("   Оброблено: " + message);
                message = queue.take();
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}