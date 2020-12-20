package ru.vsu.larionov.main.Main;

import ru.vsu.larionov.model.Carriage.PassangerCarriage.PassengerCarriage;

import java.math.BigDecimal;

public interface CreatePassenger extends Create {
    PassengerCarriage createPassenger(BigDecimal weight, String manufacturer, BigDecimal width,
                                      BigDecimal length);
}
