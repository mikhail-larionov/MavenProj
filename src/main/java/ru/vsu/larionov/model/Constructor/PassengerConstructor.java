package ru.vsu.larionov.model.Constructor;

import ru.vsu.larionov.Utils.IdGenerator;
import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.model.Train.PassengerTrain.PassengerTrain;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.sql.SQLException;


public class PassengerConstructor extends Constructor{

    public PassengerConstructor(){
            train = new PassengerTrain();
            train.setId(IdGenerator.generateId());
            trainId = train.getId();

    }

    public Train getTrain() {
        return train;
    }
    public void addLocomotive(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal power) throws SQLException {
        if (check()) {
            train.addLocomotive(weight, manufacturer, width, length, power, trainId);
        }
        else throw new IllegalStateException("Нет поезда");
    }
    public void addCoupeCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length) throws SQLException {
        if (check()) {
            if (train instanceof PassengerTrain) {
                ((PassengerTrain) train).addCoupeCarriage(weight, manufacturer, width, length, trainId);
            } else throw new IllegalArgumentException("Неверные данные");
        }
        else throw new IllegalStateException();
    }
    public void addLuxuryCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                                  BigDecimal length) throws SQLException {
        if (check()) {
            if (train instanceof PassengerTrain) {
                ((PassengerTrain) train).addLuxuryCarriage(weight, manufacturer, width, length, trainId);
            } else throw new IllegalArgumentException("Неверные данные");
        }
        else throw new IllegalStateException();
    }

    public void addRestaurantCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length) throws SQLException {
        if (check()) {
            if (train instanceof PassengerTrain) {
                ((PassengerTrain) train).addRestaurantCarriage(weight, manufacturer, width, length, trainId);
            } else throw new IllegalArgumentException("Неверные данные");
        }
        else throw new IllegalStateException();
    }

    public void addSitCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length) throws SQLException {
        if (check()) {
            if (train instanceof PassengerTrain) {
                ((PassengerTrain) train).addSitCarriage(weight, manufacturer, width, length, trainId);
            } else throw new IllegalArgumentException("Неверные данные");
        }
        else throw new IllegalStateException();
    }

}
