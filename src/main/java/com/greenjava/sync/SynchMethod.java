package com.greenjava.sync;

public class SynchMethod {

    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }
    public synchronized void  syncCalculate() {
        setSum(getSum() + 1);
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
