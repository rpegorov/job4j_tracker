package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(users -> users.getRequisite().equals(requisite))
                .findFirst());
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcRequisiteOne = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> srcRequisiteTwo = findByRequisite(destPassport, destRequisite);
        if (srcRequisiteOne.isPresent() && srcRequisiteTwo.isPresent()
                && srcRequisiteOne.get().getBalance() >= amount) {
            srcRequisiteOne.get().setBalance(srcRequisiteOne.get().getBalance() - amount);
            srcRequisiteTwo.get().setBalance(srcRequisiteTwo.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
