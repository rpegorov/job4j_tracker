package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> values;

    private EasyStream(List<Integer> values) {
        this.values = values;
    }

    public static EasyStream of(List<Integer> source) throws UnsupportedOperationException {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> func) throws UnsupportedOperationException {
        List<Integer> tmp = new ArrayList<>();
        for (Integer value : values) {
            tmp.add(func.apply(value));
        }
        return new EasyStream(tmp);
    }

    public EasyStream filter(Predicate<Integer> func) throws UnsupportedOperationException {
        List<Integer> tmp = new ArrayList<>();
        for (Integer value : values) {
            if (func.test(value)) {
                tmp.add(value);
            }
        }
        return new EasyStream(tmp);
    }

    public List<Integer> collect() throws UnsupportedOperationException {
        return values;
    }
}
