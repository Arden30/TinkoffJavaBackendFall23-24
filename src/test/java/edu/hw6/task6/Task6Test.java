package edu.hw6.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Task6Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        PortScanner portScanner = new PortScanner();
        assertDoesNotThrow(portScanner::infoAboutUsedPorts);
    }
}
