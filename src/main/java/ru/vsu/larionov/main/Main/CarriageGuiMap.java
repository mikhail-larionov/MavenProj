package ru.vsu.larionov.main.Main;

import java.util.HashMap;
import java.util.Map;

public class CarriageGuiMap {
    final static Map<String, String> types = new HashMap<>();;
    static {
        types.put("CoupeCarriage", "CoCarr");
        types.put("LuxuryCarriage", "LuCarr");
        types.put("RestaurantCarriage", "ReCarr");
        types.put("SitCarriage", "SitCarr");
        types.put("Locomotive", "Loco");
        types.put("CloseCargo", "CloCarr");
        types.put("OpenCargo", "OpenCarr");
        types.put("Tank", "Tank");
    }
    public static Map<String, String> getType(){
        return types;
    }
}
