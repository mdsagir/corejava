package com.greenjava.preethi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        BufferedReader reader = null;

        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        System.out.println("Enter the file ");
        Scanner scanner = new Scanner(System.in);
        // metting.rtf
        String fileName = scanner.nextLine();

        try {
            reader = new BufferedReader(new FileReader("/Users/sagir/Desktop/"+fileName));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                lineCount++;
                String[] words = currentLine.split(" ");
                wordCount = wordCount + words.length;
                for (String word : words) {
                    charCount = charCount + word.length();
                }
                currentLine = reader.readLine();
            }
            System.out.println("Number Of Chars In A File : " + charCount);
            System.out.println("Number Of Words In A File : " + wordCount);
            System.out.println("Number Of Lines In A File : " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
