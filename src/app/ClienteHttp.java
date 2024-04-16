package app;

import java.io.IOException;
import java.net.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class HttpClientWrapper {

    public String getDataFromUrl(String urlString) {
        try {
            URI uri = URI.create(urlString);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Error while making HTTP request", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error while processing HTTP response", e);
        }
    }
}
