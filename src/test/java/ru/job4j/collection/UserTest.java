package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * <p>UserTest class.</p>
 *
 * @author rpegorov
 * @version $Id: $Id
 * @since 1.0 LATEST
 */
public class UserTest {

    /**
     * <p>whenAsc.</p>
     */
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Alex", 32));
        users.add(new User("Alex", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Alex", 31)));
        assertThat(it.next(), is(new User("Alex", 32)));
    }

    /**
     * <p>whenComparePetrVSIvan.</p>
     */
    @Test
    public void whenComparePetrVSIvan() {
        int rsl = new User("Olga", 32)
                .compareTo(
                        new User("Nick", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
}
