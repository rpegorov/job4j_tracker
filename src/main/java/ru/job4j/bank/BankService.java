package ru.job4j.bank;

import java.util.*;

/**
 * This class describes Bank Service
 * @author rpegorov
 * @version 0.1
 */
public class BankService {
    /**
     * User storage implements in collection HasMap
     * K - User {@link User}
     * V - Account {@link Account}
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method from created new users implements col ArrayList accounts {@link Account}
     * @param user new users
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * Created new Account from user
     * input passport and data account
     * @param passport from search users by passport
     * @param account addition account after search
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Method search user by passport
     * input param passport
     * @param passport from check equals user passport
     * @return Optional user find first equals passport
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Method search user by requisite
     * input param passport and requisite
     * Prepare search user by passport
     * @param passport from prepare search by passport
     * @param requisite from check equals account requisite
     * @return Optional user find first equals requisite
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
//        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(users -> users.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Method transfer money
     * input param passport and requisite users involved in transfer, amount money
     * Prepare search requisite users from transfer
     * @param srcPassport passport first user from transmission method findByRequisite
     * @param srcRequisite requisite first user from transmission method findByRequisite
     * @param destPassport passport second user from transmission method findByRequisite
     * @param destRequisite requisite second user from transmission method findByRequisite
     * @param amount transfer money
     * @return if transfer is ok - true, else false
     */
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
