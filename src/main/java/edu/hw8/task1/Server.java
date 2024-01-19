package edu.hw8.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {
    private static final int THREADS = 5;
    private static final int PORT = 2741;
    private static final int BUFFER_SIZE = 1024;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    @Override
    public void run() {
        int clients = 0;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (clients++ < THREADS) {
                var socket = serverSocket.accept();
                executorService.submit(() -> handleClient(socket));
            }
            executorService.shutdown();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void handleClient(Socket socket) {
        try {
            byte[] buffer = new byte[BUFFER_SIZE];
            InputStream inputStream = socket.getInputStream();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String word = new String(buffer, 0, bytesRead);
                String quote = getQuote(word);

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(quote.getBytes());
                outputStream.flush();
            }

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String getQuote(String word) {
        return Dictionary.getDictionary().getOrDefault(word, "No such associated word...");
    }
}
