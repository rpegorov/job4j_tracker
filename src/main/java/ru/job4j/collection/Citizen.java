package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                Citizen citizen = (Citizen) o;
                return Objects.equals(passport, citizen.passport);
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

