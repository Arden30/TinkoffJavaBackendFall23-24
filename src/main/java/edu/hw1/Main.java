package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private Main() {

    }

    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        Task0.hello();
        LOGGER.info("Task1: " + Task1.minutesToSeconds("13:59"));
        LOGGER.info("Task2: " + Task2.countDigits(133));
        LOGGER.info("Task3: " + Task3.isNestable(new int[] {}, new int[] {2, 3}));
        LOGGER.info("Task4:" + Task4.fixString("abc"));
        LOGGER.info("Task5: " + Task5.isPalindromeDescendant(1461));
        LOGGER.info("Task6: " + Task6.k(6554));
        LOGGER.info("Task7(right): " + Task7.rotateRight(2, 1));
        LOGGER.info("Task7(left): " + Task7.rotateLeft(2, 1));
        LOGGER.info("Task8: " + Task8.knightBoardCapture(
            new int[][] {{1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}}));
    }
}
