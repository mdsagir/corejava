package com.greenjava.preethi;

public class BankAccount {
    private long bankAccountNo;
    private long currentBalance;

    public long getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(long bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankAccountNo=" + bankAccountNo +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
