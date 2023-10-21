package edu.project1.logic;

import edu.project1.dictionary.Dictionary;
import edu.project1.exceptions.IncorrectDictionaryWord;
import java.util.Collections;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("RegexpSinglelineJava")
public class ConsoleHangman implements Dictionary {
    private final Scanner scanner = new Scanner(System.in);

    private static final int MAX_ATTEMPTS = 5;
    private Session session;

    @Override
    public @NotNull String randomWord() throws IncorrectDictionaryWord {
        Collections.shuffle(WORDS);
        if (WORDS.isEmpty() || WORDS.get(0).trim().length() < 1) {
            throw new IncorrectDictionaryWord("There is no appropriate word in Dictionary");
        }
        return WORDS.get(0).trim();
    }

    public void run() {
        try {
            session = new Session(randomWord(), MAX_ATTEMPTS);
            System.out.println("Welcome to Hangman game!\nTo exit input Ctrl-D combination\n");
            while (session.getAttempts() < session.getMaxAttempts()) {
                System.out.println("Guess a letter: ");
                String input = readInput();
                GuessResult guessResult = tryGuess(session, input);
                printState(guessResult);
                if (guessResult instanceof GuessResult.Win || guessResult instanceof GuessResult.Defeat) {
                    break;
                }
            }
        } catch (IncorrectDictionaryWord e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (NoSuchElementException e) {
            printState(session.giveUp());
            System.exit(0);
        }
    }

    public GuessResult tryGuess(Session session, String input) {
        if (input.length() != 1) {
            return session.incorrect();
        }
        return session.guess(input.charAt(0));
    }

    public String readInput() {
        return scanner.nextLine().trim().toLowerCase(Locale.ROOT);
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
    }
}
