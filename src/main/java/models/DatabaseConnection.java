/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author T-Gamer
 */
public class DatabaseConnection {

    private static Connection conn = null;

    private DatabaseConnection() {
        String url = "jdbc:mysql://localhost:3306/motaflix";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("New connection");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connection() {
        if(conn == null)
            new DatabaseConnection();
        return conn;
    }
}
