package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class WordDateParser implements DateParser {
    @Override
    public Optional<LocalDate> parseDate(String date) {
        try {
            LocalDate res = typeOfWord(date);
            return Optional.of(res);
        } catch (Exception e) {
            AgoDateParser dateParser = new AgoDateParser();
            return dateParser.parseDate(date);
        }
    }

    public LocalDate typeOfWord(String str) {
        String date = str.trim().toLowerCase();
        return switch (date) {
            case "yesterday" -> LocalDate.now().minusDays(1);
            case "today" -> LocalDate.now();
            case "tomorrow" -> LocalDate.now().plusDays(1);
            default -> null;
        };
    }
}
