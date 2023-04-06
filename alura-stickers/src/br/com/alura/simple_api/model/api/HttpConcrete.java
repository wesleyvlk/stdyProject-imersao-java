package br.com.alura.simple_api.model.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class HttpConcrete implements Http {
    protected static String url;

    @Override
    public HttpRequest buildRequest() {
        return HttpRequest.newBuilder(URI.create(url)).GET().build();
    }

    public String buildResponse() {
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(buildRequest(), HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
