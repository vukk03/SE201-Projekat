/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package scenes;

import entiteti.PrevoznoSredstvo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.AlertDisplayer;
import util.PrevoznoSredstvoCRUD;

/**
 *
 * @author Vuk
 */
public class DodajPrevoz extends Application {

    private TextField prevozIdField;
    private TextField tipSredstvaField;
    private TextField brojMestaField;
    private TextField brojSlobodnihMestaField;

    private static AlertDisplayer alertDisplayer;

    @Override
    public void start(Stage primaryStage) {
        alertDisplayer = new AlertDisplayer();
        prevozIdField = new TextField();
        tipSredstvaField = new TextField();
        brojMestaField = new TextField();
        brojSlobodnihMestaField = new TextField();

        Label prevozIdLabel = new Label("Prevoz id");
        Label tipSredstvaLabel = new Label("Tip sredstva:");
        Label brojMestaLabel = new Label("Broj mesta:");
        Label brojSlobodnihMestaLabel = new Label("Broj slobodnih mesta:");

        Button dodajButton = new Button("Dodaj prevoz");
        dodajButton.setOnAction(e -> {

    
            if (prevozIdField.getText().isEmpty()) {
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Polje id ne moze biti prazno");
                return;
            } else {
                try {
                    int idPrevoz = Integer.parseInt(prevozIdField.getText());
                    String tipSredstva = tipSredstvaField.getText();
                    int mesta = Integer.parseInt(brojMestaField.getText());
                    int slobodnaMesta = Integer.parseInt(brojSlobodnihMestaField.getText());

                    PrevoznoSredstvo prevoznoSredstvo = new PrevoznoSredstvo(idPrevoz, tipSredstva, mesta, slobodnaMesta);
                    PrevoznoSredstvoCRUD.DodajPrevoz(prevoznoSredstvo);
                } catch (NumberFormatException ex) {
                
                    alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Nije moguce parsirati");
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
                prevozIdLabel, prevozIdField,
                tipSredstvaLabel, tipSredstvaField,
                brojMestaLabel, brojMestaField,
                brojSlobodnihMestaLabel, brojSlobodnihMestaField,
                dodajButton,
                backButton
        );

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Dodavanje prevoza");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
