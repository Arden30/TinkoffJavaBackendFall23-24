package edu.hw2.task3;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.exceptions.ConnectionException;
import edu.hw2.task3.managers.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        int cnt = 0;
        while (true) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException e) {
                if (++cnt == maxAttempts) {
                    throw new ConnectionException(
                        "Exceeded the number of " + maxAttempts + " allowed attempts to execute " + command, e);
                }
            } catch (Exception e) {
                throw new RuntimeException("Problems with closing connection");
            }
        }
    }
}
