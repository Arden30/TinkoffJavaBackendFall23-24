package edu.hw7.task3_and_3_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockFinderService implements PersonDataBase {

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Map<Integer, Person> database;
    private final Map<Person, String> names;
    private final Map<Person, String> addresses;

    private final Map<Person, String> phones;

    public ReadWriteLockFinderService() {
        database = new HashMap<>();
        names = new HashMap<>();
        addresses = new HashMap<>();
        phones = new HashMap<>();
    }

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            database.put(person.id(), person);
            names.put(person, person.name());
            addresses.put(person, person.address());
            phones.put(person, person.phoneNumber());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = database.remove(id);
            if (person != null) {
                names.remove(person);
                addresses.remove(person);
                phones.remove(person);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.writeLock().lock();
        try {
            List<Person> res = new ArrayList<>();
            for (Map.Entry<Person, String> person: names.entrySet()) {
                if (person.getValue().equals(name)) {
                    res.add(person.getKey());
                }
            }
            return res;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.writeLock().lock();
        try {
            List<Person> res = new ArrayList<>();
            for (Map.Entry<Person, String> person: addresses.entrySet()) {
                if (person.getValue().equals(address)) {
                    res.add(person.getKey());
                }
            }
            return res;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.writeLock().lock();
        try {
            List<Person> res = new ArrayList<>();
            for (Map.Entry<Person, String> person: phones.entrySet()) {
                if (person.getValue().equals(phone)) {
                    res.add(person.getKey());
                }
            }
            return res;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Map<Integer, Person> getBase() {
        return database;
    }
}
