package edu.hw11.task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Changing behaviour of class method while program running")
    void test1() throws InstantiationException, IllegalAccessException {
        Class<? extends ArithmeticUtils> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(new Multiplier()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        assertThat(dynamicType.newInstance().sum(2, 5)).isEqualTo(2 * 5);
    }
}
