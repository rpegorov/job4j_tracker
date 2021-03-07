package ru.job4j.search;

import org.junit.Test;
import ru.job4j.collection.Person;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void findBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Rostislav", "Egorov",
                "8912111222333", "Kiev"));
        ArrayList<Person> persons = phones.find("Rostislav");
        assertThat(persons.get(0).getSurname(), is("Egorov"));
    }

    @Test
    public void findByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Rostislav", "Egorov",
                "8912111222333", "Kiev"));
        ArrayList<Person> persons = phones.find("Rostislav");
        assertThat(persons.get(0).getSurname(), is("Egorov"));
    }

    @Test
    public void findByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Rostislav", "Egorov",
                "8912111222333", "Kiev"));
        ArrayList<Person> persons = phones.find("Rostislav");
        assertThat(persons.get(0).getPhone(), is("8912111222333"));
    }

    @Test
    public void findByPhoneKeySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Rostislav", "Egorov",
                "8912111222333", "Kiev"));
        ArrayList<Person> persons = phones.find("Egorov");
        assertThat(persons.get(0).getPhone(), is("8912111222333"));
    }
}