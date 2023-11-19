package edu.project3;

import edu.project3.utils.ProgramRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project3Test {

    private final static String CORRECT_MARKDOWN_REPORT = "src/test/java/edu/project3/correct.md";
    private final static String MARKDOWN_REPORT = "src/test/java/edu/project3/report.md";
    private final static String CORRECT_ADOC_REPORT = "src/test/java/edu/project3/correct.adoc";
    private final static String ADOC_REPORT = "src/test/java/edu/project3/report.adoc";

    @Test
    @DisplayName("Test adoc report")
    void testAdocReport() {
        String[] args = {
            "--path", "src\\test\\java\\edu\\project3\\test*",
            "--format", "adoc"
        };

        String expected;
        try {
            expected = Files.readString(Paths.get(CORRECT_ADOC_REPORT));
        } catch (IOException ignored) {
            expected = "";
        }

        ProgramRunner programRunner = new ProgramRunner(args);
        programRunner.run();

        String res;
        try {
            res = Files.readString(Paths.get(ADOC_REPORT));
        } catch (IOException ignored) {
            res = " ";
        }

        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test markdown report")
    void testMarkdownReport() {
        String[] args = {
            "--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--from", "2015-05-17",
            "--to", "2015-05-20",
            "--format", "markdown"
        };

        String expected;
        try {
            expected = Files.readString(Paths.get(CORRECT_MARKDOWN_REPORT));
        } catch (IOException ignored) {
            expected = "";
        }

        ProgramRunner programRunner = new ProgramRunner(args);
        programRunner.run();

        String res;
        try {
            res = Files.readString(Paths.get(MARKDOWN_REPORT));
        } catch (IOException ignored) {
            res = " ";
        }

        assertThat(res).isEqualTo(expected);
    }
}
