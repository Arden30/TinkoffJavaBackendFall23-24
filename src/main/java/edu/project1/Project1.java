package edu.project1;

import edu.project1.logic.ConsoleHangman;

@SuppressWarnings("UncommentedMain")
public final class Project1 {

    private Project1() {
    }

    public static void main(String[] args) {
        ConsoleHangman consoleHangman = new ConsoleHangman();
        consoleHangman.run();
    }
}
