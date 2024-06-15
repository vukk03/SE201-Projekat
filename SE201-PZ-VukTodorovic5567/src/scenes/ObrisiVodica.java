package scenes;

import entiteti.Vodic;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import util.VodicCRUD;

public class ObrisiVodica extends Application {
    private static AlertDisplayer alertDisplayer;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Brisanje vodica");

        Label label = new Label("Unesite id vodica za brisanje:");

        TextField vodicidField = new TextField();
        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.ChoiceScene().start(primaryStage);
        });

        Button obrisiButton = new Button("Obriši");
        obrisiButton.setOnAction(e -> {
            if (alertDisplayer ==null){
                alertDisplayer= new AlertDisplayer();
            }
            if (vodicidField.getText().isEmpty()) {
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greska!", "Polje id ne moze biti prazno");
                return;
            }
            try {
                int idVodic = Integer.parseInt(vodicidField.getText());
                VodicCRUD.obrisiVodica(idVodic);                
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Nepravilan unos id-a.");
            } catch(Exception ex){
                ex.printStackTrace();
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Greška", "Došlo je do greške prilikom brisanja vodica.");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(label, vodicidField, obrisiButton,backButton);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
}
