package edu.hw2.task3.connections;

import static edu.hw2.task3.managers.ConnectionManager.LOGGER;

public class StableConnection implements Connection {

    @Override
    public void execute(String command) {
        LOGGER.info(" '" + command + "' " + "was executed!");
    }

    @Override
    public void close() {
        LOGGER.info("Connection closed");
    }
}
