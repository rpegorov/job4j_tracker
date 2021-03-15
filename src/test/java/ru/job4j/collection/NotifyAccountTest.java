package ru.job4j.collection;

import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("8888", "Rostislav", "22222"),
                new Account("5555", "Egorov", "3333333")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("8888", "Rostislav", "22222"),
                        new Account("5555", "Egorov", "3333333")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentDuplicate() {
        List<Account> accounts = List.of(
                new Account("111", "ros", "1111111"),
                new Account("111", "egorov", "00000")
        );
        HashSet<Account> expect = new HashSet<>(
                Collections.singletonList(
                        new Account("111", "ros", "1111111")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}