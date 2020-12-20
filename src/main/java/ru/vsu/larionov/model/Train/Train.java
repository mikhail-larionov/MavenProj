package ru.vsu.larionov.model.Train;

import ru.vsu.larionov.Utils.IdGenerator;
import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.storage.Storable;
import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.storage.TrainStorage;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.vsu.larionov.Utils.Utils.getConnection;

public abstract class Train implements TrainStorage<Train> {
    private String type;
    private Long id;
    protected int numberOfCarriage = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return numberOfCarriage == train.numberOfCarriage &&
                Objects.equals(type, train.type) &&
                Objects.equals(id, train.id) &&
                Objects.equals(maxSpeed, train.maxSpeed) &&
                Objects.equals(locomotives, train.locomotives) &&
                Objects.equals(carriages, train.carriages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, numberOfCarriage, maxSpeed, locomotives, carriages);
    }

    protected BigDecimal maxSpeed;
    private  ArrayList<Locomotive> locomotives = new ArrayList<>();
    private  ArrayList<Carriage> carriages = new ArrayList<>();
    protected Train(String type, Long id){
        this.type = type;
        this.id = id;
    }

    protected Train(String type) {
        this.type = type;
    }

    public void addCarriage(Carriage carriage) {
        carriages.add(carriage);
        numberOfCarriage++;
    }

    private void addLocomotive(Locomotive locomotive) throws IllegalArgumentException {
        if (locomotives.size() > 3) {
            throw new IllegalArgumentException("Слишком много локомотивов");
        }
        else {
            locomotives.add(locomotive);
        }
    }
    public void addLocomotive(BigDecimal weight, String manufacturer, BigDecimal width,
                              BigDecimal length, BigDecimal power){
        Locomotive locomotive = new Locomotive(weight, manufacturer, width, length, power);
        numberOfCarriage++;
        addLocomotive(locomotive);

    }
    public void addLocomotive(BigDecimal weight, String manufacturer, BigDecimal width,
                              BigDecimal length, BigDecimal power, Long trainId) throws SQLException {
        if (weight.doubleValue() > 0 && width.doubleValue() > 0 && length.doubleValue() > 0 && power.doubleValue() > 0) {
            Locomotive locomotive = new Locomotive(weight, manufacturer, width, length, power);
            addLocomotive(locomotive);
            numberOfCarriage++;
            locomotive.setId(IdGenerator.generateId());
            locomotive.setTrainId(trainId);
                locomotive.saveToDb();

        } else throw new IllegalArgumentException("Неверные данные");
    }
    public void addLocomotiveFromDb(Locomotive locomotive){
        if (locomotive.getWeight().doubleValue() > 0 && locomotive.getWidth().doubleValue()> 0 && locomotive.getLength().doubleValue() > 0 && locomotive.getPower().doubleValue() > 0) {
            numberOfCarriage++;
            addLocomotive(locomotive);
        }
    }

    public void setLocomotives(ArrayList<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public int getNumberOfCarriage() {
        return carriages.size() + locomotives.size();
    }

    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public Train saveToDb() throws SQLException {
        Connection c = getConnection();
        PreparedStatement statement = c.prepareStatement("insert into Trains (Train_id, TRAIN_TYPE, NUMBER_OF_CARRIAGE, MAX_SPEED ) values (?, ?, ?, ?)");
        statement.setLong(1, this.getId());
        statement.setString(2, this.getType());
        statement.setInt(3, this.getNumberOfCarriage());
        statement.setBigDecimal(4, this.getMaxSpeed());
        statement.executeUpdate();
        return this;
    }


    @Override
    public String toString() {
        return "Train{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", numberOfCarriage=" + numberOfCarriage +
                ", maxSpeed=" + maxSpeed +
                ", locomotives=" + locomotives +
                ", carriages=" + carriages +
                '}';
    }
}
