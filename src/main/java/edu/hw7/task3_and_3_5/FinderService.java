package edu.hw7.task3_and_3_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinderService implements PersonDataBase {

    private final Map<Integer, Person> database;

    public FinderService() {
        database = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        if (!database.containsKey(person.id())) {
            database.put(person.id(), person);
        } else {
            throw new RuntimeException("Person with such id exists!");
        }
    }

    @Override
    public synchronized void delete(int id) {
        database.remove(id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        List<Person> res = new ArrayList<>();
        for (Map.Entry<Integer, Person> person : database.entrySet()) {
            if (person.getValue().name().equals(name)) {
                res.add(person.getValue());
            }
        }
        return res;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        List<Person> res = new ArrayList<>();
        for (Map.Entry<Integer, Person> person : database.entrySet()) {
            if (person.getValue().address().equals(address)) {
                res.add(person.getValue());
            }
        }
        return res;
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        List<Person> res = new ArrayList<>();
        for (Map.Entry<Integer, Person> person : database.entrySet()) {
            if (person.getValue().phoneNumber().equals(phone)) {
                res.add(person.getValue());
            }
        }
        return res;
    }

    public Map<Integer, Person> getBase() {
        return database;
    }
}
