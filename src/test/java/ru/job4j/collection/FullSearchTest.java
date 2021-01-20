package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> list = Arrays.asList(
                new Task("1", "First"),
                new Task("2", "Second"),
                new Task("1", "First")
        );
        Set<String> expect = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(list), is(expect));
    }
}