package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <p>StringCompareTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class StringCompareTest {

    /**
     * <p>whenStringsAreEqualThenZero.</p>
     */
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    /**
     * <p>compare.</p>
     */
    @Test
    public void compare() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    /**
     * <p>whenEmptyCompare.</p>
     */
    @Test
    public void whenEmptyCompare() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                ""
        );
        assertThat(rst, is(0));
    }

    /**
     * <p>whenO1EmprtyO2NotEpmty.</p>
     */
    @Test
    public void whenO1EmprtyO2NotEpmty() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                "Ivanov"
        );
        assertThat(rst, lessThan(0));
    }

    /**
     * <p>whenO2EmprtyO1NotEpmty.</p>
     */
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
