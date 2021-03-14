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
import models.Media;

/**
 *
 * @author T-Gamer
 */
public class MediaDAO {

    private static MediaDAO instance;

    public static MediaDAO getInstance() {
        if (instance == null) {
            instance = new MediaDAO();
        }
        return instance;
    }

    public MediaDAO() {
    }

    public ResultSet index() throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("SELECT * FROM media");
            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(Integer id) throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("DELETE FROM media WHERE id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int change(Media media) throws SQLException, ParseException {
        PreparedStatement ps = null;
        try {
            if (media.getId() == 0) {
                ps = DatabaseConnectionDAO.connection().prepareStatement("INSERT INTO media (name, description, release_date) VALUES(?, ?, ?)");
                ps.setString(1, media.getName());
                ps.setString(2, media.getDescription());

                String dateString1 = media.getRelease().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);

                ps.setDate(3, new java.sql.Date(date.getTime()));
            } else {
                ps = DatabaseConnectionDAO.connection().prepareStatement("UPDATE media SET name = ?, description = ?, release_date = ? WHERE id = ?");
                ps.setString(1, media.getName());
                ps.setString(2, media.getDescription());
                String dateString1 = media.getRelease().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);
                ps.setDate(3, new java.sql.Date(date.getTime()));
                ps.setInt(4, media.getId());
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
