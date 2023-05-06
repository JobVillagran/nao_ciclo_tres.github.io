package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScholarView {
    public String getAuthorIdFromUser() throws IOException {
        System.out.print("Enter author ID: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String authorId = reader.readLine();
        return authorId;
    }

    public void displayAuthorData(String authorData) {
        System.out.println(authorData);
    }

    public void displayError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
