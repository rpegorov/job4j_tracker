package ru.job4j.job;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

/**
 * <p>JobTestSort class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class JobTestSort {

    /**
     * <p>sortByNameAndPriorityAsc.</p>
     */
    @Test
    public void sortByNameAndPriorityAsc() {
        Comparator<Job> test = new JobSortByNameAsc().thenComparing(new JobSortByPriorityAsc());
        int rsl = test.compare(
                new Job("AAA", 0),
                new Job("AAA", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    /**
     * <p>whenCompatorByNameAndPrority.</p>
     */
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobSortByNameDesc().thenComparing(new JobSortByPriorityDesc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    /**
     * <p>sortByNameAndPriorityDesc.</p>
     */
    @Test
    public void sortByNameAndPriorityDesc() {
        Comparator<Job> test = new JobSortByNameAsc().thenComparing(new JobSortByPriorityDesc());
        int rsl = test.compare(
                new Job("AAA", 0),
                new Job("ZZZ", 1)
        );
        assertThat(rsl, lessThan(1));
    }

    /**
     * <p>sortByNameAsc.</p>
     */
    @Test
    public void sortByNameAsc() {
        List<Job> jobs = Arrays.asList(
                new Job("AAA", 0),
                new Job("ZZZ", 1)
        );
        JobSortByNameAsc s = new JobSortByNameAsc();
        jobs.sort(s);
        assertThat(jobs.get(0).getName(), is("AAA"));
    }

    /**
     * <p>sortByNameDesc.</p>
     */
    @Test
    public void sortByNameDesc() {
        List<Job> jobs = Arrays.asList(
                new Job("AAA", 0),
                new Job("ZZZ", 1)
        );
        JobSortByNameDesc s = new JobSortByNameDesc();
        jobs.sort(s);
        assertThat(jobs.get(0).getName(), is("ZZZ"));
    }

    /**
     * <p>sortByPriorityAsc.</p>
     */
    @Test
    public void sortByPriorityAsc() {
        Comparator<Job> test = new JobSortByPriorityAsc();
        int rsl = test.compare(
                new Job("CCC", 4),
                new Job("CCC", 8)
        );
        assertThat(rsl, lessThan(4));
    }

    /**
     * <p>sortByPriorityDsc.</p>
     */
    @Test
    public void sortByPriorityDsc() {
        Comparator<Job> test = new JobSortByPriorityDesc();
        int rsl = test.compare(
                new Job("FFF", 6),
                new Job("FFF", 13)
        );
        assertThat(rsl, lessThan(13));
    }
}
