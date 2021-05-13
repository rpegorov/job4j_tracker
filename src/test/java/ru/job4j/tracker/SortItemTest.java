package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * <p>SortItemTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class SortItemTest {

    /**
     * <p>sortByName.</p>
     */
    @Test
    public void sortByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("BBB");
        tracker.add(item1);
        Item item2 = new Item("FFF");
        tracker.add(item2);
        Item item3 = new Item("ZZZ");
        tracker.add(item3);
        Item item4 = new Item("CCC");
        tracker.add(item4);
        Item item5 = new Item("AAA");
        tracker.add(item5);

        List<Item> result = tracker.findAll();
        SortByName s = new SortByName();
        result.sort(s);
        assertThat(result.get(0).getName(), is("AAA"));
    }

    /**
     * <p>sortByNameRevers.</p>
     */
    @Test
    public void sortByNameRevers() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("BBB");
        tracker.add(item1);
        Item item2 = new Item("FFF");
        tracker.add(item2);
        Item item3 = new Item("ZZZ");
        tracker.add(item3);
        Item item4 = new Item("CCC");
        tracker.add(item4);
        Item item5 = new Item("AAA");
        tracker.add(item5);

        List<Item> result = tracker.findAll();
        SortByNameRevers s = new SortByNameRevers();
        result.sort(s);
        assertThat(result.get(0).getName(), is("ZZZ"));
    }
}
