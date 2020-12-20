package ru.vsu.larionov.main.Main;

import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.*;

import java.math.BigDecimal;

public class PassengerAdder {
    public static PassengerCarriage add(BigDecimal weight, String manufacturer, BigDecimal width,
                                 BigDecimal length, String type){
        if (type.equalsIgnoreCase("CoupeCarriage"))
            return new CoupeCarriage(weight, manufacturer, width, length);
        if (type.equalsIgnoreCase("LuxuryCarriage"))
            return new LuxuryCarriage(weight, manufacturer, width, length);
        if (type.equalsIgnoreCase("RestaurantCarriage"))
            return new RestaurantCarriage(weight, manufacturer, width, length);
        if (type.equalsIgnoreCase("SitCarriage"))
            return new SitCarriage(weight, manufacturer, width, length);
        return null;
    }
}
