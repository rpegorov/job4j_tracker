package ru.job4j.collection;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] valueOrg = origin.split(" ");
        String[] valueLin = line.split(" ");
        for (String value : valueLin) {
            boolean tmp = false;
            for (String s : valueOrg) {
                if (s.contains(value)) {
                    tmp = true;
                    break;
                }
            }
            if (!tmp) {
                return false;
            }
        }
        return true;
    }
}