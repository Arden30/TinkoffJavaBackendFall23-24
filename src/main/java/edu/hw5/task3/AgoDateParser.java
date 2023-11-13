package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class AgoDateParser implements DateParser {
    @Override
    public Optional<LocalDate> parseDate(String date) {
        try {
            int days = Integer.parseInt(date.trim().split(" ")[0]);
            LocalDate localDate = LocalDate.now().minusDays(days);
            return Optional.of(localDate);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
