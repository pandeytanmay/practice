package com.tanmay.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author PandeyTanmay
 * @author tkpandey@hotmail.com
 */
public class Regex {
    public static void main(String args[]){
        String target = "arun /.-_\\32|7,(12)abc&as'";
        System.out.println("Target is - " + target);
        System.out.println(Pattern.matches("^[\\w/.,|'&\\-\\s()\\\\]*", target));
        Set<String> set = new HashSet<>();
    }
}
