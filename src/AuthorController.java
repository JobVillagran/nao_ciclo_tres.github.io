
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class AuthorController {
    private static final String API_URL = "https://api.scholar.google.com/citations?key=AIzaSyCvucxwmjZ-4lJIr6oaGbWjrsEEjyYfnVA&user_id=";

    private static final String AUTHOR_API_BASE_URL = "https://api.scholar.google.com/citations?user=";

    private static final Gson gson = new Gson();

    public Author getAuthor(String userId) throws IOException {
        String apiUrl = API_URL + userId;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(AUTHOR_API_BASE_URL + userId);
        HttpResponse response = httpClient.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        JsonObject json = gson.fromJson(responseBody, JsonObject.class);
        JsonArray authorArray = json.getAsJsonArray("author");
        JsonObject authorJson = authorArray.get(0).getAsJsonObject();

        Author author = new Author();
        author.setName(authorJson.get("name").getAsString());
        author.setAffiliation(authorJson.get("affiliation").getAsString());
        author.setEmail(authorJson.get("email").getAsString());
        author.setCitations(authorJson.get("cited_by").getAsInt());

        return author;
    }
}

