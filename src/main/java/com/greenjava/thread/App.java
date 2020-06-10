package com.greenjava.thread;

import java.util.ArrayList;
import java.util.List;

class Processor {

    List<Integer> list = new ArrayList<>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private int value = 0;
    private final Object lock = new Object();

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LIMIT) {
                    System.out.println("Waiting for removing for element");
                    lock.wait();
                } else {
                    System.out.println("Adding: "+value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }

        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == BOTTOM) {
                    System.out.println("Waiting for adding item");
                    lock.wait();
                } else {
                    System.out.println("removing "+list.remove(--value));
                    lock.notify();
                }
                Thread
                        .sleep(500);
            }
        }
    }
}

public class App {
    static Processor processor=new Processor();
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread1.start();

    }
}
