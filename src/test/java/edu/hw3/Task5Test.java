package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Ascending order")
    void ascOrder() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<Contact> res = Task5.parseContacts(names, "ASC");
        String[] sortedNames = {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"};
        assertThat(res).isEqualTo(Task5.createContacts(sortedNames));
    }

    @Test
    @DisplayName("Descending order")
    void descOrder() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        List<Contact> res = Task5.parseContacts(names, "DESC");
        String[] sortedNames = {"Carl Gauss", "Leonhard Euler", "Paul Erdos"};
        assertThat(res).isEqualTo(Task5.createContacts(sortedNames));
    }

    @Test
    @DisplayName("Null input")
    void nullInput() {
        String[] names = null;
        List<Contact> res = Task5.parseContacts(names, "DESC");
        String[] sortedNames = {};
        assertThat(res).isEqualTo(Task5.createContacts(sortedNames));
    }

    @Test
    @DisplayName("Empty input")
    void emptyInput() {
        String[] names = {};
        List<Contact> res = Task5.parseContacts(names, "DESC");
        String[] sortedNames = {};
        assertThat(res).isEqualTo(Task5.createContacts(sortedNames));
    }

    @Test
    @DisplayName("Without surname")
    void withoutSurname() {
        String[] names = {"John", "Thomas", "David", "Rene"};
        List<Contact> res = Task5.parseContacts(names, "ASC");
        String[] sortedNames = {"David", "John", "Rene", "Thomas"};
        assertThat(res).isEqualTo(Task5.createContacts(sortedNames));
    }

    @Test
    @DisplayName("Wrong order doesn't change order")
    void wrongOrder() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        List<Contact> res = Task5.parseContacts(names, "aC");
        String[] sortedNames = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        assertThat(res).isEqualTo(Task5.createContacts(sortedNames));
    }
}
