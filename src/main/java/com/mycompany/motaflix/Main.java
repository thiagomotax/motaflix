/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motaflix;

import com.mysql.jdbc.Connection;
import classes.DatabaseConnection;
import screens.FormUser;
import screens.Home;
import mdlaf.*;
import mdlaf.animation.*;
import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.EmptyBorder;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialOceanicTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.utils.MaterialColors;

/**
 *
 * @author thiag
 */
public class Main {

    public static void main(String[] args) throws SQLException {
       

        try {
            MaterialLookAndFeel material = new MaterialLookAndFeel(new JMarsDarkTheme());
            UIManager.setLookAndFeel(material);

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Home frameForm = new Home();

        frameForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameForm.setVisible(true);

    }

}
