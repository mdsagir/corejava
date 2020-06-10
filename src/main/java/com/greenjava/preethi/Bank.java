package com.greenjava.preethi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {

    public static void main(String[] args) throws IOException {

        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setBankAccountNo(10303);
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setBankAccountNo(32123);

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);

        String path = "src/main/java/com/greenjava/preethi/filesystem/balance.txt";

        Stream<String> lines = Files.lines(Paths.get(path));
        List<String> collect = lines.collect(Collectors.toList());

        System.out.println(bankAccounts);
        for (int i = 0; i < bankAccounts.size(); i++) {
                bankAccounts.get(i).setCurrentBalance(Long.parseLong(collect.get(i)));
        }
        System.out.println(bankAccounts);

        Stream<Integer> iterate = Stream.iterate(0, i -> bankAccounts.size());

    }

}
