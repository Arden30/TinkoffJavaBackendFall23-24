package edu.hw2.task3.managers;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {

    private final double chance;
    private static final double CHECKER = 0.7;

    public DefaultConnectionManager(double chance) {
        this.chance = chance;
    }

    @Override
    public Connection getConnection() {
        if (chance <= CHECKER) {
            return new StableConnection();
        } else {
            return new FaultyConnection(chance);
        }
    }
}
