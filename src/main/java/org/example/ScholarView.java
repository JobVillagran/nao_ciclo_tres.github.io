package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ScholarView {
    public void displayAuthorData(String authorData) {
        System.out.println(authorData);
    }

    public String getAuthorIdFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter author ID: ");
        String authorId = scanner.nextLine();
        return authorId;
    }

    public void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }
}