package ru.job4j.search;

import org.junit.Test;
import ru.job4j.collection.Person;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void findByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Rostislav", "Egorov",
                "8912111222333", "Kiev"));
        List<Person> persons = phones.find("Rostislav");
        assertThat(persons.get(0).getSurname(), is("Egorov"));
    }
}