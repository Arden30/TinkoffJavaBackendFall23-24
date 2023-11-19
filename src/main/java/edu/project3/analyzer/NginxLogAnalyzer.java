package edu.project3.analyzer;

import edu.project3.parsers.LogParser;
import edu.project3.utils.LogRecord;
import edu.project3.utils.Option;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NginxLogAnalyzer {
    private final List<LogRecord> logs;
    private final Map<Option, String> parameters;

    private final LogParser logParser;
    public NginxLogAnalyzer(List<LogRecord> logs, Map<Option, String> parameters, LogParser logParser) {
        this.parameters = parameters;
        this.logs = logsFromDateToDate(logs);
        this.logParser = logParser;
    }

//    public void analyzeLogs() {
//        ParametersParser parametersParser = new ParametersParser();
//        Map<Option, String> parameters = parametersParser.parse();
//        FormatADOC formatADOC = new FormatADOC();
//        formatADOC.print(parameters);
//    }

    public Map<Integer, Long> errorCodes() {
        Map<Integer, Long> res = logs.stream()
            .collect(Collectors.groupingBy(LogRecord::status, Collectors.counting()));
        Map<Integer, Long> sorted = new TreeMap<>(Comparator.naturalOrder());
        sorted.putAll(res);
        return sorted;
    }

    public Map<String, Long> resources() {
        Pattern pattern = Pattern.compile("/\\w+ ");
        Map<String, Long> res = logs.stream()
            .collect(Collectors.groupingBy(logRecord -> {
                Matcher matcher = pattern.matcher(logRecord.request());
                if (matcher.find()) {
                    return matcher.group();
                }
                return null;
            }, Collectors.counting()));
        Map<String, Long> sorted = new TreeMap<>(Comparator.naturalOrder());
        sorted.putAll(res);
        return sorted;
    }

    public int requestsNumber() {
        return logs.size();
    }

    public List<LogRecord> logsFromDateToDate(List<LogRecord> source) {
        List<LogRecord> res = new ArrayList<>();
        LocalDate from = getDateFrom();
        LocalDate to = getDateTo();

        if (from != null) {
            res = source.stream()
                .filter(logRecord -> logRecord.dateTime().toLocalDate().isAfter(getDateFrom()))
                .toList();
        }

        if (to != null) {
            res = source.stream()
                .filter(logRecord -> logRecord.dateTime().toLocalDate().isBefore(getDateTo()))
                .toList();
        }

        if (to == null && from == null) {
            return source;
        } else {
            return res;
        }
    }

    public LocalDate getDateFrom() {
        try {
            if (parameters.containsKey(Option.FROM)) {
                String from = parameters.get(Option.FROM);
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
                return LocalDate.parse(from, formatter);
            }
        } catch (DateTimeParseException e) {
            return null;
        }
        return null;
    }

    public LocalDate getDateTo() {
        try {
            if (parameters.containsKey(Option.TO)) {
                String from = parameters.get(Option.TO);
                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
                return LocalDate.parse(from, formatter);
            }
        } catch (DateTimeParseException e) {
            return null;
        }
        return null;
    }

    public String parseDate(LocalDate localDate) {
        if (localDate == null) {
            return "-";
        } else {
            return localDate.toString();
        }
    }

    public String fileName() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Path> paths = logParser.getAllPaths();
        for (Path path : paths) {
            stringBuilder.append(path.getFileName()).append(" ");
        }
        return stringBuilder.toString();
    }

    public long avgResponseSize() {
        long avg = 0;
        for (LogRecord logRecord : logs) {
            avg += logRecord.size();
        }
        if (logs.size() != 0) {
            return avg / logs.size();
        } else {
            return 0;
        }
    }

}
