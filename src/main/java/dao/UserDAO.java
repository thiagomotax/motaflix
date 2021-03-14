/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import models.DatabaseConnection;
import models.User;

/**
 *
 * @author T-Gamer
 */
public class UserDAO {
    public ResultSet index() throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement("SELECT * FROM user");
        ResultSet rs = ps.executeQuery();

        return rs;
    }

    public ResultSet delete(Integer id) throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement("DELETE FROM user WHERE id = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int change(User user) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("user" + user.getId( ));
        try {
            if (user.getId() == 0) {
                ps = DatabaseConnection.connection().prepareStatement("INSERT INTO user (name, cpf, birthday, email, password, parental_id) VALUES(?, ?, ?, ?, ?, ?)");
                ps.setString(1, user.getName());
                ps.setString(2, user.getCPF());

                String dateString1 = user.getBirthday().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);

                ps.setDate(3, new java.sql.Date(date.getTime()));

                ps.setString(4, user.getEmail());
                ps.setString(5, user.getPassword());
                ps.setInt(6, user.getParental_id());
            } else {
                ps = DatabaseConnection.connection().prepareStatement("UPDATE user SET name = ?, cpf = ?, birthday = ?, email = ?, password = ?, parental_id = ? WHERE id = ?");
                ps.setString(1, user.getName());
                ps.setString(2, user.getCPF());
                String dateString1 = user.getBirthday().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);
                ps.setDate(3, new java.sql.Date(date.getTime()));
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getPassword());
                ps.setInt(6, user.getParental_id());
                ps.setInt(7, user.getId());
            }

        } catch (SQLException e) {
            System.out.println(e + "error");
        }
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int idx = 0;
        if (rs.next()) {
            idx = rs.getInt(1);
        }
        return idx;
    }
}
