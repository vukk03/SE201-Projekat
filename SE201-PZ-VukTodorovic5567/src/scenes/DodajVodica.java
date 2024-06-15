/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package scenes;

import entiteti.Vodic;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.AlertDisplayer;
import util.DatabaseConnector;
import util.VodicCRUD;

/**
 *
 * @author Vuk
 */
public class DodajVodica extends Application {

    private TextField vodicidField;
    private TextField turistickaAgencijaIdField;
    private TextField imeField;
    private TextField prezimeField;
    private TextField starostField;
    private TextField godineRadaField;
    private static AlertDisplayer alertDisplayer;

    @Override
    public void start(Stage primaryStage) {
        alertDisplayer = new AlertDisplayer();
        vodicidField = new TextField();
        turistickaAgencijaIdField = new TextField();
        imeField = new TextField();
        prezimeField = new TextField();
        starostField = new TextField();
        godineRadaField = new TextField();

        Label vodicidLabel = new Label("ID vodica:");
        Label turistickaAgencijaIdLabel = new Label("ID agencije:");
        Label imeLabel = new Label("Ime:");
        Label prezimeLabel = new Label("Prezime:");
        Label starostLabel = new Label("Godine:");
        Label godineRadaLabel = new Label("godine Rada:");

        Button dodajButton = new Button("Dodaj vodica");
        dodajButton.setOnAction(e -> {

            if (vodicidField.getText().isEmpty()) {
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Polje id ne moze biti prazno");
                return;
            } else {
                try {
                    int idVodic = Integer.parseInt(vodicidField.getText());
                    int turistickaAgencijaId = Integer.parseInt(turistickaAgencijaIdField.getText());
                    String imeVodica = imeField.getText();
                    String prezimeVodica = prezimeField.getText();
                    int starost = Integer.parseInt(starostField.getText());
                    int godineRada = Integer.parseInt(godineRadaField.getText());

                    Vodic vodic = new Vodic(idVodic, turistickaAgencijaId, imeVodica, prezimeVodica, starost, godineRada);
                    VodicCRUD.dodajVodica(vodic);
                } catch (NumberFormatException ex) {
                    alertDisplayer.showAlertMet(Alert.AlertType.ERROR  , "Greska!", "Nije moguce dodati");
                } catch (Exception ex) {
                    alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "Neispravno unet vodic");
                }
            }

        });
        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.ChoiceScene().start(primaryStage);
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                vodicidLabel, vodicidField,
                turistickaAgencijaIdLabel, turistickaAgencijaIdField,
                imeLabel, imeField,
                prezimeLabel, prezimeField,
                starostLabel, starostField,
                godineRadaLabel, godineRadaField,
                dodajButton,
                backButton
        );

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Dodavanje vodica");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    

}
