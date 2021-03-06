package ru.job4j.job;

import java.util.Comparator;

public class JobSortByNameAsc implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
