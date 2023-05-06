package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.sql.Connection;
import java.io.IOException;
import okhttp3.HttpUrl;
import java.util.HashMap;
import java.util.Map;

public class ScholarModel {
    private final String API_KEY = "7e29144377a9ed113fbb4ed8dd2e5b20579682c5d0e33fd374e5be9c16e6681b";
    private final OkHttpClient client = new OkHttpClient();

    private Connection conn;

    public ScholarModel(Connection conn) {
        this.conn = conn;
    }

    public String getAuthorData(String authorId) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.semanticscholar.org/v1/author/" + authorId).newBuilder();
        urlBuilder.addQueryParameter("apiKey", API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            return response.body().string();
        }
    }
}

