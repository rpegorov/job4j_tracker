package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;


public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> rsl = new HashSet<>(Arrays.asList(origin.replaceAll("[.,!]", "").split(" ")));
        String[] valueLine = line.split(" ");
        for (String s : valueLine) {
            if (!rsl.contains(s)) {
                return false;
            }
        }
        return true;
    }
}