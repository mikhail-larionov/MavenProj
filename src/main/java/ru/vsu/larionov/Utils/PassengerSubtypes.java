package ru.vsu.larionov.Utils;

public enum PassengerSubtypes {
    COUPE("COUPE"),
    LUXURY("LUXURY"),
    SIT("SIT"),
    RESTAURANT("RESTAURANT")
    ;
    private final String subtype;
    PassengerSubtypes(String subtype){
        this.subtype = subtype;
    }

    public String getSubtype() {
        return subtype;
    }
}
