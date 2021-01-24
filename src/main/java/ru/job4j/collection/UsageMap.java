package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("rostislav.egorov@gmail.com", "Rostislav Egorov");
        for (String k : map.keySet()) {
            String v = map.get(k);
            System.out.println(k + " = " + v);
        }
    }
}
