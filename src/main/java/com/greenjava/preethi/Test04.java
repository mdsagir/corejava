package com.greenjava.preethi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test04 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string for search ");
        String input = scanner.nextLine();

        List<String> results = new ArrayList<String>();
        String path = "/Users/sagir/Desktop/filesystem";

        File[] files = new File("/Users/sagir/Desktop/filesystem").listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        for (String s : results) {

            Stream<String> lines = Files.lines(Paths.get(path + "/" + s));
            List<String> collect = lines.collect(Collectors.toList());

            for (String c : collect) {
                if (!c.isEmpty() && c.contains(input)) {
                    System.out.println(c);
                }
            }
        }

    }
}
