package edu.project1.logic;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    String WORD = "The word: ";

    record Defeat(int attempt, int maxAttempts, char[] state) implements GuessResult {

        @Override
        public @NotNull String message() {
            FailedGuess failedGuess = new FailedGuess(attempt, maxAttempts, state);
            String msg = failedGuess.message();
            return msg + "\n\nYou lost (:";
        }
    }

    record Win(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return WORD + new String(state()) + "\n\nYou won!";
        }
    }

    record SuccessfulGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!\n" + WORD + String.join("", new String(state())) + "\n";
        }

    }

    record FailedGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Missed, mistake " + attempt() + " out of " + maxAttempts() + "\n" + WORD
                + String.join("", new String(state())) + "\n";
        }

    }

    record TypoGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Enter only 1 symbol!" + "\n";
        }
    }

    record ExitGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Game stopped";
        }
    }

}
