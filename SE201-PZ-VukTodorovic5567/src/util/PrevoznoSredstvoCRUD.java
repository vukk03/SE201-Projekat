/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import entiteti.PrevoznoSredstvo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import static util.DatabaseConnector.con;

/**
 *
 * @author Vuk
 */
public class PrevoznoSredstvoCRUD {

    private static AlertDisplayer alertDisplayer;

    public static void DodajPrevoz(PrevoznoSredstvo prevoznoSredstvo) {
        if (alertDisplayer == null) {
            alertDisplayer = new AlertDisplayer();
        }
        try {
            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("INSERT INTO `prevoznosredstvo`(`PREVOZID`, `TIPSREDSTVA`, `BROJMESTA`, `BROJSLOBODNIHMESTA`)" + " VALUES (?,?,?,?)");
            st.setInt(1, prevoznoSredstvo.getPrevozId());
            st.setString(2, prevoznoSredstvo.getTipSredstva());
            st.setInt(3, prevoznoSredstvo.getBrojMesta());
            st.setInt(4, prevoznoSredstvo.getBrojSlobodnihMesta());


            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                 alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Uspesno!", "Uspesno ste dodali sredstvo.");
            } else {
                 alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "sredstvo nije uspesno dodato.");
            }           
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "sredstvo nije uspesno dodato.");
        }
    }

    public static String ispisPrevoza() throws SQLException {
        StringBuilder rezultat=new StringBuilder(); 
        if (alertDisplayer == null) {
            alertDisplayer = new AlertDisplayer();
        }
        ResultSet resultSet = null;
        try {
            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT * FROM prevoznosredstvo");

            resultSet = st.executeQuery();
            while (resultSet.next()) {
                int idPrevoz = resultSet.getInt("PREVOZID");
                String tipSredstva = resultSet.getString("TIPSREDSTVA");
                int mesta = resultSet.getInt("BROJMESTA");
                int slobodnaMesta = resultSet.getInt("BROJSLOBODNIHMESTA");

                rezultat.append("PREVOZID: ").append(idPrevoz).append(", TIPSREDSTVA: ").append(tipSredstva).append(", BROJMESTA: ").append(mesta).append(", BROJSLOBODNIHMESTA: ").append(slobodnaMesta).append("\n").append("\n");
                
                
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "Tabela nije uspesno prikazana!");
        }
        
        return rezultat.toString();
    }

    public static void ObrisiPrevoz(int prevozId) throws SQLException {
        if (alertDisplayer == null) {
            alertDisplayer = new AlertDisplayer();
        }
        try {
            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("DELETE FROM prevoznosredstvo WHERE PREVOZID = ?");
            st.setInt(1, prevozId);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                 alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Uspesno!", "Uspesno ste obrisali prevoz.");
            } else {
                 alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "Niste uspesno obrisali prevoz!");
            }
            st.execute();
            con.close();
        } catch (SQLException ex) {
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "prevoz nije uspesno obrisan.");
        }
    }

    public static void dodajPrevoz(PrevoznoSredstvo avion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
