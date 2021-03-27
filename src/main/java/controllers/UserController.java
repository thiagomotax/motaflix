/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import models.User;

/**
 *
 * @author T-Gamer
 */
public class UserController {
     public int save(int id, String name, String cpf, String birthday, String email, String password, int parental) throws SQLException, ParseException{
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCPF(cpf);
        user.setEmail(email);
        user.setPassword(password);
        user.setBirthday(birthday);
        user.setParental_id(parental);
        UserDAO dao = new UserDAO();
        
        return UserDAO.getInstance().change(user);
    }
     
    public void delete(int id) throws SQLException{
        UserDAO.getInstance().delete(id);
    }
    
    public ResultSet index() throws SQLException{
        return UserDAO.getInstance().index();
    }
}
