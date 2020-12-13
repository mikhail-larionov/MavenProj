package ru.vsu.larionov.model.Carriage.PassangerCarriage;

import ru.vsu.larionov.model.Carriage.Carriage;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ru.vsu.larionov.Utils.Utils.getConnection;

public abstract class PassengerCarriage extends Carriage {
    private int numberOfSeats;
    private int numberOfFloors;
    private int numberOfSeatsInRoom;
    private final static String type = "Passenger";


    PassengerCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                      BigDecimal length, int numberOfSeats, int numberOfFloors, int numberOfSeatsInRoom, String subType) {
        super(weight, manufacturer, width, length, type, subType);
        setNumberOfSeats(numberOfSeats);
        setNumberOfFloors(numberOfFloors);
        setNumberOfSeatsInRoom(numberOfSeatsInRoom);

    }

    public int getNumberOfSeatsInRoom() {
        return numberOfSeatsInRoom;
    }

    public void setNumberOfSeatsInRoom(int numberOfSeatsInRoom) {
        this.numberOfSeatsInRoom = numberOfSeatsInRoom;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    @Override
    public Carriage saveToDb() throws SQLException {
        Connection c = getConnection();
        PreparedStatement statement = c.prepareStatement("insert into Carriages (TypeCarr,  Train_id, CARRIAGE_ID , WEIGHT, MANUFACTURER, WIDTH, LENGTH, NUMBER_OF_SITS_IN_ROOM, NUMBER_OF_SITS, NUMBER_OF_FLOORS, SUBTYPE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, this.getType());
        statement.setLong(2, this.getTrainId());
        statement.setLong(3, this.getId());
        statement.setBigDecimal(4, this.getWeight());
        statement.setString(5, this.getManufacturer());
        statement.setBigDecimal(6, this.getWidth());
        statement.setBigDecimal(7, this.getLength());
        statement.setInt(8, this.getNumberOfSeatsInRoom());
        statement.setInt(9, this.getNumberOfSeats());
        statement.setInt(10, this.getNumberOfFloors());
        statement.setString(11, this.getSubType());
        statement.executeUpdate();
        return this;
    }
}
