package ru.vsu.larionov.Utils.adders;

import ru.vsu.larionov.factory.Factory;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;

import java.math.BigDecimal;

public class LocomotiveAdder {
    public static Locomotive add(BigDecimal weight, String manufacturer, BigDecimal width,
                                 BigDecimal length, BigDecimal power){
        return Factory.createLocomotive(weight, manufacturer, width, length, power);

    }
}
