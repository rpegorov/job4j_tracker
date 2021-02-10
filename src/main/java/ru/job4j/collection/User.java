package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull User o) {
        return Comparator.comparing(User::getName)
                .thenComparing(User::getAge)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                User user = (User) o;
                return age == user.age && Objects.equals(name, user.name);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
