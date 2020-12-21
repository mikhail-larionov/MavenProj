package ru.vsu.larionov.guiController;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.vsu.larionov.Utils.Saver;
import ru.vsu.larionov.Utils.adders.CargoAdder;
import ru.vsu.larionov.Utils.adders.PassengerAdder;
import ru.vsu.larionov.main.Main.Main;
import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Train.CargoTrain.CargoTrain;
import ru.vsu.larionov.model.Train.PassengerTrain.PassengerTrain;
import ru.vsu.larionov.model.Train.Train;

public class ConstructorController {
    ArrayList<Carriage> last;
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
    private Button deleteLast;

    @FXML
    private Button saveButton;

    @FXML
    void initialize() {
        last = new ArrayList<>();
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
            try {
                if (trainType.getValue().equalsIgnoreCase("Cargo")) {
                    carriagePassengerType.setVisible(false);
                    carriageCargoType.setVisible(true);
                    train = new CargoTrain();
                } else {
                    carriageCargoType.setVisible(false);
                    carriagePassengerType.setVisible(true);
                    train = new PassengerTrain();
                }
            }
            catch (NullPointerException exception){
                getAlert("Выберите тип поезда");
            }
        });

        Add.setOnAction(event -> {
            try {
                if (trainType.getValue().equalsIgnoreCase("Cargo")) {
                    if (carriageCargoType.getValue().equalsIgnoreCase("Locomotive")) {
                        try {
                            Locomotive locomotive = train.addLocomotive(BigDecimal.TEN, "Ural", BigDecimal.ONE, BigDecimal.valueOf(24), BigDecimal.valueOf(100));
                            last.add(locomotive);
                        } catch (IllegalArgumentException ex) {
                            getAlert("Слишком много локомотивов");
                        }
                    } else {

                        Carriage carriage = train.addCarriage(CargoAdder.add(BigDecimal.valueOf(10), "Ural", BigDecimal.valueOf(30), BigDecimal.valueOf(100), BigDecimal.valueOf(43),
                                BigDecimal.valueOf(40), carriageCargoType.getValue()));
                        last.add(carriage);
                    }
                } else {
                    if (carriagePassengerType.getValue().equalsIgnoreCase("Locomotive")) {
                        try {
                            Locomotive locomotive = train.addLocomotive(BigDecimal.TEN, "Ural", BigDecimal.ONE, BigDecimal.valueOf(24), BigDecimal.valueOf(100));
                            last.add(locomotive);
                        } catch (IllegalArgumentException ex) {
                            getAlert("Слишком много Локомотивов");
                        }
                    } else {
                        Carriage carriage = train.addCarriage(PassengerAdder.add(BigDecimal.TEN, "Ural", BigDecimal.ONE, BigDecimal.valueOf(24), carriagePassengerType.getValue()));
                        last.add(carriage);
                    }
                }
                repaint();
                System.out.println(train);
            }
            catch (NullPointerException ex){
                getAlert("Не выбран тип поезда или тип вагона");
            }
        });

        sendButton.setOnAction(event -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String string = objectMapper.writeValueAsString(train);
                System.out.println(string);
                if (checkTrain()) {
                    Main.client.sentMessageForAll(string);
                    train = null;
                    last.clear();
                    text.setText("");
                } else {
                    getAlert("Поезд создан неправильно");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        deleteLast.setOnAction(event -> {
            if (last.size() > 0) {
                train.removeLast(last.get(last.size() - 1));
                last.remove(last.size() - 1);
                repaint();
            }
        });

        saveButton.setOnAction(event -> {
            try {
                if (checkTrain()) {
                    Saver.saverTrainToDb(train);
                }
                else getAlert("Поезд собран некорректно");
            } catch (SQLException exception) {
                getAlert("Не удалось подключиться к бд");
            }

        });
    }

    private void repaint() {
        text.setText("");
        for (int i = 0; i < train.getLocomotives().size(); i++) {
            text.appendText(train.getLocomotives().get(i).getSubType() + " ");
        }
        for (int i = 0; i < train.getCarriages().size(); i++) {
            text.appendText(train.getCarriages().get(i).getSubType() + " ");
        }
    }

    public void getAlert(String string) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(string);
        alert.showAndWait();
    }
    private boolean checkTrain(){
        return train != null && train.getLocomotives().size() < 3 && train.getLocomotives().size() > 0;
    }
}