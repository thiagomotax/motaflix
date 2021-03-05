/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    private int parental_id;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getParental_id() {
        return parental_id;
    }

    public void setParental_id(Integer parental_id) {
        this.parental_id = parental_id;
    }

    public User(int id, String name, String CPF, String birthday, String email, String password, Integer parental_id) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.parental_id = parental_id;
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
