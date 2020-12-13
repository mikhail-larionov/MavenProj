package ru.vsu.larionov.model.Train.CargoTrain;

import ru.vsu.larionov.Utils.TrainTypes;
import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CloseCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.OpenCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.Tank;
import ru.vsu.larionov.model.Train.Train;

import java.math.BigDecimal;
import java.sql.SQLException;

import static ru.vsu.larionov.Utils.IdGenerator.generateId;

public class CargoTrain extends Train{
    private final static String type = TrainTypes.CARGO.getType();
    public CargoTrain(){
        super(type);
        db = new DB();
    }
    public CargoTrain(String type, Long id){
        super(type, id);
    }



    public void addCloseCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                                      BigDecimal length, BigDecimal carrying, BigDecimal volume, Long trainId) throws SQLException {
        if (check(weight.doubleValue(), width.doubleValue() ,length.doubleValue(),carrying.doubleValue()  ,volume.doubleValue())) {
            CloseCargoCarriage closeCargoCarriage = new CloseCargoCarriage(weight, manufacturer, width, length, carrying, volume);
            this.addCarriage(closeCargoCarriage);
            closeCargoCarriage.setId(generateId());
            closeCargoCarriage.setTrainId(trainId);
            closeCargoCarriage.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }
    public void addTank(BigDecimal weight, String manufacturer, BigDecimal width, BigDecimal length, BigDecimal carrying, BigDecimal volume, Long trainId) throws SQLException {
        if (check(weight.doubleValue(), width.doubleValue() ,length.doubleValue(),carrying.doubleValue()  ,volume.doubleValue())) {
            Tank tank = new Tank(weight, manufacturer, width, length, carrying, volume);
            this.addCarriage(tank);
            tank.setId(generateId());
            tank.setTrainId(trainId);
            tank.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }
    public void addOpenCargoCarriage(BigDecimal weight, String manufacturer, BigDecimal width,
                                     BigDecimal length, BigDecimal carrying, BigDecimal volume, Long trainId) throws SQLException {
        if (check(weight.doubleValue(), width.doubleValue() ,length.doubleValue(),carrying.doubleValue()  ,volume.doubleValue())) {
            OpenCargoCarriage openCargoCarriage = new OpenCargoCarriage(weight, manufacturer, width, length, carrying, volume);
            this.addCarriage(openCargoCarriage);
            openCargoCarriage.setId(generateId());
            openCargoCarriage.setTrainId(trainId);
            openCargoCarriage.saveToDb();
        }
        else throw new IllegalArgumentException("Неверные данные");
    }
    private boolean check(double weight, double width, double length, double carrying ,double volume){
        return weight > 0 && width > 0 && length > 0 && carrying > 0 && volume > 0;
    }

}
