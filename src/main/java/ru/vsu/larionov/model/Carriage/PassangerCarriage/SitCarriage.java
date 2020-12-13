package ru.vsu.larionov.model.Carriage.PassangerCarriage;

import java.math.BigDecimal;

public class SitCarriage extends PassengerCarriage{
    private static final int DEFAULT_NUMBER_OF_SEATS = 80;
    private static final int DEFAULT_NUMBER_OF_FLOORS = 2;
    private static final int DEFAULT_NUMBER_OF_SEATS_IN_ROOM = 80;
    private static final String SUBTYPE = "SIT";
    public SitCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                       BigDecimal length) {
        super(weight, manufacturer, width, length, DEFAULT_NUMBER_OF_SEATS,DEFAULT_NUMBER_OF_FLOORS, DEFAULT_NUMBER_OF_SEATS_IN_ROOM, SUBTYPE);
    }
}
