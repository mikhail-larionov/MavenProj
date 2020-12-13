package ru.vsu.larionov.model.Train.PassengerTrain;

import ru.vsu.larionov.Utils.TrainTypes;
import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.CoupeCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.LuxuryCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.RestaurantCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.SitCarriage;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.sql.SQLException;

import static ru.vsu.larionov.Utils.IdGenerator.generateId;

public class PassengerTrain extends Train {
    private static final String type = TrainTypes.PASSENGER.getType();
    public PassengerTrain(){
        super(type);
    }
    public PassengerTrain(String type, Long id){
        super(type, id);
    }
    public void addCoupeCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, Long trainId) throws IllegalArgumentException, SQLException {
        if (weight.doubleValue() > 0 && width.doubleValue() > 0 && length.doubleValue() > 0) {
            CoupeCarriage coupeCarriage = new CoupeCarriage(weight, manufacturer, width, length);
            this.addCarriage(coupeCarriage);
            coupeCarriage.setId(generateId());
            coupeCarriage.setTrainId(trainId);
            coupeCarriage.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }
    public void addLuxuryCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                                  BigDecimal length, Long trainId) throws SQLException {
        if (weight.doubleValue() > 0 && width.doubleValue() > 0 && length.doubleValue() > 0) {
            LuxuryCarriage luxuryCarriage = new LuxuryCarriage(weight, manufacturer, width, length);
            this.addCarriage(luxuryCarriage);
            luxuryCarriage.setId(generateId());
            luxuryCarriage.setTrainId(trainId);
            luxuryCarriage.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }
    public void addRestaurantCarriage(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, Long trainId) throws SQLException {
        if (weight.doubleValue() > 0 && width.doubleValue() > 0 && length.doubleValue() > 0) {
            RestaurantCarriage restaurantCarriage = new RestaurantCarriage(weight, manufacturer, width, length);
            this.addCarriage(restaurantCarriage);
            restaurantCarriage.setId(generateId());
            restaurantCarriage.setTrainId(trainId);

            restaurantCarriage.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }
    public void addSitCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                               BigDecimal length, Long trainId) throws SQLException {
        if (weight.doubleValue() > 0 && width.doubleValue() > 0 && length.doubleValue() > 0) {
            SitCarriage sitCarriage = new SitCarriage(weight, manufacturer, width, length);
            this.addCarriage(sitCarriage);
            sitCarriage.setId(generateId());
            sitCarriage.setTrainId(trainId);
            sitCarriage.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }

}
