package com.greenjava.preethi;

import java.io.*;

public class Test03 {
    public static void main(String[] args) throws Exception {
        String[] filename = {"/Users/sagir/Desktop/filesystem/first.txt", "/Users/sagir/Desktop/filesystem/second.txt"};
        File file = new File("/Users/sagir/Desktop/filesystem/third.txt");
        FileWriter output = new FileWriter(file);
        try {
            for (int i = 0; i < filename.length; i++) {
                BufferedReader objBufferedReader = new BufferedReader(new FileReader(getDictionaryFilePath(filename[i])));

                String line;
                while ((line = objBufferedReader.readLine()) != null) {
                    line = line.replace(" ", "");

                    output.write(line);
                }
                objBufferedReader.close();
            }
            output.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static String getDictionaryFilePath(String filename) throws Exception {
        String dictionaryFolderPath = null;
        File configFolder = new File(filename);
        try {
            dictionaryFolderPath = configFolder.getAbsolutePath();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return dictionaryFolderPath;
    }
}
