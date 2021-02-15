package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] obj1 = o1.split("\\.");
        String[] obj2 = o2.split("\\.");
        int x = Integer.parseInt(String.valueOf(obj1[0]));
        int y = Integer.parseInt(String.valueOf(obj2[0]));
        return Integer.compare(x, y);
    }
}
