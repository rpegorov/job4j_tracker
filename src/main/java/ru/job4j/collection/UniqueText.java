package ru.job4j.collection;

import java.util.HashSet;
import static java.util.Collections.*;

public class UniqueText {
    public static boolean isEquals(String originTxt, String duplicateTxt) {
        String[] origin = originTxt.split(" ");
        String[] duplicate = duplicateTxt.split(" ");
        HashSet<String> check = new HashSet<>();
        addAll(check, origin);
        for (String i : duplicate) {
            if (!check.contains(i)) {
                return false;
            }
        }
        return true;
    }
}


