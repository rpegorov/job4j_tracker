package ru.job4j.collection;

import java.util.Objects;

public class Account {
    private String passport;
    private String username;
    private String deposit;

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                Account account = (Account) o;
                return Objects.equals(passport, account.passport);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(
                "Account{passport='").append(
                        passport).append("', username='").append(
                                username).append("', deposit='").append(
                                        deposit).append("'}").toString();
    }
}
