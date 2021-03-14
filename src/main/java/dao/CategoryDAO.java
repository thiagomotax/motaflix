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
import models.Category;

/**
 *
 * @author T-Gamer
 */
public class CategoryDAO {

    private static CategoryDAO instance;

    public static CategoryDAO getInstance() {
        if (instance == null) {
            instance = new CategoryDAO();
        }
        return instance;
    }

    public CategoryDAO() {
    }

    public ResultSet index() throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("SELECT * FROM category");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(int id) throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("DELETE FROM category WHERE id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int change(Category category) throws SQLException, ParseException {
        PreparedStatement ps = null;
        try {
            if (category.getId() == 0) {
                ps = DatabaseConnectionDAO.connection().prepareStatement("INSERT INTO category (name) VALUES(?)");
                ps.setString(1, category.getName());
            } else {
                ps = DatabaseConnectionDAO.connection().prepareStatement("UPDATE category SET name = ? WHERE id = ?");
                ps.setString(1, category.getName());
                ps.setInt(2, category.getId());
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
