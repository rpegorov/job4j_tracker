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
        Map<String, Student> rsl = filter.filters(students);
        Map<String, Student> exp = new HashMap<>();
        exp.put("Surname1", new Student(10, "Surname1", "name1"));
        exp.put("Surname2", new Student(20, "Surname2", "name2"));
        exp.put("Surname3", new Student(30, "Surname3", "name3"));
        exp.put("Surname4", new Student(40, "Surname4", "name4"));
        exp.put("Surname5", new Student(50, "Surname5", "name5"));
        exp.put("Surname6", new Student(60, "Surname6", "name6"));
        exp.put("Surname7", new Student(70, "Surname7", "name7"));
        exp.put("Surname8", new Student(80, "Surname8", "name8"));
        exp.put("Surname9", new Student(90, "Surname9", "name9"));
        assertThat(rsl, is(exp));
    }
}