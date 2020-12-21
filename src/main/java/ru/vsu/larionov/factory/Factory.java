package ru.vsu.larionov.factory;

import ru.vsu.larionov.model.Carriage.CargoCarriage.CargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CloseCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.OpenCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.Tank;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.CoupeCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.LuxuryCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.RestaurantCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.SitCarriage;

import java.math.BigDecimal;

public class Factory {
    public static CoupeCarriage createCoupeCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length){
        if (passengerCheck(weight, manufacturer, width, length)){
            return new CoupeCarriage(weight, manufacturer, width, length);
        }
        else throw generateEx();

    }

    public static LuxuryCarriage createLuxuryCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length){
        if (passengerCheck(weight, manufacturer, width, length)){
            return new LuxuryCarriage(weight, manufacturer, width, length);
        }
        else throw generateEx();
    }

    public static RestaurantCarriage createRestaurantCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length){
        if (passengerCheck(weight, manufacturer, width, length)){
            return new RestaurantCarriage(weight, manufacturer, width, length);
        }
        else throw generateEx();
    }

    public static SitCarriage createSitCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length){
        if (passengerCheck(weight, manufacturer, width, length)){
            return new SitCarriage(weight, manufacturer, width, length);
        }
        else throw generateEx();
    }

    public static Locomotive createLocomotive(BigDecimal weight, String manufacturer, BigDecimal width,
                                              BigDecimal length, BigDecimal power){
        if (locomotiveCheck(weight, manufacturer, width, length, power)){
            return new Locomotive(weight, manufacturer, width, length, power);
        }
        else throw generateEx();
    }

    public static CloseCargoCarriage createCloseCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal carrying, BigDecimal volume){
        if (cargoCheck(weight, manufacturer, width, length, carrying, volume)){
            return new CloseCargoCarriage(weight, manufacturer, width, length, carrying, volume);
        }
        else throw generateEx();
    }

    public static OpenCargoCarriage createOpenCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal carrying, BigDecimal volume){
        if (cargoCheck(weight, manufacturer, width, length, carrying, volume)){
            return new OpenCargoCarriage(weight, manufacturer, width, length, carrying, volume);
        }
        else throw generateEx();
    }

    public static Tank createTank(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal carrying, BigDecimal volume){
        if (cargoCheck(weight, manufacturer, width, length, carrying, volume)){
            return new Tank(weight, manufacturer, width, length, carrying, volume);
        }
        else throw generateEx();
    }

    private static boolean passengerCheck(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length){
        try {
            return (weight.doubleValue() > 0 && !manufacturer.equals("") && width.doubleValue() > 0 && length.doubleValue() > 0);
        }
        catch (NullPointerException ex){
            throw new IllegalArgumentException();
        }
    }
    private static boolean cargoCheck(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal carrying, BigDecimal volume){
        try {
            return (weight.doubleValue() > 0 && !manufacturer.equals("") && width.doubleValue() > 0 && length.doubleValue() > 0
                    && carrying.doubleValue() > 0 && volume.doubleValue() > 0);
        }
        catch (NullPointerException ex){
            throw new IllegalArgumentException();
        }
    }

    private static boolean locomotiveCheck(BigDecimal weight, String manufacturer, BigDecimal width,
                                    BigDecimal length, BigDecimal power){
        try {
            return (weight.doubleValue() > 0 && !manufacturer.equals("") && width.doubleValue() > 0 && length.doubleValue() > 0
                    && power.doubleValue() > 0);
        }
        catch (NullPointerException ex){
            throw new IllegalArgumentException();
        }
    }
    private static IllegalArgumentException generateEx(){
        return new IllegalArgumentException();
    }
}
