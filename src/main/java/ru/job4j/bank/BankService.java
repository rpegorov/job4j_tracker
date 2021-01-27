package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User search = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                search = user;
                break;
            }
        }
        return search;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account search = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account a : accounts) {
                if (a.getRequisite().contains(requisite)) {
                    search = a;
                }
            }
        }
        return search;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcRequisiteOne = findByRequisite(srcPassport, srcRequisite);
        Account srcRequisiteTwo = findByRequisite(destPassport, destRequisite);
        if (srcRequisiteOne != null && srcRequisiteTwo != null
                && srcRequisiteOne.getBalance() >= amount) {
            srcRequisiteOne.setBalance(srcRequisiteOne.getBalance() - amount);
            srcRequisiteTwo.setBalance(srcRequisiteTwo.getBalance() + amount);
            return true;
        }
        return false;
    }
}
