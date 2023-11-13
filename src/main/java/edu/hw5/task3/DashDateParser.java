package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DashDateParser implements DateParser {
    @Override
    public Optional<LocalDate> parseDate(String string) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y-M-d");
            LocalDate date = LocalDate.parse(string, formatter);
            return Optional.of(date);
        } catch (Exception e) {
            SlashDateParser dateParser = new SlashDateParser();
            return dateParser.parseDate(string);
        }
    }
}
