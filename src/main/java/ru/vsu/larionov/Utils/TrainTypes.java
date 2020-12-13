package ru.vsu.larionov.Utils;

import ru.vsu.larionov.model.Train.PassengerTrain.PassengerTrain;
import ru.vsu.larionov.model.Train.Train;

public enum TrainTypes {
    CARGO("CARGO"),
    PASSENGER("PASSENGER");
    private final String type;
    TrainTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
