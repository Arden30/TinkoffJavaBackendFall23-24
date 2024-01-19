package edu.hw11.task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.Implementation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.lang.reflect.Modifier;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    private static final String CLASS_NAME = "FibonacciCalculator";
    private static final String METHOD_NAME = "fibonacci";

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21", "9, 34"})
    void createClassWithASM(int n, long fib) throws Exception {
        var fibonacciCalculator = new ByteBuddy()
            .subclass(Object.class)
            .name(CLASS_NAME)
            .defineMethod(METHOD_NAME, long.class, Modifier.PUBLIC | Modifier.STATIC)
            .withParameters(int.class)
            .intercept(new Implementation.Simple(new FibonacciAppender()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        long result = (long) fibonacciCalculator
            .getMethod(METHOD_NAME, int.class)
            .invoke(null, n);

        assertThat(result).isEqualTo(fib);
    }
}
