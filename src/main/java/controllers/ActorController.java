/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ActorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import models.Actor;

/**
 *
 * @author T-Gamer
 */
public class ActorController {

    public int save(int id, String name, String date, String height) throws SQLException, ParseException {
        Actor actor = new Actor();
        actor.setId(id);
        actor.setName(name);
        actor.setBirthday(date);
        actor.setHeight(Float.valueOf(height));

        ActorDAO dao = new ActorDAO();

        return ActorDAO.getInstance().change(actor);
    }

    public void delete(int id) throws SQLException {
        ActorDAO.getInstance().delete(id);
    }

    public ResultSet index() throws SQLException {
        return ActorDAO.getInstance().index();
    }
}
