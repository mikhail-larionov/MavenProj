package ru.vsu.larionov.Utils.adders;

import ru.vsu.larionov.factory.Factory;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CloseCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.OpenCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.Tank;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.PassengerCarriage;

import java.math.BigDecimal;

public class CargoAdder {
    public static CargoCarriage add(BigDecimal weight, String manufacturer, BigDecimal width,
                             BigDecimal length, BigDecimal carrying, BigDecimal volume, String type){
        if (type.equalsIgnoreCase("CloseCargo"))
            return Factory.createCloseCargoCarriage(weight, manufacturer, width, length, carrying, volume);
        if (type.equalsIgnoreCase("OpenCargo"))
            return Factory.createOpenCargoCarriage(weight, manufacturer, width, length, carrying, volume);
        if (type.equalsIgnoreCase("Tank"))
            return Factory.createTank(weight, manufacturer, width, length, carrying, volume);
        return null;
    }
}
