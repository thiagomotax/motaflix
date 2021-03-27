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
import models.Actor;

/**
 *
 * @author T-Gamer
 */
public class ActorDAO {

    private static ActorDAO instance;

    public static ActorDAO getInstance() {
        if (instance == null) {
            instance = new ActorDAO();
        }
        return instance;
    }

    public ActorDAO() {
    }

    public ResultSet index() throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("SELECT * FROM actor");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(Integer id) throws SQLException {
        try {
            PreparedStatement ps = DatabaseConnectionDAO.connection().prepareStatement("DELETE FROM actor WHERE id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int change(Actor actor) throws SQLException, ParseException {
        PreparedStatement ps = null;
        try {
            if (actor.getId() == 0) {
                ps = DatabaseConnectionDAO.connection().prepareStatement("INSERT INTO actor (name, birthday, height) VALUES(?, ?, ?)");
                ps.setString(1, actor.getName());

                String dateString1 = actor.getBirthday().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);

                ps.setDate(2, new java.sql.Date(date.getTime()));

                ps.setFloat(3, actor.getHeight());
            } else {
                ps = DatabaseConnectionDAO.connection().prepareStatement("UPDATE actor SET name = ?, birthday = ?, height = ? WHERE id = ?");
                ps.setString(1, actor.getName());
                String dateString1 = actor.getBirthday().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);
                ps.setDate(2, new java.sql.Date(date.getTime()));
                ps.setFloat(3, actor.getHeight());
                ps.setInt(4, actor.getId());
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
