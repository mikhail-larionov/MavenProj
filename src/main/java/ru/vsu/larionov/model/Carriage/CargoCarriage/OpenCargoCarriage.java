package ru.vsu.larionov.model.Carriage.CargoCarriage;

import java.math.BigDecimal;

public class OpenCargoCarriage extends CargoCarriage {
    private static final String SUBTYPE = "OPEN_CARGO";
    public OpenCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                             BigDecimal length, BigDecimal carrying, BigDecimal volume) {
        super(weight, manufacturer, width, length, carrying, volume, SUBTYPE);
    }
}
