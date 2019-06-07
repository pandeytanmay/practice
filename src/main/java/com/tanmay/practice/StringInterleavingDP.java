package com.tanmay.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringInterleavingDP {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        System.out.println("Enter");
        try {
            input = br.readLine().split(" ");
        }
        catch (IOException e) {
            System.err.println("Error reading input");
            e.printStackTrace();
        }
        if (isInterleaved(input[0], input[1], input[2]))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    private static boolean isInterleaved (String a, String b, String c) {

        //If reached end of all the string, return true
        if (a.length() ==0 && b.length() ==0 && c.length() == 0)
            return true;

        //If not reached end of first two, but reached end of third, then false
        if (c.length() ==0)
            return false;

        if (a.length() != 0 && c.charAt(0) == a.charAt(0))
            return  isInterleaved(a.substring(1), b, c.substring(1));
        if (b.length() != 0 && b.charAt(0) == c.charAt(0))
            return  isInterleaved(a, b.substring(1), c.substring(1));
        return false;
    }
}
