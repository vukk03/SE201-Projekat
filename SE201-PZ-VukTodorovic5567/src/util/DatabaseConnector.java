/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author Vuk
 */
public class DatabaseConnector {

    public static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/aviotickets";
    private static String username = "root";
    private static String password = "";

    public static void getConnection(){
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url,username, password);
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}
