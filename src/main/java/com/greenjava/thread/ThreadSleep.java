package com.greenjava.thread;

/**
 * Thread.sleep() interact with  thread scheduler put current thread in waiting state
 * once time is over thread state goes to runnable state and wait for the CPU for
 * further execution
 * the actual time for the thread scheduler waiting state is depend on thread scheduler
 * which is the part of cpu
 * <p>
 * for further execution so, actual time for the thread sleep
 */
class ThreadSleepDemo implements Runnable {

    @Override
    public void run() {

        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Hello "+i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadSleep {

    public static void main(String[] args) {

        Thread thread = new Thread(new ThreadSleepDemo());
        thread.start();
        Thread thread1 = new Thread(new ThreadSleepDemo());
        thread1.start();
    }

}
