package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, -1, -2, -3, -4, 0, 10, -5));
        List<Integer> rsl = numbs.stream().filter(
                integer -> integer >= 0
        ).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
