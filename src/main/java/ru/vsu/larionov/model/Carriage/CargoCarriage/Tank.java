package ru.vsu.larionov.model.Carriage.CargoCarriage;

import java.math.BigDecimal;

public class Tank extends CargoCarriage{
    private static final String SUBTYPE = "TANK";
    public Tank(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal carrying, BigDecimal volume) {
        super(weight, manufacturer, width, length, carrying, volume, SUBTYPE);
    }
}
