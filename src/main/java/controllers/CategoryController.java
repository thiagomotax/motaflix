/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import models.Category;

/**
 *
 * @author T-Gamer
 */
public class CategoryController {

    public int save(int id, String name) throws SQLException, ParseException {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        CategoryDAO dao = new CategoryDAO();

        return CategoryDAO.getInstance().change(category);
    }

    public void delete(int id) throws SQLException {
        CategoryDAO.getInstance().delete(id);
    }
    
     public ResultSet index() throws SQLException{
        return CategoryDAO.getInstance().index();
    }
}
