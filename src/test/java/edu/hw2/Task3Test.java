package edu.hw2;

import edu.hw2.task3.exceptions.ConnectionException;
import edu.hw2.task3.managers.ConnectionManager;
import edu.hw2.task3.managers.DefaultConnectionManager;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.managers.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connections.StableConnection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
@Disabled
public class Task3Test {

    @Test
    @DisplayName("Check that default connection with low chance manager with stable connection")
    void defaultManager() {
        ConnectionManager connectionManager = new DefaultConnectionManager(0.3);

        assertThat(connectionManager.getConnection()).isInstanceOf(StableConnection.class);
    }

    @Test
    @DisplayName("Check that default connection manager with high chance with stable connection")
    void defaultFailureManager() {
        ConnectionManager connectionManager = new DefaultConnectionManager(0.9);

        assertThat(connectionManager.getConnection()).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Check that default connection works with low chance of failure")
    void stableConnection() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(0.5), 5);

        assertDoesNotThrow(executor::updatePackages);
    }

    @Test
    @DisplayName("Check that faulty connection manager with faulty connection")
    void faultyManager() {
        ConnectionManager connectionManager = new FaultyConnectionManager(0);

        assertThat(connectionManager.getConnection()).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Check that failure connection can be lost with high chance of failure")
    void faultyConnection() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(1), 10);

        assertThrows(ConnectionException.class, executor::updatePackages);
    }
}
