/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.MediaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import models.Media;

/**
 *
 * @author T-Gamer
 */
public class MediaController {

    public int save(int id, String name, String description, String release) throws SQLException, ParseException {
        Media media = new Media();
        media.setId(id);
        media.setName(name);
        media.setDescription(description);
        media.setRelease(release);

        MediaDAO dao = new MediaDAO();

        return MediaDAO.getInstance().change(media);
    }

    public void delete(int id) throws SQLException {
        MediaDAO.getInstance().delete(id);
    }

    public ResultSet index() throws SQLException {
        return MediaDAO.getInstance().index();
    }
}
