package edu.hw2.task3.connections;

import edu.hw2.task3.exceptions.ConnectionException;
import static edu.hw2.task3.managers.ConnectionManager.LOGGER;

public class FaultyConnection implements Connection {
    private final double chance;
    private static final double CHECKER = 0.8;

    public FaultyConnection(double chance) {
        this.chance = chance;
    }

    @Override
    public void execute(String command) throws ConnectionException {
        if (chance <= CHECKER) {
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
