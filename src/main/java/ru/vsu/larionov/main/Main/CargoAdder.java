package ru.vsu.larionov.main.Main;

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
            return new CloseCargoCarriage(weight, manufacturer, width, length, carrying, volume);
        if (type.equalsIgnoreCase("OpenCargo"))
            return new OpenCargoCarriage(weight, manufacturer, width, length, carrying, volume);
        if (type.equalsIgnoreCase("Tank"))
            return new Tank(weight, manufacturer, width, length, carrying, volume);
        return null;
    }
}
