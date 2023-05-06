package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            DBConnection connection = new DBConnection();
            conn = connection.getConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        ScholarModel model = new ScholarModel(conn);
        ScholarView view = new ScholarView();
        ScholarController controller = new ScholarController(model, view);
        controller.getAuthorData();
    }
}
