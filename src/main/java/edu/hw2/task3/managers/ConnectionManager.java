package edu.hw2.task3.managers;

import edu.hw2.task3.connections.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ConnectionManager {
    Logger LOGGER = LogManager.getLogger();

    Connection getConnection();
}
