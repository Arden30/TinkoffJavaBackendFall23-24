package edu.hw7.task3_and_3_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinderService implements PersonDataBase {

    private final Map<Integer, Person> database;
    private final Map<Person, String> names;
    private final Map<Person, String> addresses;
    private final Map<Person, String> phones;

    public FinderService() {
        database = new HashMap<>();
        names = new HashMap<>();
        addresses = new HashMap<>();
        phones = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        database.put(person.id(), person);
        names.put(person, person.name());
        addresses.put(person, person.address());
        phones.put(person, person.phoneNumber());
    }

    @Override
    public synchronized void delete(int id) {
        Person person = database.remove(id);
        if (person != null) {
            names.remove(person);
            addresses.remove(person);
            phones.remove(person);
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        List<Person> res = new ArrayList<>();
        for (Map.Entry<Person, String> person : names.entrySet()) {
            if (person.getValue().equals(name)) {
                res.add(person.getKey());
            }
        }
        return res;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        List<Person> res = new ArrayList<>();
        for (Map.Entry<Person, String> person : addresses.entrySet()) {
            if (person.getValue().equals(address)) {
                res.add(person.getKey());
            }
        }
        return res;
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        List<Person> res = new ArrayList<>();
        for (Map.Entry<Person, String> person : phones.entrySet()) {
            if (person.getValue().equals(phone)) {
                res.add(person.getKey());
            }
        }
        return res;
    }

    public Map<Integer, Person> getBase() {
        return database;
    }
}
