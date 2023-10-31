package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;

public record Contact(String name, String surname) implements Comparable<Contact> {
    @Override
    public int compareTo(@NotNull Contact contact) {
        if (contact.surname == null || surname == null || contact.surname.equals(surname)) {
            return this.name.compareTo(contact.name);
        }
        return this.surname.compareTo(contact.surname);
    }
}
