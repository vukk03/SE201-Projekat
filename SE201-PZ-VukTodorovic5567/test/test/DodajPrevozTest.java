/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import entiteti.PrevoznoSredstvo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import util.PrevoznoSredstvoCRUD;
import util.DatabaseConnector;

/**
 *
 * @author Vuk
 */
public class DodajPrevozTest {
    
   
     @Test
     public void dodajPrevoz() throws SQLException {
        DatabaseConnector.openConnection();
        PrevoznoSredstvo avion = new PrevoznoSredstvo(11, "Avion", 10, 2);

        PrevoznoSredstvoCRUD.DodajPrevoz(avion);
        DatabaseConnector.openConnection();
        PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT PREVOZID FROM prevoznosredstvo WHERE PREVOZID = 11");
        ResultSet resultSet = st.executeQuery();

        assertTrue(resultSet.next());

        DatabaseConnector.closeConnection();
     }
}
