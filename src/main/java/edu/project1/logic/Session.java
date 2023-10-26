package edu.project1.logic;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts = 0;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
    }

    @NotNull public GuessResult guess(char guess) {
        for (int i = 0; i < answer.length(); i++) {
            if (guess == answer.charAt(i)) {
                for (int j = 0; j < userAnswer.length; j++) {
                    if (answer.charAt(j) == guess) {
                        userAnswer[j] = guess;
                    }
                }
                if (!String.valueOf(userAnswer).contains("*")) {
                    return new GuessResult.Win(attempts, maxAttempts, userAnswer);
                }
                return new GuessResult.SuccessfulGuess(attempts, maxAttempts, userAnswer);
            }
        }
        if (++attempts == maxAttempts) {
            return new GuessResult.Defeat(attempts, maxAttempts, userAnswer);
        }
        return new GuessResult.FailedGuess(attempts, maxAttempts, userAnswer);
    }

    public @NotNull GuessResult giveUp() {
        return new GuessResult.ExitGuess(attempts, maxAttempts, userAnswer);
    }

    @NotNull public GuessResult incorrect() {
        return new GuessResult.TypoGuess(attempts, maxAttempts, userAnswer);
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
