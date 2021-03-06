package ru.job4j.job;

import java.util.Comparator;

public class JobSortByNameDesc implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
