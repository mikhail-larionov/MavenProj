package ru.vsu.larionov.connection;

import ru.vsu.larionov.model.Train.Train;

import java.util.HashMap;
import java.util.Map;

public class Trains {
    private Map<Integer, Train> trains = new HashMap<>();
    public void addTrain(Integer hangarNumber, Train train){
        trains.put(hangarNumber, train);
    }
}
