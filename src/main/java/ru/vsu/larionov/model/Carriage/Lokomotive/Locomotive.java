package ru.vsu.larionov.model.Carriage.Lokomotive;

import ru.vsu.larionov.model.Carriage.Carriage;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static ru.vsu.larionov.Utils.Utils.getConnection;

public class Locomotive extends Carriage {
    private BigDecimal power;
    private Long Id;
    private Long trainId;
    private final static String type = "Locomotive";
    public Locomotive(BigDecimal weight, String manufacturer, BigDecimal width,
                      BigDecimal length, BigDecimal power){
        super(weight, manufacturer, width ,length, type, type);
        setPower(power);
    }
    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    @Override
    public Carriage saveToDb() throws SQLException {
        Connection c = getConnection();
        PreparedStatement statement = c.prepareStatement("insert into Carriages (TypeCarr, Train_id, CARRIAGE_ID , WEIGHT, MANUFACTURER, WIDTH, LENGTH, POWER, SUBTYPE) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, this.getType());
        statement.setLong(2, this.getTrainId());
        statement.setLong(3, this.getId());
        statement.setBigDecimal(4, this.getWeight());
        statement.setString(5, this.getManufacturer());
        statement.setBigDecimal(6, this.getWidth());
        statement.setBigDecimal(7, this.getLength());
        statement.setBigDecimal(8, this.getPower());
        statement.setString(9, this.getType());
        statement.executeUpdate();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return Objects.equals(power, that.power) &&
                Objects.equals(Id, that.Id) &&
                Objects.equals(trainId, that.trainId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, Id, trainId);
    }
}
