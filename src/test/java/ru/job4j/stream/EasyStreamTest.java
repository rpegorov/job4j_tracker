package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <p>EasyStreamTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class EasyStreamTest {

    /**
     * <p>whenEmptySource.</p>
     */
    @Test
    public void whenEmptySource() {
        var rsl = EasyStream.of(List.of()).collect();
        assertThat(rsl, is(List.of()));
    }

    /**
     * <p>whenFilledSource.</p>
     */
    @Test
    public void whenFilledSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .collect();
        assertThat(rsl, is(List.of(1, 2, 3)));
    }

    /**
     * <p>whenFilteredSource.</p>
     */
    @Test
    public void whenFilteredSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .collect();
        assertThat(rsl, is(List.of(2)));
    }

    /**
     * <p>whenMappedSource.</p>
     */
    @Test
    public void whenMappedSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .collect();
        assertThat(rsl, is(List.of(2, 4, 6)));
    }

    /**
     * <p>whenFilteredMappedSource.</p>
     */
    @Test
    public void whenFilteredMappedSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .map(e -> e * 2)
                .collect();
        assertThat(rsl, is(List.of(4)));
    }

    /**
     * <p>whenMappedFilteredSource.</p>
     */
    @Test
    public void whenMappedFilteredSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .filter(e -> e == 2)
                .collect();
        assertThat(rsl, is(List.of(2)));
    }

    /**
     * <p>whenMultyFilterSource.</p>
     */
    @Test
    public void whenMultyFilterSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3, 4, 5))
                .filter(e -> e >= 2)
                .filter(e -> e <= 4)
                .collect();
        assertThat(rsl, is(List.of(2, 3, 4)));
    }

}
