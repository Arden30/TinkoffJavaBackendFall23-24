package edu.hw10.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private final RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

    @Test
    @DisplayName("Test 1 (constructor)")
    void test1()
        throws InvocationTargetException,
        InstantiationException,
        IllegalAccessException {
        for (int i = 0; i < 100; i++) {
            var myClass = (CreditAccount) randomObjectGenerator.nextObject(CreditAccount.class);

            assertThat(myClass.getSum()).isBetween(0.0, 10000000.0);
            assertThat(myClass.getName()).isNotNull();
        }
    }

    @Test
    @DisplayName("Test 2 (method)")
    void test2()
        throws InvocationTargetException,
        IllegalAccessException {
        for (int i = 0; i < 100; i++) {
            var myClass = (CreditAccount) randomObjectGenerator.nextObject(CreditAccount.class, "create");

            assertThat(myClass.getSum()).isBetween(0.0, 10000000.0);
            assertThat(myClass.getName()).isNotNull();
        }
    }

    @Test
    @DisplayName("Test 3 (record)")
    void test3()
        throws InvocationTargetException,
        InstantiationException,
        IllegalAccessException {
        for (int i = 0; i < 100; i++) {
            var myClass = (CreditRec) randomObjectGenerator.nextObject(CreditRec.class);

            assertThat(myClass.sum()).isBetween(0.0, 10000000.0);
            assertThat(myClass.name()).isNotNull();
        }
    }
}
