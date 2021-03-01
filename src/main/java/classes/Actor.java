/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
