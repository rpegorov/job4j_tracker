package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void convertMatrixToList() {
        Integer[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0}
        };
        List<Integer> exp = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        List<Integer> rsl = MatrixToList.convertMatrixToList(matrix);
        assertThat(rsl, is(exp));
    }
}