package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1", "name1"));
        students.add(new Student(20, "Surname2", "name1"));
        students.add(new Student(30, "Surname3", "name1"));
        students.add(new Student(40, "Surname4", "name1"));
        students.add(new Student(50, "Surname5", "name1"));
        students.add(new Student(60, "Surname6", "name1"));
        students.add(new Student(70, "Surname7", "name1"));
        students.add(new Student(80, "Surname8", "name1"));
        students.add(new Student(90, "Surname9", "name1"));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Predicate<Student> pr = (x) -> x.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7", "name1"));
        expected.add(new Student(80, "Surname8", "name1"));
        expected.add(new Student(90, "Surname9", "name1"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Predicate<Student> pr = (x) -> x.getScore() >= 50 && x.getScore() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5", "name1"));
        expected.add(new Student(60, "Surname6", "name1"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Predicate<Student> pr = (x) -> x.getScore() > 0 && x.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1", "name1"));
        expected.add(new Student(20, "Surname2", "name1"));
        expected.add(new Student(30, "Surname3", "name1"));
        expected.add(new Student(40, "Surname4", "name1"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void listToMap() {
        Filter filter = new Filter();
       assertTrue(filter.filters(students).size() == 9);
    }
}