package com.greenjava.trywithresource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class TryWithResource {

    public void tryCatchFinally() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("hello.txt"));
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public void tryWithResource() {

        try (Scanner scanner = new Scanner(new File("hello.txt"))) {
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tryWithResourceWithMultipleResource() {
        // second resource closing first
        try (Scanner scanner = new Scanner(new File("hello.txt"));
             PrintWriter printWriter = new PrintWriter(new File("hello.txt"))) {
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {

        }
    }

    public void userDataAutoCloseable() {
        try (UserData userData = new UserData()) {

            System.out.println(userData.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
