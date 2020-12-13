package ru.vsu.larionov.main.Main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ru.vsu.larionov.connection.Client;

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
    public void update(Integer numberOfHangar, String s){
        if (numberOfHangar == 1){
            firstTrain.setText(s);

        }
    }
}
