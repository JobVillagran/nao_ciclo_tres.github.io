package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ScholarModel {
    private static final String API_URL = "https://scholar.google.com/citations?user=";

    private Connection connection;

    public ScholarModel(Connection connection) {
        this.connection = connection;
    }

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

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO scholar_data (author_id, data) VALUES (?, ?)")) {
            statement.setString(1, authorId);
            statement.setString(2, result.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result.toString();
    }
}
