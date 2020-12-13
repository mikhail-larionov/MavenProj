package ru.vsu.larionov.db;

import ru.vsu.larionov.Utils.*;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CloseCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.OpenCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.Tank;
import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.CoupeCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.LuxuryCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.RestaurantCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.SitCarriage;
import ru.vsu.larionov.model.Train.CargoTrain.CargoTrain;
import ru.vsu.larionov.model.Train.PassengerTrain.PassengerTrain;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.nio.file.LinkOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }

//todo сделать мапу сохранения с ключом типом вакона , значением типом сохранителя
public Train getTrainById(Long id) throws SQLException {
        Train train = null;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("select Train_Type from TRAINS where TRAIN_ID = ?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String train_type = rs.getString(1);
            Enum.valueOf(TrainTypes.class, "CARGO");
            if (TrainTypes.CARGO.getType().trim().toUpperCase().equals(train_type.trim().toUpperCase())) {
                train = GetterMap.getterMap.get(TrainTypes.CARGO.getType().trim().toUpperCase()).getFormDbById(id);
            } else if ((TrainTypes.PASSENGER.getType()).trim().toUpperCase().equals(train_type.trim().toUpperCase())) {
                train = GetterMap.getterMap.get(TrainTypes.PASSENGER.getType().trim().toUpperCase()).getFormDbById(id);
            }
        }
        if (train == null){
            throw new NullPointerException("Поезд не найден");
        }
        return train;
}
public void clearAllBase() throws SQLException {
    Connection connection = getConnection();
    PreparedStatement statement = connection.prepareStatement("DELETE FROM TRAINS");
    statement.executeUpdate();
    statement = connection.prepareStatement("DELETE FROM CARRIAGES");
    statement.executeUpdate();
}
public void deleteById(Long id) throws SQLException {
//    getTrainById(id); нужно ли это?
    Connection connection = getConnection();
    PreparedStatement statement = connection.prepareStatement("DELETE FROM TRAINS WHERE TRAIN_ID = ?");
    statement.setLong(1, id);
    statement.executeUpdate();
    statement = connection.prepareStatement("DELETE FROM CARRIAGES WHERE TRAIN_ID = ?");
    statement.setLong(1, id);
    statement.executeUpdate();
}

    //Domen driver design
//    public List<Train> getAllTrains(){
//        List<Train> trains = new ArrayList<>();
//        try {
//            Connection connection = getConnection();
//            PreparedStatement statement = connection.prepareStatement("select Train_id,Train_Type,Number_Of_carriage, Max_Speed from TRAINS");
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                Long train_id = rs.getLong(1);
//                String train_type = rs.getString(2);
//                int number_of_carriage = rs.getInt(3);
//                BigDecimal max_speed = rs.getBigDecimal(4);
//                if ("CARGO".trim().toUpperCase().equals(train_type.trim().toUpperCase())) {
//                    Train train = new PassengerTrain(train_type, number_of_carriage, train_id, max_speed);
//                    trains.add(train);
//                }
//                else {
//                    Train train = new CargoTrain(train_type, number_of_carriage, train_id, max_speed);
//                    trains.add(train);
//                }
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return trains;
//    }
//todo реализовать по йди и для поезда и для вагона
}
