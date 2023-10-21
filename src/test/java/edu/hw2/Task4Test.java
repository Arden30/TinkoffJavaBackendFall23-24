package edu.hw2;

import edu.hw2.task4.CallingInfoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("thisNameMustBeReturned method")
    void thisNameMustBeReturned() {
        String methodName = CallingInfoUtil.callingInfo().methodName();
        assertThat(methodName).isEqualTo("thisNameMustBeReturned");
    }

    @Test
    @DisplayName("anotherMethod method")
    void anotherMethod() {
        String methodName = CallingInfoUtil.callingInfo().methodName();
        assertThat(methodName).isEqualTo("anotherMethod");
    }

    @Test
    @DisplayName("Task4Test class")
    void classTask4Test() {
        String className = CallingInfoUtil.callingInfo().className();
        assertThat(className).isEqualTo("edu.hw2.Task4Test");
    }
}
