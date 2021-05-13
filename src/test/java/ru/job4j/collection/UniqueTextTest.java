package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <p>UniqueTextTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class UniqueTextTest {

    /**
     * <p>isEqualsTrue.</p>
     */
    @Test
    public void isEqualsTrue() {
        String origin = "True test";
        String duplicate = "test True";
        assertThat(UniqueText.isEquals(origin, duplicate), is(true));
    }

    /**
     * <p>isFalse.</p>
     */
    @Test
    public void isFalse() {
        String origin = "Test false";
        String duplicate = "text text";
        assertThat(UniqueText.isEquals(origin, duplicate), is(false));
    }
}
