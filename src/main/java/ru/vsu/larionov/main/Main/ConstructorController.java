package ru.vsu.larionov.main.Main;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.vsu.larionov.connection.Connection;
import ru.vsu.larionov.model.Constructor.Constructor;

public class ConstructorController {

    @FXML
    private TextField text;

    @FXML
    private Button sendButton;

    @FXML
    void initialize() {
        sendButton.setOnAction(event -> {
            try {
                Main.client.sentMessageForAll(text.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}