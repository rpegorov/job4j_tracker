package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertArray2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}
