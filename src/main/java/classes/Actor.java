/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author thiag
 */
public class Actor {
    private String tableName = "actor";
    private int id;
    private String name;
    private String birthday;
    private float height;

    public Actor(int id, String name, String birthday, float height) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.height = height;
    }

    public Actor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement(String.format("SELECT * FROM %s", tableName));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
      public ResultSet delete(Integer id) throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement("DELETE actor user WHERE id = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int change(Actor actor) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("actor" + actor.getId( ));
        try {
            if (actor.getId() == 0) {
                ps = DatabaseConnection.connection().prepareStatement("INSERT INTO actor (name, birthday, height) VALUES(?, ?, ?)");
                ps.setString(1, actor.getName());

                String dateString1 = actor.getBirthday().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);

                ps.setDate(2, new java.sql.Date(date.getTime()));

                ps.setFloat(3, actor.getHeight());
            } else {
                ps = DatabaseConnection.connection().prepareStatement("UPDATE actor SET name = ?, birthday = ?, height = ? WHERE id = ?");
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
