package ru.vsu.larionov.model.getFromDb;

import ru.vsu.larionov.Utils.CarriageTypes;
import ru.vsu.larionov.Utils.PassengerSubtypes;
import ru.vsu.larionov.Utils.TrainTypes;
import ru.vsu.larionov.Utils.Utils;
import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.CoupeCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.LuxuryCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.RestaurantCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.SitCarriage;
import ru.vsu.larionov.model.Train.PassengerTrain.PassengerTrain;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerTrainGetter implements Getter<Train> {

    @Override
    public Train getFormDbById(Long id) throws SQLException {
        Train passengerTrain = new PassengerTrain(TrainTypes.PASSENGER.getType(), id);
        Carriage carriage = null;
        Locomotive locomotive = null;
        Connection connection = Utils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select TypeCarr, Train_id, CARRIAGE_ID , WEIGHT, MANUFACTURER, WIDTH, LENGTH, SUBTYPE, POWER from CARRIAGES  where TRAIN_ID = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String type_curr = rs.getString(1);
            if (type_curr.toUpperCase().trim().equals(CarriageTypes.CARGO.getType().toUpperCase().trim())) {
                throw new SQLException();
            }
            Long trainId = rs.getLong(2);
            Long carriageId = rs.getLong(3);
            BigDecimal weight = rs.getBigDecimal(4);
            String manufacturer = rs.getString(5);
            BigDecimal width = rs.getBigDecimal(6);
            BigDecimal length = rs.getBigDecimal(7);
            String subtype = rs.getString(8);
            BigDecimal power = rs.getBigDecimal(9);

            if (subtype != null) {
                if (subtype.trim().toUpperCase().equals(PassengerSubtypes.COUPE.getSubtype())) {
                    carriage = new CoupeCarriage(weight, manufacturer, width, length);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (subtype.trim().toUpperCase().equals(PassengerSubtypes.LUXURY.getSubtype())) {
                    carriage = new LuxuryCarriage(weight, manufacturer, width, length);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (subtype.trim().toUpperCase().equals(PassengerSubtypes.SIT.getSubtype())) {
                    carriage = new SitCarriage(weight, manufacturer, width, length);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (subtype.trim().toUpperCase().equals(PassengerSubtypes.RESTAURANT.getSubtype())) {
                    carriage = new RestaurantCarriage(weight, manufacturer, width, length);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (type_curr.toUpperCase().trim().equals(CarriageTypes.LOCOMOTIVE.getType())) {
                    locomotive = new Locomotive(weight, manufacturer, width, length, power);
                    locomotive.setTrainId(trainId);
                    locomotive.setId(carriageId);
                    passengerTrain.addLocomotiveFromDb(locomotive);
                }
                else {
                    passengerTrain.addCarriage(carriage);
                }
            }
        }
        return passengerTrain;
    }
}