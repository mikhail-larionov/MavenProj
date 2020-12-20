package ru.vsu.larionov.main.Main;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.vsu.larionov.connection.Connection;
import ru.vsu.larionov.model.Constructor.Constructor;
import ru.vsu.larionov.model.Train.CargoTrain.CargoTrain;
import ru.vsu.larionov.model.Train.PassengerTrain.PassengerTrain;
import ru.vsu.larionov.model.Train.Train;

public class ConstructorController {
    Train train;
    @FXML
    private TextField text;

    @FXML
    private Button sendButton;

    @FXML
    private ComboBox<String> trainType;

    @FXML
    private ComboBox<String> carriageCargoType;

    @FXML
    private ComboBox<String> carriagePassengerType;

    @FXML
    private Button Accept;

    @FXML
    private Button Add;

    @FXML
    void initialize() {
        carriagePassengerType.setVisible(false);
        trainType.getItems().addAll("Cargo", "Passenger");
        carriageCargoType.getItems().addAll(
                "CloseCargo",
                "OpenCargo",
                "Tank",
                "Locomotive"
        );
        carriagePassengerType.getItems().addAll(
                "CoupeCarriage",
                "LuxuryCarriage",
                "RestaurantCarriage",
                "SitCarriage",
                "Locomotive"
        );
        Accept.setOnAction(event -> {
            text.setText("");
            if (trainType.getValue().equalsIgnoreCase("Cargo")){
                carriagePassengerType.setVisible(false);
                carriageCargoType.setVisible(true);
                train = new CargoTrain();
            }
            else {
                carriageCargoType.setVisible(false);
                carriagePassengerType.setVisible(true);
                train = new PassengerTrain();
            }
        });
        Add.setOnAction(event -> {
            if (trainType.getValue().equalsIgnoreCase("Cargo")) {
                train.addCarriage(CargoAdder.add(BigDecimal.valueOf(10), "Ural", BigDecimal.valueOf(30), BigDecimal.valueOf(100), BigDecimal.valueOf(43),
                        BigDecimal.valueOf(40), carriageCargoType.getValue()));
                text.appendText(CarriageGuiMap.getType().get(carriageCargoType.getValue()) + " ");
            }
            else {
                train.addCarriage(PassengerAdder.add(BigDecimal.TEN, "Ural", BigDecimal.ONE, BigDecimal.valueOf(24), carriagePassengerType.getValue()));
                text.appendText(CarriageGuiMap.getType().get(carriagePassengerType.getValue()) + " ");
            }
            if (carriagePassengerType.getValue().equalsIgnoreCase("Locomotive") ||
                    carriagePassengerType.getValue().equalsIgnoreCase("Locomotive"))
                train.addLocomotive(BigDecimal.TEN, "Ural", BigDecimal.ONE, BigDecimal.valueOf(24), BigDecimal.valueOf(100));
//                        .addLocomotive(LocomotiveAdder.add(BigDecimal.TEN, "Ural", BigDecimal.ONE, BigDecimal.valueOf(24), BigDecimal.valueOf(100)));
            System.out.println(train);
        });
        sendButton.setOnAction(event -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String string = objectMapper.writeValueAsString(train);
                Main.client.sentMessageForAll(string);
                train = null;
                text.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}