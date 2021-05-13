package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <p>ConvertList2ArrayTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class ConvertList2ArrayTest {

    /**
     * <p>toArray.</p>
     */
    @Test
    public void toArray() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result;
        result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
}
