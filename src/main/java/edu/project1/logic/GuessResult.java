package edu.project1.logic;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

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
            String userAnswer = "You guessed the word: " + String.valueOf(state()) + "\n\n";
            return userAnswer + "You won!";
        }
    }

    record SuccessfulGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            String userAnswer = "The word: " + String.valueOf(state()) + "\n";
            return "Hit!\n" + userAnswer;
        }

    }

    record FailedGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Missed, mistake " + attempt() + " out of " + maxAttempts() + "\n"
                + String.valueOf(state()) + "\n";
        }

    }

    record TypoGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Enter only 1 symbol!\n";
        }
    }

    record ExitGuess(int attempt, int maxAttempts, char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Game stopped";
        }
    }

}
