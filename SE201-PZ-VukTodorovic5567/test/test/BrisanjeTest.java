///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package test;
//
//import entiteti.PrevoznoSredstvo;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import util.PrevoznoSredstvoCRUD;
//import util.DatabaseConnector;
//import static util.DatabaseConnector.con;
//import java.sql.*;
//
///**
// *
// * @author Vuk
// */
//public class BrisanjeTest {
//
//    @Test
//    public void brisanjeTest() throws SQLException {
//        int prevozId = 11;
//        DatabaseConnector.openConnection();
//        PrevoznoSredstvo avion = new PrevoznoSredstvo(11, "avion", 10, 2);
//
//        PrevoznoSredstvoCRUD.DodajPrevoz(avion);
//        DatabaseConnector.openConnection();
//        PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT PREVOZID FROM prevoznosredstvo WHERE PREVOZID = 11");
//        ResultSet resultSet = st.executeQuery();
//
//        PreparedStatement dt = DatabaseConnector.con.prepareStatement("DELETE FROM prevoznosredstvo WHERE PREVOZID = ?");
//        dt.setInt(1, prevozId);
//        int rowsAffected = dt.executeUpdate();
//        assertTrue(rowsAffected > 0);
//        dt.execute();
//        con.close();
//
//    }
//}
