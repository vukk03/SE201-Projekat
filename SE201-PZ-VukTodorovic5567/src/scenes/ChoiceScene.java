package scenes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static util.PrevoznoSredstvoCRUD.ispisPrevoza;
import util.DatabaseConnector;
import static util.DatabaseConnector.con;
import static util.VodicCRUD.*;

public class ChoiceScene extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Lista i Postojeće Scene");

        ObservableList<String> items = FXCollections.observableArrayList(
                "Obrisi vodica", "Prikazi sve vodice", "Dodaj prevoz", "Obrisi prevoz", "Prikazi sve prevoze");

        ListView<String> listView = new ListView<>(items);

        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {

                prikaziPostojecuScenu(selectedItem);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(listView);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private void prikaziPostojecuScenu(String selectedItem) {

        if (selectedItem.equals("")) {

            prikaziScenuStavke1();
        } else if (selectedItem.equals("Obrisi vodica")) {

            prikaziScenuStavke2();
        } else if (selectedItem.equals("Prikazi sve vodice")) {

            prikaziScenuStavke3();
        } else if (selectedItem.equals("Dodaj prevoz")) {

            prikaziScenuStavke4();
        } else if (selectedItem.equals("Obrisi prevoz")) {

            prikaziScenuStavke5();
        } else if (selectedItem.equals("Prikazi sve prevoze")) {
            prikaziScenuStavke6();
        } 
    }

    private void prikaziScenuStavke1() {
        primaryStage.close();
        new DodajVodica().start(primaryStage);
    }

    private void prikaziScenuStavke2() {
        primaryStage.close();
        new ObrisiVodica().start(primaryStage);
    }

    private void prikaziScenuStavke3() {
        Label podaciLabela = new Label();
        try {
            DatabaseConnector.getConnection();

            String podaci = ispisVodica();

            podaciLabela.setText(podaci);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        VBox novoRoot = new VBox(10);
        novoRoot.setPadding(new Insets(10));
        novoRoot.getChildren().addAll(podaciLabela);

        Scene novaScene = new Scene(novoRoot, 750, 750);
        Stage noviProzor = new Stage();
        noviProzor.setTitle("Prikaz vodica");

        noviProzor.setScene(novaScene);

        noviProzor.show();
    }

    private void prikaziScenuStavke4() {
        primaryStage.close();
        new DodajPrevoz().start(primaryStage);
    }

    private void prikaziScenuStavke5() {
        primaryStage.close();
        new ObrisiPrevoz().start(primaryStage);
    }

    private void prikaziScenuStavke6() {
        Label podaciLabela = new Label();
        try {
            DatabaseConnector.getConnection();

            String podaci = ispisPrevoza();

            podaciLabela.setText(podaci);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        VBox novoRoot = new VBox(10);
        novoRoot.setPadding(new Insets(10));
        novoRoot.getChildren().addAll(podaciLabela);

        Scene novaScene = new Scene(novoRoot, 750, 750);
        Stage noviProzor = new Stage();
        noviProzor.setTitle("Prikaz prevoza");

        noviProzor.setScene(novaScene);

        noviProzor.show();
    }

    private void prikaziScenuStavke7() {
        primaryStage.close();
        new InternetScena().start(primaryStage);
    }

}
