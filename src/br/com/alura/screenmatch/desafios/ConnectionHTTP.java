package br.com.alura.screenmatch.desafios;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;
import java.nio.charset.StandardCharsets;

public class ConnectionHTTP {
    public String encodeURL(String base, String bookName) {
        try {
            String query = URLEncoder.encode(bookName, StandardCharsets.UTF_8);
            String finalUrl = base + query;
            return finalUrl;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String connect(String url) {
    try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}
