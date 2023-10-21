package edu.hw2.task3.connections;

import edu.hw2.task3.exceptions.ConnectionException;
import static edu.hw2.task3.managers.ConnectionManager.LOGGER;

public class FaultyConnection implements Connection {

    private static final double LIMIT = 0.99;

    @Override
    public void execute(String command) throws ConnectionException {
        if (Math.random() >= LIMIT) {
            LOGGER.info(" '" + command + "' " + "was executed!");
        } else {
            throw new ConnectionException("Connection lost");
        }
    }

    @Override
    public void close() {
        LOGGER.info("Connection closed");
    }

}
