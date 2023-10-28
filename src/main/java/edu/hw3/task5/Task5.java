package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    private Task5() {

    }

    public static List<Contact> parseContacts(String[] names, String order) {
        if (names == null) {
            return List.of();
        }
        List<Contact> list = createContacts(names);
        switch (order) {
            case "ASC" -> {
                Comparator<Contact> comparator = Comparator.naturalOrder();
                list.sort(comparator);
                return list;
            }
            case "DESC" -> {
                Comparator<Contact> comparator = Comparator.reverseOrder();
                list.sort(comparator);
                return list;
            }
            default -> {
                return list;
            }
        }
    }

    public static List<Contact> createContacts(String[] names) {
        List<Contact> list = new ArrayList<>();
        for (String str : names) {
            String[] tmp = str.trim().split(" ");
            String name = tmp[0];
            String surname = null;
            if (tmp.length > 1) {
                surname = tmp[1];
            }
            Contact contact = new Contact(name, surname);
            list.add(contact);
        }
        return list;
    }
}
