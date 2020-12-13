package ru.vsu.larionov.storage;

import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Train.Train;

import java.sql.SQLException;

public interface Storable <T> {

    T saveToDb() throws SQLException;

}
