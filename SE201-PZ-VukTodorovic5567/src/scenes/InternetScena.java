/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package scenes;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Vuk
 */
public class InternetScena extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Paragraf sa web stranice");

        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 400);

        Label paragrafLabel = new Label();
        root.getChildren().add(paragrafLabel);

        primaryStage.setScene(scene);
        primaryStage.show();

        scrapeParagraf(paragrafLabel);
    }

    private void scrapeParagraf(Label paragrafLabel) {
        String url = "https://www.esky.rs/prilike/80768/BEG-NYO-W6";

        try {
            Document doc = Jsoup.connect(url).get();

            Element paragraf = doc.selectFirst(".paragraph");
            if (paragraf != null) {
                String tekst = paragraf.text();
                tekst = wrapText(tekst, 100);
                paragrafLabel.setText(tekst);
            } else {
                paragrafLabel.setText("Nije pronađen paragraf na web stranici.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metoda za wrapovanje teksta za skrejpovani paragraf
    private String wrapText(String text, int wrapLength) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < text.length()) {
            sb.append(text, index, Math.min(index + wrapLength, text.length())).append("\n");
            index += wrapLength;
        }
        return sb.toString();
    }

}
