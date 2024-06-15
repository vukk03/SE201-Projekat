/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;
import static util.DatabaseConnector.con;

/**
 *
 * @author Vuk
 */
public class SortiranjeBaze {

    private static final String URL = "jdbc:mysql://localhost:3306/aviotickets";
    private static final String USER = "root";
    private static final String PASSWORD = "";

//    public static void sortiranjeBaze(String tabela, String kolona, String nacin) throws SQLException {
//        try {
//            DatabaseConnector.getConnection();
//            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT * FROM " + tabela + " ORDER BY " + kolona + " " + nacin);
//            ResultSet resultSet = st.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt(tabela);
//                String sortiranaKolona = resultSet.getString(kolona);
//
//                System.out.println("Id: " + id + " " + kolona + ":" + sortiranaKolona);
//
//            }
//            con.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    public static void sortTable(String tableName, String columnName, String sortOrder) throws SQLException {
        // Povezivanje s bazom podataka
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM " + tableName + " ORDER BY " + columnName + " " + sortOrder;

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(columnName));
                    }
                }
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
