package ru.vsu.larionov.storage;

import ru.vsu.larionov.model.Train.Train;

import java.sql.SQLException;

public interface TrainStorage<T extends Train> extends Storable<T> {
    @Override
    T saveToDb() throws SQLException;
}
