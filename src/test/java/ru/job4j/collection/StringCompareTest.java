package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void compare() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenEmptyCompare() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                ""
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenO1EmprtyO2NotEpmty() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                "Ivanov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenO2EmprtyO1NotEpmty() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                ""
        );
        assertThat(rst, greaterThan(0));
    }
}