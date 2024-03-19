import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class SimpleApiHttpClient {
    private final HttpClient client;

    public SimpleApiHttpClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String fetchData(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public List<Post> parseJsonPosts(String json) {
        Gson gson = new Gson();
        Type postListType = new TypeToken<List<Post>>(){}.getType();
        return gson.fromJson(json, postListType);
    }
}
