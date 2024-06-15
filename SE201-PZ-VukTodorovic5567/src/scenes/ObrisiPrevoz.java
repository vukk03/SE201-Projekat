/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package scenes;

import javafx.application.Application;
import static javafx.application.Application.launch;
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
import util.PrevoznoSredstvoCRUD;
import util.VodicCRUD;

/**
 *
 * @author Vuk
 */
public class ObrisiPrevoz extends Application {
    private static AlertDisplayer alertDisplayer;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Brisanje prevoza");

        Label label = new Label("Unesite ID prevoza za brisanje:");

        TextField prevozId = new TextField();
        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.ChoiceScene().start(primaryStage);
        });
        Button obrisiButton = new Button("Obriši");
        obrisiButton.setOnAction(e -> {
            if (alertDisplayer == null){
                alertDisplayer = new AlertDisplayer();
            }
            if (prevozId.getText().isEmpty()) {
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "Polje id ne moze biti prazno");
                return;
            }
            try {
                int idPrevoz = Integer.parseInt(prevozId.getText());
                PrevoznoSredstvoCRUD.ObrisiPrevoz(idPrevoz);                
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Nepravilan unos ID-ja prevoza.");
            } catch(Exception ex){
                ex.printStackTrace();
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Došlo je do greške prilikom brisanja prevoza.");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(label, prevozId, obrisiButton, backButton);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
     
    
}
