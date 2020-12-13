package ru.vsu.larionov;

import ru.vsu.larionov.model.Train.Train;

public class DTO {
    Integer numberOfHangar;
    Train train;

    public DTO(Integer numberOfHangar, Train train) {
        this.numberOfHangar = numberOfHangar;
        this.train = train;
    }
}
