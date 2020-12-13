package ru.vsu.larionov.Utils;

public enum CarriageTypes {
    PASSENGER("PASSENGER"),
    CARGO("CARGO"),
    LOCOMOTIVE("LOCOMOTIVE");
    private final String type;
    CarriageTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
