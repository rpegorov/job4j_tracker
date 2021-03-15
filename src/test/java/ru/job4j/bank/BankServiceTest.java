package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("1122", "Test test");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("1122"), is(user));
    }

    @Test
    public void addAccount() {
        User user = new User("1122", "Test tests");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("3344", 150.0D));
        assertThat(bank.findByRequisite("1122", "3344").get().getBalance(), is(150.0D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Test tests");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Test tests");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }
}