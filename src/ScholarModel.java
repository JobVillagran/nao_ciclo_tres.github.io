import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ScholarModel {
    private static final String API_URL = "https://scholar.google.com/citations?user=";

    public String getAuthorData(String authorId) throws IOException {
        String url = API_URL + authorId;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent())
        );

        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}