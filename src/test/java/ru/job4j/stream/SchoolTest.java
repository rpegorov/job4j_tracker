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
        students.add(new Student(20, "Surname2", "name2"));
        students.add(new Student(30, "Surname3", "name3"));
        students.add(new Student(40, "Surname4", "name4"));
        students.add(new Student(50, "Surname5", "name5"));
        students.add(new Student(60, "Surname6", "name6"));
        students.add(new Student(70, "Surname7", "name7"));
        students.add(new Student(80, "Surname8", "name8"));
        students.add(new Student(90, "Surname9", "name9"));
        students.add(new Student(90, "Surname9", "name9"));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Predicate<Student> pr = (x) -> x.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7", "name7"));
        expected.add(new Student(80, "Surname8", "name8"));
        expected.add(new Student(90, "Surname9", "name9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Predicate<Student> pr = (x) -> x.getScore() >= 50 && x.getScore() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5", "name5"));
        expected.add(new Student(60, "Surname6", "name6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Predicate<Student> pr = (x) -> x.getScore() > 0 && x.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1", "name1"));
        expected.add(new Student(20, "Surname2", "name2"));
        expected.add(new Student(30, "Surname3", "name3"));
        expected.add(new Student(40, "Surname4", "name4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void listToMap() {
        Filter filter = new Filter();
        assertEquals(9, filter.filters(students).size());
    }

    @Test
    public void listToMapWhenDupKey() {
        Filter filter = new Filter();
        Map<String, Student> student = filter.filters(students);
        assertEquals(10, students.size());
        assertEquals("Surname9", student.get("Surname9").getSurname());
    }
}