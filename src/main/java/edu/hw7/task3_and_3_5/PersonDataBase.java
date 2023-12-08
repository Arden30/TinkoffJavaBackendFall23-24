package edu.hw7.task3_and_3_5;

import java.util.List;

public interface PersonDataBase {
    void add(Person person);

    void delete(int id);

    List<Person> findByName(String name);

    List<Person> findByAddress(String address);

    List<Person> findByPhone(String phone);
}