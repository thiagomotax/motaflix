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
public class Media {

    private String tableName = "media";
    private int id;
    private String name;
    private String description;
    private String release;
    //include categories,actors, etc

    public Media(int id, String name, String description, String release) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.release = release;
    }

    public Media() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public ResultSet index() throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement(String.format("SELECT * FROM %s", tableName));
        ResultSet rs = ps.executeQuery();

        return rs;
    }

    public ResultSet delete(Integer id) throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement("DELETE FROM media WHERE id = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int change(Media media) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("media" + media.getId());
        try {
            if (media.getId() == 0) {
                ps = DatabaseConnection.connection().prepareStatement("INSERT INTO media (name, description, release_date) VALUES(?, ?, ?)");
                ps.setString(1, media.getName());
                ps.setString(2, media.getDescription());

                String dateString1 = media.getRelease().replace("/", "-");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString1);

                ps.setDate(3, new java.sql.Date(date.getTime()));
            } else {
                ps = DatabaseConnection.connection().prepareStatement("UPDATE media SET name = ?, description = ?, release_date = ? WHERE id = ?");
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
