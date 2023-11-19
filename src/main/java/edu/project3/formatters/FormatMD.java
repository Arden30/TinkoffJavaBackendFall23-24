package edu.project3.formatters;

import edu.project3.analyzer.NginxLogAnalyzer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FormatMD implements Format {

    private final Path path = Path.of("src/test/java/edu/project3/report.md");
    private final static Logger LOGGER = LogManager.getLogger();

    private final static String NEXT_LINE = "|\n";

    @Override
    public void print(NginxLogAnalyzer logAnalyzer) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write("#### Общая информация\n");
            bufferedWriter.write("|Метрика|Значение|\n");
            bufferedWriter.write("|:---------------------:|-------------:|\n");
            bufferedWriter.write("|Файл(-ы)|" + logAnalyzer.fileName() + NEXT_LINE);
            bufferedWriter.write("|Начальная дата|" + logAnalyzer.parseDate(logAnalyzer.getDateFrom()) + NEXT_LINE);
            bufferedWriter.write("|Конечная дата|" + logAnalyzer.parseDate(logAnalyzer.getDateTo()) + NEXT_LINE);
            bufferedWriter.write("|Количество запросов|" + logAnalyzer.requestsNumber() + NEXT_LINE);
            bufferedWriter.write("|Средний размер ответа|" + logAnalyzer.avgResponseSize() + "b|\n");
            bufferedWriter.write("#### Запрашиваемые ресурсы\n");
            bufferedWriter.write("|Ресурс|Количество|\n");
            bufferedWriter.write("|:---------------:|-----------:|\n");
            Map<String, Long> req = logAnalyzer.resources();
            for (Map.Entry<String, Long> r : req.entrySet()) {
                bufferedWriter.write("|" + r.getKey() + "|" + r.getValue() + NEXT_LINE);
            }
            bufferedWriter.write("#### Коды ответа\n");
            bufferedWriter.write("|Код|Количество|\n");
            bufferedWriter.write("|:------------:|-----------:|\n");
            Map<Integer, Long> codes = logAnalyzer.errorCodes();
            for (Map.Entry<Integer, Long> r : codes.entrySet()) {
                bufferedWriter.write("|" + r.getKey() + "|" + r.getValue() + NEXT_LINE);
            }
        } catch (IOException e) {
            LOGGER.info("Some problems with creating MD report");
        }
    }
}
