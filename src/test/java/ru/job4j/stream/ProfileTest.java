package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    @Test
    public void getAddress() {
        Address moscow = new Address("Moscow", "Lenina", 10, 54);
        Address kiev = new Address("Kiev", "T.Shevchenko", 24, 32);
        Address syktyvkar = new Address("Syktyvkar", "Morozova", 6, 23);
        List<Profile> profiles = List.of(
                new Profile(moscow),
                new Profile(kiev),
                new Profile(syktyvkar)
        );
        List<Address> exp = List.of(
                moscow,
                kiev,
                syktyvkar
        );
        List<Address> rsl = new Profiles().collect(profiles);
        assertThat(rsl, is(exp));
    }

    @Test
    public void whenDuplicate() {
        Address moscow = new Address("Moscow", "Lenina", 10, 54);
        Address kiev = new Address("Kiev", "T.Shevchenko", 24, 32);
        Address syktyvkar = new Address("Syktyvkar", "Morozova", 6, 23);
        Address syktyvkarDuble = new Address("Syktyvkar", "Morozova", 6, 23);
        List<Profile> profiles = List.of(
                new Profile(moscow),
                new Profile(kiev),
                new Profile(syktyvkar),
                new Profile(syktyvkarDuble)
        );
        List<Address> exp = List.of(
                moscow,
                kiev,
                syktyvkar
        );
        List<Address> rsl = new Profiles().collect(profiles);
        assertThat(rsl, is(exp));
    }
}