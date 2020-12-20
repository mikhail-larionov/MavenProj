package ru.vsu.larionov.main.Main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ru.vsu.larionov.DTO;
import ru.vsu.larionov.connection.Client;
import ru.vsu.larionov.connection.Hangars;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  Button init;

    @FXML
    private TextArea firstTrain;

    @FXML
    private TextArea secondTrain;

    @FXML
    private TextArea thirdTrain;

    @FXML
    private TextArea forthTrain;

    @FXML
    void initialize() {
        Main.controller = this;
        init.setOnAction(event -> {
            URL url = null;
            Main.controller = this;
            try {
                url = new File("src/main/resources/constructor.fxml").toURI().toURL();
//                init.getScene().getWindow().hide();
            } catch (MalformedURLException e) {
                throw new RuntimeException();
            }
            try {
                Parent root = FXMLLoader.load(url);
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 600, 400));
                stage.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        });
    }
    public void update(Hangars hangars){
        hangars.getHangars().forEach((k, v) -> {
            if (k == 0){
                firstTrain.setText(v);
            }
            if (k == 1){
                secondTrain.setText(v);
            }
            if (k == 3){
                thirdTrain.setText(v);
            }
            if (k == 4){
                forthTrain.setText(v);
            }
        });
    }
}
