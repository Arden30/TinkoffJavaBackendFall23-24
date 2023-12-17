package edu.hw11.task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.Implementation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.lang.reflect.Modifier;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    private static final long[] FIBONACCI_NUMBERS = {
        0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L
    };
    private static final String CLASS_NAME = "FibonacciCalculator";
    private static final String METHOD_NAME = "fibonacci";

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    void createClassWithASM(int n) throws Exception {
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

        assertThat(result).isEqualTo(FIBONACCI_NUMBERS[n]);
    }
}
