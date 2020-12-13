package ru.vsu.larionov.Utils;

public enum CargoSubtypes {
    OPEN("OPEN_CARGO"),
    CLOSE("CLOSE_CARGO"),
    TANK("TANK");
    private final String subtype;
    CargoSubtypes(String subtype){
        this.subtype = subtype;
    }

    public String getSubtype() {
        return subtype;
    }
}
