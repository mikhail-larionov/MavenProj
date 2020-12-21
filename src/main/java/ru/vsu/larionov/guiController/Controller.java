package ru.vsu.larionov.guiController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ru.vsu.larionov.Utils.Saver;
import ru.vsu.larionov.Utils.Utils;
import ru.vsu.larionov.connection.Hangars;
import ru.vsu.larionov.main.Main.Main;
import ru.vsu.larionov.model.Train.Train;

public class Controller {
    ArrayList<TextArea> textAreas = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();
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
        textAreas.add(firstTrain);
        textAreas.add(secondTrain);
        textAreas.add(thirdTrain);
        textAreas.add(forthTrain);
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
        clearFields();
        hangars.getHangars().forEach((k, v) -> {
            textAreas.get(k).setText(v);

//            todo сделать нормальную отрисовку приходящих значений
        });
    }
//    private void draw(Integer hangar, String str) throws JsonProcessingException {
//        Train train = objectMapper.readValue(str, Train.class);
//        textAreas.get(hangar).setText("");
//        for (int i = 0; i < train.getLocomotives().size(); i++) {
//            textAreas.get(hangar).appendText(train.getLocomotives().get(i).getSubType() + " ");
//        }
//        for (int i = 0; i < train.getCarriages().size(); i++) {
//            textAreas.get(hangar).appendText(train.getCarriages().get(i).getSubType() + " ");
//
//        }
//    }
    private void clearFields(){
        for (int i = 0; i < textAreas.size(); i++) {
            textAreas.get(i).setText("");
        }
    }
}
