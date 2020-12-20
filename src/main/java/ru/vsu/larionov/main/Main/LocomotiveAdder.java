package ru.vsu.larionov.main.Main;

import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;

import java.math.BigDecimal;

public class LocomotiveAdder {
    public static Locomotive add(BigDecimal weight, String manufacturer, BigDecimal width,
                                 BigDecimal length, BigDecimal power){
        return new Locomotive(weight, manufacturer, width, length, power);

    }
}
