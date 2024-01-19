package edu.hw8;

import edu.hw8.task1.Client;
import edu.hw8.task1.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private final Path path = Path.of("src/test/java/edu/hw8/quotes.txt");
    @Test
    @DisplayName("Test 2 clients")
    void test1() throws IOException, InterruptedException {
        Files.writeString(path, "");

        Server server = new Server();
        server.start();

        String client1Word = "личности";
        String client1ExpectedQuote = "Не переходи на личности там, где их нет";

        String client2Word = "глупый";
        String client2ExpectedQuote = "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";

        try (var inputStream = new ByteArrayInputStream(client1Word.getBytes())) {
            Client client1 = new Client();
            client1.start();
            System.setIn(inputStream);
            Thread.sleep(500);
        }

        try (var inputStream = new ByteArrayInputStream(client2Word.getBytes())) {
            System.setIn(inputStream);
            Client client2 = new Client();
            client2.start();
            Thread.sleep(500);
        }

        assertThat(containsInFile(client1ExpectedQuote)).isTrue();
        assertThat(containsInFile(client2ExpectedQuote)).isTrue();

        server.interrupt();
    }

    private boolean containsInFile(String expected) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(expected)) {
                    return true;
                }
            }
        }
        return false;
    }
}
