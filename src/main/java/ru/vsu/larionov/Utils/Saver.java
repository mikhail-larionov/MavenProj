package ru.vsu.larionov.Utils;

import ru.vsu.larionov.model.Train.Train;

import java.sql.SQLException;
import java.util.Date;

public class Saver {
    public static Train saverTrainToDb(Train train) throws SQLException {
        train.setId(IdGenerator.generateId());
        for (int i = 0; i < train.getCarriages().size(); i++) {
            train.getCarriages().get(i).setId(IdGenerator.generateId());
            train.getCarriages().get(i).setTrainId(IdGenerator.generateId());
            train.getCarriages().get(i).saveToDb();
        }
        for (int i = 0; i < train.getLocomotives().size(); i++) {
            train.getLocomotives().get(i).setId(IdGenerator.generateId());
            train.getLocomotives().get(i).setTrainId(IdGenerator.generateId());
            train.getLocomotives().get(i).saveToDb();
        }
        train.saveToDb();
        return train;
    }
}
