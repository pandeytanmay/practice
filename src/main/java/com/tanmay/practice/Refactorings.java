package com.tanmay.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author PandeyTanmay
 * @author tkpandey@hotmail.com
 */
class Refactorings {
    public static final String TXT = "txt";

    public static void main(String[] args) throws IOException {
        String[] array = test(new FileReader("input." + TXT));
        Arrays.sort(array);
        for (String s : array) {
            System.out.println(s);
        }
    }

    private static String[] test(FileReader fileReader) throws IOException {
        BufferedReader reader1 = new BufferedReader(fileReader);
        BufferedReader bufferedReader = reader1;
        BufferedReader reader = bufferedReader;
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines.toArray(new String[lines.size()]);
    }
}