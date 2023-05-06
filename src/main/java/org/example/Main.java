package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            DBConnection connection = new DBConnection();
            conn = connection.getConnection();
            System.out.println("Connected to database at " + conn.getMetaData().getURL() + " as user " + conn.getMetaData().getUserName());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        ScholarModel model = new ScholarModel(conn);
        ScholarView view = new ScholarView();
        ScholarController controller = new ScholarController(model, view);
        controller.getAuthorData();
    }
}
