package ru.vsu.larionov.model.Constructor;

import ru.vsu.larionov.Utils.IdGenerator;
import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.model.Train.CargoTrain.CargoTrain;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CargoConstructor extends Constructor{

    public CargoConstructor(){
        train = new CargoTrain();
        train.setId(IdGenerator.generateId());
        trainId = train.getId();
    }

    public void addCloseCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                                      BigDecimal length, BigDecimal carrying, BigDecimal volume) throws SQLException {
        if (check()) {
            if (train instanceof CargoTrain) {
                    ((CargoTrain) train).addCloseCargoCarriage(weight, manufacturer, width, length, carrying, volume, trainId);
            } else throw new IllegalArgumentException();
        }
        else throw new IllegalStateException();
    }

    public void addOpenCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                                     BigDecimal length, BigDecimal carrying, BigDecimal volume) throws SQLException {
        if (check()) {
            if (train instanceof CargoTrain) {
                ((CargoTrain) train).addOpenCargoCarriage(weight, manufacturer, width, length, carrying, volume, trainId);
            } else throw new IllegalArgumentException();
        }
        else throw new IllegalStateException();
    }

    public void addTank(BigDecimal weight, String manufacturer, BigDecimal width,
                        BigDecimal length, BigDecimal carrying, BigDecimal volume) throws SQLException {
        if (check()) {
            if (train instanceof CargoTrain) {
                ((CargoTrain) train).addTank(weight, manufacturer, width, length, carrying, volume, trainId);
            } else throw new IllegalArgumentException();
        }
        else throw new IllegalStateException();
    }
}
