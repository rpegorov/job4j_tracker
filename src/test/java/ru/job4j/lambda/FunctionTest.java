package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * <p>FunctionTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class FunctionTest {

    /**
     * <p>testDiapason.</p>
     */
    @Test
    public void testDiapason() {
        Function function = new Function();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * <p>whenQuadraticFunction.</p>
     */
    @Test
    public void whenQuadraticFunction() {
        Function function = new Function();
        List<Double> result = function.diapason(5, 9, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    /**
     * <p>whenExponentialFunction.</p>
     */
    @Test
    public void whenExponentialFunction() {
        Function function = new Function();
        List<Double> result = function.diapason(5, 7, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D);
        assertThat(result, is(expected));
    }
}
