package edu.project3.formatters;

import edu.project3.analyzer.NginxLogAnalyzer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FormatADOC implements Format {
    private final Path path = Path.of("src/test/java/edu/project3/report.adoc");
    private final static String COLS = "[cols=\"1,1\"]\n";
    private final static String TABLE_START = "|===\n";
    private final static String TABLE_END = "|===\n\n";
    private final static String SKIP_LINE = "\n\n";

    @Override
    public void print(NginxLogAnalyzer logAnalyzer) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {

            bufferedWriter.write("=== Общая информация\n");
            bufferedWriter.write(COLS);
            bufferedWriter.write(TABLE_START);
            bufferedWriter.write("|Метрика |Значение\n\n");

            bufferedWriter.write("|Файл(-ы)\n");
            bufferedWriter.write("|" + logAnalyzer.fileName() + SKIP_LINE);

            bufferedWriter.write("|Начальная дата\n");
            bufferedWriter.write("|" + logAnalyzer.parseDate(logAnalyzer.getDateFrom()) + SKIP_LINE);

            bufferedWriter.write("|Конечная дата\n");
            bufferedWriter.write("|" + logAnalyzer.parseDate(logAnalyzer.getDateTo()) + SKIP_LINE);

            bufferedWriter.write("|Количество запросов\n");
            bufferedWriter.write("|" + logAnalyzer.requestsNumber() + SKIP_LINE);

            bufferedWriter.write("|Средний размер ответа\n");
            bufferedWriter.write("|" + logAnalyzer.avgResponseSize() + "b" + SKIP_LINE);
            bufferedWriter.write(TABLE_END);

            bufferedWriter.write("=== Запрашиваемые ресурсы\n");
            bufferedWriter.write(COLS);
            bufferedWriter.write(TABLE_START);
            bufferedWriter.write("|Ресурс |Количество\n\n");

            Map<String, Long> req = logAnalyzer.resources();
            for (Map.Entry<String, Long> r : req.entrySet()) {
                bufferedWriter.write("|" + r.getKey() + "\n");
                bufferedWriter.write("|" + r.getValue() + SKIP_LINE);
            }
            bufferedWriter.write(TABLE_END);

            bufferedWriter.write("=== Коды ответа\n");
            bufferedWriter.write(COLS);
            bufferedWriter.write(TABLE_START);
            bufferedWriter.write("|Код |Количество\n\n");

            Map<Integer, Long> codes = logAnalyzer.errorCodes();
            for (Map.Entry<Integer, Long> r : codes.entrySet()) {
                bufferedWriter.write("|" + r.getKey() + "\n");
                bufferedWriter.write("|" + r.getValue() + SKIP_LINE);
            }
            bufferedWriter.write(TABLE_END);

        } catch (IOException e) {
            LOGGER.info("Some problems with creating ADOC report");
        }
    }
}
