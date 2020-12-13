package ru.vsu.larionov.model.Carriage.CargoCarriage;

import ru.vsu.larionov.model.Carriage.Carriage;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static ru.vsu.larionov.Utils.Utils.getConnection;

public abstract class CargoCarriage extends Carriage {
    private BigDecimal carrying;
    private BigDecimal volume;

    private final static String type = "Cargo";
    public CargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                         BigDecimal length, BigDecimal carrying, BigDecimal volume, String subType){
        super(weight, manufacturer, width, length, type, subType);
        setCarrying(carrying);
        setVolume(volume);
    }

    public BigDecimal getVolume() {
        return volume;
    }

    private void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    private BigDecimal getCarrying() {
        return carrying;
    }

    public void setCarrying(BigDecimal carrying) {
        this.carrying = carrying;
    }
    @Override
    public Carriage saveToDb() throws SQLException {
        Connection c = getConnection();
        PreparedStatement statement = c.prepareStatement("insert into Carriages (TypeCarr, Train_id, CARRIAGE_ID , WEIGHT, MANUFACTURER, WIDTH, LENGTH, SUBTYPE, VOLUME, CARRYING) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, this.getType());
        statement.setLong(2, this.getTrainId());
        statement.setLong(3, this.getId());
        statement.setBigDecimal(4, this.getWeight());
        statement.setString(5, this.getManufacturer());
        statement.setBigDecimal(6, this.getWidth());
        statement.setBigDecimal(7, this.getLength());
        statement.setString(8, this.getSubType());
        statement.setBigDecimal(9, this.getVolume());
        statement.setBigDecimal(10, this.getCarrying());
        statement.executeUpdate();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoCarriage that = (CargoCarriage) o;
        return Objects.equals(carrying, that.carrying) &&
                Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrying, volume);
    }
}

