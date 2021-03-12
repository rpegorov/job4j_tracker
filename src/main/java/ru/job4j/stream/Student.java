package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private String surname;
    private String name;

    public Student(int score, String surname, String name) {
        this.score = score;
        this.surname = surname;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname)
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname, name);
    }
}
