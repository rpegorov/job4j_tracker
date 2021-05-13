package ru.job4j.bank;

import java.util.Objects;

/**
 * Class describes the user Account
 * @author rpegorov
 * @version 0.1
 */
public class Account {
    /**
     * The account has fields requisite and balance
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            Account account = (Account) o;
            return Objects.equals(requisite, account.requisite);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
