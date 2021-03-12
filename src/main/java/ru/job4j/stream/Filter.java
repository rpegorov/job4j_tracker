package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {
    Map<String, Student> filters(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        x -> x,
                        (x, y) -> x)
                );
    }
}