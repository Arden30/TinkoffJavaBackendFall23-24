package edu.project3.parsers;

import edu.project3.utils.LogRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.net.http.HttpClient.newHttpClient;

@SuppressWarnings({"MultipleStringLiterals", "InnerAssignment"})
public class LogParser {
    private final static Logger LOGGER = LogManager.getLogger();
    private final String source;
    private final static List<String> PATTERNS = new ArrayList<>();
    private final static List<Path> ALL_PATHS = new ArrayList<>();
    private URI uri;

    static {
        String remoteAddr = "(\\d{1,4}\\.){3}(\\d{1,4})";
        String remoteUser = "-(\\d{1,3}\\.){3}(\\d{1,3})";
        String timeLocal = "\\d{1,2}/[A-Z][a-z]{2}/(\\d{4}:)(\\d{2}:){2}(\\d{2}) (-|(\\+))\\d{4}";
        String request = "\"[A-Z]+ (/\\w*)* (HTTP/\\d+\\.\\d+)\"";
        String status = "\\d{3}";
        String size = "\\d+";
        String httpReferer = "\"-\"";
        String userAgent = "\"[^\"]+\"";
        PATTERNS.addAll(List.of(remoteAddr, remoteUser, timeLocal, request, status, size, httpReferer, userAgent));
    }

    public LogParser(String source) {
        this.source = source;
    }

    public LogRecord parseLog(String str) {
        String log = str;
        List<String> parameters = new ArrayList<>();
        String parameter;
        for (String s : PATTERNS) {
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(log);
            if (matcher.find()) {
                parameter = matcher.group(0);
                parameters.add(parameter);
                log = log.substring(matcher.end());
            } else {
                parameters.add("\"-\"");
            }
        }
        int cnt = 0;
        String addr = parameters.get(cnt++);
        String user = parameters.get(cnt++);
        LocalDateTime localDateTime = parseDate(parameters.get(cnt++));
        String req = parameters.get(cnt++);
        int status = Integer.parseInt(parameters.get(cnt++));
        long size = Integer.parseInt(parameters.get(cnt++));
        String referrer = parameters.get(cnt++);
        String agent = parameters.get(cnt++);

        return new LogRecord(addr, user, localDateTime, req, status, size, referrer, agent);
    }

    public List<LogRecord> parseAllLogs() {
        List<LogRecord> logs = new ArrayList<>();
        List<String> list;

        if ((list = parsePath()) == null) {
            if ((list = parseURI()) == null) {
                LOGGER.info("You made a mistake in path/uri");
                System.exit(1);
            }
        }

        for (String log : list) {
            logs.add(parseLog(log));
        }

        return logs;
    }

    public LocalDateTime parseDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        return LocalDateTime.parse(string, formatter);
    }

    public List<String> parsePath() {
        List<String> logs = new ArrayList<>();
        try {
            Path path = Path.of(source.substring(0, source.length() - 1)).getParent();
            List<Path> paths = Files.walk(path).toList();
            for (Path p : paths) {
                if (p.toString().startsWith(source.substring(0, source.length() - 2))) {
                    ALL_PATHS.add(p);
                }
            }
        } catch (InvalidPathException | IOException e) {
            return null;
        }

        for (Path path : ALL_PATHS) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    logs.add(str);
                }
            } catch (IOException e) {
                return null;
            }
        }

        return logs;
    }

    public List<Path> getAllPaths() {
        List<Path> res = new ArrayList<>();
        if (uri != null) {
            res.add(Path.of(uri.getPath()));
            return res;
        } else {
            return ALL_PATHS;
        }
    }

    public List<String> parseURI() {
        List<String> logs = new ArrayList<>();
        try {
            uri = URI.create(source);
            var request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

            HttpClient httpClient = newHttpClient();

            String[] response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body()
                .split("\n");

            logs.addAll(Arrays.asList(response));

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            return null;
        }

        return logs;
    }
}
