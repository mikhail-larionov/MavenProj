package ru.vsu.larionov.model.Carriage;

import ru.vsu.larionov.storage.CarriageStorage;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Carriage implements CarriageStorage<Carriage> {
    private final BigDecimal weight;
    private final String manufacturer;
    private final BigDecimal width;
    private final BigDecimal length;
    private final String type;
    private Long id;
    private Long trainId;
    private final String subType;
    public Carriage(BigDecimal weight, String manufacturer, BigDecimal width,
                    BigDecimal length, String type, String subType){
        this.type = type;
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.width = width;
        this.length = length;
        this.subType = subType;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Long getTrainId() {
        return trainId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public BigDecimal getLength() {
        return length;
    }

    public String getSubType() {
        return subType;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "weight=" + weight +
                ", manufacturer='" + manufacturer + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", trainId=" + trainId +
                ", subType='" + subType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carriage carriage = (Carriage) o;
        return Objects.equals(weight, carriage.weight) &&
                Objects.equals(manufacturer, carriage.manufacturer) &&
                Objects.equals(width, carriage.width) &&
                Objects.equals(length, carriage.length) &&
                Objects.equals(type, carriage.type) &&
                Objects.equals(id, carriage.id) &&
                Objects.equals(trainId, carriage.trainId) &&
                Objects.equals(subType, carriage.subType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, manufacturer, width, length, type, id, trainId, subType);
    }
}
