package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expected = List.of("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenNotMissed() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expected = List.of("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expected));
    }
}