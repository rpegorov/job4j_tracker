package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void levelOf() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(30, "Surname1", "Name1"));
        input.add(new Student(100, "Surname2", "Name2"));
        List<Student> exp = List.of(
                new Student(100, "Surname2", "Name2"),
                new Student(30, "Surname1", "Name1")
        );
        assertThat(StudentLevel.levelOf(input, 20), is(exp));
    }

    @Test
    public void whenNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> exp = List.of();
        assertThat(StudentLevel.levelOf(input, 20), is(exp));
    }

    @Test
    public void whenNullAndNotNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(30, "Surname1", "Name1"));
        input.add(null);
        input.add(new Student(100, "Surname2", "Name2"));
        input.add(null);
        input.add(new Student(10, "Surname3", "Name3"));
        List<Student> exp = List.of(
                new Student(100, "Surname2", "Name2"),
                new Student(30, "Surname1", "Name1")
        );
        assertThat(StudentLevel.levelOf(input, 20), is(exp));
    }

}