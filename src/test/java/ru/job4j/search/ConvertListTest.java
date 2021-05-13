package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <p>ConvertListTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class ConvertListTest {

    /**
     * <p>convert.</p>
     */
    @Test
    public void convert() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }
}
