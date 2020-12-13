package ru.vsu.larionov.model.getFromDb;

import java.sql.SQLException;

public interface Getter<T> {
    T getFormDbById(Long id) throws SQLException;
}
