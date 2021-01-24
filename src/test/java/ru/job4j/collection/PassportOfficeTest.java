package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("111222", "Rostislav");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
}