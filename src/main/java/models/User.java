/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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

    private int id;
    private String name;
    private String CPF;
    private String birthday;
    private String email;
    private String password;
    private int parental_id;

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

    public int getParental_id() {
        return parental_id;
    }

    public void setParental_id(Integer parental_id) {
        this.parental_id = parental_id;
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

}
