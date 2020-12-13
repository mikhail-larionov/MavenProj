package ru.vsu.larionov.model.Carriage.CargoCarriage;

import java.math.BigDecimal;

public class CloseCargoCarriage extends CargoCarriage{
    private static final String SUBTYPE = "CLOSE_CARGO";
    public CloseCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                              BigDecimal length, BigDecimal carrying, BigDecimal volume) {
        super(weight, manufacturer, width, length, carrying, volume, SUBTYPE);
    }
}
