package com.greenjava.thread;

/**
 * Thread Sleep
 * NEW => RUNNABLE =>
 */

class ThreadDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(" " + Thread.currentThread().getName());
        }
    }
}

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new ThreadDemo();
        Runnable runnable2 = new ThreadDemo();
        Runnable runnable3 = new ThreadDemo();

        Thread thread1 = new Thread(runnable1);
        thread1.setName("thread1");
        Thread thread2 = new Thread(runnable2);
        thread2.setName("thread2");
        Thread thread3 = new Thread(runnable3);
        thread3.setName("thread3");

        // to running thread sequential
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();

//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread1.join();
//        thread2.join();
//        thread3.join();
    }

}
