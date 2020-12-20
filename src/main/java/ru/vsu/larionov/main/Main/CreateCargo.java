package ru.vsu.larionov.main.Main;

import ru.vsu.larionov.model.Carriage.CargoCarriage.CargoCarriage;

import java.math.BigDecimal;

public interface CreateCargo extends Create{
    CargoCarriage createCargo(BigDecimal weight, String manufacturer, BigDecimal width,
                              BigDecimal length, BigDecimal carrying, BigDecimal volume);
}
