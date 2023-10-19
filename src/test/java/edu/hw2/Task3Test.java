package edu.hw2;

import edu.hw2.task3.exceptions.ConnectionException;
import edu.hw2.task3.managers.ConnectionManager;
import edu.hw2.task3.managers.DefaultConnectionManager;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.managers.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connections.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    @DisplayName("Check that default manager works")
    void defaultManager() {
        DefaultConnectionManager connectionManager = new DefaultConnectionManager();

        assertThat(connectionManager.getConnection()).isInstanceOf(StableConnection.class);
    }

    @Test
    @DisplayName("Check that connection from default manager works with big amount of attempts")
    void stableConnection() {
        DefaultConnectionManager connectionManager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(connectionManager, 15);

        assertDoesNotThrow(executor::updatePackages);
    }

    @Test
    @DisplayName("Check that faulty connection manager returns faulty connection")
    void faultyManager() {
        ConnectionManager connectionManager = new FaultyConnectionManager();

        assertThat(connectionManager.getConnection()).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Check that failure connection in most cases throws exception")
    void faultyConnection() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 10);

        assertThrows(ConnectionException.class, executor::updatePackages);
    }
}
