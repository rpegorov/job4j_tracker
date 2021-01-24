package ru.job4j.collection;

import java.util.HashMap;

public class PassportOffice {
    private HashMap<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return false;
    }

    public Citizen get(String password) {
        return citizens.get(password);
    }
}
