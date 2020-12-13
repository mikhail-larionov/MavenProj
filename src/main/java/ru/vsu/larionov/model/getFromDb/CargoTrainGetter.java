package ru.vsu.larionov.model.getFromDb;

import ru.vsu.larionov.Utils.CargoSubtypes;
import ru.vsu.larionov.Utils.CarriageTypes;
import ru.vsu.larionov.Utils.TrainTypes;
import ru.vsu.larionov.Utils.Utils;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CloseCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.OpenCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.Tank;
import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Train.CargoTrain.CargoTrain;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoTrainGetter implements Getter<Train> {

    @Override
    public Train getFormDbById(Long id) throws SQLException {
        Train cargoTrain = new CargoTrain(TrainTypes.CARGO.getType(), id);
        Carriage carriage = null;
        Locomotive locomotive = null;
        Connection connection = Utils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select TypeCarr, Train_id, CARRIAGE_ID , WEIGHT, MANUFACTURER, WIDTH, LENGTH, SUBTYPE, VOLUME, CARRYING, POWER from CARRIAGES where TRAIN_ID = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String type_curr = rs.getString(1);
            if (type_curr.toUpperCase().trim().equals(CarriageTypes.PASSENGER.getType())) {
                throw new SQLException();
            }
            Long trainId = rs.getLong(2);
            Long carriageId = rs.getLong(3);
            BigDecimal weight = rs.getBigDecimal(4);
            String manufacturer = rs.getString(5);
            BigDecimal width = rs.getBigDecimal(6);
            BigDecimal length = rs.getBigDecimal(7);
            String subtype = rs.getString(8);
            BigDecimal volume = rs.getBigDecimal(9);
            BigDecimal carrying = rs.getBigDecimal(10);
            BigDecimal power = rs.getBigDecimal(11);

            if (subtype != null) {
                if (subtype.trim().toUpperCase().equals(CargoSubtypes.CLOSE.getSubtype())) {
                    carriage = new CloseCargoCarriage(weight, manufacturer, width, length, carrying, volume);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (subtype.trim().toUpperCase().equals(CargoSubtypes.OPEN.getSubtype())) {
                    carriage = new OpenCargoCarriage(weight, manufacturer, width, length, carrying, volume);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (subtype.trim().toUpperCase().equals(CargoSubtypes.TANK.getSubtype())) {
                    carriage = new Tank(weight, manufacturer, width, length, carrying, volume);
                    carriage.setTrainId(trainId);
                    carriage.setId(carriageId);
                }
                if (type_curr.toUpperCase().trim().equals(CarriageTypes.LOCOMOTIVE.getType())) {
                    locomotive = new Locomotive(weight, manufacturer, width, length, power);
                    locomotive.setTrainId(trainId);
                    locomotive.setId(carriageId);
                    cargoTrain.addLocomotiveFromDb(locomotive);
                }
                else {
                    cargoTrain.addCarriage(carriage);
                }
            }
        }
        return cargoTrain;
    }
}
