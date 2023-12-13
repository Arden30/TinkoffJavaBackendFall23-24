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

    public ReadWriteLockFinderService() {
        database = new HashMap<>();
    }

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            if (!database.containsKey(person.id())) {
                database.put(person.id(), person);
            } else {
                throw new RuntimeException("Person with such id exists!");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            database.remove(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            List<Person> res = new ArrayList<>();
            for (Map.Entry<Integer, Person> person : database.entrySet()) {
                if (person.getValue().name().equals(name)) {
                    res.add(person.getValue());
                }
            }
            return res;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            List<Person> res = new ArrayList<>();
            for (Map.Entry<Integer, Person> person : database.entrySet()) {
                if (person.getValue().address().equals(address)) {
                    res.add(person.getValue());
                }
            }
            return res;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            List<Person> res = new ArrayList<>();
            for (Map.Entry<Integer, Person> person : database.entrySet()) {
                if (person.getValue().phoneNumber().equals(phone)) {
                    res.add(person.getValue());
                }
            }
            return res;
        } finally {
            lock.readLock().unlock();
        }
    }

    public Map<Integer, Person> getBase() {
        return database;
    }
}
