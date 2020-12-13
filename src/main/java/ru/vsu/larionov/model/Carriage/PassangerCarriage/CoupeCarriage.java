package ru.vsu.larionov.model.Carriage.PassangerCarriage;

import ru.vsu.larionov.model.Carriage.Carriage;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CoupeCarriage extends PassengerCarriage{
    private static final int DEFAULT_NUMBER_OF_SEATS = 40;
    private static final int DEFAULT_NUMBER_OF_FLOORS = 1;
    private static final int DEFAULT_NUMBER_OF_SEATS_IN_ROOM = 4;
    private static final String SUBTYPE = "COUPE";
    public CoupeCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length) {
        super(weight, manufacturer, width, length, DEFAULT_NUMBER_OF_SEATS, DEFAULT_NUMBER_OF_FLOORS, DEFAULT_NUMBER_OF_SEATS_IN_ROOM, SUBTYPE);
    }



}
