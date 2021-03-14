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
import models.User;

/**
 *
 * @author T-Gamer
 */
public class UserDAO {

    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public UserDAO() {
    }

    public ResultSet index() throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("SELECT * FROM user");
            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public void delete(Integer id) throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("DELETE FROM user WHERE id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int change(User user) throws SQLException, ParseException {
        PreparedStatement ps = null;
        try {
            if (user.getId() == 0) {
                ps = DatabaseConnectionDAO.connection().prepareStatement("INSERT INTO user (name, cpf, birthday, email, password, parental_id) VALUES(?, ?, ?, ?, ?, ?)");
                ps.setString(1, user.getName());
                ps.setString(2, user.getCPF());

                String dateString1 = user.getBirthday().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);

                ps.setDate(3, new java.sql.Date(date.getTime()));

                ps.setString(4, user.getEmail());
                ps.setString(5, user.getPassword());
                ps.setInt(6, user.getParental_id());
            } else {
                ps = DatabaseConnectionDAO.connection().prepareStatement("UPDATE user SET name = ?, cpf = ?, birthday = ?, email = ?, password = ?, parental_id = ? WHERE id = ?");
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
