package ru.job4j.bank;

import java.util.Objects;

/**
 * Class describes the user of the bank service
 * @author rpegorov
 * @version 0.1
 */
public class User {
    /**
     * The user has fields passport and username
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                User user = (User) o;
                return Objects.equals(passport, user.passport);
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
}
