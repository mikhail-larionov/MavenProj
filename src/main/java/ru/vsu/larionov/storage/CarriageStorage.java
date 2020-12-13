package ru.vsu.larionov.storage;

import ru.vsu.larionov.model.Carriage.Carriage;

import java.sql.SQLException;

public interface CarriageStorage<T extends Carriage> extends Storable<T>{
    @Override
    T saveToDb() throws SQLException;
}
