package edu.project1;

import edu.project1.logic.ConsoleHangman;
import edu.project1.logic.GuessResult;
import edu.project1.logic.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProjectTest {
    private ConsoleHangman consoleHangman = new ConsoleHangman();

    @Test
    @DisplayName("Test win case")
    void winResult() {
        consoleHangman = new ConsoleHangman();
        String answer = "hello";
        int maxAttempts = 5;
        Session session = new Session(answer, maxAttempts);
        String[] input = {"t", "e", "l", "o", "o", "o", "o", "h"};
        for (int i = 0; i < input.length - 1; i++) {
            GuessResult result = consoleHangman.tryGuess(session, input[i]);
            if (answer.contains(input[i])) {
                assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
            } else {
                assertThat(result).isInstanceOf(GuessResult.FailedGuess.class);
            }
        }
        GuessResult result = consoleHangman.tryGuess(session, input[input.length - 1]);
        assertThat(result).isInstanceOf(GuessResult.Win.class);
    }

    @Test
    @DisplayName("Test win case with typo inputs")
    void winIncorrectResult() {
        consoleHangman = new ConsoleHangman();
        String answer = "hello";
        int maxAttempts = 5;
        Session session = new Session(answer, maxAttempts);
        String[] input = {"t", "e", "l", "o", "o", "o", "o", "aaa", "", "       ", "h"};
        for (int i = 0; i < input.length - 1; i++) {
            GuessResult result = consoleHangman.tryGuess(session, input[i]);
            if (input[i].length() > 0 && answer.contains(input[i])) {
                assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
            } else if (input[i].trim().length() != 1) {
                assertThat(result).isInstanceOf(GuessResult.TypoGuess.class);
            } else {
                assertThat(result).isInstanceOf(GuessResult.FailedGuess.class);
            }
        }
        GuessResult result = consoleHangman.tryGuess(session, input[input.length - 1]);
        assertThat(result).isInstanceOf(GuessResult.Win.class);
    }

    @Test
    @DisplayName("Test lose case")
    void loseResult() {
        String answer = "hello";
        int maxAttempts = 5;
        Session session = new Session(answer, maxAttempts);
        String[] input = {"t", "e", "l", "a", "b", "h", "c", "!"};
        for (int i = 0; i < input.length - 1; i++) {
            GuessResult result = consoleHangman.tryGuess(session, input[i]);
            if (answer.contains(input[i])) {
                assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
            } else {
                assertThat(result).isInstanceOf(GuessResult.FailedGuess.class);
            }
        }
        GuessResult result = consoleHangman.tryGuess(session, input[input.length - 1]);
        assertThat(result).isInstanceOf(GuessResult.Defeat.class);
    }

}
