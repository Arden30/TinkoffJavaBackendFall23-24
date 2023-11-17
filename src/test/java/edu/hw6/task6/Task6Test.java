package edu.hw6.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        PortScanner portScanner = new PortScanner();
        String res = portScanner.infoAboutUsedPorts();
        String expected = "Протокол   Порт   Сервис\n" +
            "UDP        135    EPMAP\n" +
            "TCP        137    Служба имен NetBIOS\n" +
            "TCP        138    Служба датаграмм NetBIOS\n" +
            "UDP        139    Служба сеансов NetBIOS\n" +
            "UDP        445    Microsoft-DS Active Directory\n" +
            "TCP        843    Adobe Flash\n" +
            "TCP       1900    Simple Service Discovery Protocol (SSDP)\n" +
            "TCP       3702    Динамическое обнаружение веб-служб\n" +
            "TCP      17500    Dropbox\n" +
            "TCP      27017    MongoDB\n";
        assertThat(res).isEqualTo(expected);
    }
}
