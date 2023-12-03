package edu.hw8.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Path;
import java.util.Scanner;

public class Client extends Thread {
    private static final int PORT = 2741;
    private static final int BUFFER_SIZE = 1024;

    @Override
    public void run() {
        try (Socket client = new Socket(InetAddress.getByName("localhost"), PORT)) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (scanner.hasNextLine()) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    String word = scanner.nextLine();

                    if (word.toLowerCase().trim().equals("exit")) {
                        break;
                    }

                    OutputStream outputStream = client.getOutputStream();
                    outputStream.write(word.getBytes());
                    outputStream.flush();

                    InputStream inputStream = client.getInputStream();
                    int bytesRead = inputStream.read(buffer);

                    if (bytesRead == -1) {
                        break;
                    }

                    String quote = new String(buffer, 0, bytesRead);
                    writeQuoteInFile(quote);

                    if (client.isOutputShutdown()) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void writeQuoteInFile(String quote) {
        Path path = Path.of("src/test/java/edu/hw8/quotes.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), true))) {
            bufferedWriter.write(quote);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
