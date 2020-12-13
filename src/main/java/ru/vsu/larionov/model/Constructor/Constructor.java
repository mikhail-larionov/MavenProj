package ru.vsu.larionov.model.Constructor;

import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.model.Train.Train;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;

public abstract class Constructor {
    protected Train train = null;
    protected Long trainId;

    protected boolean check() {
        return train != null;
    }

    public void addLocomotive(BigDecimal weight, String manufacturer, BigDecimal width,
                              BigDecimal length, BigDecimal power) throws SQLException {
        if (check()) train.addLocomotive(weight, manufacturer, width, length, power, trainId);
    }

    public Train createTrain() throws SQLException {
        saveToDb();
        return train;
    }
    private void saveToDb() throws SQLException {
        try {
            if (check() & train.getLocomotives().size() > 0 & train.getCarriages().size() > 0) {
                train.saveToDb();
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException ex) {
            System.out.println("Поезд неправильно собран");
        }
    }
    public Train getTrain() {
        return train;
    }
}
