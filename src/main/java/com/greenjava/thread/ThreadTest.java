package com.greenjava.thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread is running");
    }
}

class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Running runnable interface!!");
    }
}


public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new MyThread();
       // thread.start();
        Runnable runnable = new MyRunnableThread();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2=new Thread(()-> System.out.println("Hello"));


    }
}
