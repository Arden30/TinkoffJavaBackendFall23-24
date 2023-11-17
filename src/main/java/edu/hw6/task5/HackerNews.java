package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class HackerNews {
    public long[] hackerNewsTopStories() {
        try {
            URI uri = new URI("https://hacker-news.firebaseio.com/v0/topstories.json");
            var response = getResponse(uri);

            String[] array = response.body().replaceAll("[\\[\\]]", "").split(",");
            long[] res = new long[array.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = Long.parseLong(array[i]);
            }

            return res;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            return new long[0];
        }
    }

    public String news(long id) {
        try {
            URI uri = new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json");
            var response = getResponse(uri);

            Pattern pattern = Pattern.compile("\"title\":\"[^\"]*\"");
            Matcher matcher = pattern.matcher(response.body());

            if (matcher.find()) {
                return matcher.group().split(":")[1];
            }

            return "Title was not found";
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException();
        }
    }

    private HttpResponse<String> getResponse(URI uri) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
            .uri(uri)
            .GET()
            .build();

        HttpClient httpClient = newHttpClient();

        return httpClient
            .send(request, HttpResponse.BodyHandlers.ofString());
    }
}
