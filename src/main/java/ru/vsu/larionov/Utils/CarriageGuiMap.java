package ru.vsu.larionov.Utils;

import java.util.HashMap;
import java.util.Map;

public class CarriageGuiMap {
    final static Map<String, String> types = new HashMap<>();;
    static {
        types.put("CoupeCarriage", "COUPE");
        types.put("LuxuryCarriage", "LUXURY");
        types.put("RestaurantCarriage", "RESTAURANT");
        types.put("SitCarriage", "SIT");
        types.put("LOCOMOTIVE", "LOCOMOTIVE");
        types.put("CloseCargo", "CLOSE_CARGO");
        types.put("OpenCargo", "OPEN_CARGO");
        types.put("Tank", "TANK");
    }
    public static Map<String, String> getType(){
        return types;
    }
}
