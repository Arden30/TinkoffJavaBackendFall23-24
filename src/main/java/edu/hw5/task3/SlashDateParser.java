package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class SlashDateParser implements DateParser {
    @Override
    public Optional<LocalDate> parseDate(String string) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
            LocalDate date = LocalDate.parse(string, formatter);
            return Optional.of(date);
        } catch (Exception e) {
            WordDateParser dateParser = new WordDateParser();
            return dateParser.parseDate(string);
        }
    }
}
