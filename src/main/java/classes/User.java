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
public class User {

    private String tableName = "user";
    private int id;
    private String name;
    private String CPF;
    private String birthday;
    private String email;
    private String password;

    public User(int id, String name, String CPF, String birthday, String email, String password) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    public User() {
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResultSet index() throws SQLException {
        PreparedStatement ps = DatabaseConnection.connection().prepareStatement(String.format("SELECT * FROM %s", tableName));
        ResultSet rs = ps.executeQuery();

        return rs;
    }

}
