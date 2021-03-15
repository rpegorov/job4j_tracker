package ru.job4j.search;

import ru.job4j.collection.Person;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> searchName = (x) -> x.getName().contains(key);
        Predicate<Person> searchSurname = (x) -> x.getSurname().contains(key);
        Predicate<Person> searchPhone = (x) -> x.getPhone().contains(key);
        Predicate<Person> searchAddress = (x) -> x.getAddress().contains(key);
        Predicate<Person> combine = searchName.or(searchSurname.or(searchPhone).or(searchAddress));
        ArrayList<Person> result = persons.stream()
                .filter(combine::test)
                .collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
}

