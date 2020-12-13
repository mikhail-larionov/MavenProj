package ru.vsu.larionov.Utils;

import ru.vsu.larionov.model.Train.Train;
import ru.vsu.larionov.model.getFromDb.CargoTrainGetter;
import ru.vsu.larionov.model.getFromDb.Getter;
import ru.vsu.larionov.model.getFromDb.PassengerTrainGetter;

import java.util.HashMap;
import java.util.Map;

public class GetterMap {
    public static final Map<String, Getter<Train>> getterMap = new HashMap<>();
    static {
        getterMap.put(TrainTypes.PASSENGER.getType(), new PassengerTrainGetter());
        getterMap.put(TrainTypes.CARGO.getType(), new CargoTrainGetter());
    }
}
