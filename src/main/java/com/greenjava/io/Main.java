package com.greenjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {


        final InputStreamReader in = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(in);
        System.out.println("Enter the string! ");
        final String data = bufferedReader.readLine();
        final char[] chars = data.toCharArray();

        StringBuilder stringBuilder=new StringBuilder();
        StringBuilder stringBuilder2=new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i]!=' '){
                stringBuilder.append(chars[i]);
            } else {
               stringBuilder2.append(stringBuilder.reverse()+" ");
               stringBuilder.setLength(0);
            }

        }
        System.out.println(stringBuilder2);

    }
}
