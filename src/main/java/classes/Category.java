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
public class Category {

    private String tableName = "category";

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
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

    public ResultSet index() throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement(String.format("SELECT * FROM %s", tableName));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
     public ResultSet delete(Integer id) throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement("DELETE FROM category WHERE id = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int change(Category category) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("category" + category.getId( ));
        try {
            if (category.getId() == 0) {
                ps = DatabaseConnection.connection().prepareStatement("INSERT INTO category (name) VALUES(?)");
                ps.setString(1, category.getName());
            } else {
                ps = DatabaseConnection.connection().prepareStatement("UPDATE category SET name = ? WHERE id = ?");
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
