package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void isEqualsTrue() {
        String origin = "True test";
        String duplicate = "Test True";
        assertThat(UniqueText.isEquals(origin, duplicate), is(true));
    }

    @Test
    public void isFalse() {
        String origin = "Test false";
        String duplicate = "text text";
        assertThat(UniqueText.isEquals(origin, duplicate), is(false));
    }
}