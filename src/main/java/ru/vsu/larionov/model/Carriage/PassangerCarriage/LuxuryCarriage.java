package ru.vsu.larionov.model.Carriage.PassangerCarriage;

import java.math.BigDecimal;

public class LuxuryCarriage extends PassengerCarriage {

    private static final int DEFAULT_NUMBER_OF_SEATS = 20;
    private static final int DEFAULT_NUMBER_OF_FLOORS = 1;
    private static final int DEFAULT_NUMBER_OF_SEATS_IN_ROOM = 0;
    private static final String SUBTYPE = "LUXURY";
    public LuxuryCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                          BigDecimal length) {
        super(weight, manufacturer, width, length, DEFAULT_NUMBER_OF_SEATS,DEFAULT_NUMBER_OF_FLOORS,DEFAULT_NUMBER_OF_SEATS_IN_ROOM, SUBTYPE);
    }

}
