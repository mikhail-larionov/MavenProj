package ru.vsu.larionov.Utils.adders;

import ru.vsu.larionov.factory.Factory;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.*;

import java.math.BigDecimal;

public class PassengerAdder {
    public static PassengerCarriage add(BigDecimal weight, String manufacturer, BigDecimal width,
                                 BigDecimal length, String type){
        if (type.equalsIgnoreCase("CoupeCarriage"))
            return Factory.createCoupeCarriage(weight, manufacturer, width, length);
        if (type.equalsIgnoreCase("LuxuryCarriage"))
            return Factory.createLuxuryCarriage(weight, manufacturer, width, length);
        if (type.equalsIgnoreCase("RestaurantCarriage"))
            return Factory.createRestaurantCarriage(weight, manufacturer, width, length);
        if (type.equalsIgnoreCase("SitCarriage"))
            return Factory.createSitCarriage(weight, manufacturer, width, length);
        return null;
    }
}
