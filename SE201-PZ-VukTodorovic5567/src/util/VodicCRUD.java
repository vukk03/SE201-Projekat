/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;
import entiteti.Vodic;
import javafx.scene.control.Alert;
import static util.DatabaseConnector.con;

/**
 *
 * @author Vuk
 */
public class VodicCRUD {

    private static AlertDisplayer alertDisplayer;

    public static void dodajVodica(Vodic vodic) {
        if (alertDisplayer == null) {
            alertDisplayer = new AlertDisplayer();
        }

        try {
            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("INSERT INTO `vodic`(`VODICID`, `TURISTICKA_AGENCIJA_ID`, `IME`, `PREZIME`, `STAROST`, `GODINERADA`)" + " VALUES (?,?,?,?,?,?)");
            st.setInt(1, vodic.getVodicId());
            st.setInt(2, vodic.getTuristickaAgencijaId());
            st.setString(3, vodic.getIme());
            st.setString(4, vodic.getPrezime());
            st.setInt(5, vodic.getStarost());
            st.setInt(6, vodic.getGodineRada());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Uspesno!", "Uspesno ste dodali vodica.");
            } else {
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Dodavanje vodica nije uspelo.");
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Dodavanje vodica nije uspelo.");
        }
    }
    
    //Metoda za ispis u bazu

    public static String ispisVodica() throws SQLException {
        StringBuilder rezultat= new StringBuilder();
        ResultSet resultSet = null;
        try {
            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT * FROM vodic");

            resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id_vodica = resultSet.getInt("VODICID");
                int turistickaAgencijaId = resultSet.getInt("TURISTICKA_AGENCIJA_ID");
                String imeVodica = resultSet.getString("IME");
                String prezimeVodica = resultSet.getString("PREZIME");
                int starost = resultSet.getInt("STAROST");
                int godineRada = resultSet.getInt("GODINERADA");

                rezultat.append("Vodic id: ").append(id_vodica).append(", Id agencije: ").append(turistickaAgencijaId).append(", Ime: ").append(starost).append(", Prezime: ").append(imeVodica).append(", Starost: ").append(prezimeVodica).append(", Iskustvo: ").append(godineRada).append("\n").append("\n");

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Prikaz vodica nije uspeo.");
        }
        return rezultat.toString();
    }
    
    //Metoda za brisanje zivotinja
    public static void obrisiVodica(int idVodic) throws SQLException {
        if (alertDisplayer == null) {
            alertDisplayer = new AlertDisplayer();
        }
        try {
            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("DELETE FROM vodic WHERE VODICID = ?");
            st.setInt(1, idVodic);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Uspesno!", "Uspesno ste obrisali vodica.");
            } else {
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Nema podataka za brisanje.");
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Dodavanje vodica nije uspelo.");
        }
    }
}
