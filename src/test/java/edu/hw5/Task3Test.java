package edu.hw5;

import edu.hw5.task3.DashDateParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private final DashDateParser dateParser = new DashDateParser();

    @ParameterizedTest
    @DisplayName("Test 1 (appropriate formats)")
    @ValueSource(strings = {
        "2020-10-10",
        "2020-12-2",
        "1/3/1976",
        "1/3/20",
        "tomorrow",
        "today",
        "yesterday",
        "1 day ago",
        "2234 days ago"
    })
    void testSuccessfulParse(String date) {
        Optional<LocalDate> result = dateParser.parseDate(date);

        assertThat(result).isPresent().containsInstanceOf(LocalDate.class);
    }

    @Test
    @DisplayName("Test 2 (wrong input)")
    void testUnsuccessfulParse() {
        String unknownDateFormat = "2023/12-10";

        Optional<LocalDate> result = dateParser.parseDate(unknownDateFormat);

        assertThat(result).isNotPresent();
    }
}
