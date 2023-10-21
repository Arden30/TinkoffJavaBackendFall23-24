package edu.hw2.task3.managers;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double LIMIT = 0.09;

    @Override
    public Connection getConnection() {
        if (Math.random() >= LIMIT) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }

}
